package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class MerchantStall implements Serializable {
    @ApiModelProperty(value = "自增主键")
    private Integer stallId;

    @ApiModelProperty(value = "所属商家ID(农贸市场)")
    private Integer merchantId;

    @ApiModelProperty(value = "摊位编号")
    private String stallNo;

    @ApiModelProperty(value = "摊位状态（0：空缺；1：营业；2：歇业）")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "摊主ID")
    private Integer stallHolderId;

    private static final long serialVersionUID = 1L;

    public Integer getStallId() {
        return stallId;
    }

    public void setStallId(Integer stallId) {
        this.stallId = stallId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getStallNo() {
        return stallNo;
    }

    public void setStallNo(String stallNo) {
        this.stallNo = stallNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStallHolderId() {
        return stallHolderId;
    }

    public void setStallHolderId(Integer stallHolderId) {
        this.stallHolderId = stallHolderId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stallId=").append(stallId);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", stallNo=").append(stallNo);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", stallHolderId=").append(stallHolderId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}