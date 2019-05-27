package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class GoodsIntroduction implements Serializable {
    private Integer introductionId;

    private Integer goodsId;

    private String introductionInfo;

    private static final long serialVersionUID = 1L;

    public Integer getIntroductionId() {
        return introductionId;
    }

    public void setIntroductionId(Integer introductionId) {
        this.introductionId = introductionId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getIntroductionInfo() {
        return introductionInfo;
    }

    public void setIntroductionInfo(String introductionInfo) {
        this.introductionInfo = introductionInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", introductionId=").append(introductionId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", introductionInfo=").append(introductionInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}