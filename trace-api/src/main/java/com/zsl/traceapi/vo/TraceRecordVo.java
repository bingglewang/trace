package com.zsl.traceapi.vo;

import lombok.Data;

@Data
public class TraceRecordVo {
    private Integer traceRecordId;
    private String traceCodeNumber;
    private Integer traceGoodId;
    private String traceGoodsName;
    private Long traceToNumber;
    private Long traceFromNumber;
    private Integer traceStallId;
    private String traceStallName;
    private Long fromSid;
    private Long toSid;
}
