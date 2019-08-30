package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class MerchantAgent implements Serializable {
    @ApiModelProperty(value = "代理商ID")
    private Integer merchantAgentId;

    private Integer merchantId;

    @ApiModelProperty(value = "代理商名称")
    private String agentName;

    @ApiModelProperty(value = "代理商别名")
    private String agentAnotherName;

    @ApiModelProperty(value = "代理商联系人")
    private String agentContact;

    @ApiModelProperty(value = "代理商联系人电话")
    private String agentCpntactNumber;

    @ApiModelProperty(value = "四级行政ID")
    private String fourthAdministrationId;

    @ApiModelProperty(value = "详细地址")
    private String agentDetailSite;

    @ApiModelProperty(value = "营业执照或证件图")
    private String agentPapersUrl;

    @ApiModelProperty(value = "代理商描述")
    private String agentDescription;

    @ApiModelProperty(value = "代理商状态：0表示禁止，1表示开通，2表示待审核,3表示拒绝")
    private Byte agentStatus;

    private Date createTime;

    @ApiModelProperty(value = "代理途径")
    private Byte agentPath;

    @ApiModelProperty(value = "代理商品")
    private String agentGoods;

    private static final long serialVersionUID = 1L;

    public Integer getMerchantAgentId() {
        return merchantAgentId;
    }

    public void setMerchantAgentId(Integer merchantAgentId) {
        this.merchantAgentId = merchantAgentId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentAnotherName() {
        return agentAnotherName;
    }

    public void setAgentAnotherName(String agentAnotherName) {
        this.agentAnotherName = agentAnotherName;
    }

    public String getAgentContact() {
        return agentContact;
    }

    public void setAgentContact(String agentContact) {
        this.agentContact = agentContact;
    }

    public String getAgentCpntactNumber() {
        return agentCpntactNumber;
    }

    public void setAgentCpntactNumber(String agentCpntactNumber) {
        this.agentCpntactNumber = agentCpntactNumber;
    }

    public String getFourthAdministrationId() {
        return fourthAdministrationId;
    }

    public void setFourthAdministrationId(String fourthAdministrationId) {
        this.fourthAdministrationId = fourthAdministrationId;
    }

    public String getAgentDetailSite() {
        return agentDetailSite;
    }

    public void setAgentDetailSite(String agentDetailSite) {
        this.agentDetailSite = agentDetailSite;
    }

    public String getAgentPapersUrl() {
        return agentPapersUrl;
    }

    public void setAgentPapersUrl(String agentPapersUrl) {
        this.agentPapersUrl = agentPapersUrl;
    }

    public String getAgentDescription() {
        return agentDescription;
    }

    public void setAgentDescription(String agentDescription) {
        this.agentDescription = agentDescription;
    }

    public Byte getAgentStatus() {
        return agentStatus;
    }

    public void setAgentStatus(Byte agentStatus) {
        this.agentStatus = agentStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getAgentPath() {
        return agentPath;
    }

    public void setAgentPath(Byte agentPath) {
        this.agentPath = agentPath;
    }

    public String getAgentGoods() {
        return agentGoods;
    }

    public void setAgentGoods(String agentGoods) {
        this.agentGoods = agentGoods;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", merchantAgentId=").append(merchantAgentId);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", agentName=").append(agentName);
        sb.append(", agentAnotherName=").append(agentAnotherName);
        sb.append(", agentContact=").append(agentContact);
        sb.append(", agentCpntactNumber=").append(agentCpntactNumber);
        sb.append(", fourthAdministrationId=").append(fourthAdministrationId);
        sb.append(", agentDetailSite=").append(agentDetailSite);
        sb.append(", agentPapersUrl=").append(agentPapersUrl);
        sb.append(", agentDescription=").append(agentDescription);
        sb.append(", agentStatus=").append(agentStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", agentPath=").append(agentPath);
        sb.append(", agentGoods=").append(agentGoods);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}