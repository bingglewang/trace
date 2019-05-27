package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class MiddleCategoryProperty implements Serializable {
    private Integer categoryPropertyId;

    private Integer categoryId;

    private Integer propertyId;

    @ApiModelProperty(value = "录入类型：0文本框 1下拉框")
    private Integer enterType;

    @ApiModelProperty(value = "字段长度")
    private Integer fieldLength;

    private static final long serialVersionUID = 1L;

    public Integer getCategoryPropertyId() {
        return categoryPropertyId;
    }

    public void setCategoryPropertyId(Integer categoryPropertyId) {
        this.categoryPropertyId = categoryPropertyId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public Integer getEnterType() {
        return enterType;
    }

    public void setEnterType(Integer enterType) {
        this.enterType = enterType;
    }

    public Integer getFieldLength() {
        return fieldLength;
    }

    public void setFieldLength(Integer fieldLength) {
        this.fieldLength = fieldLength;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", categoryPropertyId=").append(categoryPropertyId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", propertyId=").append(propertyId);
        sb.append(", enterType=").append(enterType);
        sb.append(", fieldLength=").append(fieldLength);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}