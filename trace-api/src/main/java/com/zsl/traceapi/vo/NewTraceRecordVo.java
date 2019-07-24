package com.zsl.traceapi.vo;

import lombok.Data;

import java.util.Date;

@Data
public class NewTraceRecordVo {
    private Integer traceId;
    private Date traceApplyDate;
    private String merchantName;
    private Long traceApplyCount;
    private String handleStatus;
    private String merchantLogo;
    private String traceCodeNumber;
    private String traceRefuseRemark;
}
