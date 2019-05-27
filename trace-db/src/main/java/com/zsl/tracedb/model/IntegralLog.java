package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class IntegralLog implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "操作类型：0积分增加、1积分扣减")
    private Integer operationType;

    @ApiModelProperty(value = "操作业务：例如 认证、商品录入")
    private String function;

    @ApiModelProperty(value = "操作业务表主键id 例如：追溯表（追溯会扣减积分）")
    private Integer functionId;

    @ApiModelProperty(value = "当前操作要增减的积分数")
    private Integer operationIntegral;

    @ApiModelProperty(value = "操作增减后总积分数")
    private Integer totalIntegral;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public Integer getOperationIntegral() {
        return operationIntegral;
    }

    public void setOperationIntegral(Integer operationIntegral) {
        this.operationIntegral = operationIntegral;
    }

    public Integer getTotalIntegral() {
        return totalIntegral;
    }

    public void setTotalIntegral(Integer totalIntegral) {
        this.totalIntegral = totalIntegral;
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
        sb.append(", operationType=").append(operationType);
        sb.append(", function=").append(function);
        sb.append(", functionId=").append(functionId);
        sb.append(", operationIntegral=").append(operationIntegral);
        sb.append(", totalIntegral=").append(totalIntegral);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}