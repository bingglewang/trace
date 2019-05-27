package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class MiddleGoodsPropertyValue implements Serializable {
    private Integer goodsPropertyValueId;

    private Integer goodsId;

    private Integer propertyValueId;

    private String textboxValue;

    private static final long serialVersionUID = 1L;

    public Integer getGoodsPropertyValueId() {
        return goodsPropertyValueId;
    }

    public void setGoodsPropertyValueId(Integer goodsPropertyValueId) {
        this.goodsPropertyValueId = goodsPropertyValueId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getPropertyValueId() {
        return propertyValueId;
    }

    public void setPropertyValueId(Integer propertyValueId) {
        this.propertyValueId = propertyValueId;
    }

    public String getTextboxValue() {
        return textboxValue;
    }

    public void setTextboxValue(String textboxValue) {
        this.textboxValue = textboxValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsPropertyValueId=").append(goodsPropertyValueId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", propertyValueId=").append(propertyValueId);
        sb.append(", textboxValue=").append(textboxValue);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}