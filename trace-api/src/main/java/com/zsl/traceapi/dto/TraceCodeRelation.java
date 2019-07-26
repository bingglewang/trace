package com.zsl.traceapi.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TraceCodeRelation implements Serializable {
    private Long fromNumber;
    private Long toNumber;
    private int goodsId;
    private int stallId;
    private String traceCodeNumber;
}
