package com.zsl.traceapi.dao;

import java.util.List;

import com.zsl.traceapi.vo.GoodsSellChannelVo;
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

	
	
	
	/**
	 * --根据商品id获取销售渠道信息
	 * @param goodsId
	 * @param goodsSellChannelId
	 * @return
	 */
	GoodsSellChannelVo goodsSellChannelForEditPage(Integer goodsId, Integer goodsSellChannelId);
	/**
	 * --保存商品销售渠道
	 * @param param
	 */
	void saveSellChannel(GoodsSellChannelVo param);
	/**
	 * --更新商品销售渠道
	 * @param param
	 */
	void updateSellChannel(GoodsSellChannelVo param);

}
