package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Goods implements Serializable {
    private Integer goodsId;

    private String goodsName;

    private Integer merchantId;

    private Integer categoryId;

    private String categoryFullName;

    private Date goodsCreatTime;

    private Date goodsUpdateTime;

    private Integer brandId;

    private String videoName;

    private String videoUrl;

    @ApiModelProperty(value = "是否货物")
    private Byte cargo;

    @ApiModelProperty(value = "货物来源")
    private String source;

    @ApiModelProperty(value = "地址")
    private String location;

    @ApiModelProperty(value = "联系电话")
    private String phone;

    @ApiModelProperty(value = "经办人")
    private String operator;

    @ApiModelProperty(value = "生产日期")
    private Date producedTime;

    @ApiModelProperty(value = "单品运费模版id")
    private Integer templateId;

    @ApiModelProperty(value = "是否上架国际贸易区（0：下架，1：上架）")
    private Byte internationalSales;

    private static final long serialVersionUID = 1L;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryFullName() {
        return categoryFullName;
    }

    public void setCategoryFullName(String categoryFullName) {
        this.categoryFullName = categoryFullName;
    }

    public Date getGoodsCreatTime() {
        return goodsCreatTime;
    }

    public void setGoodsCreatTime(Date goodsCreatTime) {
        this.goodsCreatTime = goodsCreatTime;
    }

    public Date getGoodsUpdateTime() {
        return goodsUpdateTime;
    }

    public void setGoodsUpdateTime(Date goodsUpdateTime) {
        this.goodsUpdateTime = goodsUpdateTime;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Byte getCargo() {
        return cargo;
    }

    public void setCargo(Byte cargo) {
        this.cargo = cargo;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getProducedTime() {
        return producedTime;
    }

    public void setProducedTime(Date producedTime) {
        this.producedTime = producedTime;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public Byte getInternationalSales() {
        return internationalSales;
    }

    public void setInternationalSales(Byte internationalSales) {
        this.internationalSales = internationalSales;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", categoryFullName=").append(categoryFullName);
        sb.append(", goodsCreatTime=").append(goodsCreatTime);
        sb.append(", goodsUpdateTime=").append(goodsUpdateTime);
        sb.append(", brandId=").append(brandId);
        sb.append(", videoName=").append(videoName);
        sb.append(", videoUrl=").append(videoUrl);
        sb.append(", cargo=").append(cargo);
        sb.append(", source=").append(source);
        sb.append(", location=").append(location);
        sb.append(", phone=").append(phone);
        sb.append(", operator=").append(operator);
        sb.append(", producedTime=").append(producedTime);
        sb.append(", templateId=").append(templateId);
        sb.append(", internationalSales=").append(internationalSales);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}