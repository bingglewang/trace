package com.zsl.traceapi.dto;

import lombok.Data;

@Data
public class ScanRecordInsertParam {
    /**
     * 扫码地址
     */
    private String scanAddress;

    /**
     * 扫码时间
     */
    private Long scanTime;
    private Long sid;
}
