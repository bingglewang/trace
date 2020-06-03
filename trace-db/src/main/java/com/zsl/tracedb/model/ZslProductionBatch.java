package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ZslProductionBatch implements Serializable {
    private Integer batchId;

    @ApiModelProperty(value = "生产批次号")
    private String batchNo;

    @ApiModelProperty(value = "商品id")
    private Integer goodsId;

    @ApiModelProperty(value = "生产时间范围")
    private String productionTimeScope;

    @ApiModelProperty(value = "商家id")
    private Integer merchantId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getProductionTimeScope() {
        return productionTimeScope;
    }

    public void setProductionTimeScope(String productionTimeScope) {
        this.productionTimeScope = productionTimeScope;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
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
        sb.append(", batchId=").append(batchId);
        sb.append(", batchNo=").append(batchNo);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", productionTimeScope=").append(productionTimeScope);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}