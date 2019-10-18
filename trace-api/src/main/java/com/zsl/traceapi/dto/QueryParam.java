package com.zsl.traceapi.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class QueryParam {
    /**
     * 追溯码批次号
     */
    private String traceCodeNumber;

    /**
     * 所属公司名称
     */
    private String traceCompanyName;
    private Long  traceApplyStartDate;
    private Long traceApplyEndDate;
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")

    /**
     * 申请开始日期
     */
    private Date  traceApplyStartDate1;
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")

    /**
     * 申请结束日期
     */
    private Date  traceApplyEndDate1;

    /**
     * 处理状态
     */
    private Integer traceHandleStatus;

    /**
     * 商家名称
     */
    private String merchantName;

    /**
     * 申请类型
     */
    private Integer traceApplyType;

    /**
     * 商家id
     */
    private Integer merchantId;

    /**
     * 加盟商id
     */
    private Integer allianceId;

    /**
     * 是否为总部运营
     */
    private String isZongBu;

    /**
     * 是否为小程序
     */
    private String isMiniProgram;
}
