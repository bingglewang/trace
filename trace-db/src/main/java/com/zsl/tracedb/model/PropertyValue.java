package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class PropertyValue implements Serializable {
    private Integer propertyValueId;

    private Integer categoryPropertyId;

    private String comboboxValue;

    private static final long serialVersionUID = 1L;

    public Integer getPropertyValueId() {
        return propertyValueId;
    }

    public void setPropertyValueId(Integer propertyValueId) {
        this.propertyValueId = propertyValueId;
    }

    public Integer getCategoryPropertyId() {
        return categoryPropertyId;
    }

    public void setCategoryPropertyId(Integer categoryPropertyId) {
        this.categoryPropertyId = categoryPropertyId;
    }

    public String getComboboxValue() {
        return comboboxValue;
    }

    public void setComboboxValue(String comboboxValue) {
        this.comboboxValue = comboboxValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", propertyValueId=").append(propertyValueId);
        sb.append(", categoryPropertyId=").append(categoryPropertyId);
        sb.append(", comboboxValue=").append(comboboxValue);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}