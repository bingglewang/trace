package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class VoucherIntegral implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "充值获得积分数")
    private Integer getIntegral;

    @ApiModelProperty(value = "商家id")
    private Integer merchantId;

    @ApiModelProperty(value = "订单表主键id")
    private Integer orderId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGetIntegral() {
        return getIntegral;
    }

    public void setGetIntegral(Integer getIntegral) {
        this.getIntegral = getIntegral;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
        sb.append(", getIntegral=").append(getIntegral);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", orderId=").append(orderId);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}