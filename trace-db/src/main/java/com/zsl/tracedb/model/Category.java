package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable {
    private Integer categoryId;

    private Integer categorySuperId;

    private String categoryName;

    @ApiModelProperty(value = "分类名称全称")
    private String categoryFullName;

    private Integer categoryLevel;

    private Byte includeBrand;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCategorySuperId() {
        return categorySuperId;
    }

    public void setCategorySuperId(Integer categorySuperId) {
        this.categorySuperId = categorySuperId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryFullName() {
        return categoryFullName;
    }

    public void setCategoryFullName(String categoryFullName) {
        this.categoryFullName = categoryFullName;
    }

    public Integer getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(Integer categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

    public Byte getIncludeBrand() {
        return includeBrand;
    }

    public void setIncludeBrand(Byte includeBrand) {
        this.includeBrand = includeBrand;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", categoryId=").append(categoryId);
        sb.append(", categorySuperId=").append(categorySuperId);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", categoryFullName=").append(categoryFullName);
        sb.append(", categoryLevel=").append(categoryLevel);
        sb.append(", includeBrand=").append(includeBrand);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}