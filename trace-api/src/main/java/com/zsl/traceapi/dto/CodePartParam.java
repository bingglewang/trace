package com.zsl.traceapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CodePartParam
 * @Description 覆盖码段
 * @Author binggleW
 * @Date 2019-10-07 16:42
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodePartParam {
    /**
     * 码段开始
     */
    private Long startNum;

    /**
     * 码段结束
     */
    private Long endNum;

    /**
     * 数量
     */
    private Long count;
}
