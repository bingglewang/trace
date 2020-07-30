package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ZslConflictCode implements Serializable {
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "追溯sid")
    private Long traceSid;

    @ApiModelProperty(value = "追溯批次号")
    private String traceCodeNumber;

    @ApiModelProperty(value = "生产批次号")
    private String productBatchCode;

    @ApiModelProperty(value = "商品名称")
    private String traceGoodName;

    @ApiModelProperty(value = "追溯节点名称（代理商名称）")
    private String traceNodeName;

    @ApiModelProperty(value = "追溯节点所在地址（代理商所在地址）")
    private String traceAddress;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTraceSid() {
        return traceSid;
    }

    public void setTraceSid(Long traceSid) {
        this.traceSid = traceSid;
    }

    public String getTraceCodeNumber() {
        return traceCodeNumber;
    }

    public void setTraceCodeNumber(String traceCodeNumber) {
        this.traceCodeNumber = traceCodeNumber;
    }

    public String getProductBatchCode() {
        return productBatchCode;
    }

    public void setProductBatchCode(String productBatchCode) {
        this.productBatchCode = productBatchCode;
    }

    public String getTraceGoodName() {
        return traceGoodName;
    }

    public void setTraceGoodName(String traceGoodName) {
        this.traceGoodName = traceGoodName;
    }

    public String getTraceNodeName() {
        return traceNodeName;
    }

    public void setTraceNodeName(String traceNodeName) {
        this.traceNodeName = traceNodeName;
    }

    public String getTraceAddress() {
        return traceAddress;
    }

    public void setTraceAddress(String traceAddress) {
        this.traceAddress = traceAddress;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", traceSid=").append(traceSid);
        sb.append(", traceCodeNumber=").append(traceCodeNumber);
        sb.append(", productBatchCode=").append(productBatchCode);
        sb.append(", traceGoodName=").append(traceGoodName);
        sb.append(", traceNodeName=").append(traceNodeName);
        sb.append(", traceAddress=").append(traceAddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}