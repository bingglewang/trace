package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ZslTracePoint implements Serializable {
    @ApiModelProperty(value = "追溯点id")
    private Integer tracePointId;

    @ApiModelProperty(value = "关联追溯记录id")
    private Integer traceRecordId;

    @ApiModelProperty(value = "追溯点其他信息")
    private String tracePointName;

    @ApiModelProperty(value = "追溯点起始编码")
    private Integer tracePointToNumber;

    @ApiModelProperty(value = "追溯点结束编码")
    private Integer tracePointFromNumber;

    private static final long serialVersionUID = 1L;

    public Integer getTracePointId() {
        return tracePointId;
    }

    public void setTracePointId(Integer tracePointId) {
        this.tracePointId = tracePointId;
    }

    public Integer getTraceRecordId() {
        return traceRecordId;
    }

    public void setTraceRecordId(Integer traceRecordId) {
        this.traceRecordId = traceRecordId;
    }

    public String getTracePointName() {
        return tracePointName;
    }

    public void setTracePointName(String tracePointName) {
        this.tracePointName = tracePointName;
    }

    public Integer getTracePointToNumber() {
        return tracePointToNumber;
    }

    public void setTracePointToNumber(Integer tracePointToNumber) {
        this.tracePointToNumber = tracePointToNumber;
    }

    public Integer getTracePointFromNumber() {
        return tracePointFromNumber;
    }

    public void setTracePointFromNumber(Integer tracePointFromNumber) {
        this.tracePointFromNumber = tracePointFromNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tracePointId=").append(tracePointId);
        sb.append(", traceRecordId=").append(traceRecordId);
        sb.append(", tracePointName=").append(tracePointName);
        sb.append(", tracePointToNumber=").append(tracePointToNumber);
        sb.append(", tracePointFromNumber=").append(tracePointFromNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}