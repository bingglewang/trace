package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class AdministrationFourth implements Serializable {
    @ApiModelProperty(value = "四级行政ID")
    private Integer fourthAdministrationId;

    @ApiModelProperty(value = "四级行政地址")
    private String fourthAdministrationName;

    @ApiModelProperty(value = "一级行政ID")
    private Integer firstAdministrationId;

    @ApiModelProperty(value = "二级行政ID")
    private Integer secondAdministrationId;

    @ApiModelProperty(value = "三级行政ID")
    private Integer thirdAdministrationId;

    private static final long serialVersionUID = 1L;

    public Integer getFourthAdministrationId() {
        return fourthAdministrationId;
    }

    public void setFourthAdministrationId(Integer fourthAdministrationId) {
        this.fourthAdministrationId = fourthAdministrationId;
    }

    public String getFourthAdministrationName() {
        return fourthAdministrationName;
    }

    public void setFourthAdministrationName(String fourthAdministrationName) {
        this.fourthAdministrationName = fourthAdministrationName;
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

    public Integer getThirdAdministrationId() {
        return thirdAdministrationId;
    }

    public void setThirdAdministrationId(Integer thirdAdministrationId) {
        this.thirdAdministrationId = thirdAdministrationId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fourthAdministrationId=").append(fourthAdministrationId);
        sb.append(", fourthAdministrationName=").append(fourthAdministrationName);
        sb.append(", firstAdministrationId=").append(firstAdministrationId);
        sb.append(", secondAdministrationId=").append(secondAdministrationId);
        sb.append(", thirdAdministrationId=").append(thirdAdministrationId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}