package com.zsl.traceapi.controller;

import com.zsl.traceapi.service.SpurtCodeService;
import com.zsl.tracecommon.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SpurtCodeController
 * @Description 喷码
 * @Author binggleW
 * @Date 2020-01-05 14:21
 * @Version 1.0
 **/
@RestController
@RequestMapping("spurtCode")
public class SpurtCodeController {

    @Autowired
    private SpurtCodeService spurtCodeService;

    @GetMapping("list")
    public CommonResult getSidsByTraceCodeNumber(String traceCodeNumber){
        return  CommonResult.success(spurtCodeService.getSidsByTraceCodeNumber(traceCodeNumber));
    }

    @GetMapping("isExist")
    public CommonResult isExitByTraceCodeNumberAndSid(String traceCodeNumber,Long traceSid){
        return  CommonResult.success(spurtCodeService.isExitByTraceCodeNumberAndSid(traceCodeNumber,traceSid));
    }
}
