package com.zsl.traceapi.service.impl;

import com.zsl.traceapi.dto.SceneForNewBatchParam;
import com.zsl.traceapi.dto.SourceMaterialParam;
import com.zsl.tracedb.mapper.MaterialWarehouseMapper;
import com.zsl.tracedb.mapper.MaterialWarehouseOutMapper;
import com.zsl.tracedb.mapper.ZslBatchMaterialOutMapper;
import com.zsl.tracedb.mapper.ZslProductionSceneMapper;
import com.zsl.tracedb.mapper.ZslSceneImageMapper;
import com.zsl.tracedb.model.MaterialWarehouse;
import com.zsl.tracedb.model.MaterialWarehouseOut;
import com.zsl.tracedb.model.ZslBatchMaterialOut;
import com.zsl.tracedb.model.ZslProductionScene;
import com.zsl.tracedb.model.ZslSceneImage;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * --公共服务业务类
 */
@Service
public class CommonService {
    @Autowired
    private ZslSceneImageMapper sceneImageMapper;
    @Autowired
	private ZslProductionSceneMapper sceneMapper;
    @Autowired
	private MaterialWarehouseOutMapper materialOutMapper;
	@Autowired
	private ZslBatchMaterialOutMapper batchMaterialOutMapper;
	@Autowired
	private MaterialWarehouseMapper materialInMapper;
    
    /**
	 * --检查新旧数据是否改变
	 * @param oldData
	 * @param newData
	 * @return
	 */
	public boolean checkDataChange(String oldData, String newData) {
		if((StringUtils.isNotBlank(oldData) && StringUtils.isNotBlank(newData) && !oldData.equals(newData)) 
				|| (StringUtils.isNotBlank(oldData) && StringUtils.isBlank(newData)) 
				|| (StringUtils.isBlank(oldData) && StringUtils.isNotBlank(newData)) ) {
			return true;
		}
		return false;
	}
	
	/**
	 * --新建/编辑批次时，生产场景相关操作业务
	 * @param sceneParam
	 * @return
	 */
	public Integer sceneOperation(SceneForNewBatchParam sceneParam, Integer goodsId) {
		//	校验生产场景是否存在
		Integer sceneId = sceneParam.getSceneId();
		ZslProductionScene oldScene = sceneMapper.selectByPrimaryKey(sceneId);
		if(oldScene==null) {
			new Exception("sceneId‘"+sceneId+"’不存在");
		}
		if(oldScene.getGoodsId()!=goodsId) {
			new Exception("场景名‘"+oldScene.getName()+"’并非该生产批次的商品归属");
		}
		/**
		 * --校验生产场景说明、视频、图片数据是否有改动
		 * --只要有一项数据改动，将对该场景数据重新增加新的场景记录
		 * --并把原来这条场景记录状态改为‘历史启用’（该状态数据不作为后续使用）
		 */
		boolean isChanged = this.checkDataChange(oldScene.getDescription(), sceneParam.getDescription());
		if(!isChanged) {
			isChanged = this.checkDataChange(oldScene.getVideoUrl(), sceneParam.getVideoUrl());
		}
		Integer[] delImageIds = sceneParam.getDelImageIds();
		String[] imageUrls = sceneParam.getImageUrls();
		if(!isChanged) {
			if((delImageIds!=null && delImageIds.length>0) || (imageUrls!=null && imageUrls.length>0)) {
				isChanged = true;
			}
		}
		//	生产场景更新或新建操作
		if(isChanged) {
			//	插入生产场景主记录
			ZslProductionScene newScene = new ZslProductionScene();
			BeanUtils.copyProperties(oldScene, newScene);
			newScene.setSceneId(null);
			newScene.setDescription(sceneParam.getDescription());
			newScene.setVideoUrl(sceneParam.getVideoUrl());
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			newScene.setUpdateTime(timestamp);
			newScene.setCreateTime(timestamp);
			sceneMapper.insert(newScene);
			//	插入新场景的图片
			String[] newImages = sceneParam.getImageUrls();
			sceneId = newScene.getSceneId();
			if(newImages!=null && newImages.length>0) {
				for (int i=0; i<newImages.length; i++) {
					ZslSceneImage sceneImage = new ZslSceneImage();
					sceneImage.setSceneId(sceneId);
					sceneImage.setImageUrl(newImages[i]);
					sceneImage.setShowSort(i+1);
					sceneImageMapper.insertSelective(sceneImage);
				}
			}
			//	原来的场景记录更新状态为‘历史启用’
			oldScene.setCurrentStatus(2);
			oldScene.setUpdateTime(timestamp);
			sceneMapper.updateByPrimaryKey(oldScene);
		}
		return sceneId;
	}
	
	/**
	 * --原材料出库操作
	 * @param smpList
	 * @param merchantId
	 * @param sceneBatchId
	 */
	public void materialOperation(List<SourceMaterialParam> smpList, Integer merchantId, Integer sceneBatchId) {
		for(SourceMaterialParam smp : smpList) {
			//	保存材料出库记录
			MaterialWarehouseOut materialOut = new MaterialWarehouseOut();
			materialOut.setBatchNumber(smp.getInStorageBatchNo());
			materialOut.setWarehouseId(smp.getMaterialInId());
			materialOut.setWarehouseOutOrder(smp.getOutOrderNo());
			materialOut.setStockNumber(smp.getOutStorageCount());
			materialOut.setUnits(smp.getUnit());
			materialOut.setMerchantId(merchantId);
			materialOutMapper.insert(materialOut);
			//	保存场景的材料出库中间表
			ZslBatchMaterialOut batchMaterialOut = new ZslBatchMaterialOut();
			batchMaterialOut.setMaterialOutId(materialOut.getId());
			batchMaterialOut.setSceneBatchId(sceneBatchId);
			batchMaterialOutMapper.insert(batchMaterialOut);
			//	更新入库原材料的剩余库存
			MaterialWarehouse materialIn = materialInMapper.selectByPrimaryKey(smp.getMaterialInId());
			BigDecimal residueStock = materialIn.getResidueStock().subtract(materialOut.getStockNumber());
			materialIn.setResidueStock(residueStock);
			materialInMapper.updateByPrimaryKeySelective(materialIn);
		}
	}

}
