package com.zsl.traceapi.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Test", description = "测试接口")
@RestController("/test")
public class Test {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
