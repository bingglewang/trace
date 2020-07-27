package com.zsl.traceapi.dto;

import lombok.Data;

@Data
public class TraceRecordInsertParam {
    /**
     * 关联追溯码批次号
     */
    private String traceCodeNumber;

    /**
     * 关联商品id
     */
    private Integer traceGoodId;

    /**
     * 商品起始编码
     */
    private Long traceToNumber;

    /**
     * 商品结束编码
     */
    private Long traceFromNumber;

    /**
     * 关联摊位id（没有则为非农贸）
     */
    private Integer traceStallId;

    /**
     * 生产批次
     */
    private String productionBatch;
}
