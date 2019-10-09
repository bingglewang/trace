package com.zsl.traceapi.dto;

import lombok.Data;

@Data
public class OutCodeBatch {
    /**
     * 外码开始
     */
    private Long outCodeStart;

    /**
     * 外码结束
     */
    private Long outCodeEnd;

    /**
     * 内码开始
     */
    private Long inCodeStart;

    /**
     * 内码结束
     */
    private Long inCodeEnd;
}
