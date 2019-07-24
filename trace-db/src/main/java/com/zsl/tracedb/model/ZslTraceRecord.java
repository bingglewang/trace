package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ZslTraceRecord implements Serializable {
    @ApiModelProperty(value = "追溯记录id")
    private Integer traceRecordId;

    @ApiModelProperty(value = "关联追溯码批次号")
    private String traceCodeNumber;

    @ApiModelProperty(value = "关联商品id")
    private Integer traceGoodId;

    @ApiModelProperty(value = "商品结束编码")
    private Integer traceToNumber;

    @ApiModelProperty(value = "商品起始编码")
    private Integer traceFromNumber;

    @ApiModelProperty(value = "关联摊位id（没有则为非农贸）")
    private Integer traceStallId;

    private static final long serialVersionUID = 1L;

    public Integer getTraceRecordId() {
        return traceRecordId;
    }

    public void setTraceRecordId(Integer traceRecordId) {
        this.traceRecordId = traceRecordId;
    }

    public String getTraceCodeNumber() {
        return traceCodeNumber;
    }

    public void setTraceCodeNumber(String traceCodeNumber) {
        this.traceCodeNumber = traceCodeNumber;
    }

    public Integer getTraceGoodId() {
        return traceGoodId;
    }

    public void setTraceGoodId(Integer traceGoodId) {
        this.traceGoodId = traceGoodId;
    }

    public Integer getTraceToNumber() {
        return traceToNumber;
    }

    public void setTraceToNumber(Integer traceToNumber) {
        this.traceToNumber = traceToNumber;
    }

    public Integer getTraceFromNumber() {
        return traceFromNumber;
    }

    public void setTraceFromNumber(Integer traceFromNumber) {
        this.traceFromNumber = traceFromNumber;
    }

    public Integer getTraceStallId() {
        return traceStallId;
    }

    public void setTraceStallId(Integer traceStallId) {
        this.traceStallId = traceStallId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", traceRecordId=").append(traceRecordId);
        sb.append(", traceCodeNumber=").append(traceCodeNumber);
        sb.append(", traceGoodId=").append(traceGoodId);
        sb.append(", traceToNumber=").append(traceToNumber);
        sb.append(", traceFromNumber=").append(traceFromNumber);
        sb.append(", traceStallId=").append(traceStallId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}