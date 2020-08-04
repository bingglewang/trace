package com.zsl.traceapi.controller;

import com.zsl.traceapi.dto.MerchantPointDto;
import com.zsl.traceapi.service.OtherAccountServcie;
import com.zsl.tracecommon.CommonResult;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OtherAccountController
 * @Description
 * @Author binggleW
 * @Date 2019-10-16 9:46
 * @Version 1.0
 **/
@RestController
@RequestMapping("other")
public class OtherAccountController {
    @Autowired
    private OtherAccountServcie accountServcie;

    /**
     * 根据手机号判断会员是否存在
     * @param mobile
     * @return
     */
    @GetMapping("getNodeByMobile")
    public CommonResult getNodeByMobile(String mobile){
        MerchantPointDto accountDistributeNode = accountServcie.getNodeByMobile(mobile);
        if(accountDistributeNode == null){
            return CommonResult.success(-1,"不存在");
        }else{
            return CommonResult.success(accountDistributeNode);
        }
    }

    /**
     * 判断当前用户是否为最新节点
     */
    @GetMapping("isCurrentNodeNewest")
    public CommonResult isCurrentNodeNewest(Long sid){
        boolean result = accountServcie.isCurrentNodeNewest(sid);
        return CommonResult.success(result);
    }
    
    
    
    /**
     * --根据商家获取员工列表（子账号）
     * @param merchantId
     * @return
     */
    @GetMapping("optionAccountList/{merchantId}")
    public CommonResult<List<Map<String, Object>>> optionAccountList(@PathVariable Integer merchantId){
        return CommonResult.success(accountServcie.optionAccountList(merchantId));
    }

}
