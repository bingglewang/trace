package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ZslBatchMaterialOut implements Serializable {
    private Integer batchMaterialOutId;

    @ApiModelProperty(value = "生产批次id")
    private Integer productionBatchId;

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

    public Integer getProductionBatchId() {
        return productionBatchId;
    }

    public void setProductionBatchId(Integer productionBatchId) {
        this.productionBatchId = productionBatchId;
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
        sb.append(", productionBatchId=").append(productionBatchId);
        sb.append(", materialOutId=").append(materialOutId);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}