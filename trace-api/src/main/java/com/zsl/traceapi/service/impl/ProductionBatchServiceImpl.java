package com.zsl.traceapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsl.traceapi.dao.ZslProductionBatchDao;
import com.zsl.traceapi.dto.BatchParam;
import com.zsl.traceapi.dto.BatchQueryParam;
import com.zsl.traceapi.dto.SceneForNewBatchParam;
import com.zsl.traceapi.service.ProductionBatchService;
import com.zsl.traceapi.vo.BatchModifyVo;
import com.zsl.traceapi.vo.BatchPagingVo;
import com.zsl.tracecommon.CommonResult;
import com.zsl.tracedb.mapper.ZslProductionBatchMapper;
import com.zsl.tracedb.mapper.ZslSceneBatchMapper;
import com.zsl.tracedb.model.ZslProductionBatch;
import com.zsl.tracedb.model.ZslSceneBatch;
import com.zsl.tracedb.model.ZslSceneBatchExample;

/**
 * @author CH W
 * @description	追溯生产批次业务实现类
 * @date 2020年6月2日 下午5:08:15
 * @version 1.0
 */
@Service
public class ProductionBatchServiceImpl implements ProductionBatchService {
	@Autowired
	private CommonService commonService;
	@Autowired
	private ZslProductionBatchMapper batchMapper;
	@Autowired
	private ZslProductionBatchDao batchDao;
	@Autowired
	private ZslSceneBatchMapper sceneBatchMapper;
	
