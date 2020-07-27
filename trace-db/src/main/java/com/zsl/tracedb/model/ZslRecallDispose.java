package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ZslRecallDispose implements Serializable {
    private Integer recallDisposeId;

    @ApiModelProperty(value = "批次召回id")
    private Integer batchRecallId;

    @ApiModelProperty(value = "处理批次号")
    private String disposeBatchNo;

    @ApiModelProperty(value = "处理码段数据文件url")
    private String excelFileUrl;

    @ApiModelProperty(value = "处理类型（0销毁、1继续销售）")
    private Integer disposeType;

    @ApiModelProperty(value = "处理日期范围")
    private String disposeTimeScope;

    @ApiModelProperty(value = "员工id")
    private Integer employeId;

    @ApiModelProperty(value = "处理地点")
    private String disposeSite;

    @ApiModelProperty(value = "处理数量")
    private Integer disposeCount;

    @ApiModelProperty(value = "处理方式")
    private String description;

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

    public String getDisposeBatchNo() {
        return disposeBatchNo;
    }

    public void setDisposeBatchNo(String disposeBatchNo) {
        this.disposeBatchNo = disposeBatchNo;
    }

    public String getExcelFileUrl() {
        return excelFileUrl;
    }

    public void setExcelFileUrl(String excelFileUrl) {
        this.excelFileUrl = excelFileUrl;
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

    public String getDisposeSite() {
        return disposeSite;
    }

    public void setDisposeSite(String disposeSite) {
        this.disposeSite = disposeSite;
    }

    public Integer getDisposeCount() {
        return disposeCount;
    }

    public void setDisposeCount(Integer disposeCount) {
        this.disposeCount = disposeCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        sb.append(", disposeBatchNo=").append(disposeBatchNo);
        sb.append(", excelFileUrl=").append(excelFileUrl);
        sb.append(", disposeType=").append(disposeType);
        sb.append(", disposeTimeScope=").append(disposeTimeScope);
        sb.append(", employeId=").append(employeId);
        sb.append(", disposeSite=").append(disposeSite);
        sb.append(", disposeCount=").append(disposeCount);
        sb.append(", description=").append(description);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}