package com.zsl.traceapi.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zsl.traceapi.dto.SceneParam;
import com.zsl.traceapi.dto.SceneQueryParam;
import com.zsl.traceapi.vo.ScenePagingVo;
import com.zsl.traceapi.vo.traceBatchVo;
import com.zsl.traceapi.vo.SceneDetailVo;
import com.zsl.traceapi.vo.SceneForEditBatchVo;
import com.zsl.traceapi.vo.SceneForNewBatchVo;
import com.zsl.tracecommon.CommonResult;

/**
 * @author CH W
 * @description	追溯生产场景业务接口
 * @date 2020年6月2日 下午5:06:45
 * @version 1.0
 */
public interface ProductionSceneService {
	/**
	 * --分页查询商品的生产场景列表
	 * @param queryParam
	 * @return
	 */
	CommonResult<PageInfo<ScenePagingVo>> pagingList(SceneQueryParam queryParam);
	/**
	 * --新建商品的生产场景
	 * @param params
	 * @return
	 */
	CommonResult<String> newScene(SceneParam params);
	/**
	 * --id查询生产场景详细信息
	 * @param sceneId
	 * @return
	 */
	CommonResult<SceneDetailVo> detailById(Integer sceneId);
	/**
	 * --修改生产场景信息
	 * @param params
	 * @return
	 */
	CommonResult<String> modify(SceneParam params);
	/**
     * --新建生产批次时的加载场景信息列表
     * @param goodsId
     * @return
     */
	CommonResult<List<SceneForNewBatchVo>> sceneListForNewBatch(Integer goodsId);
	/**
	 * --编辑生产批次时关联的场景
	 * @param batchId
	 * @param goodsId
	 * @return
	 */
	List<SceneForEditBatchVo> sceneListForEditBatch(Integer batchId, Integer goodsId);
	/**
	 * --获取当前生产批次未关联的场景
	 * @param batchId
	 * @param goodsId
	 * @param sceneIds
	 * @return
	 */
	List<SceneForNewBatchVo> sceneListForNoBound(Integer batchId, Integer goodsId, List<Integer> sceneIds);
	/**
	 * --根据生产批次追溯场景信息
	 * @param bathcNo
	 * @return
	 */
	CommonResult<traceBatchVo> traceScene(String bathcNo);

}
