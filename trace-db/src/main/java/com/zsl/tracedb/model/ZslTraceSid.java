package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ZslTraceSid implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "sid起始下标")
    private Long sidStartIndex;

    @ApiModelProperty(value = "sid结束下标")
    private Long sidEndIndex;

    @ApiModelProperty(value = "sid当前关联了的下标")
    private Long sidCurrentIndex;

    @ApiModelProperty(value = "纸质sid是否预生成完成（1：完成，-1：未完成）")
    private Byte sidPreCreate;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "当前电子使用下标")
    private Long currentEIndex;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSidStartIndex() {
        return sidStartIndex;
    }

    public void setSidStartIndex(Long sidStartIndex) {
        this.sidStartIndex = sidStartIndex;
    }

    public Long getSidEndIndex() {
        return sidEndIndex;
    }

    public void setSidEndIndex(Long sidEndIndex) {
        this.sidEndIndex = sidEndIndex;
    }

    public Long getSidCurrentIndex() {
        return sidCurrentIndex;
    }

    public void setSidCurrentIndex(Long sidCurrentIndex) {
        this.sidCurrentIndex = sidCurrentIndex;
    }

    public Byte getSidPreCreate() {
        return sidPreCreate;
    }

    public void setSidPreCreate(Byte sidPreCreate) {
        this.sidPreCreate = sidPreCreate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCurrentEIndex() {
        return currentEIndex;
    }

    public void setCurrentEIndex(Long currentEIndex) {
        this.currentEIndex = currentEIndex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sidStartIndex=").append(sidStartIndex);
        sb.append(", sidEndIndex=").append(sidEndIndex);
        sb.append(", sidCurrentIndex=").append(sidCurrentIndex);
        sb.append(", sidPreCreate=").append(sidPreCreate);
        sb.append(", createTime=").append(createTime);
        sb.append(", currentEIndex=").append(currentEIndex);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}