package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MaterialWarehouse implements Serializable {
    @ApiModelProperty(value = "库房表主键id")
    private Integer id;

    @ApiModelProperty(value = "库房名称")
    private String warehouseName;

    @ApiModelProperty(value = "库房编号")
    private String warehouseNumber;

    @ApiModelProperty(value = "入库单号")
    private String warehouseOrder;

    @ApiModelProperty(value = "入库人员")
    private String staffName;

    @ApiModelProperty(value = "材料id")
    private Integer materialId;

    @ApiModelProperty(value = "库存")
    private BigDecimal stock;

    @ApiModelProperty(value = "剩余库存")
    private BigDecimal residueStock;

    @ApiModelProperty(value = "单位")
    private String units;

    @ApiModelProperty(value = "商家id")
    private Integer merchantId;

    @ApiModelProperty(value = "货源分配id（商家新增材料自主入库，分配id为null；）")
    private Integer allotId;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseNumber() {
        return warehouseNumber;
    }

    public void setWarehouseNumber(String warehouseNumber) {
        this.warehouseNumber = warehouseNumber;
    }

    public String getWarehouseOrder() {
        return warehouseOrder;
    }

    public void setWarehouseOrder(String warehouseOrder) {
        this.warehouseOrder = warehouseOrder;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public BigDecimal getResidueStock() {
        return residueStock;
    }

    public void setResidueStock(BigDecimal residueStock) {
        this.residueStock = residueStock;
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

    public Integer getAllotId() {
        return allotId;
    }

    public void setAllotId(Integer allotId) {
        this.allotId = allotId;
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
        sb.append(", warehouseName=").append(warehouseName);
        sb.append(", warehouseNumber=").append(warehouseNumber);
        sb.append(", warehouseOrder=").append(warehouseOrder);
        sb.append(", staffName=").append(staffName);
        sb.append(", materialId=").append(materialId);
        sb.append(", stock=").append(stock);
        sb.append(", residueStock=").append(residueStock);
        sb.append(", units=").append(units);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", allotId=").append(allotId);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}