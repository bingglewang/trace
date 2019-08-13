package com.zsl.traceapi.config.kafka.producer;

import com.zsl.traceapi.dto.QueueEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class TraceUpdateProducerKafka {
    private static Logger logger = LoggerFactory.getLogger(TraceUpdateProducerKafka.class);

    @Autowired
    KafkaTemplate kafkaTemplate;

    public void sendMessage(String traceCodeJson) throws Exception{
        //给延迟队列发送消息
        kafkaTemplate.send("test",traceCodeJson);
        logger.info("发送的json字符串:{}",traceCodeJson);
    }
}
