package com.zsl.traceapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName TraceSubcodeUpdateParamSid
 * @Description 子码关联封装类
 * @Author binggleW
 * @Date 2019-09-20 18:05
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TraceSubcodeUpdateParamSid {
    /**
     * 下标
     */
    private Long traceIndex;
    /**
     * 追溯批次号
     */
    private String traceCodeNumber;
    /**
     * 商品id
     */
    private Integer goodsId;
    /**
     * 摊位id
     */
    private Integer stallId;
    /**
     * 主键
     */
    private Long id;
}
