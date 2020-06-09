package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ZslSceneBatch implements Serializable {
    private Integer sceneBatchId;

    @ApiModelProperty(value = "场景id")
    private Integer sceneId;

    @ApiModelProperty(value = "员工id")
    private Integer employeId;

    @ApiModelProperty(value = "当前生产批次的生产场景下生产时间范围")
    private String sceneTimeScope;

    @ApiModelProperty(value = "批次id")
    private Integer batchId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getSceneBatchId() {
        return sceneBatchId;
    }

    public void setSceneBatchId(Integer sceneBatchId) {
        this.sceneBatchId = sceneBatchId;
    }

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public Integer getEmployeId() {
        return employeId;
    }

    public void setEmployeId(Integer employeId) {
        this.employeId = employeId;
    }

    public String getSceneTimeScope() {
        return sceneTimeScope;
    }

    public void setSceneTimeScope(String sceneTimeScope) {
        this.sceneTimeScope = sceneTimeScope;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
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
        sb.append(", sceneBatchId=").append(sceneBatchId);
        sb.append(", sceneId=").append(sceneId);
        sb.append(", employeId=").append(employeId);
        sb.append(", sceneTimeScope=").append(sceneTimeScope);
        sb.append(", batchId=").append(batchId);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}