package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ZslRecallTraceSubcode implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "召回id")
    private Integer recallId;

    @ApiModelProperty(value = "召回类型（0销毁、1继续销售）")
    private Integer recallType;

    @ApiModelProperty(value = "追溯码id")
    private Integer subcodeId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecallId() {
        return recallId;
    }

    public void setRecallId(Integer recallId) {
        this.recallId = recallId;
    }

    public Integer getRecallType() {
        return recallType;
    }

    public void setRecallType(Integer recallType) {
        this.recallType = recallType;
    }

    public Integer getSubcodeId() {
        return subcodeId;
    }

    public void setSubcodeId(Integer subcodeId) {
        this.subcodeId = subcodeId;
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
        sb.append(", id=").append(id);
        sb.append(", recallId=").append(recallId);
        sb.append(", recallType=").append(recallType);
        sb.append(", subcodeId=").append(subcodeId);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}