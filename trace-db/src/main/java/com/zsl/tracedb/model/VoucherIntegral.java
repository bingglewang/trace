package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class VoucherIntegral implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "支付订单号")
    private String orderNum;

    @ApiModelProperty(value = "支付方式：1用户转账、2支付宝、3微信支付")
    private Integer payType;

    @ApiModelProperty(value = "商家id")
    private Integer merchantId;

    @ApiModelProperty(value = "支付证明（用户转账时需要）")
    private String payCertify;

    @ApiModelProperty(value = "支付金额")
    private Float paySum;

    @ApiModelProperty(value = "支付状态：1未支付、2支付成功、3支付失败")
    private Integer payStatus;

    @ApiModelProperty(value = "充值获得积分数")
    private Integer getIntegral;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getPayCertify() {
        return payCertify;
    }

    public void setPayCertify(String payCertify) {
        this.payCertify = payCertify;
    }

    public Float getPaySum() {
        return paySum;
    }

    public void setPaySum(Float paySum) {
        this.paySum = paySum;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getGetIntegral() {
        return getIntegral;
    }

    public void setGetIntegral(Integer getIntegral) {
        this.getIntegral = getIntegral;
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
        sb.append(", orderNum=").append(orderNum);
        sb.append(", payType=").append(payType);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", payCertify=").append(payCertify);
        sb.append(", paySum=").append(paySum);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", getIntegral=").append(getIntegral);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}