package com.zsl.traceapi.dto;

import lombok.Data;

@Data
public class TraceRecordPointParam {
    /**
     * 关联商品id
     */
    private Integer traceGoodsId;

    /**
     * 摊位id（非农贸则为-1）
     */
    private Integer traceStallId;

    /**
     * 账号id
     */
    private Integer accountId;

    /**
     * 其他用户信息(当手机号没搜到时)
     */
    private MerchantPointDto otherMerchant;

    /**
     * 追溯点起始编码
     */
    private Integer tracePointToNumber;

    /**
     * 追溯点结束编码
     */
    private Integer tracePointFromNumber;

    /**
     * 父节点id
     */
    private Integer traceParentId;

    /**
     * 追溯码批次号
     */
    private String traceCodeNumber;
}
