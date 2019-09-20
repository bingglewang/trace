package com.zsl.traceapi.dto;

import lombok.Data;

@Data
public class TraceSubcodeInsertParam {
    private String traceCodeNumber; //关联追溯码批次号
    private String traceSubcodeNumber; //子追溯码
    private Long traceIndex; //编码序号
    private Long traceSid;
}
