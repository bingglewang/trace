package com.zsl.traceapi.dto;

import lombok.Data;

/**
 * @ClassName TracePreSidInsertParam
 * @Description 纸质码预生成封装类
 * @Author binggleW
 * @Date 2019-09-20 16:29
 * @Version 1.0
 **/
@Data
public class TracePreSidInsertParam {
    /**
     * 子追溯码
     */
    private String traceSubcodeNumber;

    /**
     * sid
     */
    private Long traceSid;
}
