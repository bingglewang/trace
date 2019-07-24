package com.zsl.traceapi.dto;

import lombok.Getter;

@Getter
public enum QueueEnum {
    /**
     * 追溯队列
     */
    QUEUE_TRACE_CODE("trace.code.direct", "trace.code.generator", "trace.code.generator");

    /**
     * 交换名称
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 路由键
     */
    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}
