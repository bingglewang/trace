package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class MerchantAuth implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "入网协议：0同意、1不同意")
    private Integer isAcceptProtocol;

    @ApiModelProperty(value = "赠送积分数")
    private Integer getIntegral;

    @ApiModelProperty(value = "操作认证商家的ip地址")
    private String ipSite;

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

    public Integer getIsAcceptProtocol() {
        return isAcceptProtocol;
    }

    public void setIsAcceptProtocol(Integer isAcceptProtocol) {
        this.isAcceptProtocol = isAcceptProtocol;
    }

    public Integer getGetIntegral() {
        return getIntegral;
    }

    public void setGetIntegral(Integer getIntegral) {
        this.getIntegral = getIntegral;
    }

    public String getIpSite() {
        return ipSite;
    }

    public void setIpSite(String ipSite) {
        this.ipSite = ipSite;
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
        sb.append(", isAcceptProtocol=").append(isAcceptProtocol);
        sb.append(", getIntegral=").append(getIntegral);
        sb.append(", ipSite=").append(ipSite);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", orderId=").append(orderId);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}