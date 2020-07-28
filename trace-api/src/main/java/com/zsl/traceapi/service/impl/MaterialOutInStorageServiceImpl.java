package com.zsl.traceapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsl.traceapi.dao.MaterialOutInStorageDao;
import com.zsl.traceapi.service.MaterialOutInStorageService;
import com.zsl.traceapi.vo.MaterialInStorageVo;
import com.zsl.tracecommon.CommonResult;

/**
 * @author CH W
 * @description	追溯生产场景业务实现类
 * @date 2020年6月2日 下午5:08:15
 * @version 1.0
 */
@Service
public class MaterialOutInStorageServiceImpl implements MaterialOutInStorageService {
	@Autowired
	private MaterialOutInStorageDao materialOutInStorageDao;

	@Override
	public CommonResult<List<MaterialInStorageVo>> listByMerchant(Integer merchantId) {
		return CommonResult.success(materialOutInStorageDao.listByMerchant(merchantId));
	}
	
}
