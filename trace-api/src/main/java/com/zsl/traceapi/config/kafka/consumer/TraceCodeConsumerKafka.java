package com.zsl.traceapi.config.kafka.consumer;

import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.dto.TracePreSidInsertParam;
import com.zsl.traceapi.util.MyThread;
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

   

    @KafkaListener(topics = "traceInsert")
    public void handle(ConsumerRecord<?, ?> record){
        String traceCodeNumber = record.value().toString();
        try {
            //原来
            new MyThread(traceCodeNumber).start();
           
        }catch (Exception e){
            logger.info("生成失败:{traceInsert}"+traceCodeNumber);
        }
    }

}
