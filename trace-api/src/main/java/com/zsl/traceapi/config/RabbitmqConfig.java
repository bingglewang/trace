package com.zsl.traceapi.config;

import com.zsl.traceapi.dto.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    /**
     * 追溯子码实际消费队列所绑定的交换机
     * @return
     */
    @Bean
    DirectExchange traceCodeDirect(){
        return (DirectExchange) ExchangeBuilder
                .directExchange(QueueEnum.QUEUE_TRACE_CODE.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 追组子码队列
     * @return
     */
    @Bean
    public Queue traceCodeQueue(){
        return new Queue(QueueEnum.QUEUE_TRACE_CODE.getName(),true,false,false);
    }

    /**
     * 将队列绑定到交换机
     * @param traceCodeDirect
     * @param traceCodeQueue
     * @return
     */
    @Bean
    Binding traceCodeBinding(DirectExchange traceCodeDirect,Queue traceCodeQueue){
        return BindingBuilder
                .bind(traceCodeQueue)
                .to(traceCodeDirect)
                .with(QueueEnum.QUEUE_TRACE_CODE.getRouteKey());
    }
}
