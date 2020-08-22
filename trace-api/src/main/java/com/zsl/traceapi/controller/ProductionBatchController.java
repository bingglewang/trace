package com.zsl.traceapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.zsl.traceapi.dto.BatchParam;
import com.zsl.traceapi.dto.BatchQueryParam;
import com.zsl.traceapi.dto.SceneForNewBatchParam;
import com.zsl.traceapi.dto.BatchQueryParam.Merchant;
import com.zsl.traceapi.service.ProductionBatchService;
import com.zsl.traceapi.service.ProductionSceneService;
import com.zsl.traceapi.vo.BatchModifyVo;
import com.zsl.traceapi.vo.BatchPagingVo;
import com.zsl.traceapi.vo.SceneForEditBatchVo;
import com.zsl.traceapi.vo.SceneForNewBatchVo;
import com.zsl.tracecommon.CommonResult;

/**
 * @author CH W
 * @description	追溯生产批次相关功能控制器
 * @date 2020年6月2日 下午4:53:16
 * @version 1.0
 */
@RestController
@RequestMapping(value = "p_batch/")
public class ProductionBatchController {
	@Autowired
	private ProductionBatchService batchService;
	@Autowired
	private ProductionSceneService sceneService;
	
	/**
	 * --运营端生产批次分页
	 * @param queryParam
	 * @return
	 */
	@PostMapping(value = "operateForPagingList")
	public CommonResult<PageInfo<BatchPagingVo>> operateForPagingList(@RequestBody BatchQueryParam queryParam) {
		return batchService.pagingList(queryParam);
	}
	/**
	 * --商家端生产批次分页
	 * @param queryParam
	 * @return
	 */
	@PostMapping(value = "merchantForPagingList")
	public CommonResult<PageInfo<BatchPagingVo>> merchantForPagingList(
			@RequestBody @Validated(Merchant.class) BatchQueryParam queryParam) {
		return batchService.pagingList(queryParam);
	}
	/**
	 * --新建批次时加载场景列表
	 * @param goodsId
	 * @return
	 */
	@GetMapping(value = "loadSceneForNewBatch/{goodsId}")
	public CommonResult<List<SceneForNewBatchVo>> loadSceneForNewBatch(@PathVariable Integer goodsId) {
		return sceneService.sceneListForNewBatch(goodsId);
	}
	/**
	 * --新建生产批次
	 * @param param
	 * @return
	 */
	@PostMapping(value = "newBatch")
	public CommonResult<String> newBatch(@RequestBody @Validated(
			{BatchParam.Insert.class, SceneForNewBatchParam.Insert.class}) BatchParam param) {
		return batchService.newBatch(param);
	}
	/**
	 * --编辑批次时加载批次
	 * @param batchId
	 * @return
	 */
	@GetMapping(value = "detailForEditBatch/{batchId}")
	public CommonResult<BatchModifyVo> detailForEditBatch(@PathVariable Integer batchId) {
		try {
			BatchModifyVo batchInfo = batchService.getBatchInfo(batchId);
			List<SceneForEditBatchVo> sfebvList = sceneService.sceneListForEditBatch(batchId, batchInfo.getGoodsId());
			batchInfo.setSfebvList(sfebvList);
			List<Integer> sceneIds = new ArrayList<>();
			if(sfebvList!=null && sfebvList.size()>0) {
				for(SceneForEditBatchVo sfebv : sfebvList) {
					sceneIds.add(sfebv.getSceneId());
				}
			}
			List<SceneForNewBatchVo> sceneListForNoBound = sceneService.sceneListForNoBound(batchId, batchInfo.getGoodsId(), sceneIds);
			batchInfo.setNoBoundSceneList(sceneListForNoBound);
			return CommonResult.success(batchInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.failed(e.getMessage());
		}
	}
	/**
	 * --修改生产批次
	 * @param param
	 * @return
	 */
	@PostMapping(value = "modify")
	public CommonResult<String> modify(@RequestBody @Validated(
			{BatchParam.Update.class, SceneForNewBatchParam.Update.class}) BatchParam param) {
		return batchService.modify(param);
	}
	/**
	 * --批次号获取所属商品列表
	 * @param goodsId
	 * @return
	 */
	@GetMapping(value = "goodsListByBatchNo/{batchNo}")
	public CommonResult<List<Map<String, Object>>> goodsListByBatchNo(@PathVariable String batchNo) {
		return batchService.goodsListByBatchNo(batchNo);
	}
	
	
	/**
	 * --商家获取生产批次列表
	 * @param merchantId
	 * @return
	 */
	@GetMapping(value = "batchListByMerchant/{merchantId}")
	public CommonResult<List<Map<String, Object>>> batchListByMerchant(@PathVariable Integer merchantId) {
		return batchService.batchListByMerchant(merchantId);
	}
	
}
