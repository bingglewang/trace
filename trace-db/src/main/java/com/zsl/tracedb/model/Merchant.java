package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Merchant implements Serializable {
    private Integer merchantId;

    @ApiModelProperty(value = "商家名称")
    private String merchantName;

    @ApiModelProperty(value = "商家账号")
    private String merchantAccount;

    @ApiModelProperty(value = "行政ID")
    private Integer adminstrationId;

    @ApiModelProperty(value = "行政地址全称")
    private String administrativeDivisionFullSite;

    @ApiModelProperty(value = "详细地址")
    private String merchantDetailSite;

    @ApiModelProperty(value = "商家网址")
    private String merchantUrl;

    @ApiModelProperty(value = "入网类型-外键")
    private Integer netType;

    @ApiModelProperty(value = "积分")
    private Integer merchantCoin;

    @ApiModelProperty(value = "归属加盟商ID")
    private Integer allianceBusinessId;

    @ApiModelProperty(value = "商家类型（外键）")
    private Integer merchantType;

    @ApiModelProperty(value = "法人代表/个人 名称")
    private String lealPersonName;

    @ApiModelProperty(value = "营业执照/身份证/护照 图片地址")
    private String papersUrl;

    @ApiModelProperty(value = "营业执照/身份证/护照 反面图片地址")
    private String papersBackUrl;

    @ApiModelProperty(value = "营业执照/身份证/护照 号码")
    private String papersNumber;

    @ApiModelProperty(value = "经营品种")
    private String businessLines;

    @ApiModelProperty(value = "商家联系人")
    private String merchantContact;

    @ApiModelProperty(value = "联系人电话")
    private String contactNumber;

    @ApiModelProperty(value = "商家入驻时间")
    private Date merchantEnterTime;

    @ApiModelProperty(value = "商家状态：0正常  1禁用")
    private Integer merchantStatus;

    @ApiModelProperty(value = "短视频地址")
    private String shortVideoUrl;

    @ApiModelProperty(value = "是否缴纳认证金：0未缴纳 1已缴纳")
    private Byte certificationToPay;

    @ApiModelProperty(value = "商家描述")
    private String merchantDesciption;

    @ApiModelProperty(value = "摊位数（农贸专享）")
    private Integer stallLimit;

    @ApiModelProperty(value = "纸质标签额度上限")
    private Long paperLabelUpper;

    @ApiModelProperty(value = "横坐标")
    private String siteAbscissa;

    @ApiModelProperty(value = "纵坐标")
    private String siteOrdinate;

    @ApiModelProperty(value = "识别地址")
    private String discernSite;

    @ApiModelProperty(value = "销售网址")
    private String salesUrl;

    private static final long serialVersionUID = 1L;

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public Integer getAdminstrationId() {
        return adminstrationId;
    }

    public void setAdminstrationId(Integer adminstrationId) {
        this.adminstrationId = adminstrationId;
    }

    public String getAdministrativeDivisionFullSite() {
        return administrativeDivisionFullSite;
    }

    public void setAdministrativeDivisionFullSite(String administrativeDivisionFullSite) {
        this.administrativeDivisionFullSite = administrativeDivisionFullSite;
    }

    public String getMerchantDetailSite() {
        return merchantDetailSite;
    }

    public void setMerchantDetailSite(String merchantDetailSite) {
        this.merchantDetailSite = merchantDetailSite;
    }

    public String getMerchantUrl() {
        return merchantUrl;
    }

    public void setMerchantUrl(String merchantUrl) {
        this.merchantUrl = merchantUrl;
    }

    public Integer getNetType() {
        return netType;
    }

    public void setNetType(Integer netType) {
        this.netType = netType;
    }

    public Integer getMerchantCoin() {
        return merchantCoin;
    }

    public void setMerchantCoin(Integer merchantCoin) {
        this.merchantCoin = merchantCoin;
    }

    public Integer getAllianceBusinessId() {
        return allianceBusinessId;
    }

    public void setAllianceBusinessId(Integer allianceBusinessId) {
        this.allianceBusinessId = allianceBusinessId;
    }

    public Integer getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(Integer merchantType) {
        this.merchantType = merchantType;
    }

    public String getLealPersonName() {
        return lealPersonName;
    }

    public void setLealPersonName(String lealPersonName) {
        this.lealPersonName = lealPersonName;
    }

    public String getPapersUrl() {
        return papersUrl;
    }

    public void setPapersUrl(String papersUrl) {
        this.papersUrl = papersUrl;
    }

    public String getPapersBackUrl() {
        return papersBackUrl;
    }

    public void setPapersBackUrl(String papersBackUrl) {
        this.papersBackUrl = papersBackUrl;
    }

    public String getPapersNumber() {
        return papersNumber;
    }

    public void setPapersNumber(String papersNumber) {
        this.papersNumber = papersNumber;
    }

    public String getBusinessLines() {
        return businessLines;
    }

    public void setBusinessLines(String businessLines) {
        this.businessLines = businessLines;
    }

    public String getMerchantContact() {
        return merchantContact;
    }

    public void setMerchantContact(String merchantContact) {
        this.merchantContact = merchantContact;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Date getMerchantEnterTime() {
        return merchantEnterTime;
    }

    public void setMerchantEnterTime(Date merchantEnterTime) {
        this.merchantEnterTime = merchantEnterTime;
    }

    public Integer getMerchantStatus() {
        return merchantStatus;
    }

    public void setMerchantStatus(Integer merchantStatus) {
        this.merchantStatus = merchantStatus;
    }

    public String getShortVideoUrl() {
        return shortVideoUrl;
    }

    public void setShortVideoUrl(String shortVideoUrl) {
        this.shortVideoUrl = shortVideoUrl;
    }

    public Byte getCertificationToPay() {
        return certificationToPay;
    }

    public void setCertificationToPay(Byte certificationToPay) {
        this.certificationToPay = certificationToPay;
    }

    public String getMerchantDesciption() {
        return merchantDesciption;
    }

    public void setMerchantDesciption(String merchantDesciption) {
        this.merchantDesciption = merchantDesciption;
    }

    public Integer getStallLimit() {
        return stallLimit;
    }

    public void setStallLimit(Integer stallLimit) {
        this.stallLimit = stallLimit;
    }

    public Long getPaperLabelUpper() {
        return paperLabelUpper;
    }

    public void setPaperLabelUpper(Long paperLabelUpper) {
        this.paperLabelUpper = paperLabelUpper;
    }

    public String getSiteAbscissa() {
        return siteAbscissa;
    }

    public void setSiteAbscissa(String siteAbscissa) {
        this.siteAbscissa = siteAbscissa;
    }

    public String getSiteOrdinate() {
        return siteOrdinate;
    }

    public void setSiteOrdinate(String siteOrdinate) {
        this.siteOrdinate = siteOrdinate;
    }

    public String getDiscernSite() {
        return discernSite;
    }

    public void setDiscernSite(String discernSite) {
        this.discernSite = discernSite;
    }

    public String getSalesUrl() {
        return salesUrl;
    }

    public void setSalesUrl(String salesUrl) {
        this.salesUrl = salesUrl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", merchantId=").append(merchantId);
        sb.append(", merchantName=").append(merchantName);
        sb.append(", merchantAccount=").append(merchantAccount);
        sb.append(", adminstrationId=").append(adminstrationId);
        sb.append(", administrativeDivisionFullSite=").append(administrativeDivisionFullSite);
        sb.append(", merchantDetailSite=").append(merchantDetailSite);
        sb.append(", merchantUrl=").append(merchantUrl);
        sb.append(", netType=").append(netType);
        sb.append(", merchantCoin=").append(merchantCoin);
        sb.append(", allianceBusinessId=").append(allianceBusinessId);
        sb.append(", merchantType=").append(merchantType);
        sb.append(", lealPersonName=").append(lealPersonName);
        sb.append(", papersUrl=").append(papersUrl);
        sb.append(", papersBackUrl=").append(papersBackUrl);
        sb.append(", papersNumber=").append(papersNumber);
        sb.append(", businessLines=").append(businessLines);
        sb.append(", merchantContact=").append(merchantContact);
        sb.append(", contactNumber=").append(contactNumber);
        sb.append(", merchantEnterTime=").append(merchantEnterTime);
        sb.append(", merchantStatus=").append(merchantStatus);
        sb.append(", shortVideoUrl=").append(shortVideoUrl);
        sb.append(", certificationToPay=").append(certificationToPay);
        sb.append(", merchantDesciption=").append(merchantDesciption);
        sb.append(", stallLimit=").append(stallLimit);
        sb.append(", paperLabelUpper=").append(paperLabelUpper);
        sb.append(", siteAbscissa=").append(siteAbscissa);
        sb.append(", siteOrdinate=").append(siteOrdinate);
        sb.append(", discernSite=").append(discernSite);
        sb.append(", salesUrl=").append(salesUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}