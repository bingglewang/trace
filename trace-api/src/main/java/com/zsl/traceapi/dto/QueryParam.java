package com.zsl.traceapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class QueryParam {
    private String traceCodeNumber; //追溯码批次号
    private String traceCompanyName; //所属公司名称
    private Date traceApplyStartDate; //申请开始日期
    private Date traceApplyEndDate; //申请结束日期
    private Integer traceHandleStatus; //处理状态
    private String merchantName; //商家名称
}
