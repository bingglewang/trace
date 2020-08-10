package com.zsl.traceapi.dao;

import java.util.List;
import java.util.Map;

import com.zsl.traceapi.dto.BatchQueryParam;
import com.zsl.traceapi.vo.BatchModifyVo;
import com.zsl.traceapi.vo.BatchPagingVo;

/**
 * @author CH W
 * @description	追溯生产批次dao
 * @date 2020年6月5日 下午4:09:06
 * @version 1.0
 */
public interface ZslProductionBatchDao {
    /**
     * --分页查询生产批次列表
     * @param queryParams
     * @return
     */
    List<BatchPagingVo> listByCondition(BatchQueryParam queryParam);

	/**
	 * --id获取批次信息
	 * @param batchId
	 * @return
	 */
	BatchModifyVo getBatchInfo(Integer batchId);

	/**
	 * --批次id获取场景时间范围列表
	 * @param batchId
	 * @return
	 */
	List<String> getSceneTimeByBatchId(Integer batchId);

	/**
	 * --生产批次id获取追溯码段
	 * @param batchId
	 * @return
	 */
	List<Map<String, Object>> getTraceCodeSidByBatchId(Integer batchId);

	/**
	 * --批次号获取所属商品列表
	 * @param batchNo
	 * @return
	 */
	List<Map<String, Object>> goodsListByBatchNo(String batchNo);

	
	
	/**
	 * --商家获取生产批次列表
	 * @param merchantId
	 * @return
	 */
	List<Map<String, Object>> batchListByMerchant(Integer merchantId);

}
