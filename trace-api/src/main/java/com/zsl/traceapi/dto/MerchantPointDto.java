package com.zsl.traceapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName MerchantPointDto
 * @Description 流通实体（商家）
 * @Author binggleW
 * @Date 2019-10-14 14:57
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchantPointDto {
    /**
     * 业务类型（1：商家，2：代理商，3：员工，4：其他）
     */
    private Integer serviceType;
    /**
     * 商家id，员工id，代理商id，其他id
     */
    private Integer serviceId;
    /**
     * 流通节点名称
     */
    private String tracePointName;

    /**
     * 负责人
     */
    private String personInCharge;

    /**
     * 联系电话
     */
    private String contactNumber;

    /**
     * 详细地址
     */
    private String  detailAddress;
}
