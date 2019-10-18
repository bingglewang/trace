package com.zsl.traceapi.dto;

import lombok.Data;

@Data
public class TraceSubcodeInsertParam {
    /**
     * 关联追溯码批次号
     */
    private String traceCodeNumber;

    /**
     * 子追溯码
     */
    private String traceSubcodeNumber;

    /**
     * 编码序号
     */
    private Long traceIndex;
    private Long traceSid;
}
