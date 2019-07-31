package com.zsl.traceapi.dto;

import lombok.Data;

@Data
public class OutCodeBatch {
    private Long outCodeStart; //外码开始
    private Long outCodeEnd; //外码结束
    private Long inCodeStart; //内码开始
    private Long inCodeEnd; // 内码结束
}
