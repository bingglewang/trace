package com.zsl.traceapi.dto;

import lombok.Data;

@Data
public class MerchantRankVo {
    private String merchantName; //商家名称
    private Long traceCount; //追溯额数量
}
