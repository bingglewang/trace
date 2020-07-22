package com.zsl.traceapi.dto;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName ZslTraceSidPageParam
 * @Description TODO
 * @Author binggleW
 * @Date 2020-07-21 15:11
 * @Version 1.0
 **/
@Data
public class ZslTraceSidPageParam {
    private Long startSid;
    private Long endSid;
    private Long startCreateTime;
    private Long endCreateTime;
    private Date startTime;
    private Date endTime;
}
