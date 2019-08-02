package com.zsl.traceapi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ScanPointQueryParam {
    private String tracePointName;
    private Date tracePointTime;
}
