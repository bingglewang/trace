package com.zsl.traceapi.dto;

import lombok.Data;

@Data
public class TraceOutCodeUpdateParam {
    private Long parentId; //父码的id
    private Long id; //主键
}
