package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ZslTrace implements Serializable {
    @ApiModelProperty(value = "追溯id")
    private Integer traceId;

    @ApiModelProperty(value = "追溯码批次号")
    private String traceCodeNumber;

    @ApiModelProperty(value = "关联商家id")
    private Integer traceBusinessId;

    @ApiModelProperty(value = "申请类型（1：纸质标签，2：电子标签）")
    private Integer traceApplyType;

    @ApiModelProperty(value = "处理状态（1：已通过，2：待审核，3：已撤回，4：已拒绝）")
    private Integer traceHandleStatus;

    @ApiModelProperty(value = "所属公司名称")
    private String traceCompanyName;

    @ApiModelProperty(value = "申请日期")
    private Date traceApplyDate;

    @ApiModelProperty(value = "审批日期")
    private Date traceReviewDate;

    @ApiModelProperty(value = "申请数量")
    private Long traceApplyCount;

    @ApiModelProperty(value = "可用数量")
    private Integer traceEnableCount;

    @ApiModelProperty(value = "拒绝申请原因")
    private String traceRefuseRemark;

    @ApiModelProperty(value = "已经关联的数量")
    private Integer traceBack1;

    @ApiModelProperty(value = "加盟商id（null：总部，）")
    private Integer traceBack2;

    @ApiModelProperty(value = "申请的码是否已经生成完(Y:生成完，N:没有)，默认N")
    private String traceBack3;

    @ApiModelProperty(value = "备用字段4")
    private String traceBack4;

    @ApiModelProperty(value = "备用字段5")
    private String traceBack5;

    private static final long serialVersionUID = 1L;

    public Integer getTraceId() {
        return traceId;
    }

    public void setTraceId(Integer traceId) {
        this.traceId = traceId;
    }

    public String getTraceCodeNumber() {
        return traceCodeNumber;
    }

    public void setTraceCodeNumber(String traceCodeNumber) {
        this.traceCodeNumber = traceCodeNumber;
    }

    public Integer getTraceBusinessId() {
        return traceBusinessId;
    }

    public void setTraceBusinessId(Integer traceBusinessId) {
        this.traceBusinessId = traceBusinessId;
    }

    public Integer getTraceApplyType() {
        return traceApplyType;
    }

    public void setTraceApplyType(Integer traceApplyType) {
        this.traceApplyType = traceApplyType;
    }

    public Integer getTraceHandleStatus() {
        return traceHandleStatus;
    }

    public void setTraceHandleStatus(Integer traceHandleStatus) {
        this.traceHandleStatus = traceHandleStatus;
    }

    public String getTraceCompanyName() {
        return traceCompanyName;
    }

    public void setTraceCompanyName(String traceCompanyName) {
        this.traceCompanyName = traceCompanyName;
    }

    public Date getTraceApplyDate() {
        return traceApplyDate;
    }

    public void setTraceApplyDate(Date traceApplyDate) {
        this.traceApplyDate = traceApplyDate;
    }

    public Date getTraceReviewDate() {
        return traceReviewDate;
    }

    public void setTraceReviewDate(Date traceReviewDate) {
        this.traceReviewDate = traceReviewDate;
    }

    public Long getTraceApplyCount() {
        return traceApplyCount;
    }

    public void setTraceApplyCount(Long traceApplyCount) {
        this.traceApplyCount = traceApplyCount;
    }

    public Integer getTraceEnableCount() {
        return traceEnableCount;
    }

    public void setTraceEnableCount(Integer traceEnableCount) {
        this.traceEnableCount = traceEnableCount;
    }

    public String getTraceRefuseRemark() {
        return traceRefuseRemark;
    }

    public void setTraceRefuseRemark(String traceRefuseRemark) {
        this.traceRefuseRemark = traceRefuseRemark;
    }

    public Integer getTraceBack1() {
        return traceBack1;
    }

    public void setTraceBack1(Integer traceBack1) {
        this.traceBack1 = traceBack1;
    }

    public Integer getTraceBack2() {
        return traceBack2;
    }

    public void setTraceBack2(Integer traceBack2) {
        this.traceBack2 = traceBack2;
    }

    public String getTraceBack3() {
        return traceBack3;
    }

    public void setTraceBack3(String traceBack3) {
        this.traceBack3 = traceBack3;
    }

    public String getTraceBack4() {
        return traceBack4;
    }

    public void setTraceBack4(String traceBack4) {
        this.traceBack4 = traceBack4;
    }

    public String getTraceBack5() {
        return traceBack5;
    }

    public void setTraceBack5(String traceBack5) {
        this.traceBack5 = traceBack5;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", traceId=").append(traceId);
        sb.append(", traceCodeNumber=").append(traceCodeNumber);
        sb.append(", traceBusinessId=").append(traceBusinessId);
        sb.append(", traceApplyType=").append(traceApplyType);
        sb.append(", traceHandleStatus=").append(traceHandleStatus);
        sb.append(", traceCompanyName=").append(traceCompanyName);
        sb.append(", traceApplyDate=").append(traceApplyDate);
        sb.append(", traceReviewDate=").append(traceReviewDate);
        sb.append(", traceApplyCount=").append(traceApplyCount);
        sb.append(", traceEnableCount=").append(traceEnableCount);
        sb.append(", traceRefuseRemark=").append(traceRefuseRemark);
        sb.append(", traceBack1=").append(traceBack1);
        sb.append(", traceBack2=").append(traceBack2);
        sb.append(", traceBack3=").append(traceBack3);
        sb.append(", traceBack4=").append(traceBack4);
        sb.append(", traceBack5=").append(traceBack5);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}