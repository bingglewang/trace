package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ZslRecallDispose implements Serializable {
    private Integer recallDisposeId;

    @ApiModelProperty(value = "批次召回id")
    private Integer batchRecallId;

    @ApiModelProperty(value = "销毁/处理码段数据文件url")
    private String codeSegmentFileUrl;

    @ApiModelProperty(value = "处理类型（0销毁、1继续销售）")
    private Integer disposeType;

    @ApiModelProperty(value = "处理/销毁日期范围")
    private String disposeTimeScope;

    @ApiModelProperty(value = "员工id")
    private Integer employeId;

    @ApiModelProperty(value = "处理/销毁地点")
    private String address;

    @ApiModelProperty(value = "处理/销毁数量")
    private Integer count;

    @ApiModelProperty(value = "处理方式")
    private String disposeWay;

    @ApiModelProperty(value = "记录创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getRecallDisposeId() {
        return recallDisposeId;
    }

    public void setRecallDisposeId(Integer recallDisposeId) {
        this.recallDisposeId = recallDisposeId;
    }

    public Integer getBatchRecallId() {
        return batchRecallId;
    }

    public void setBatchRecallId(Integer batchRecallId) {
        this.batchRecallId = batchRecallId;
    }

    public String getCodeSegmentFileUrl() {
        return codeSegmentFileUrl;
    }

    public void setCodeSegmentFileUrl(String codeSegmentFileUrl) {
        this.codeSegmentFileUrl = codeSegmentFileUrl;
    }

    public Integer getDisposeType() {
        return disposeType;
    }

    public void setDisposeType(Integer disposeType) {
        this.disposeType = disposeType;
    }

    public String getDisposeTimeScope() {
        return disposeTimeScope;
    }

    public void setDisposeTimeScope(String disposeTimeScope) {
        this.disposeTimeScope = disposeTimeScope;
    }

    public Integer getEmployeId() {
        return employeId;
    }

    public void setEmployeId(Integer employeId) {
        this.employeId = employeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDisposeWay() {
        return disposeWay;
    }

    public void setDisposeWay(String disposeWay) {
        this.disposeWay = disposeWay;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", recallDisposeId=").append(recallDisposeId);
        sb.append(", batchRecallId=").append(batchRecallId);
        sb.append(", codeSegmentFileUrl=").append(codeSegmentFileUrl);
        sb.append(", disposeType=").append(disposeType);
        sb.append(", disposeTimeScope=").append(disposeTimeScope);
        sb.append(", employeId=").append(employeId);
        sb.append(", address=").append(address);
        sb.append(", count=").append(count);
        sb.append(", disposeWay=").append(disposeWay);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}