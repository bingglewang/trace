package com.zsl.traceapi.dto;

import lombok.Data;

@Data
public class TraceRecordPointParam {
    private Integer traceGoodsId;//关联商品id

    private Integer traceStallId;//摊位id（非农贸则为-1）

    private String tracePointName;//追溯点其他信息

    private Integer tracePointToNumber;//追溯点起始编码

    private Integer tracePointFromNumber;//追溯点结束编码

    private Integer traceParentId;//父节点id
}
