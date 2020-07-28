package com.zsl.traceapi.controller;

import java.util.List;

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
import com.zsl.traceapi.dto.DisposeRecallParam;
import com.zsl.traceapi.dto.RecallParam;
import com.zsl.traceapi.dto.RecallQueryParam;
import com.zsl.traceapi.service.RecallService;
import com.zsl.traceapi.vo.DestroyPagingVo;
import com.zsl.traceapi.vo.RecallDetailForEditVo;
import com.zsl.traceapi.vo.DisposeRecallResultVo;
import com.zsl.traceapi.vo.RecallPagingVo;
import com.zsl.tracecommon.CommonResult;

/**
 * @author CH W
 * @description	追溯批次召回相关功能
 * @date 2020年6月2日 下午4:53:16
 * @version 1.0
 */
@RestController
@RequestMapping(value = "recall/")
public class RecallController {
	@Autowired
	private RecallService recallService;
	
	/**
	 * --召回批次分页列表
	 * @param param
	 * @return
	 */
	@PostMapping(value = "paging")
	public CommonResult<PageInfo<RecallPagingVo>> paging(@RequestBody @Valid RecallQueryParam param) {
		return recallService.paging(param);
	}
	/**
	 * --新建召回
	 * @param param
	 * @return
	 */
	@PostMapping(value = "newRecall")
	public CommonResult<String> newRecall(@RequestBody @Validated(RecallParam.Insert.class) RecallParam param) {
		return recallService.newRecall(param);
	}
	/**
	 * --删除召回记录
	 * @param recallId
	 * @return
	 */
	@PostMapping(value = "delete/{recallId}")
	public CommonResult<String> delete(@PathVariable Integer recallId) {
		return recallService.delete(recallId);
	}
	/**
	 * --编辑页面详细
	 * @param recallId
	 * @return
	 */
	@GetMapping(value = "detailForEdit/{recallId}")
	public CommonResult<RecallDetailForEditVo> detailForEdit(@PathVariable Integer recallId) {
		return recallService.detailForEdit(recallId);
	}
	/**
	 * --修改召回记录
	 * @param param
	 * @return
	 */
	@PostMapping(value = "modify")
	public CommonResult<String> modify(@RequestBody @Validated(RecallParam.Update.class) RecallParam param) {
		return recallService.modify(param);
	}
	/**
	 * --新建处理时召回详细
	 * @param recallId
	 * @return
	 */
	@GetMapping(value = "recallDetailForNewDispose/{recallId}")
	public CommonResult<DisposeRecallResultVo> recallDetailForNewDispose(@PathVariable Integer recallId) {
		return recallService.recallDetailForNewDispose(recallId);
	}
	/**
	 * --处理召回信息
	 * @param param
	 * @return
	 */
	@PostMapping(value = "disposeRecallInfo/{recallId}")
	public CommonResult<String> disposeRecallInfo(@PathVariable Integer recallId, 
			@RequestBody @Valid List<DisposeRecallParam> param) {
		return recallService.disposeRecallInfo(recallId, param);
	}
	/**
	 * --处理的结果详情
	 * @param recallId
	 * @return
	 */
	@GetMapping(value = "disposeDetail/{recallId}")
	public CommonResult<DisposeRecallResultVo> disposeDetail(@PathVariable Integer recallId) {
		return recallService.disposeDetail(recallId);
	}
	/**
	 * --召回销毁分页列表
	 * @param param
	 * @return
	 */
	@PostMapping(value = "destroyPaging")
	public CommonResult<PageInfo<DestroyPagingVo>> destroyPaging(@RequestBody @Valid RecallQueryParam param) {
		return recallService.destroyPaging(param);
	}

}
