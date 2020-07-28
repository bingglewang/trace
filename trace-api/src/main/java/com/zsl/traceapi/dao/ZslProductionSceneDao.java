package com.zsl.traceapi.dao;

import java.util.List;

import com.zsl.traceapi.dto.SceneQueryParam;
import com.zsl.traceapi.vo.ScenePagingVo;
import com.zsl.traceapi.vo.traceBatchVo;
import com.zsl.traceapi.vo.SceneDetailVo;
import com.zsl.traceapi.vo.SceneForEditBatchVo;
import com.zsl.traceapi.vo.SceneForNewBatchVo;

/**
 * @author CH W
 * @description	追溯生产场景dao
 * @date 2020年6月5日 下午4:09:06
 * @version 1.0
 */
public interface ZslProductionSceneDao {
    /**
     * --按条件查询生产场景列表
     * @param queryParams
     * @return
     */
    List<ScenePagingVo> listByCondition(SceneQueryParam queryParams);

	/**
	 * --id获取生产场景详细
	 * @param sceneId
	 * @return
	 */
    SceneDetailVo detailById(Integer sceneId);
	
	/**
     * --新建生产批次时的加载场景信息列表
     * @param goodsId
     * @return
     */
    List<SceneForNewBatchVo> sceneListForNewBatch(Integer goodsId);
    
    /**
     * --编辑生产批次时关联的场景
	 * @param bathcId
	 * @return
	 */
	List<SceneForEditBatchVo> sceneListForEditBatch(Integer bathcId);
	
	/**
	 * --获取未绑定当前生产批次的场景列表
	 * @param goodsId
	 * @param batchId
	 * @return
	 */
	List<SceneForEditBatchVo> getSceneListForNoBound(Integer goodsId, Integer batchId);

	/**
	 * --根据生产批次追溯场景信息
	 * @param batchNo
	 * @return
	 */
	traceBatchVo traceScene(String batchNo);

}
