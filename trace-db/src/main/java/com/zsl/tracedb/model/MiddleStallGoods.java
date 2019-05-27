package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class MiddleStallGoods implements Serializable {
    private Integer stallGoodsId;

    private Integer goodsId;

    private Integer stallId;

    private static final long serialVersionUID = 1L;

    public Integer getStallGoodsId() {
        return stallGoodsId;
    }

    public void setStallGoodsId(Integer stallGoodsId) {
        this.stallGoodsId = stallGoodsId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getStallId() {
        return stallId;
    }

    public void setStallId(Integer stallId) {
        this.stallId = stallId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stallGoodsId=").append(stallGoodsId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", stallId=").append(stallId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}