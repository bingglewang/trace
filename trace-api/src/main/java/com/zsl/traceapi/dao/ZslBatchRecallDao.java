package com.zsl.traceapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zsl.traceapi.dto.RecallQueryParam;
import com.zsl.traceapi.vo.RecallDetailForEditVo;
import com.zsl.traceapi.vo.DestroyPagingVo;
import com.zsl.traceapi.vo.DisposeRecallResultVo;
import com.zsl.traceapi.vo.RecallPagingVo;
import com.zsl.tracedb.model.ZslProductionBatch;
import com.zsl.tracedb.model.ZslRecallDispose;
import com.zsl.tracedb.model.ZslRecallTraceSubcode;

/**
 * @author CH W
 * @description	追溯生产场景dao
 * @date 2020年6月5日 下午4:09:06
 * @version 1.0
 */
public interface ZslBatchRecallDao {

	/**
	 * --条件查询分页列表
	 * @param param
	 * @return
	 */
	List<RecallPagingVo> listByCondition(RecallQueryParam param);

	/**
	 * --编辑页面详细
	 * @param recallId
	 * @return
	 */
	RecallDetailForEditVo detailForEdit(Integer recallId);

	/**
	 * --处理召回的结果详情
	 * @param recallId
	 * @return
	 */
	DisposeRecallResultVo disposeDetail(Integer recallId);

	/**
	 * --销毁记录分页列表
	 * @param param
	 * @return
	 */
	List<DestroyPagingVo> destroyPaging(RecallQueryParam param);

	/**
	 * --批量插入处理记录
	 * @param rdList
	 */
	void batchInsertDispose(@Param("rdList") List<ZslRecallDispose> rdList);
	
	/**
	 * --批量插入召回追溯码中间表记录
	 * @param rtsList
	 */
	void batchInsertRecallSubcode(@Param("rtsList") List<ZslRecallTraceSubcode> rtsList);

	/**
	 * --生产批次号和商品id查询记录
	 * @param productionBatchNo
	 * @param goodsId
	 * @return
	 */
	@Select("SELECT * FROM zsl_production_batch WHERE batch_no=#{batchNo} AND goods_id=#{goodsId}")
	ZslProductionBatch recordByBatchNoAndGoodsId(String batchNo, Integer goodsId);

}
