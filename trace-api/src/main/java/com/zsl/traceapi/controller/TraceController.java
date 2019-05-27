package com.zsl.traceapi.controller;

import com.zsl.traceapi.service.TraceService;
import com.zsl.tracecommon.CommonResult;
import com.zsl.tracedb.model.ZslTrace;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "TraceController", description = "追溯模块")
@RestController("/trace")
public class TraceController {

    @Autowired
    private TraceService traceService;

    @GetMapping("/{id:[0-9]+}")
    @ResponseBody
    public CommonResult getById(@PathVariable Integer id ){
        ZslTrace result =  traceService.getZslTraceById(id);
        if(result != null){
            return  CommonResult.success(result);
        }else{
            return  CommonResult.success(null,"没有查到该追溯信息");
        }
    }

    @PostMapping("/insert")
    @ApiOperation("新增追溯信息")
    @ResponseBody
    public CommonResult insert(@RequestBody ZslTrace zslTrace){
        ZslTrace result =  traceService.insert(zslTrace);
        if(result != null){
            return  CommonResult.success(result,"新增成功");
        }else{
            return  CommonResult.success(null,"新增失败");
        }
    }
}
