package com.zsl.traceapi.vo;

import lombok.Data;

@Data
public class ZslTracePointVo{
    /**
     * 流通节点名称
     */
    private String tracePointName;

    /**
     * 流通节点时间
     */
    private String tracePointTime;

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
