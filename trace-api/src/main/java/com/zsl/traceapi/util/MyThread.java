package com.zsl.traceapi.util;

import com.zsl.traceapi.config.kafka.producer.TraceCodeImageProducerKafka;
import com.zsl.traceapi.config.kafka.producer.TraceCodeProducerKafka;
import com.zsl.traceapi.dao.ZslTraceSidDao;
import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.dto.TraceSubcodeInsertParam;
import com.zsl.tracedb.mapper.ZslTraceMapper;
import com.zsl.tracedb.mapper.ZslTraceSidMapper;
import com.zsl.tracedb.model.ZslTrace;
import com.zsl.tracedb.model.ZslTraceExample;
import com.zsl.tracedb.model.ZslTraceSid;
import com.zsl.tracedb.model.ZslTraceSubcode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.zsl.traceapi.dto.InitPaperStart.INIT_SID_START_INDES;

/**
 * @ClassName MyThread
 * @Description TODO
 * @Author binggleW
 * @Date 2019-10-08 16:26
 * @Version 1.0
 **/
public  class MyThread extends Thread{
    private static Logger logger = LoggerFactory.getLogger(MyThread.class);

    private ZslTraceMapper zslTraceMapper = (ZslTraceMapper)SpringContextUtil.getBean(ZslTraceMapper.class);

    private ZslTraceSubcodeDao zslTraceSubcodeDao = (ZslTraceSubcodeDao)SpringContextUtil.getBean(ZslTraceSubcodeDao.class);

    private ZslTraceSidDao zslTraceSidDao = (ZslTraceSidDao)SpringContextUtil.getBean(ZslTraceSidDao.class);

    private ZslTraceSidMapper zslTraceSidMapper = (ZslTraceSidMapper)SpringContextUtil.getBean(ZslTraceSidMapper.class);

    private TraceCodeProducerKafka traceCodeProducerKafka = (TraceCodeProducerKafka)SpringContextUtil.getBean(TraceCodeProducerKafka.class);


    private String traceCodeNumber;

    public MyThread(String traceCodeNumber){
        this.traceCodeNumber = traceCodeNumber;
    }

    @Override
    public void run(){
        try {
            logger.info("要生成的批次号:{}", traceCodeNumber);
            //判断是否已经有，有则删掉之前的
            ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectByCodeNumber(traceCodeNumber);
            if (zslTraceSubcode != null) {
                int j = zslTraceSubcodeDao.deleteByCodeNumber(traceCodeNumber);
                logger.info(zslTraceSubcode + "的删除结果:{}", j);
            }

            //拿到最新sid信息
            ZslTraceSid zslTraceSid = zslTraceSidDao.selectNewPrePaperCode();

            //拿到追溯信息
            ZslTraceExample zslTraceExample = new ZslTraceExample();
            ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
            criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
            List<ZslTrace> zslTraceList = zslTraceMapper.selectByExample(zslTraceExample);
            if (!(CollectionUtils.isEmpty(zslTraceList))) {
                Long count = zslTraceList.get(0).getTraceApplyCount();
                List<TraceSubcodeInsertParam> insertParams = new ArrayList<>();
                Long currentTimeStamp = System.currentTimeMillis() * 1000;

                Long sidStart = INIT_SID_START_INDES;
                if(zslTraceSid == null){
                    //插入一个记录电子下标的记录
                    ZslTraceSid insertE = new ZslTraceSid();
                    insertE.setSidPreCreate((byte)(-1));
                    insertE.setCreateTime(new Date());
                    insertE.setSidStartIndex(0L);
                    insertE.setSidEndIndex(0L);
                    insertE.setCurrentEIndex(sidStart + count - 1);
                    zslTraceSidMapper.insert(insertE);
                }else{
                    sidStart = zslTraceSid.getCurrentEIndex() + 1;
                }

                for (int i = 0; i < count; i++) {
                    StringBuffer stringBuffer = new StringBuffer();
                    TraceSubcodeInsertParam subcodeInsertParam = new TraceSubcodeInsertParam();
                    stringBuffer.append(RandomUtil.getRandNumberCode(4));
                    stringBuffer.append(currentTimeStamp);
                    stringBuffer.append(i + 1);
                    subcodeInsertParam.setTraceIndex(new Long(i + 1));
                    subcodeInsertParam.setTraceCodeNumber(traceCodeNumber);
                    subcodeInsertParam.setTraceSubcodeNumber(stringBuffer.toString());
                    subcodeInsertParam.setTraceSid(sidStart + i);
                    insertParams.add(subcodeInsertParam);
                    if (insertParams.size() >= 10000) {
                        zslTraceSubcodeDao.insertCodeBatch(insertParams);
                        insertParams.clear();
                    }
                }
                if (insertParams.size() > 0) {
                    zslTraceSubcodeDao.insertCodeBatch(insertParams);
                }
                //修改追溯状态为：已生成Y
                ZslTrace updateTrace = new ZslTrace();
                updateTrace.setTraceId(zslTraceList.get(0).getTraceId());
                updateTrace.setTraceBack3("Y");
                zslTraceMapper.updateByPrimaryKeySelective(updateTrace);
                //更改当前电子指针位置
                if(zslTraceSid != null){
                    ZslTraceSid updateE = new ZslTraceSid();
                    updateE.setId(zslTraceSid.getId());
                    updateE.setCurrentEIndex(zslTraceSid.getCurrentEIndex() + zslTraceList.get(0).getTraceApplyCount());
                    zslTraceSidMapper.updateByPrimaryKeySelective(updateE);
                }
                //调用生成三维码接口
                // traceCodeImageProducerKafka.sendMessage(traceCodeNumber);
            }
            logger.info("已经完成的批次号:{}", traceCodeNumber);
        }catch (Exception e){
            logger.info("处理失败:{}", traceCodeNumber);
            try {
                traceCodeProducerKafka.sendMessage(traceCodeNumber);
            }catch (Exception e1){
            }
        }
    }
}
