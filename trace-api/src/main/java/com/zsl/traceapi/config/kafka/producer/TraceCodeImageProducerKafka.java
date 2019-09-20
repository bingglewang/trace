package com.zsl.traceapi.config.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @ClassName TraceCodeImageProducerKafka
 * @Description 三维码图片生产者
 * @Author binggleW
 * @Date 2019-09-16 12:00
 * @Version 1.0
 **/
@Component
public class TraceCodeImageProducerKafka {
    private static Logger logger = LoggerFactory.getLogger(TraceCodeImageProducerKafka.class);

    @Autowired
    KafkaTemplate kafkaTemplate;

    public void sendMessage(String traceCodeNumber) throws Exception{
        //给延迟队列发送消息
        kafkaTemplate.send("zidingyi",traceCodeNumber);
        logger.info("要生成三维吗的批次号:{}",traceCodeNumber);
    }
}
