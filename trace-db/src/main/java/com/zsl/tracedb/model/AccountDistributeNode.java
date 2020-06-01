package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class AccountDistributeNode implements Serializable {
    @ApiModelProperty(value = "自增主键")
    private Integer id;

    @ApiModelProperty(value = "账号ID")
    private Integer accountId;

    @ApiModelProperty(value = "追溯点名称")
    private String tracePoint;

    @ApiModelProperty(value = "追溯点别称")
    private String traceAnotherName;

    @ApiModelProperty(value = "地址")
    private String location;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getTracePoint() {
        return tracePoint;
    }

    public void setTracePoint(String tracePoint) {
        this.tracePoint = tracePoint;
    }

    public String getTraceAnotherName() {
        return traceAnotherName;
    }

    public void setTraceAnotherName(String traceAnotherName) {
        this.traceAnotherName = traceAnotherName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
        sb.append(", accountId=").append(accountId);
        sb.append(", tracePoint=").append(tracePoint);
        sb.append(", traceAnotherName=").append(traceAnotherName);
        sb.append(", location=").append(location);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}