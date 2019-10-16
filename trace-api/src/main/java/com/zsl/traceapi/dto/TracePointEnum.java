package com.zsl.traceapi.dto;

import lombok.Getter;

/**
 * @ClassName TracePointEnum
 * @Description 流通节点枚举
 * @Author binggleW
 * @Date 2019-10-14 9:56
 * @Version 1.0
 **/
@Getter
public enum TracePointEnum {
    MERCHANT(1,"商家"),
    AGENT(2,"代理商"),
    EMPLOYMENT(3,"员工"),
    OTHER(4,"其他");

    /**
     * 业务类型
     */
    private Integer type;

    /**
     * 描述
     */
    private String desc;

    TracePointEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
