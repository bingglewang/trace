package com.zsl.traceapi.dto;

import com.zsl.traceapi.validator.FlagValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ZslTraceAddAndUpdateParam {
    @ApiModelProperty(value = "关联商家id")
    private Integer traceBusinessId;

    @ApiModelProperty(value = "申请类型（1：纸质标签，2：电子标签）")
    @FlagValidator(value = {"1","2"},message = "申请类型值只能为1或者2")
    private Integer traceApplyType;

    @ApiModelProperty(value = "申请数量")
    private Long traceApplyCount;
}
