package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ZslBatchMaterialOut implements Serializable {
    private Integer batchMaterialOutId;

    @ApiModelProperty(value = "生产批次和生产场景中间表id")
    private Integer sceneBatchId;

    @ApiModelProperty(value = "出库单id")
    private Integer materialOutId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getBatchMaterialOutId() {
        return batchMaterialOutId;
    }

    public void setBatchMaterialOutId(Integer batchMaterialOutId) {
        this.batchMaterialOutId = batchMaterialOutId;
    }

    public Integer getSceneBatchId() {
        return sceneBatchId;
    }

    public void setSceneBatchId(Integer sceneBatchId) {
        this.sceneBatchId = sceneBatchId;
    }

    public Integer getMaterialOutId() {
        return materialOutId;
    }

    public void setMaterialOutId(Integer materialOutId) {
        this.materialOutId = materialOutId;
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
        sb.append(", batchMaterialOutId=").append(batchMaterialOutId);
        sb.append(", sceneBatchId=").append(sceneBatchId);
        sb.append(", materialOutId=").append(materialOutId);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}