package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ZslTraceRelation implements Serializable {
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "当前录入下标")
    private Long currentIndexRelation;

    @ApiModelProperty(value = "批次号")
    private String traceCodeNumber;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCurrentIndexRelation() {
        return currentIndexRelation;
    }

    public void setCurrentIndexRelation(Long currentIndexRelation) {
        this.currentIndexRelation = currentIndexRelation;
    }

    public String getTraceCodeNumber() {
        return traceCodeNumber;
    }

    public void setTraceCodeNumber(String traceCodeNumber) {
        this.traceCodeNumber = traceCodeNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", currentIndexRelation=").append(currentIndexRelation);
        sb.append(", traceCodeNumber=").append(traceCodeNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}