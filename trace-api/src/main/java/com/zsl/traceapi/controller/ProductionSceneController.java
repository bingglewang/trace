package com.zsl.traceapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.zsl.traceapi.dto.SceneParam;
import com.zsl.traceapi.dto.SceneQueryParam;
import com.zsl.traceapi.service.ProductionSceneService;
import com.zsl.traceapi.vo.ScenePagingVo;
import com.zsl.traceapi.vo.traceBatchVo;
import com.zsl.traceapi.vo.SceneDetailVo;
import com.zsl.tracecommon.CommonResult;

/**
 * @author CH W
 * @description	追溯生产场景相关功能控制器层
 * @date 2020年6月2日 下午4:53:16
 * @version 1.0
 */
@RestController
@RequestMapping(value = "p_scene/")
public class ProductionSceneController {
	@Autowired
	private ProductionSceneService productionSceneService;
	
	/**
	 * --分页查询商品的生产场景列表
	 * @param queryParam
	 * @return
	 */
	@PostMapping(value = "pagingList")
	public CommonResult<PageInfo<ScenePagingVo>> pagingList(@RequestBody @Valid SceneQueryParam queryParam) {
		return productionSceneService.pagingList(queryParam);
	}
	/**
	 * --新建生产场景
	 * @param params
	 * @return
	 */
	@PostMapping(value = "newScene")
	public CommonResult<String> newScene(
			@RequestBody @Validated(SceneParam.Insert.class) SceneParam params) {
		return productionSceneService.newScene(params);
	}
	/**
	 * --id查询场景详细
	 * @param sceneId
	 * @return
	 */
	@GetMapping(value = "detailById/{sceneId}")
	public CommonResult<SceneDetailVo> detailById(@PathVariable Integer sceneId) {
		return productionSceneService.detailById(sceneId);
	}
	/**
	 * --修改生产场景
	 * @param params
	 * @return
	 */
	@PostMapping(value = "modify")
	public CommonResult<String> modifyScene(
			@RequestBody @Validated(SceneParam.Update.class) SceneParam params) {
		return productionSceneService.modify(params);
	}
	/**
	 * --根据生产批次追溯场景信息
	 * @param batchNo
	 * @return
	 */
	@GetMapping(value = "traceScene/{batchNo}")
	public CommonResult<traceBatchVo> traceScene(@PathVariable String batchNo){
		return productionSceneService.traceScene(batchNo);
	}

}
