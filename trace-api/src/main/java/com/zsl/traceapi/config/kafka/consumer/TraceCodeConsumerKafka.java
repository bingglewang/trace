package com.zsl.traceapi.config.kafka.consumer;

import com.zsl.traceapi.util.MyThread;
import com.zsl.traceapi.util.TraceSidThread;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 追溯子码监听消费者
 */
@Component
public class TraceCodeConsumerKafka {

    @KafkaListener(topics = "traceInsert")
    public void handle(ConsumerRecord<?, ?> record){
        String traceCodeNumber = record.value().toString();
        try {
            Long zslTradeSid = Long.parseLong(traceCodeNumber);
            new TraceSidThread(zslTradeSid).start();
        }catch (Exception e){
            new MyThread(traceCodeNumber).start();
        }
    }




}
