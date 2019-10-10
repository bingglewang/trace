package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ZslTracePapper implements Serializable {
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "纸质批次起始sid")
    private Long traceNumStart;

    @ApiModelProperty(value = "纸质批次结束sid")
    private Long traceNumEnd;

    @ApiModelProperty(value = "关联批次号")
    private String traceCodeNumber;

    @ApiModelProperty(value = "数量")
    private Long traceCount;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTraceNumStart() {
        return traceNumStart;
    }

    public void setTraceNumStart(Long traceNumStart) {
        this.traceNumStart = traceNumStart;
    }

    public Long getTraceNumEnd() {
        return traceNumEnd;
    }

    public void setTraceNumEnd(Long traceNumEnd) {
        this.traceNumEnd = traceNumEnd;
    }

    public String getTraceCodeNumber() {
        return traceCodeNumber;
    }

    public void setTraceCodeNumber(String traceCodeNumber) {
        this.traceCodeNumber = traceCodeNumber;
    }

    public Long getTraceCount() {
        return traceCount;
    }

    public void setTraceCount(Long traceCount) {
        this.traceCount = traceCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", traceNumStart=").append(traceNumStart);
        sb.append(", traceNumEnd=").append(traceNumEnd);
        sb.append(", traceCodeNumber=").append(traceCodeNumber);
        sb.append(", traceCount=").append(traceCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}