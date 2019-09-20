package com.zsl.traceapi.dto;

import lombok.Data;

/**
 * @ClassName TraceSubcodeUpdateParamSid
 * @Description TODO
 * @Author binggleW
 * @Date 2019-09-20 18:05
 * @Version 1.0
 **/
@Data
public class TraceSubcodeUpdateParamSid {
    private Long traceIndex;
    private String traceCodeNumber;
    private Integer goodsId; //商品id
    private Integer stallId; //摊位id
    private Long id; //主键
}
