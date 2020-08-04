package com.zsl.traceapi.service;

import java.util.List;
import java.util.Map;

import com.zsl.traceapi.dto.MerchantPointDto;

/**
 * @ClassName OtherAccountServcie
 * @Description 流通节点(其他)
 * @Author binggleW
 * @Date 2019-10-15 17:14
 * @Version 1.0
 **/
public interface OtherAccountServcie {
    /**
     * 根据手机号获取流通人信息
     * @param mobile
     * @return
     */
    MerchantPointDto getNodeByMobile(String mobile);

    /**
     * 判断当前用户是否为最新节点
     * @param sid
     * @return
     */
    boolean isCurrentNodeNewest(Long sid);

	/**
	 * --根据商家获取员工列表（子账号）
	 * @param merchantId
	 * @return
	 */
	List<Map<String, Object>> optionAccountList(Integer merchantId);
}
