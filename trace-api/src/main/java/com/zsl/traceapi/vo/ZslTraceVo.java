package com.zsl.traceapi.vo;

import com.zsl.tracedb.model.AllianceBusiness;
import com.zsl.tracedb.model.Merchant;
import lombok.Data;

import java.util.Date;

@Data
public class ZslTraceVo {
    private Integer traceId;  //追溯id
    private String traceCodeNumber;  //追溯码批次号
    private String merchantName; //商家名称
    private Integer traceApplyType; //申请类型
    private Integer traceHandleStatus; // 申请处理状态
    private String  companyName;  // 公司名称
    private Date traceApplyDate;  //申请日期
    private Date traceReviewDate; //审核日期
    private Long traceApplyCount; //申请数量
    private String traceRefuseRemark; //拒绝备注
}
