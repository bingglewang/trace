package com.zsl.traceapi.vo;

import lombok.Data;

/**
 * @ClassName SpurtCodeVo
 * @Description 喷码封装
 * @Author binggleW
 * @Date 2020-01-05 11:53
 * @Version 1.0
 **/
@Data
public class SpurtCodeVo {
    /**
     * 追溯码
     */
    private String traceCodeNumber;

    /**
     * sid
     */
    private Long sid;
}
