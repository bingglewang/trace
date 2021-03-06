package com.zsl.traceapi.vo;

import com.zsl.tracedb.model.Merchant;
import lombok.Data;

import java.util.Date;

@Data
public class ZslTraceVo {
    private Integer traceId;  //追溯id
    private String traceCodeNumber;  //追溯码批次号
    private Merchant merchant; //商家信息
    private Integer traceApplyType; //申请类型
    private Integer traceHandleStatus; // 申请处理状态
    private String  companyName;  // 公司名称
    private Date traceApplyDate;  //申请日期
    private Date traceReviewDate; //审核日期
    private Long traceApplyCount; //申请数量
    private Integer traceEnableCount; //剩余数量
    private String traceRefuseRemark; //拒绝备注
    private String isMiniProgram;//是否为小程序
}
