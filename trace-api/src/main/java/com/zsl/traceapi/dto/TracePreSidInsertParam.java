package com.zsl.traceapi.dto;

import lombok.Data;

/**
 * @ClassName TracePreSidInsertParam
 * @Description TODO
 * @Author binggleW
 * @Date 2019-09-20 16:29
 * @Version 1.0
 **/
@Data
public class TracePreSidInsertParam {
    private String traceSubcodeNumber; //子追溯码
    private Long traceSid; //sid
}
