package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ZslTracePoint implements Serializable {
    @ApiModelProperty(value = "追溯点id")
    private Integer tracePointId;

    @ApiModelProperty(value = "关联商品id")
    private Integer traceGoodsId;

    @ApiModelProperty(value = "追溯点其他信息")
    private String tracePointName;

    @ApiModelProperty(value = "追溯点结束编码")
    private Long tracePointToNumber;

    @ApiModelProperty(value = "追溯点起始编码")
    private Long tracePointFromNumber;

    @ApiModelProperty(value = "父节点id")
    private Integer traceParentId;

    @ApiModelProperty(value = "摊位id（非农贸则为-1）")
    private Integer traceStallId;

    @ApiModelProperty(value = "追溯码批次号")
    private String traceCodeNumber;

    private Date tracePointTime;

    @ApiModelProperty(value = "流通节点关联的账号id")
    private Integer tracePointAccountId;

    private static final long serialVersionUID = 1L;

    public Integer getTracePointId() {
        return tracePointId;
    }

    public void setTracePointId(Integer tracePointId) {
        this.tracePointId = tracePointId;
    }

    public Integer getTraceGoodsId() {
        return traceGoodsId;
    }

    public void setTraceGoodsId(Integer traceGoodsId) {
        this.traceGoodsId = traceGoodsId;
    }

    public String getTracePointName() {
        return tracePointName;
    }

    public void setTracePointName(String tracePointName) {
        this.tracePointName = tracePointName;
    }

    public Long getTracePointToNumber() {
        return tracePointToNumber;
    }

    public void setTracePointToNumber(Long tracePointToNumber) {
        this.tracePointToNumber = tracePointToNumber;
    }

    public Long getTracePointFromNumber() {
        return tracePointFromNumber;
    }

    public void setTracePointFromNumber(Long tracePointFromNumber) {
        this.tracePointFromNumber = tracePointFromNumber;
    }

    public Integer getTraceParentId() {
        return traceParentId;
    }

    public void setTraceParentId(Integer traceParentId) {
        this.traceParentId = traceParentId;
    }

    public Integer getTraceStallId() {
        return traceStallId;
    }

    public void setTraceStallId(Integer traceStallId) {
        this.traceStallId = traceStallId;
    }

    public String getTraceCodeNumber() {
        return traceCodeNumber;
    }

    public void setTraceCodeNumber(String traceCodeNumber) {
        this.traceCodeNumber = traceCodeNumber;
    }

    public Date getTracePointTime() {
        return tracePointTime;
    }

    public void setTracePointTime(Date tracePointTime) {
        this.tracePointTime = tracePointTime;
    }

    public Integer getTracePointAccountId() {
        return tracePointAccountId;
    }

    public void setTracePointAccountId(Integer tracePointAccountId) {
        this.tracePointAccountId = tracePointAccountId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tracePointId=").append(tracePointId);
        sb.append(", traceGoodsId=").append(traceGoodsId);
        sb.append(", tracePointName=").append(tracePointName);
        sb.append(", tracePointToNumber=").append(tracePointToNumber);
        sb.append(", tracePointFromNumber=").append(tracePointFromNumber);
        sb.append(", traceParentId=").append(traceParentId);
        sb.append(", traceStallId=").append(traceStallId);
        sb.append(", traceCodeNumber=").append(traceCodeNumber);
        sb.append(", tracePointTime=").append(tracePointTime);
        sb.append(", tracePointAccountId=").append(tracePointAccountId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}