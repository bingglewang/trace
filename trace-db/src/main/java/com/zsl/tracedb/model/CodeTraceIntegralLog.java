package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class CodeTraceIntegralLog implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "商家id")
    private Integer merchantId;

    @ApiModelProperty(value = "扫码追溯主键id")
    private Integer functionId;

    @ApiModelProperty(value = "当前扣除的积分数")
    private Integer deductIntegral;

    @ApiModelProperty(value = "扣除后剩余积分数")
    private Integer surplusIntegral;

    @ApiModelProperty(value = "扣减时间")
    private Date deductTime;

    @ApiModelProperty(value = "扣减状态：1未扣减、2已扣减")
    private Integer deductStatus;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public Integer getDeductIntegral() {
        return deductIntegral;
    }

    public void setDeductIntegral(Integer deductIntegral) {
        this.deductIntegral = deductIntegral;
    }

    public Integer getSurplusIntegral() {
        return surplusIntegral;
    }

    public void setSurplusIntegral(Integer surplusIntegral) {
        this.surplusIntegral = surplusIntegral;
    }

    public Date getDeductTime() {
        return deductTime;
    }

    public void setDeductTime(Date deductTime) {
        this.deductTime = deductTime;
    }

    public Integer getDeductStatus() {
        return deductStatus;
    }

    public void setDeductStatus(Integer deductStatus) {
        this.deductStatus = deductStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", functionId=").append(functionId);
        sb.append(", deductIntegral=").append(deductIntegral);
        sb.append(", surplusIntegral=").append(surplusIntegral);
        sb.append(", deductTime=").append(deductTime);
        sb.append(", deductStatus=").append(deductStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}