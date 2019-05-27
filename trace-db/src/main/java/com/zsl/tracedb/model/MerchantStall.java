package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class MerchantStall implements Serializable {
    @ApiModelProperty(value = "摊位ID")
    private Integer stallId;

    @ApiModelProperty(value = "摊位名称")
    private String stallName;

    @ApiModelProperty(value = "所属商家ID")
    private Integer merchantId;

    @ApiModelProperty(value = "摊主姓名")
    private String stallholderName;

    @ApiModelProperty(value = "摊主联系电话")
    private String stallholderNumber;

    @ApiModelProperty(value = "绑定微信")
    private String stallholderOpenid;

    private static final long serialVersionUID = 1L;

    public Integer getStallId() {
        return stallId;
    }

    public void setStallId(Integer stallId) {
        this.stallId = stallId;
    }

    public String getStallName() {
        return stallName;
    }

    public void setStallName(String stallName) {
        this.stallName = stallName;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getStallholderName() {
        return stallholderName;
    }

    public void setStallholderName(String stallholderName) {
        this.stallholderName = stallholderName;
    }

    public String getStallholderNumber() {
        return stallholderNumber;
    }

    public void setStallholderNumber(String stallholderNumber) {
        this.stallholderNumber = stallholderNumber;
    }

    public String getStallholderOpenid() {
        return stallholderOpenid;
    }

    public void setStallholderOpenid(String stallholderOpenid) {
        this.stallholderOpenid = stallholderOpenid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stallId=").append(stallId);
        sb.append(", stallName=").append(stallName);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", stallholderName=").append(stallholderName);
        sb.append(", stallholderNumber=").append(stallholderNumber);
        sb.append(", stallholderOpenid=").append(stallholderOpenid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}