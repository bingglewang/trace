package com.zsl.traceapi.service;

import java.util.List;

import com.zsl.traceapi.vo.MaterialInStorageVo;
import com.zsl.tracecommon.CommonResult;

/**
 * @author CH W
 * @description 原材料相关功能操作接口
 * @date 2020年6月11日 下午5:12:37
 * @version 1.0
 */
public interface MaterialOutInStorageService {

	/**
	 * --商家id获取原材料入库信息列表
	 * @param merchantId
	 * @return
	 */
	CommonResult<List<MaterialInStorageVo>> listByMerchant(Integer merchantId);

}
