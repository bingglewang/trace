package com.zsl.traceapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class RelationOutCode {
    /**
     * 外码
     */
    private String outCode;

    /**
     * 子码列表
     */
    private List<String> subCodeList;
}
