package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MaterialWarehouseOut implements Serializable {
    @ApiModelProperty(value = "出库记录表主键id")
    private Integer id;

    @ApiModelProperty(value = "入库批次号(规则:YCL20200912+入库表主键id)")
    private String batchNumber;

    @ApiModelProperty(value = "出库单号")
    private String warehouseOutOrder;

    @ApiModelProperty(value = "出库数量")
    private BigDecimal stockNumber;

    @ApiModelProperty(value = "单位")
    private String units;

    @ApiModelProperty(value = "商家id")
    private Integer merchantId;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getWarehouseOutOrder() {
        return warehouseOutOrder;
    }

    public void setWarehouseOutOrder(String warehouseOutOrder) {
        this.warehouseOutOrder = warehouseOutOrder;
    }

    public BigDecimal getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(BigDecimal stockNumber) {
        this.stockNumber = stockNumber;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
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
        sb.append(", id=").append(id);
        sb.append(", batchNumber=").append(batchNumber);
        sb.append(", warehouseOutOrder=").append(warehouseOutOrder);
        sb.append(", stockNumber=").append(stockNumber);
        sb.append(", units=").append(units);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}