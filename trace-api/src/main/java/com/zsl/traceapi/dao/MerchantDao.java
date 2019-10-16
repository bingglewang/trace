package com.zsl.traceapi.dao;

import com.zsl.traceapi.dto.MerchantPointDto;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName MerchantDao
 * @Description 商家账号相关dao
 * @Author binggleW
 * @Date 2019-10-14 14:54
 * @Version 1.0
 **/
public interface MerchantDao {
    /**
     * 商家
     * @param merchantId
     * @return
     */
    MerchantPointDto getMerchantPoint(@Param("merchantId") Integer merchantId);

    /**
     * 根据手机号获取商家
     * @param mobile
     * @return
     */
    MerchantPointDto getMerchantPointByMobile(@Param("mobile") String mobile);

    /**
     * 代理商
     * @param agentId
     * @return
     */
    MerchantPointDto getAgentPoint(@Param("agentId") Integer agentId);

    /**
     * 根据手机号获取代理商
     * @param mobile
     * @return
     */
    MerchantPointDto getAgentPointByMobile(@Param("mobile") String mobile);

    /**
     * 其他
     * @param otherId
     * @return
     */
    MerchantPointDto getOtherPoint(@Param("otherId") Integer otherId);

    /**
     * 根据手机号获取其他
     * @param mobile
     * @return
     */
    MerchantPointDto getOtherPointByMobile(@Param("mobile") String mobile);

    /**
     * 商家员工
     * @param employId
     * @return
     */
    MerchantPointDto getEmployPoint(@Param("employId") Integer employId);

    /**
     * 根据手机号获取商家员工
     * @param mobile
     * @return
     */
    MerchantPointDto getEmployPointByMobile(@Param("mobile") String mobile);
}
