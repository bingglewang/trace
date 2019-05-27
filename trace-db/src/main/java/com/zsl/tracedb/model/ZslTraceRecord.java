package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ZslTraceRecord implements Serializable {
    @ApiModelProperty(value = "追溯记录id")
    private Integer traceRecordId;

    @ApiModelProperty(value = "记录所属追溯")
    private Integer traceId;

    @ApiModelProperty(value = "关联商品id")
    private Integer traceGoodId;

    @ApiModelProperty(value = "商品起始编码")
    private Integer traceToNumber;

    @ApiModelProperty(value = "商品结束编码")
    private Integer traceFromNumber;

    private static final long serialVersionUID = 1L;

    public Integer getTraceRecordId() {
        return traceRecordId;
    }

    public void setTraceRecordId(Integer traceRecordId) {
        this.traceRecordId = traceRecordId;
    }

    public Integer getTraceId() {
        return traceId;
    }

    public void setTraceId(Integer traceId) {
        this.traceId = traceId;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", traceRecordId=").append(traceRecordId);
        sb.append(", traceId=").append(traceId);
        sb.append(", traceGoodId=").append(traceGoodId);
        sb.append(", traceToNumber=").append(traceToNumber);
        sb.append(", traceFromNumber=").append(traceFromNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}