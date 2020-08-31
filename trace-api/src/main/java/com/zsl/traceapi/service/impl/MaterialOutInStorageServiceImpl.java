package com.zsl.traceapi.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsl.traceapi.dao.MaterialOutInStorageDao;
import com.zsl.traceapi.service.MaterialOutInStorageService;
import com.zsl.traceapi.vo.GoodsSellChannelVo;
import com.zsl.traceapi.vo.MaterialInStorageVo;
import com.zsl.tracecommon.CommonResult;
import com.zsl.tracecommon.ResultCode;

/**
 * @author CH W
 * @description	追溯原材料出入库业务实现类
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

	
	
	
	
	//========================================商品销售渠道相关=========================================//
	
	@Override
	public CommonResult<String> newOrModifyGoodsSellChannel(GoodsSellChannelVo param) {
		try {
			GoodsSellChannelVo gscv = materialOutInStorageDao.
					goodsSellChannelForEditPage(param.getGoodsId(), param.getGoodsSellChannelId());
			//	校验参数数据
			if(StringUtils.isBlank(param.getTmall()) || 
					StringUtils.isBlank(param.getTmall()) || StringUtils.isBlank(param.getTmall())) {
				return CommonResult.failed(ResultCode.VALIDATE_FAILED);
			}
			//	看插入还是更新操作
			if(gscv==null) {
				materialOutInStorageDao.saveSellChannel(param);
			}else {
				param.setGoodsSellChannelId(gscv.getGoodsSellChannelId());
				materialOutInStorageDao.updateSellChannel(param);
			}
			return CommonResult.success(null);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.failed();
		}
	}

	@Override
	public CommonResult<GoodsSellChannelVo> goodsSellChannelForEditPage(Integer goodsId) {
		return CommonResult.success(materialOutInStorageDao.goodsSellChannelForEditPage(goodsId, null));
	}
	
}
