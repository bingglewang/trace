package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class MerchantAuth implements Serializable {
    private Integer merchantAuthId;

    @ApiModelProperty(value = "支付订单号")
    private String orderNum;

    @ApiModelProperty(value = "关联商家主键id")
    private Integer merchantId;

    @ApiModelProperty(value = "操作认证商家的ip地址")
    private String ipSite;

    @ApiModelProperty(value = "支付方式：1用户转账、2支付宝、3微信")
    private Integer payType;

    @ApiModelProperty(value = "认证支付金额")
    private Float authSum;

    @ApiModelProperty(value = "支付证明（用户转账时需要）")
    private String payCertify;

    @ApiModelProperty(value = "支付状态：1未支付、2支付成功、3支付失败")
    private Integer payStatus;

    @ApiModelProperty(value = "审核状态：1待审核、2通过、3拒绝")
    private Integer auditStatus;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "审核结果说明")
    private String auditRemark;

    private static final long serialVersionUID = 1L;

    public Integer getMerchantAuthId() {
        return merchantAuthId;
    }

    public void setMerchantAuthId(Integer merchantAuthId) {
        this.merchantAuthId = merchantAuthId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getIpSite() {
        return ipSite;
    }

    public void setIpSite(String ipSite) {
        this.ipSite = ipSite;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Float getAuthSum() {
        return authSum;
    }

    public void setAuthSum(Float authSum) {
        this.authSum = authSum;
    }

    public String getPayCertify() {
        return payCertify;
    }

    public void setPayCertify(String payCertify) {
        this.payCertify = payCertify;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", merchantAuthId=").append(merchantAuthId);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", ipSite=").append(ipSite);
        sb.append(", payType=").append(payType);
        sb.append(", authSum=").append(authSum);
        sb.append(", payCertify=").append(payCertify);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", auditRemark=").append(auditRemark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}