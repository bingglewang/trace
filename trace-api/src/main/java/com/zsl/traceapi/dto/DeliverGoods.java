package com.zsl.traceapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class DeliverGoods {
    /**
     * 外码或内码
     */
    private List<String> codeNumber;

    /**
     * 商家名称
     */
    private String bussName;
}
