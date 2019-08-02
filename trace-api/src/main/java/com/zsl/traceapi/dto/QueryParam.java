package com.zsl.traceapi.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class QueryParam {
    private String traceCodeNumber; //追溯码批次号
    private String traceCompanyName; //所属公司名称
    private Long  traceApplyStartDate;
    private Long traceApplyEndDate;
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date  traceApplyStartDate1; //申请开始日期
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date  traceApplyEndDate1; //申请结束日期
    private Integer traceHandleStatus; //处理状态
    private String merchantName; //商家名称
    private Integer traceApplyType; //申请类型
    private Integer merchantId; //商家id
    private Integer allianceId; //加盟商id
    private String isZongBu; //是否为总部运营
    private String isMiniProgram; //是否为小程序
}
