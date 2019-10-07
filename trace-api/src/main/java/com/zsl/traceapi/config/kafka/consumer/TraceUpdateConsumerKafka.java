package com.zsl.traceapi.config.kafka.consumer;

import com.zsl.traceapi.util.CoreThread;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TraceUpdateConsumerKafka {
    private static Logger logger = LoggerFactory.getLogger(TraceUpdateConsumerKafka.class);


    @KafkaListener(topics = "traceUpdate")
    public void handle(ConsumerRecord<?, ?> record) {
        logger.info("接受到的json字符串:{}", record.value());
        String traceCodeJson = record.value().toString();
        new CoreThread(traceCodeJson).start();
    }



}
