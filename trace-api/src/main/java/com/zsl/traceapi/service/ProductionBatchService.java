package com.zsl.traceapi.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.zsl.traceapi.dto.BatchParam;
import com.zsl.traceapi.dto.BatchQueryParam;
import com.zsl.traceapi.vo.BatchModifyVo;
import com.zsl.traceapi.vo.BatchPagingVo;
import com.zsl.tracecommon.CommonResult;

/**
 * @author CH W
 * @description	追溯生产批次业务接口
 * @date 2020年6月2日 下午5:06:45
 * @version 1.0
 */
public interface ProductionBatchService {
	
	/**
	 * --分页查询生产批次列表
	 * @param queryParam
	 * @return
	 */
	CommonResult<PageInfo<BatchPagingVo>> pagingList(BatchQueryParam queryParam);
	/**
	 * --新建生产批次
	 * @param param
	 * @return
	 */
	CommonResult<String> newBatch(BatchParam param);
	/**
	 * --id获取批次信息
	 * @param batchId
	 * @return
	 */
	BatchModifyVo getBatchInfo(Integer batchId);
	/**
	 * --修改生产批次
	 * @param param
	 * @return
	 */
	CommonResult<String> modify(BatchParam param);
	/**
	 * --批次号获取所属商品列表
	 * @param batchNo
	 * @return
	 */
	CommonResult<List<Map<String, Object>>> goodsListByBatchNo(String batchNo);
	
	
	/**
	 * --商家获取生产批次列表
	 * @param merchantId
	 * @return
	 */
	CommonResult<List<Map<String, Object>>> batchListByMerchant(Integer merchantId);

}
