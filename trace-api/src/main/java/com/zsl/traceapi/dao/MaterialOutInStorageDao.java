package com.zsl.traceapi.dao;

import java.util.List;

import com.zsl.traceapi.vo.MaterialInStorageVo;

/**
 * @author CH W
 * @description 原材料相关操作Dao接口
 * @date 2020年6月11日 下午5:22:57
 * @version 1.0
 */
public interface MaterialOutInStorageDao {

	/**
	 * --原材料入库信息列表
	 * @param merchantId
	 * @return
	 */
	List<MaterialInStorageVo> listByMerchant(Integer merchantId);

}
