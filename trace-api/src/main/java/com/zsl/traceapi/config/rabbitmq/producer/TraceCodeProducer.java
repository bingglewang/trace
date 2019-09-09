package com.zsl.traceapi.config.rabbitmq.producer;

import com.zsl.traceapi.dto.QueueEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class TraceCodeProducer {
    private static Logger logger = LoggerFactory.getLogger(TraceCodeProducer.class);

    //@Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(String traceCodeNumber,final long delayTimes) throws Exception{
        //给延迟队列发送消息
        amqpTemplate.convertAndSend(QueueEnum.QUEUE_TRACE_CODE.getExchange(), QueueEnum.QUEUE_TRACE_CODE.getRouteKey(), traceCodeNumber, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //给消息设置延迟毫秒值
                message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                message.getMessageProperties().setExpiration(String.valueOf(delayTimes));
                return message;
            }
        });
        logger.info("发送的批次号:{}",traceCodeNumber);
    }
}
