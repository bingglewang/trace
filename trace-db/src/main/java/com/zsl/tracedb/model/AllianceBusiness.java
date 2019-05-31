package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class AllianceBusiness implements Serializable {
    private Integer allianceBusinessId;

    @ApiModelProperty(value = "加盟商名称")
    private String allianceBusinessName;

    @ApiModelProperty(value = "加盟商营业执照")
    private String businessLicenseUrl;

    @ApiModelProperty(value = "公司描述")
    private String companyDescription;

    @ApiModelProperty(value = "加盟商入驻时间")
    private Date allianceBusinessEnterTime;

    @ApiModelProperty(value = "加盟商状态：0正常 1：禁用")
    private Byte allianceBusinessStatus;

    private static final long serialVersionUID = 1L;

    public Integer getAllianceBusinessId() {
        return allianceBusinessId;
    }

    public void setAllianceBusinessId(Integer allianceBusinessId) {
        this.allianceBusinessId = allianceBusinessId;
    }

    public String getAllianceBusinessName() {
        return allianceBusinessName;
    }

    public void setAllianceBusinessName(String allianceBusinessName) {
        this.allianceBusinessName = allianceBusinessName;
    }

    public String getBusinessLicenseUrl() {
        return businessLicenseUrl;
    }

    public void setBusinessLicenseUrl(String businessLicenseUrl) {
        this.businessLicenseUrl = businessLicenseUrl;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public Date getAllianceBusinessEnterTime() {
        return allianceBusinessEnterTime;
    }

    public void setAllianceBusinessEnterTime(Date allianceBusinessEnterTime) {
        this.allianceBusinessEnterTime = allianceBusinessEnterTime;
    }

    public Byte getAllianceBusinessStatus() {
        return allianceBusinessStatus;
    }

    public void setAllianceBusinessStatus(Byte allianceBusinessStatus) {
        this.allianceBusinessStatus = allianceBusinessStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", allianceBusinessId=").append(allianceBusinessId);
        sb.append(", allianceBusinessName=").append(allianceBusinessName);
        sb.append(", businessLicenseUrl=").append(businessLicenseUrl);
        sb.append(", companyDescription=").append(companyDescription);
        sb.append(", allianceBusinessEnterTime=").append(allianceBusinessEnterTime);
        sb.append(", allianceBusinessStatus=").append(allianceBusinessStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}