package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ZslTraceSubcode implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "追溯sid")
    private Long traceSid;

    @ApiModelProperty(value = "编码序号")
    private Long traceIndex;

    @ApiModelProperty(value = "关联追溯码批次号")
    private String traceCodeNumber;

    @ApiModelProperty(value = "子追溯码")
    private String traceSubCodeNumber;

    @ApiModelProperty(value = "关联商品id")
    private Integer traceGoodId;

    @ApiModelProperty(value = "关联摊位id（没有则为非农贸）")
    private Integer traceStallId;

    @ApiModelProperty(value = "父码")
    private Long parentId;

    @ApiModelProperty(value = "是否内码（Y:是，N:否）（是否叶子节点）")
    private String isLeaf;

    @ApiModelProperty(value = "节点层级")
    private Integer nodeLevel;

    @ApiModelProperty(value = "扫码次数")
    private Long scanCount;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTraceSid() {
        return traceSid;
    }

    public void setTraceSid(Long traceSid) {
        this.traceSid = traceSid;
    }

    public Long getTraceIndex() {
        return traceIndex;
    }

    public void setTraceIndex(Long traceIndex) {
        this.traceIndex = traceIndex;
    }

    public String getTraceCodeNumber() {
        return traceCodeNumber;
    }

    public void setTraceCodeNumber(String traceCodeNumber) {
        this.traceCodeNumber = traceCodeNumber;
    }

    public String getTraceSubCodeNumber() {
        return traceSubCodeNumber;
    }

    public void setTraceSubCodeNumber(String traceSubCodeNumber) {
        this.traceSubCodeNumber = traceSubCodeNumber;
    }

    public Integer getTraceGoodId() {
        return traceGoodId;
    }

    public void setTraceGoodId(Integer traceGoodId) {
        this.traceGoodId = traceGoodId;
    }

    public Integer getTraceStallId() {
        return traceStallId;
    }

    public void setTraceStallId(Integer traceStallId) {
        this.traceStallId = traceStallId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
    }

    public Integer getNodeLevel() {
        return nodeLevel;
    }

    public void setNodeLevel(Integer nodeLevel) {
        this.nodeLevel = nodeLevel;
    }

    public Long getScanCount() {
        return scanCount;
    }

    public void setScanCount(Long scanCount) {
        this.scanCount = scanCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", traceSid=").append(traceSid);
        sb.append(", traceIndex=").append(traceIndex);
        sb.append(", traceCodeNumber=").append(traceCodeNumber);
        sb.append(", traceSubCodeNumber=").append(traceSubCodeNumber);
        sb.append(", traceGoodId=").append(traceGoodId);
        sb.append(", traceStallId=").append(traceStallId);
        sb.append(", parentId=").append(parentId);
        sb.append(", isLeaf=").append(isLeaf);
        sb.append(", nodeLevel=").append(nodeLevel);
        sb.append(", scanCount=").append(scanCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}