package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ZslTraceProductionLink implements Serializable {
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "环节名称")
    private String productionName;

    @ApiModelProperty(value = "环节日期")
    private Date productionTime;

    @ApiModelProperty(value = "负责人")
    private String productionMan;

    @ApiModelProperty(value = "记录id")
    private Integer traceRecodeId;

    @ApiModelProperty(value = "环节描述")
    private String productionDescripe;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductionName() {
        return productionName;
    }

    public void setProductionName(String productionName) {
        this.productionName = productionName;
    }

    public Date getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(Date productionTime) {
        this.productionTime = productionTime;
    }

    public String getProductionMan() {
        return productionMan;
    }

    public void setProductionMan(String productionMan) {
        this.productionMan = productionMan;
    }

    public Integer getTraceRecodeId() {
        return traceRecodeId;
    }

    public void setTraceRecodeId(Integer traceRecodeId) {
        this.traceRecodeId = traceRecodeId;
    }

    public String getProductionDescripe() {
        return productionDescripe;
    }

    public void setProductionDescripe(String productionDescripe) {
        this.productionDescripe = productionDescripe;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productionName=").append(productionName);
        sb.append(", productionTime=").append(productionTime);
        sb.append(", productionMan=").append(productionMan);
        sb.append(", traceRecodeId=").append(traceRecodeId);
        sb.append(", productionDescripe=").append(productionDescripe);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}