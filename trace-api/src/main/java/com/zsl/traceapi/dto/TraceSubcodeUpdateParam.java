package com.zsl.traceapi.dto;

import lombok.Data;

@Data
public class TraceSubcodeUpdateParam {
    private Integer goodsId; //商品id
    private Integer stallId; //摊位id
    private Long id; //主键
}
