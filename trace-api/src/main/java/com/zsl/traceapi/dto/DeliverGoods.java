package com.zsl.traceapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class DeliverGoods {
    private List<String> codeNumber;//外码或内码
    private String bussName; // 商家名称
}
