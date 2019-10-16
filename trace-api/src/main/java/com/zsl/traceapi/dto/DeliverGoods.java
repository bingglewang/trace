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
     * 业务类型（1：商家，2：代理商，3：员工，4：其他）
     */
    private Integer serviceType;
    /**
     * 商家id，员工id，代理商id，其他id
     */
    private Integer serviceId;

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
