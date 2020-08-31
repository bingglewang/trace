package com.zsl.traceapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zsl.traceapi.service.MaterialOutInStorageService;
import com.zsl.traceapi.vo.GoodsSellChannelVo;
import com.zsl.traceapi.vo.MaterialInStorageVo;
import com.zsl.tracecommon.CommonResult;

/**
 * @author CH W
 * @description	原材料相关功能控制器
 * @date 2020年6月2日 下午4:53:16
 * @version 1.0
 */
@RestController
@RequestMapping(value = "material/")
public class MaterialOutInStorageController {
	@Autowired
	private MaterialOutInStorageService materialOutInStorageService;
	
	/**
	 * --商家的材料入库列表
	 * @param queryParam
	 * @return
	 */
	@GetMapping(value = "listByMerchant/{merchantId}")
	public CommonResult<List<MaterialInStorageVo>> listByMerchant(@PathVariable Integer merchantId) {
		return materialOutInStorageService.listByMerchant(merchantId);
	}
	
	
	

    /**
     * --新建或修改商品销售渠道
     * @param param
     * @return
     */
    @PostMapping(value = "newOrModifyGoodsSellChannel")
    public CommonResult<String> newOrModifyGoodsSellChannel(@RequestBody @Valid GoodsSellChannelVo param){
    	return materialOutInStorageService.newOrModifyGoodsSellChannel(param);
    }
    /**
     * --商品销售渠道编辑页面数据
     * @param goodsId
     * @return
     */
    @GetMapping(value = "goodsSellChannelForEditPage/{goodsId}")
    public CommonResult<GoodsSellChannelVo> goodsSellChannelForEditPage(@PathVariable Integer goodsId){
    	return materialOutInStorageService.goodsSellChannelForEditPage(goodsId);
    }

}
