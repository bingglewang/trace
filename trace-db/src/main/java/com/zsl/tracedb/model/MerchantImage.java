package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class MerchantImage implements Serializable {
    private Integer merchantImageId;

    private Integer merchantId;

    @ApiModelProperty(value = "商户图片地址")
    private String merchantImageUrl;

    @ApiModelProperty(value = "图片权重值")
    private Integer merchantImageIndex;

    private static final long serialVersionUID = 1L;

    public Integer getMerchantImageId() {
        return merchantImageId;
    }

    public void setMerchantImageId(Integer merchantImageId) {
        this.merchantImageId = merchantImageId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantImageUrl() {
        return merchantImageUrl;
    }

    public void setMerchantImageUrl(String merchantImageUrl) {
        this.merchantImageUrl = merchantImageUrl;
    }

    public Integer getMerchantImageIndex() {
        return merchantImageIndex;
    }

    public void setMerchantImageIndex(Integer merchantImageIndex) {
        this.merchantImageIndex = merchantImageIndex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", merchantImageId=").append(merchantImageId);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", merchantImageUrl=").append(merchantImageUrl);
        sb.append(", merchantImageIndex=").append(merchantImageIndex);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}