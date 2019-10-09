package com.zsl.traceapi.dto;

import lombok.Data;

@Data
public class MiniCodeInsertParam {
    /**
     * 关联追溯码批次号
     */
    private String traceCodeNumber;

    /**
     * 商品起始编码
     */
    private Integer traceToNumber;

    /**
     * 商品结束编码
     */
    private Integer traceFromNumber;

    /**
     * 设置外码比例
     */
    private Integer outCodeRadio;

    /**
     * 关联商品id
     */
    private Integer traceGoodId;

    /**
     * 关联摊位id（没有则为非农贸）
     */
    private Integer traceStallId;
}
