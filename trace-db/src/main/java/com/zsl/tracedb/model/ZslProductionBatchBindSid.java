package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ZslProductionBatchBindSid implements Serializable {
    private Integer batchSidId;

    @ApiModelProperty(value = "追溯编码")
    private String traceCodeNo;

    @ApiModelProperty(value = "追溯记录id")
    private Integer traceRecordId;

    @ApiModelProperty(value = "追溯码段开始sid")
    private Long sidStart;

    @ApiModelProperty(value = "生产批次id")
    private Integer productionBatchId;

    @ApiModelProperty(value = "追溯码段结束sid")
    private Long sidEnd;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getBatchSidId() {
        return batchSidId;
    }

    public void setBatchSidId(Integer batchSidId) {
        this.batchSidId = batchSidId;
    }

    public String getTraceCodeNo() {
        return traceCodeNo;
    }

    public void setTraceCodeNo(String traceCodeNo) {
        this.traceCodeNo = traceCodeNo;
    }

    public Integer getTraceRecordId() {
        return traceRecordId;
    }

    public void setTraceRecordId(Integer traceRecordId) {
        this.traceRecordId = traceRecordId;
    }

    public Long getSidStart() {
        return sidStart;
    }

    public void setSidStart(Long sidStart) {
        this.sidStart = sidStart;
    }

    public Integer getProductionBatchId() {
        return productionBatchId;
    }

    public void setProductionBatchId(Integer productionBatchId) {
        this.productionBatchId = productionBatchId;
    }

    public Long getSidEnd() {
        return sidEnd;
    }

    public void setSidEnd(Long sidEnd) {
        this.sidEnd = sidEnd;
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
        sb.append(", batchSidId=").append(batchSidId);
        sb.append(", traceCodeNo=").append(traceCodeNo);
        sb.append(", traceRecordId=").append(traceRecordId);
        sb.append(", sidStart=").append(sidStart);
        sb.append(", productionBatchId=").append(productionBatchId);
        sb.append(", sidEnd=").append(sidEnd);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}