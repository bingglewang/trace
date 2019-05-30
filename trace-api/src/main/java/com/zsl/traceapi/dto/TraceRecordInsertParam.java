package com.zsl.traceapi.dto;

import lombok.Data;

@Data
public class TraceRecordInsertParam {
    private String traceCodeNumber; //关联追溯码批次号

    private Integer traceGoodId; //关联商品id

    private Integer traceToNumber;  //商品起始编码

    private Integer traceFromNumber; //商品结束编码

    private Integer traceStallId; //关联摊位id（没有则为非农贸）
}
