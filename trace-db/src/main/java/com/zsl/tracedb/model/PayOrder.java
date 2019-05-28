package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class PayOrder implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "支付订单号")
    private String orderNum;

    @ApiModelProperty(value = "支付方式：1用户转账、2支付宝、3微信支付")
    private Integer payType;

    @ApiModelProperty(value = "支付证明（用户转账时需要）")
    private String payCertify;

    @ApiModelProperty(value = "订单类型：1商家认证、2积分充值")
    private Integer orderType;

    @ApiModelProperty(value = "订单类型主键id")
    private Integer orderTypeId;

    @ApiModelProperty(value = "支付金额")
    private Float paySum;

    @ApiModelProperty(value = "支付状态：1未支付、2支付成功、3支付失败")
    private Integer payStatus;

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

    public String getPayCertify() {
        return payCertify;
    }

    public void setPayCertify(String payCertify) {
        this.payCertify = payCertify;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(Integer orderTypeId) {
        this.orderTypeId = orderTypeId;
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
        sb.append(", payCertify=").append(payCertify);
        sb.append(", orderType=").append(orderType);
        sb.append(", orderTypeId=").append(orderTypeId);
        sb.append(", paySum=").append(paySum);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}