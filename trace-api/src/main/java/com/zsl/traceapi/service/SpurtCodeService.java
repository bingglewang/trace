package com.zsl.traceapi.service;

import com.zsl.traceapi.vo.SpurtCodeVo;

import java.util.List;

/**
 * @ClassName SpurtCodeService
 * @Description 喷码
 * @Author binggleW
 * @Date 2020-01-05 11:51
 * @Version 1.0
 **/
public interface SpurtCodeService {
    /**
     * 根据追溯码获取sid 集合
     * @param traceCodeNumber
     * @return
     */
    List<SpurtCodeVo> getSidsByTraceCodeNumber(String traceCodeNumber);

    /**
     * 判断是否存在
     * @param traceCodeNumber
     * @param traceSid
     * @return
     */
    boolean isExitByTraceCodeNumberAndSid(String traceCodeNumber,Long traceSid);
}
