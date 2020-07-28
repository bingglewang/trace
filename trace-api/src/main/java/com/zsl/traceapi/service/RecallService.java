package com.zsl.traceapi.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zsl.traceapi.dto.DisposeRecallParam;
import com.zsl.traceapi.dto.RecallParam;
import com.zsl.traceapi.dto.RecallQueryParam;
import com.zsl.traceapi.vo.DestroyPagingVo;
import com.zsl.traceapi.vo.RecallDetailForEditVo;
import com.zsl.traceapi.vo.DisposeRecallResultVo;
import com.zsl.traceapi.vo.RecallPagingVo;
import com.zsl.tracecommon.CommonResult;

/**
 * @author CH W
 * @description	追溯批次召回业务接口
 * @date 2020年6月2日 下午5:06:45
 * @version 1.0
 */
public interface RecallService {
	
	/**
	 * --召回批次分页列表
	 * @param param
	 * @return
	 */
	CommonResult<PageInfo<RecallPagingVo>> paging(RecallQueryParam param);
	
	/**
	 * --新建召回
	 * @param param
	 * @return
	 */
	CommonResult<String> newRecall(RecallParam param);

	/**
	 * --删除召回记录
	 * @param recallId
	 * @return
	 */
	CommonResult<String> delete(Integer recallId);

	/**
	 * --编辑页面详细
	 * @param recallId
	 * @return
	 */
	CommonResult<RecallDetailForEditVo> detailForEdit(Integer recallId);

	/**
	 * --修改召回记录
	 * @param param
	 * @return
	 */
	CommonResult<String> modify(RecallParam param);

	/**
	 * --新建处理时召回详细
	 * @param recallId
	 * @return
	 */
	CommonResult<DisposeRecallResultVo> recallDetailForNewDispose(Integer recallId);
	
	/**
	 * --处理召回信息
	 * @param param
	 * @return
	 */
	CommonResult<String> disposeRecallInfo(Integer recallId, List<DisposeRecallParam> param);

	/**
	 * --处理的结果详情
	 * @param recallId
	 * @return
	 */
	CommonResult<DisposeRecallResultVo> disposeDetail(Integer recallId);

	/**
	 * --召回销毁分页列表
	 * @param param
	 * @return
	 */
	CommonResult<PageInfo<DestroyPagingVo>> destroyPaging(RecallQueryParam param);

}
