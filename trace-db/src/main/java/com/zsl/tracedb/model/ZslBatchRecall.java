package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ZslBatchRecall implements Serializable {
    private Integer batchRecallId;

    @ApiModelProperty(value = "生产批次id")
    private Integer productionBatchId;

    @ApiModelProperty(value = "商品id")
    private Integer goodsId;

    @ApiModelProperty(value = "召回数量")
    private Integer recallCount;

    @ApiModelProperty(value = "未处理数量")
    private Integer undisposedCount;

    @ApiModelProperty(value = "处理状态（1未处理、2已处理、3部分处理）")
    private Boolean disposeStatus;

    @ApiModelProperty(value = "召回负责人")
    private String principal;

    @ApiModelProperty(value = "负责人电话")
    private String principalPhone;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "召回原因")
    private String cause;

    private static final long serialVersionUID = 1L;

    public Integer getBatchRecallId() {
        return batchRecallId;
    }

    public void setBatchRecallId(Integer batchRecallId) {
        this.batchRecallId = batchRecallId;
    }

    public Integer getProductionBatchId() {
        return productionBatchId;
    }

    public void setProductionBatchId(Integer productionBatchId) {
        this.productionBatchId = productionBatchId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getRecallCount() {
        return recallCount;
    }

    public void setRecallCount(Integer recallCount) {
        this.recallCount = recallCount;
    }

    public Integer getUndisposedCount() {
        return undisposedCount;
    }

    public void setUndisposedCount(Integer undisposedCount) {
        this.undisposedCount = undisposedCount;
    }

    public Boolean getDisposeStatus() {
        return disposeStatus;
    }

    public void setDisposeStatus(Boolean disposeStatus) {
        this.disposeStatus = disposeStatus;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getPrincipalPhone() {
        return principalPhone;
    }

    public void setPrincipalPhone(String principalPhone) {
        this.principalPhone = principalPhone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", batchRecallId=").append(batchRecallId);
        sb.append(", productionBatchId=").append(productionBatchId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", recallCount=").append(recallCount);
        sb.append(", undisposedCount=").append(undisposedCount);
        sb.append(", disposeStatus=").append(disposeStatus);
        sb.append(", principal=").append(principal);
        sb.append(", principalPhone=").append(principalPhone);
        sb.append(", createTime=").append(createTime);
        sb.append(", cause=").append(cause);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}