package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class AdministrationThird implements Serializable {
    @ApiModelProperty(value = "三级行政ID")
    private Integer thirdAdministrationId;

    @ApiModelProperty(value = "三级行政地址")
    private String thirdAdministrationName;

    @ApiModelProperty(value = "一级行政ID")
    private Integer firstAdministrationId;

    @ApiModelProperty(value = "二级行政ID")
    private Integer secondAdministrationId;

    private static final long serialVersionUID = 1L;

    public Integer getThirdAdministrationId() {
        return thirdAdministrationId;
    }

    public void setThirdAdministrationId(Integer thirdAdministrationId) {
        this.thirdAdministrationId = thirdAdministrationId;
    }

    public String getThirdAdministrationName() {
        return thirdAdministrationName;
    }

    public void setThirdAdministrationName(String thirdAdministrationName) {
        this.thirdAdministrationName = thirdAdministrationName;
    }

    public Integer getFirstAdministrationId() {
        return firstAdministrationId;
    }

    public void setFirstAdministrationId(Integer firstAdministrationId) {
        this.firstAdministrationId = firstAdministrationId;
    }

    public Integer getSecondAdministrationId() {
        return secondAdministrationId;
    }

    public void setSecondAdministrationId(Integer secondAdministrationId) {
        this.secondAdministrationId = secondAdministrationId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", thirdAdministrationId=").append(thirdAdministrationId);
        sb.append(", thirdAdministrationName=").append(thirdAdministrationName);
        sb.append(", firstAdministrationId=").append(firstAdministrationId);
        sb.append(", secondAdministrationId=").append(secondAdministrationId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}