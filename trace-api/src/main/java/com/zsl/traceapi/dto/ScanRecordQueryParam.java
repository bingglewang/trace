package com.zsl.traceapi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ScanRecordQueryParam {
    private Date scanTime;
    private String scanAddress;
}
