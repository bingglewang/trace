package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class AllianceBusinesslSite implements Serializable {
    @ApiModelProperty(value = "加盟商地址ID")
    private Integer allianceBusinesslSiteId;

    @ApiModelProperty(value = "加盟商ID")
    private Integer allianceBusinessId;

    @ApiModelProperty(value = "行政ID")
    private Integer administrationId;

    private static final long serialVersionUID = 1L;

    public Integer getAllianceBusinesslSiteId() {
        return allianceBusinesslSiteId;
    }

    public void setAllianceBusinesslSiteId(Integer allianceBusinesslSiteId) {
        this.allianceBusinesslSiteId = allianceBusinesslSiteId;
    }

    public Integer getAllianceBusinessId() {
        return allianceBusinessId;
    }

    public void setAllianceBusinessId(Integer allianceBusinessId) {
        this.allianceBusinessId = allianceBusinessId;
    }

    public Integer getAdministrationId() {
        return administrationId;
    }

    public void setAdministrationId(Integer administrationId) {
        this.administrationId = administrationId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", allianceBusinesslSiteId=").append(allianceBusinesslSiteId);
        sb.append(", allianceBusinessId=").append(allianceBusinessId);
        sb.append(", administrationId=").append(administrationId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}