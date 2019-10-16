package com.zsl.traceapi.util;

import com.alibaba.fastjson.JSONObject;
import com.zsl.traceapi.dao.ZslTraceSidDao;
import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.dto.TraceCodeRelation;
import com.zsl.traceapi.dto.TraceSubcodeUpdateParam;
import com.zsl.traceapi.dto.TraceSubcodeUpdateParamSid;
import com.zsl.tracedb.mapper.ZslTraceMapper;
import com.zsl.tracedb.mapper.ZslTracePapperMapper;
import com.zsl.tracedb.mapper.ZslTraceRelationMapper;
import com.zsl.tracedb.mapper.ZslTraceSidMapper;
import com.zsl.tracedb.model.*;
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

    private ZslTracePapperMapper zslTracePapperMapper = (ZslTracePapperMapper) SpringContextUtil.getBean(ZslTracePapperMapper.class);

    private ZslTraceRelationMapper zslTraceRelationMapper = (ZslTraceRelationMapper) SpringContextUtil.getBean(ZslTraceRelationMapper.class);

    private ExecutorService service = (ExecutorService) SpringContextUtil.getBean("consumerTraceThreadPool");


    String traceCodeJson;

    public CoreThread(String traceCodeJson) {
        this.traceCodeJson = traceCodeJson;
    }

    /**
     * 判断是纸质还是电子
     *
     * @param traceCodeNumber
     * @return
     */
    private boolean isPapperOrElectric(String traceCodeNumber) {
        ZslTraceExample zslTraceExample = new ZslTraceExample();
        ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
        List<ZslTrace> zslTraceList = zslTraceMapper.selectByExample(zslTraceExample);
        if (CollectionUtils.isNotEmpty(zslTraceList) && zslTraceList.get(0).getTraceApplyType() - 1 == 0) {
            return true;
        }
        return false;
    }

    /**
     * 根据批次号获取申请的纸质码段
     *
     * @param traceCodeNumber
     * @return
     */
    private List<ZslTracePapper> getTracePaperByTraceCodeNumber(String traceCodeNumber) {
        ZslTracePapperExample zslTracePapperExample = new ZslTracePapperExample();
        ZslTracePapperExample.Criteria criteria = zslTracePapperExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
        zslTracePapperExample.setOrderByClause("trace_num_start asc");
        return zslTracePapperMapper.selectByExample(zslTracePapperExample);
    }

    /**
     * 根据批次号获取当前关联指针
     * @param traceCodeNumber
     * @return
     */
    private ZslTraceRelation getRelationByTraceCodeNumber(String traceCodeNumber) {
        ZslTraceRelationExample zslTraceRelationExample = new ZslTraceRelationExample();
        ZslTraceRelationExample.Criteria criteria = zslTraceRelationExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
        List<ZslTraceRelation> result = zslTraceRelationMapper.selectByExample(zslTraceRelationExample);
        if (CollectionUtils.isNotEmpty(result)) {
            return result.get(0);
        } else {
            return null;
        }
    }

    /**
     * 获取数量和修改当前关联指针
     * @param count
     * @param traceCodeNumber
     * @return
     */
    private List<ZslTracePapper> getTracePaperBy(long count, String traceCodeNumber){
        //
        List<ZslTracePapper> relationPaperList = getTracePaperByTraceCodeNumber(traceCodeNumber);
        if (CollectionUtils.isNotEmpty(relationPaperList)) {
            //统计数量
            Long countRelation = 0L;
            List<ZslTracePapper> relationParam = new ArrayList<>();
            for (int j = 0; j < relationPaperList.size(); j++) {
                long startN = 0L;
                long endN = 0L;
                ZslTracePapper zslTracePapper = new ZslTracePapper();
                //获取当前已经关联的下标
                ZslTraceRelation zslTraceRelation = getRelationByTraceCodeNumber(traceCodeNumber);
                if(zslTraceRelation != null && (zslTraceRelation.getCurrentIndexRelation()+1 - relationPaperList.get(j).getTraceNumStart() >= 0 && zslTraceRelation.getCurrentIndexRelation()+1 - relationPaperList.get(j).getTraceNumEnd() <= 0)){
                    startN = zslTraceRelation.getCurrentIndexRelation()+1;
                }else{
                    startN =relationPaperList.get(j).getTraceNumStart();
                }
                endN = relationPaperList.get(j).getTraceNumEnd();
                zslTracePapper.setTraceNumStart(startN);
                zslTracePapper.setTraceNumEnd(endN);
                for(long n = startN; n <= endN;n++) {
                    if(zslTraceRelation != null && (n - (zslTraceRelation.getCurrentIndexRelation()+1) >= 0)){
                        countRelation++;
                    }else if(zslTraceRelation == null){
                        countRelation++;
                    }
                    if(countRelation - count == 0){
                        //已经足够
                        zslTracePapper.setTraceNumEnd(n);
                        //更新关联指针
                        if(zslTraceRelation == null){
                            ZslTraceRelation relaTionInsert = new ZslTraceRelation();
                            relaTionInsert.setTraceCodeNumber(traceCodeNumber);
                            relaTionInsert.setCurrentIndexRelation(n);
                            zslTraceRelationMapper.insert(relaTionInsert);
                        }else{
                            ZslTraceRelation relationUpdate = new ZslTraceRelation();
                            relationUpdate.setId(zslTraceRelation.getId());
                            relationUpdate.setCurrentIndexRelation(n);
                            zslTraceRelationMapper.updateByPrimaryKeySelective(relationUpdate);
                        }
                        if(zslTracePapper.getTraceNumEnd() - zslTracePapper.getTraceNumStart() >= 0){
                            relationParam.add(zslTracePapper);
                        }
                        return relationParam;
                    }

                }
                if(zslTracePapper.getTraceNumEnd() - zslTracePapper.getTraceNumStart() >= 0){
                    if(zslTraceRelation != null && (zslTracePapper.getTraceNumEnd() - (zslTraceRelation.getCurrentIndexRelation()+1) < 0)){}else{
                        relationParam.add(zslTracePapper);
                    }
                }

            }
            return relationParam;
        }else{
            return null;
        }
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
            if (isPaperType) {
                List<ZslTracePapper> papperList = getTracePaperBy(count,traceCodeNumber);
                if(papperList != null){
                    long countTemp = fromNumber;
                    for(int i = 0;i < papperList.size();i++){
                        long start = papperList.get(i).getTraceNumStart();
                        long end = papperList.get(i).getTraceNumEnd();
                        //关联操作
                        List<Long> traceCodeIdsPaper = zslTraceSubcodeDao.selectBySidRange(start, end);
                        List<TraceSubcodeUpdateParamSid> updateSidParams = new ArrayList<>();
                        for (int j = 0; j < traceCodeIdsPaper.size(); j++) {
                            TraceSubcodeUpdateParamSid traceSubcodeUpdateParamSid = new TraceSubcodeUpdateParamSid(countTemp, traceCodeNumber, goodsId, stallId, traceCodeIdsPaper.get(j));
                            updateSidParams.add(traceSubcodeUpdateParamSid);
                            if(updateSidParams.size() % 1000 == 0){
                                int m = zslTraceSubcodeDao.updateGoodsAndStallSid(updateSidParams);
                                updateSidParams.clear();
                            }
                            countTemp++;
                        }
                        if (updateSidParams.size() > 0) {
                            zslTraceSubcodeDao.updateGoodsAndStallSid(updateSidParams);
                        }
                    }
                }
            } else {
                //电子
                int totalPage = (int) Math.ceil((double) count / 1000);
                for (int currentPage = 1; currentPage <= totalPage; currentPage++) {
                    Long fromIndex = 0L;
                    Long toIndex = 0L;
                    fromIndex = new Long((currentPage - 1) * 1000 + fromNumber);
                    if (currentPage - totalPage == 0) {
                        toIndex = toNumber;
                    } else {
                        toIndex = new Long(currentPage * 1000) + fromNumber;
                    }

                    List<Long> traceCodeIds = zslTraceSubcodeDao.selectByRange(fromIndex, toIndex, traceCodeNumber);
                    List<TraceSubcodeUpdateParam> updateParams = new ArrayList<>();
                    for (int i = 0; i < traceCodeIds.size(); i++) {
                        TraceSubcodeUpdateParam traceSubcodeUpdateParam = new TraceSubcodeUpdateParam(goodsId, stallId, traceCodeIds.get(i));
                        updateParams.add(traceSubcodeUpdateParam);
                    }
                    int j = zslTraceSubcodeDao.updateGoodsAndStall(updateParams);
                }
            }
        } catch (Exception e) {
        }
    }
}