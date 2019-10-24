package com.zsl.traceapi.dto;

import com.zsl.tracedb.model.ZslTracePapper;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TraceCodeRelation implements Serializable {
    private Long fromNumber;
    private Long toNumber;
    private int goodsId;
    private int stallId;
    private String traceCodeNumber;
    private List<ZslTracePapper> tracePappers;
}
