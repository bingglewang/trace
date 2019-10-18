package com.zsl.traceapi.dto;

import lombok.Data;

@Data
public class TraceOutCodeUpdateParam {
    /**
     * 父码的id
     */
    private Long parentId;

    /**
     * 主键
     */
    private Long id;

    /**
     * 节点层级
     */
    private Integer nodeLevel;
}
