package com.zsl.traceapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author binggleWang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TraceSubcodeUpdateParam {
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
