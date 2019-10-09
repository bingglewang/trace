package com.zsl.traceapi.dto;

import lombok.Data;

@Data
public class MerchantRankVo {
    /**
     * 商家名称
     */
    private String merchantName;

    /**
     * 追溯额数量
     */
    private Long traceCount;
}
