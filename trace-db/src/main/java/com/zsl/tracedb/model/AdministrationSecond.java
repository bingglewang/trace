package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class AdministrationSecond implements Serializable {
    @ApiModelProperty(value = "二级行政地址ID")
    private Integer secondAdministrationId;

    @ApiModelProperty(value = "二级行政地址")
    private String secondAdministrationName;

    @ApiModelProperty(value = "一级行政地址")
    private Integer firstAdministrationId;

    private static final long serialVersionUID = 1L;

    public Integer getSecondAdministrationId() {
        return secondAdministrationId;
    }

    public void setSecondAdministrationId(Integer secondAdministrationId) {
        this.secondAdministrationId = secondAdministrationId;
    }

    public String getSecondAdministrationName() {
        return secondAdministrationName;
    }

    public void setSecondAdministrationName(String secondAdministrationName) {
        this.secondAdministrationName = secondAdministrationName;
    }

    public Integer getFirstAdministrationId() {
        return firstAdministrationId;
    }

    public void setFirstAdministrationId(Integer firstAdministrationId) {
        this.firstAdministrationId = firstAdministrationId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", secondAdministrationId=").append(secondAdministrationId);
        sb.append(", secondAdministrationName=").append(secondAdministrationName);
        sb.append(", firstAdministrationId=").append(firstAdministrationId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}