package com.zsl.traceapi.dto;

import lombok.Data;

@Data
public class ScanRecordInsertParam {
    private String scanAddress; //扫码地址
    private Long scanTime; //扫码时间
    private Long sid;
}
