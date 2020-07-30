package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ZslConflictCodeDetail implements Serializable {
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "串货码id")
    private Integer conflictCodeId;

    @ApiModelProperty(value = "串货地址")
    private String conflictAddress;

    @ApiModelProperty(value = "串货日期")
    private Date conflictDate;

    @ApiModelProperty(value = "冲突ip")
    private String conflictIp;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConflictCodeId() {
        return conflictCodeId;
    }

    public void setConflictCodeId(Integer conflictCodeId) {
        this.conflictCodeId = conflictCodeId;
    }

    public String getConflictAddress() {
        return conflictAddress;
    }

    public void setConflictAddress(String conflictAddress) {
        this.conflictAddress = conflictAddress;
    }

    public Date getConflictDate() {
        return conflictDate;
    }

    public void setConflictDate(Date conflictDate) {
        this.conflictDate = conflictDate;
    }

    public String getConflictIp() {
        return conflictIp;
    }

    public void setConflictIp(String conflictIp) {
        this.conflictIp = conflictIp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", conflictCodeId=").append(conflictCodeId);
        sb.append(", conflictAddress=").append(conflictAddress);
        sb.append(", conflictDate=").append(conflictDate);
        sb.append(", conflictIp=").append(conflictIp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}