	@Override
	public CommonResult<PageInfo<BatchPagingVo>> pagingList(BatchQueryParam queryParam) {
		PageHelper.startPage(queryParam.getPageNum(), queryParam.getPageSize());
		try {
			List<BatchPagingVo> pblvList = batchDao.listByCondition(queryParam);
			if(pblvList!=null && pblvList.size()>0) {
				for(BatchPagingVo bpv : pblvList) {
					//	处理添加追溯码段
					List<Map<String, Object>> codeSidList = batchDao.getTraceCodeSidByBatchId(bpv.getBatchId());
					if(codeSidList!=null && codeSidList.size()>0) {
						StringBuilder sid = new StringBuilder();
						String traceCodeNo = "";
						for(Map<String, Object> codeSid : codeSidList) {
							sid.append(codeSid.get("sid_start")).append("--")
								.append(codeSid.get("sid_end")).append(",");
							traceCodeNo = (String)codeSid.get("trace_code_no");
						}
						sid.deleteCharAt(sid.lastIndexOf(","));
						bpv.setSidScope(sid.toString());
						bpv.setTraceCodeNo(traceCodeNo);
					}
				}
			}
			return CommonResult.success(new PageInfo<BatchPagingVo>(pblvList));
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.failed();
		}    
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public CommonResult<String> newBatch(BatchParam param) {
		//	校验生产批次号
		BatchQueryParam qbp = new BatchQueryParam();
		qbp.setBatchNo(param.getBatchNo());
		List<BatchPagingVo> bpvList = batchDao.listByCondition(qbp);
		if(bpvList!=null && bpvList.size()>0) {
			for(BatchPagingVo bpv : bpvList){
				if(param.getGoodsId()==bpv.getGoodsId()) {
					return CommonResult.failed("当前商品下已存在该生产批次号，请重新填写");
				}
			}
		}
		//	新增生产批次记录
		ZslProductionBatch batch = new ZslProductionBatch();
		BeanUtils.copyProperties(param, batch);
		batchMapper.insert(batch);
		//	生产场景相关
		List<SceneForNewBatchParam> sceneParamList = param.getSceneList();
		if(sceneParamList!=null && sceneParamList.size()>0) {
			List<String> sceneTimes = new ArrayList<>();
			for(int i=0; i<sceneParamList.size(); i++){
				SceneForNewBatchParam sceneParam = sceneParamList.get(i);
				//	当场景的员工未选择或场景生产时间范围未选择时，该场景记录不绑定生产批次保存
				if(StringUtils.isBlank(sceneParam.getStartTime()) 
						|| StringUtils.isBlank(sceneParam.getEndTime()) || sceneParam.getEmployeId()==null) {
					continue;
				}
				//	生产场景业务操作
				Integer sceneId;
				try {
					sceneId = commonService.sceneOperation(sceneParam);
				} catch (Exception e) {
					e.printStackTrace();
					return CommonResult.failed(e.getMessage());
				}
				//	插入批次、场景中间表记录
				ZslSceneBatch sceneBatch = new ZslSceneBatch();
				sceneBatch.setBatchId(batch.getBatchId());
				sceneBatch.setSceneId(sceneId);
				sceneBatch.setEmployeId(sceneParam.getEmployeId());
				sceneBatch.setSceneTimeScope(sceneParam.getStartTime()+"----"+sceneParam.getEndTime());
				sceneBatchMapper.insert(sceneBatch);
				//	原材料出库操作
				if(sceneParam.getMaterialList()!=null && sceneParam.getMaterialList().size()>0) {
					commonService.materialOperation(
						sceneParam.getMaterialList(), param.getMerchantId(), sceneBatch.getSceneBatchId());
				}
				sceneTimes.add(sceneBatch.getSceneTimeScope());
			}
			//	更新批次的生产时间范围(取批次下第一个场景的开始时间和最后一个场景的结束时间合并)
			if(sceneTimes!=null && sceneTimes.size()>0) {
				String startTime = sceneTimes.get(0).split("----")[0];
				String endTime = sceneTimes.get(sceneTimes.size()-1).split("----")[1];
				batch.setProductionTimeScope(startTime+"----"+endTime);
				batchMapper.updateByPrimaryKey(batch);
			}
		}
		return CommonResult.success(null);
	}
	
	@Override
	public BatchModifyVo getBatchInfo(Integer batchId) {
		return batchDao.getBatchInfo(batchId);
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public CommonResult<String> modify(BatchParam param) {
		ZslProductionBatch batch = batchMapper.selectByPrimaryKey(param.getBatchId());
		if(batch==null || !batch.getBatchNo().equals(param.getBatchNo())) {
			return CommonResult.failed("违规操作，修改的生产批次不存在或不匹配");
		}
		//	生产场景相关
		List<SceneForNewBatchParam> sceneParamList = param.getSceneList();
		if(sceneParamList!=null && sceneParamList.size()>0) {
			List<String> sceneTimes = new ArrayList<>();	//	已处理场景记录的时间范围
			for(SceneForNewBatchParam sceneParam : sceneParamList){
				//	生产场景业务操作
				Integer sceneId;
				try {
					sceneId = commonService.sceneOperation(sceneParam);
				} catch (Exception e) {
					e.printStackTrace();
					return CommonResult.failed(e.getMessage());
				}
				/**
				 * --校验该场景是否有绑定在当前批次下
				 * --有绑定则更新场景的生产时间范围以及员工id
				 * --未绑定的情况下，则直接插入批次与场景的中间表记录
				 */
				ZslSceneBatchExample sbExample = new ZslSceneBatchExample();
				ZslSceneBatchExample.Criteria sbCriteria = sbExample.createCriteria();
				sbCriteria.andBatchIdEqualTo(batch.getBatchId());
				sbCriteria.andSceneIdEqualTo(sceneId);
				List<ZslSceneBatch> sbList = sceneBatchMapper.selectByExample(sbExample);
				ZslSceneBatch sceneBatch = null;
				if(sbList!=null && sbList.size()>0) {
					sceneBatch = sbList.get(0);
					int oldEmployeId = sceneBatch.getEmployeId().intValue();
					String startTime = sceneParam.getStartTime();
					String endTime = sceneParam.getEndTime();
					String oldSceneTimeScope = sceneBatch.getSceneTimeScope();
					//	场景员工或场景时间范围改动了才更新记录
					if((sceneParam.getEmployeId()!=null && oldEmployeId!=sceneParam.getEmployeId().intValue()) 
							|| (StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)
							&& !oldSceneTimeScope.equals(startTime+"----"+endTime))) {
						sceneBatch.setEmployeId(sceneParam.getEmployeId());
						sceneBatch.setSceneTimeScope(startTime+"----"+endTime);
						sceneBatchMapper.updateByPrimaryKey(sceneBatch);
					}
				}else {
					//	当场景的员工未选择或场景生产时间范围未选择时，表示该场景记录不绑定生产批次保存
					if(StringUtils.isBlank(sceneParam.getStartTime()) 
							|| StringUtils.isBlank(sceneParam.getEndTime()) || sceneParam.getEmployeId()==null) {
						continue;
					}
					//	插入批次、场景中间表记录
					sceneBatch = new ZslSceneBatch();
					sceneBatch.setBatchId(batch.getBatchId());
					sceneBatch.setSceneId(sceneId);
					sceneBatch.setEmployeId(sceneParam.getEmployeId());
					sceneBatch.setSceneTimeScope(sceneParam.getStartTime()+"----"+sceneParam.getEndTime());
					sceneBatchMapper.insert(sceneBatch);
				}
				//	原材料出库操作
				if(sceneParam.getMaterialList()!=null && sceneParam.getMaterialList().size()>0) {
					commonService.materialOperation(
						sceneParam.getMaterialList(), param.getMerchantId(), sceneBatch.getSceneBatchId());
				}
				sceneTimes.add(sceneBatch.getSceneTimeScope());
			}
			//	更新批次的生产时间范围(取批次下第一个场景的开始时间和最后一个场景的结束时间合并)
			if(sceneTimes!=null && sceneTimes.size()>0) {
				String startTime = sceneTimes.get(0).split("----")[0];
				String endTime = sceneTimes.get(sceneTimes.size()-1).split("----")[1];
				batch.setProductionTimeScope(startTime+"----"+endTime);
				batchMapper.updateByPrimaryKey(batch);
			}
		}
		return CommonResult.success(null);
	}

	@Override
	public CommonResult<List<Map<String, Object>>> goodsListByBatchNo(String batchNo) {
		return CommonResult.success(batchDao.goodsListByBatchNo(batchNo));
	}

}
