package com.zsl.traceapi.util;

import com.alibaba.fastjson.JSONObject;
import com.zsl.traceapi.dao.ZslTraceSidDao;
import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.dto.TraceCodeRelation;
import com.zsl.traceapi.dto.TraceSubcodeUpdateParam;
import com.zsl.traceapi.dto.TraceSubcodeUpdateParamSid;
import com.zsl.tracedb.mapper.ZslTraceMapper;
import com.zsl.tracedb.mapper.ZslTraceSidMapper;
import com.zsl.tracedb.model.ZslTrace;
import com.zsl.tracedb.model.ZslTraceExample;
import com.zsl.tracedb.model.ZslTraceSid;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * @ClassName CoreThread
 * @Description 线程类
 * @Author binggleW
 * @Date 2019-10-07 11:44
 * @Version 1.0
 **/
public class CoreThread extends Thread {
    private static Logger logger = LoggerFactory.getLogger(CoreThread.class);
    private ZslTraceSubcodeDao zslTraceSubcodeDao = (ZslTraceSubcodeDao) SpringContextUtil.getBean(ZslTraceSubcodeDao.class);

    private ZslTraceMapper zslTraceMapper = (ZslTraceMapper) SpringContextUtil.getBean(ZslTraceMapper.class);

    private ZslTraceSidDao zslTraceSidDao = (ZslTraceSidDao) SpringContextUtil.getBean(ZslTraceSidDao.class);

    private ZslTraceSidMapper zslTraceSidMapper= (ZslTraceSidMapper) SpringContextUtil.getBean(ZslTraceSidMapper.class);

    private ExecutorService service = (ExecutorService) SpringContextUtil.getBean("consumerTraceThreadPool");


    String traceCodeJson;

    public CoreThread(String traceCodeJson) {
        this.traceCodeJson = traceCodeJson;
    }

    /**
     *  判断是纸质还是电子
     * @param traceCodeNumber
     * @return
     */
    private  boolean isPapperOrElectric(String traceCodeNumber){
        ZslTraceExample zslTraceExample = new ZslTraceExample();
        ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
        List<ZslTrace> zslTraceList = zslTraceMapper.selectByExample(zslTraceExample);
        if (CollectionUtils.isNotEmpty(zslTraceList) && zslTraceList.get(0).getTraceApplyType() - 1 == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        try {
            TraceCodeRelation traceCodeRelation = JSONObject.parseObject(traceCodeJson, TraceCodeRelation.class);
            Long fromNumber = traceCodeRelation.getFromNumber();
            Long toNumber = traceCodeRelation.getToNumber();
            int goodsId = traceCodeRelation.getGoodsId();
            int stallId = traceCodeRelation.getStallId();
            String traceCodeNumber = traceCodeRelation.getTraceCodeNumber();

            //判断是纸质还是电子
            boolean isPaperType = isPapperOrElectric(traceCodeNumber);

            Long count = toNumber - fromNumber + 1;
            int totalPage = (int) Math.ceil((double) count / 1000);
            Long start = 0L;
            Long end = 0L;
            ZslTraceSid zslTraceSid = zslTraceSidDao.selectNewPrePaperCode();

            if (zslTraceSid.getSidStartIndex() - zslTraceSid.getSidCurrentIndex() == 0) {
                start = zslTraceSid.getSidCurrentIndex();
                end = zslTraceSid.getSidCurrentIndex() + count - 1;
            } else {
                start = zslTraceSid.getSidCurrentIndex() + 1;
                end = zslTraceSid.getSidCurrentIndex() + count;
            }

            if (isPaperType) {
                //更改当前纸质指针位置
                if (zslTraceSid != null) {
                    ZslTraceSid updateE = new ZslTraceSid();
                    updateE.setId(zslTraceSid.getId());
                    updateE.setSidCurrentIndex(end);
                    zslTraceSidMapper.updateByPrimaryKeySelective(updateE);
                }
            }
            for (int currentPage = 1; currentPage <= totalPage; currentPage++) {
                Long fromIndex = 0L;
                Long toIndex = 0L;
                fromIndex = new Long((currentPage - 1) * 1000 + fromNumber);
                if (currentPage - totalPage == 0) {
                    toIndex = toNumber;
                } else {
                    toIndex = new Long(currentPage * 1000) + fromNumber;
                }
                // 区分纸质和电子
                List<Long> traceCodeIds = null;
                if (isPaperType) {

                    if (zslTraceSid == null) {
                        return;
                    }

                    if (end > zslTraceSid.getSidEndIndex()) {
                        logger.info("预生成的纸质码不足:{}", zslTraceSid.getId());
                        return;
                    }
                    traceCodeIds = zslTraceSubcodeDao.selectBySidRange(start, end);
                    List<TraceSubcodeUpdateParamSid> updateSidParams = new ArrayList<>();
                    Long countTemp = fromNumber;
                    for (int i = 0; i < traceCodeIds.size(); i++) {
                        TraceSubcodeUpdateParamSid traceSubcodeUpdateParamSid = new TraceSubcodeUpdateParamSid(countTemp,traceCodeNumber,goodsId,stallId,traceCodeIds.get(i));
                        updateSidParams.add(traceSubcodeUpdateParamSid);
                        countTemp++;
                    }
                   // service.execute(() -> {
                        logger.info("纸质线程：" + updateSidParams);
                        int j = zslTraceSubcodeDao.updateGoodsAndStallSid(updateSidParams);
                        logger.info("结果：" + j);
                  //  });
                } else {
                    //电子
                    traceCodeIds = zslTraceSubcodeDao.selectByRange(fromIndex, toIndex, traceCodeNumber);
                    List<TraceSubcodeUpdateParam> updateParams = new ArrayList<>();
                    for (int i = 0; i < traceCodeIds.size(); i++) {
                        TraceSubcodeUpdateParam traceSubcodeUpdateParam = new TraceSubcodeUpdateParam(goodsId,stallId,traceCodeIds.get(i));
                        updateParams.add(traceSubcodeUpdateParam);
                    }
                   // service.execute(() -> {
                        int j = zslTraceSubcodeDao.updateGoodsAndStall(updateParams);
                   // });
                }
            }
        } catch (Exception e) {
        }
    }
}