package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class MerchantPapersGroup implements Serializable {
    @ApiModelProperty(value = "证件组ID")
    private Integer papersGroupId;

    private Integer merchantId;

    @ApiModelProperty(value = "企业logo")
    private String merchantLogoUrl;

    @ApiModelProperty(value = "产品检验报告")
    private String productTestReportUrl;

    @ApiModelProperty(value = "卫生许可证")
    private String hygienicLicenseUrl;

    @ApiModelProperty(value = "经营许可证")
    private String businessCertificateUrl;

    @ApiModelProperty(value = "产品认证证书")
    private String productCertificationUrl;

    @ApiModelProperty(value = "生产许可证")
    private String productionLicenceUrl;

    @ApiModelProperty(value = "商标注册证书")
    private String warenzeichenlizenzUrl;

    private static final long serialVersionUID = 1L;

    public Integer getPapersGroupId() {
        return papersGroupId;
    }

    public void setPapersGroupId(Integer papersGroupId) {
        this.papersGroupId = papersGroupId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantLogoUrl() {
        return merchantLogoUrl;
    }

    public void setMerchantLogoUrl(String merchantLogoUrl) {
        this.merchantLogoUrl = merchantLogoUrl;
    }

    public String getProductTestReportUrl() {
        return productTestReportUrl;
    }

    public void setProductTestReportUrl(String productTestReportUrl) {
        this.productTestReportUrl = productTestReportUrl;
    }

    public String getHygienicLicenseUrl() {
        return hygienicLicenseUrl;
    }

    public void setHygienicLicenseUrl(String hygienicLicenseUrl) {
        this.hygienicLicenseUrl = hygienicLicenseUrl;
    }

    public String getBusinessCertificateUrl() {
        return businessCertificateUrl;
    }

    public void setBusinessCertificateUrl(String businessCertificateUrl) {
        this.businessCertificateUrl = businessCertificateUrl;
    }

    public String getProductCertificationUrl() {
        return productCertificationUrl;
    }

    public void setProductCertificationUrl(String productCertificationUrl) {
        this.productCertificationUrl = productCertificationUrl;
    }

    public String getProductionLicenceUrl() {
        return productionLicenceUrl;
    }

    public void setProductionLicenceUrl(String productionLicenceUrl) {
        this.productionLicenceUrl = productionLicenceUrl;
    }

    public String getWarenzeichenlizenzUrl() {
        return warenzeichenlizenzUrl;
    }

    public void setWarenzeichenlizenzUrl(String warenzeichenlizenzUrl) {
        this.warenzeichenlizenzUrl = warenzeichenlizenzUrl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", papersGroupId=").append(papersGroupId);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", merchantLogoUrl=").append(merchantLogoUrl);
        sb.append(", productTestReportUrl=").append(productTestReportUrl);
        sb.append(", hygienicLicenseUrl=").append(hygienicLicenseUrl);
        sb.append(", businessCertificateUrl=").append(businessCertificateUrl);
        sb.append(", productCertificationUrl=").append(productCertificationUrl);
        sb.append(", productionLicenceUrl=").append(productionLicenceUrl);
        sb.append(", warenzeichenlizenzUrl=").append(warenzeichenlizenzUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}