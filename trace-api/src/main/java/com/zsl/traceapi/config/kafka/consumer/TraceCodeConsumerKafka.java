package com.zsl.traceapi.config.kafka.consumer;

import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.dto.TracePreSidInsertParam;
import com.zsl.traceapi.util.RandomUtil;
import com.zsl.tracedb.mapper.ZslTraceSidMapper;
import com.zsl.tracedb.model.*;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 追溯子码监听消费者
 */
@Component
public class TraceCodeConsumerKafka {

    private Logger logger = LoggerFactory.getLogger(TraceCodeConsumerKafka.class);

    @Autowired
    private ZslTraceSubcodeDao zslTraceSubcodeDao;

    @Autowired
    private ZslTraceSidMapper zslTraceSidMapper;

    @KafkaListener(topics = "traceInsert")
    public void handle(ConsumerRecord<?, ?> record){
        String traceCodeNumber = record.value().toString();
        try {
            Long zslTradeSid = Long.parseLong(traceCodeNumber);
            //原来
            //new TraceSidThread(zslTradeSid).start();
            //现在
            run(zslTradeSid);
        }catch (Exception e){
            logger.info("生成失败:{traceInsert}"+traceCodeNumber);
        }
    }


    public void run(Long zslTradeSid){
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
