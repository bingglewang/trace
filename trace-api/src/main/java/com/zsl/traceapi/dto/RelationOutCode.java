package com.zsl.traceapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class RelationOutCode {
    private String outCode; //外码
    private List<String> subCodeList; // 子码列表
}
