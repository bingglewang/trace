package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class IntegralDeductRatio implements Serializable {
    private Integer integralDeductRatioId;

    private Integer integralDeductRatioType;

    @ApiModelProperty(value = "扣减或兑换的比例积分")
    private Integer integralRatio;

    @ApiModelProperty(value = "备注")
    private String integralDeductRatioDesciption;

    private static final long serialVersionUID = 1L;

    public Integer getIntegralDeductRatioId() {
        return integralDeductRatioId;
    }

    public void setIntegralDeductRatioId(Integer integralDeductRatioId) {
        this.integralDeductRatioId = integralDeductRatioId;
    }

    public Integer getIntegralDeductRatioType() {
        return integralDeductRatioType;
    }

    public void setIntegralDeductRatioType(Integer integralDeductRatioType) {
        this.integralDeductRatioType = integralDeductRatioType;
    }

    public Integer getIntegralRatio() {
        return integralRatio;
    }

    public void setIntegralRatio(Integer integralRatio) {
        this.integralRatio = integralRatio;
    }

    public String getIntegralDeductRatioDesciption() {
        return integralDeductRatioDesciption;
    }

    public void setIntegralDeductRatioDesciption(String integralDeductRatioDesciption) {
        this.integralDeductRatioDesciption = integralDeductRatioDesciption;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", integralDeductRatioId=").append(integralDeductRatioId);
        sb.append(", integralDeductRatioType=").append(integralDeductRatioType);
        sb.append(", integralRatio=").append(integralRatio);
        sb.append(", integralDeductRatioDesciption=").append(integralDeductRatioDesciption);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}