package com.zsl.traceapi.dto;

import com.zsl.traceapi.validator.FlagValidator;
import lombok.Data;

import java.util.List;

@Data
public class DeliverGoods {
    /**
     * 外码或内码
     */
    private List<String> codeNumber;

    /**
     * 账号id
     */
    private Integer accountId;

    /**
     * 其他用户信息(当手机号没搜到时)
     */
    private MerchantPointDto otherMerchant;

    /**
     * 模式（1：已经出售，2：添加节点）
     */
    @FlagValidator(value = {"1","2"},message = "模式值只能为1或者2")
    private Integer mode;
}
