package com.zsl.traceapi.config.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class TraceCodeProducerKafka {
    private static Logger logger = LoggerFactory.getLogger(TraceCodeProducerKafka.class);

    @Autowired
    KafkaTemplate kafkaTemplate;

    public void sendMessage(String traceCodeNumber) throws Exception{
        //给延迟队列发送消息
        kafkaTemplate.send("traceInsert",0,null,traceCodeNumber);
        logger.info("发送的批次号:{}",traceCodeNumber);
    }
}
