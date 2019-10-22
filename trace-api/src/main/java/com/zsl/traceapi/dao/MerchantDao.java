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
     * 根据商家id获取商家账号id
     * @param merchantId
     * @return
     */
    Integer getAccountIdByBussiId(@Param("merchantId") Integer merchantId);

    /**
     * 员工
     * @param accountId
     * @return
     */
    MerchantPointDto getEmployPoint(@Param("accountId") Integer accountId);

    /**
     * 根据手机号获取员工
     * @param mobile
     * @return
     */
    MerchantPointDto getEmployPointByMobile(@Param("mobile") String mobile);

    /**
     * 商家
     * @param accountId
     * @return
     */
    MerchantPointDto getMerchantPoint(@Param("accountId") Integer accountId);

    /**
     * 根据手机号获取商家
     * @param mobile
     * @return
     */
    MerchantPointDto getMerchantPointByMobile(@Param("mobile") String mobile);


    /**
     * 其他 和代理商
     * @param accountId
     * @return
     */
    MerchantPointDto getOtherPoint(@Param("accountId") Integer accountId);

    /**
     * 根据手机号获取其他和代理商
     * @param mobile
     * @return
     */
    MerchantPointDto getOtherPointByMobile(@Param("mobile") String mobile);

    /**
     * 根据账号id更新追溯点名称
     * @param accountId
     * @param tracePointName
     * @return
     */
    int updatePointNodeByAccountId(@Param("accountId") Integer accountId,@Param("tracePointName") String tracePointName);

}
