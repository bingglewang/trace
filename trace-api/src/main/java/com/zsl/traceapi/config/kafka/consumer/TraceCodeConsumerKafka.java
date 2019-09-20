package com.zsl.traceapi.config.kafka.consumer;

import com.zsl.traceapi.config.kafka.producer.TraceCodeImageProducerKafka;
import com.zsl.traceapi.config.kafka.producer.TraceCodeProducerKafka;
import com.zsl.traceapi.dao.ZslTraceSidDao;
import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.dto.TracePreSidInsertParam;
import com.zsl.traceapi.dto.TraceSubcodeInsertParam;
import com.zsl.traceapi.util.RandomUtil;
import com.zsl.tracedb.mapper.ZslTraceMapper;
import com.zsl.tracedb.mapper.ZslTraceSidMapper;
import com.zsl.tracedb.model.ZslTrace;
import com.zsl.tracedb.model.ZslTraceExample;
import com.zsl.tracedb.model.ZslTraceSid;
import com.zsl.tracedb.model.ZslTraceSubcode;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 追溯子码监听消费者
 */
@Component
public class TraceCodeConsumerKafka {
    private static Logger logger = LoggerFactory.getLogger(TraceCodeConsumerKafka.class);

    @Autowired
    private ZslTraceMapper zslTraceMapper;

    @Autowired
    private ZslTraceSubcodeDao zslTraceSubcodeDao;

    @Autowired
    private ZslTraceSidDao zslTraceSidDao;

    @Autowired
    private ZslTraceSidMapper zslTraceSidMapper;

    @Autowired
    private TraceCodeProducerKafka traceCodeProducerKafka;

    @Autowired
    private TraceCodeImageProducerKafka traceCodeImageProducerKafka;

    @KafkaListener(topics = "traceInsert")
    public void handle(ConsumerRecord<?, ?> record){
        String traceCodeNumber = record.value().toString();
        try {
            Long zslTradeSid = Long.parseLong(traceCodeNumber);
            new TraceSidThread(zslTradeSid);
        }catch (Exception e){
            new MyThread(traceCodeNumber).start();
        }
    }

    class TraceSidThread extends Thread{
        private Long zslTradeSid;

        TraceSidThread(Long zslTradeSid){
            this.zslTradeSid = zslTradeSid;
        }

        @Override
        public void run(){
            logger.info("要预生成的id:{}", zslTradeSid);
            //根据id 获取sid记录
            ZslTraceSid zslTraceSid = zslTraceSidMapper.selectByPrimaryKey(zslTradeSid);
            if(zslTraceSid != null){
                Long startIndex = zslTraceSid.getSidStartIndex();
                Long endIndex = zslTraceSid.getSidEndIndex();
                List<TracePreSidInsertParam> insertParams = new ArrayList<>();
                Long currentTimeStamp = System.currentTimeMillis() * 1000;
                for(Long i = startIndex; i <= endIndex; i++){
                    TracePreSidInsertParam tracePreSidInsertParam = new TracePreSidInsertParam();
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(RandomUtil.getRandNumberCode(4));
                    stringBuffer.append(currentTimeStamp);
                    stringBuffer.append(i + 1);
                    tracePreSidInsertParam.setTraceSid(i);
                    tracePreSidInsertParam.setTraceSubcodeNumber(stringBuffer.toString());
                    insertParams.add(tracePreSidInsertParam);
                    if (insertParams.size() >= 10000) {
                        zslTraceSubcodeDao.insertCodePreSidBatch(insertParams);
                        insertParams.clear();
                    }
                }
                //循环完
                if (insertParams.size() > 0) {
                    zslTraceSubcodeDao.insertCodePreSidBatch(insertParams);
                }
                //修改生成状态
                ZslTraceSid sidUpdate = new ZslTraceSid();
                sidUpdate.setId(zslTradeSid);
                sidUpdate.setSidPreCreate((byte)1); //修改为已经生成完
                zslTraceSidMapper.updateByPrimaryKeySelective(sidUpdate);
                logger.info("已经预生成完的id:{}", zslTradeSid);
            }
        }

    }

    class MyThread extends Thread{
        private String traceCodeNumber;

        MyThread(String traceCodeNumber){
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

                //拿到追溯信息
                ZslTraceExample zslTraceExample = new ZslTraceExample();
                ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
                criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
                List<ZslTrace> zslTraceList = zslTraceMapper.selectByExample(zslTraceExample);
                if (!(CollectionUtils.isEmpty(zslTraceList))) {
                    Long count = zslTraceList.get(0).getTraceApplyCount();
                    List<TraceSubcodeInsertParam> insertParams = new ArrayList<>();
                    Long currentTimeStamp = System.currentTimeMillis() * 1000;

                    //拿到最新sid信息
                    ZslTraceSid zslTraceSid = zslTraceSidDao.selectNewPrePaperCode();
                    Long sidStart = 18000000L;
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
                    //调用生成三维码接口
                    traceCodeImageProducerKafka.sendMessage(traceCodeNumber);
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
}
