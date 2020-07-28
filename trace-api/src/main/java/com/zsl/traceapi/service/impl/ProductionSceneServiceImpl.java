package com.zsl.traceapi.service.impl;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsl.traceapi.dao.ZslProductionSceneDao;
import com.zsl.traceapi.dto.SceneParam;
import com.zsl.traceapi.dto.SceneQueryParam;
import com.zsl.traceapi.service.ProductionSceneService;
import com.zsl.traceapi.vo.ScenePagingVo;
import com.zsl.traceapi.vo.traceBatchVo;
import com.zsl.traceapi.vo.traceSceneVo;
import com.zsl.traceapi.vo.SceneDetailVo;
import com.zsl.traceapi.vo.SceneForEditBatchVo;
import com.zsl.traceapi.vo.SceneForNewBatchVo;
import com.zsl.tracecommon.CommonResult;
import com.zsl.tracedb.mapper.GoodsMapper;
import com.zsl.tracedb.mapper.ZslProductionSceneMapper;
import com.zsl.tracedb.mapper.ZslSceneImageMapper;
import com.zsl.tracedb.model.Goods;
import com.zsl.tracedb.model.ZslProductionScene;
import com.zsl.tracedb.model.ZslSceneImage;
import com.zsl.tracedb.model.ZslSceneImageExample;

import cn.hutool.core.bean.BeanUtil;

/**
 * @author CH W
 * @description	追溯生产场景业务实现类
 * @date 2020年6月2日 下午5:08:15
 * @version 1.0
 */
@Service
public class ProductionSceneServiceImpl implements ProductionSceneService {
	@Autowired
	private ZslProductionSceneMapper sceneMapper;
	@Autowired
	private ZslProductionSceneDao sceneDao;
	@Autowired
	private ZslSceneImageMapper sceneImageMapper;
	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public CommonResult<PageInfo<ScenePagingVo>> pagingList(SceneQueryParam queryParam) {
		PageHelper.startPage(queryParam.getPageNum(), queryParam.getPageSize());
		try {
			List<ScenePagingVo> psvList = sceneDao.listByCondition(queryParam);
			return CommonResult.success(new PageInfo<ScenePagingVo>(psvList), "列表分页成功");
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.failed();
		}
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public CommonResult<String> newScene(SceneParam params) {
		try {
			SceneQueryParam qslp = new SceneQueryParam(params.getGoodsId(), params.getName());
			List<ScenePagingVo> zpsList = sceneDao.listByCondition(qslp);
			if(zpsList!=null && zpsList.size()>0) {
				return CommonResult.failed("当前商品下已存在该场景名称，请重新填写");
			}
			ZslProductionScene zps = BeanUtil.toBean(params, ZslProductionScene.class);
			zps.setCurrentStatus(1);
			sceneMapper.insertSelective(zps);
			// 	保存场景图片
			String[] imageUrls = params.getImageUrls();
			if(imageUrls!=null && imageUrls.length>0) {
				for (int i=0; i<imageUrls.length; i++) {
					ZslSceneImage sceneImage = new ZslSceneImage();
					sceneImage.setSceneId(zps.getSceneId());
					sceneImage.setImageUrl(imageUrls[i]);
					sceneImage.setShowSort(i+1);
					sceneImageMapper.insertSelective(sceneImage);
				}
			}
			return CommonResult.success("新建生产场景成功");
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.failed();
		}
	}
	
	@Override
	public CommonResult<SceneDetailVo> detailById(Integer sceneId) {
		if(sceneId==null || sceneId<1) {
			return CommonResult.failed("参数sceneId的值违规");
		}
		SceneDetailVo zps = sceneDao.detailById(sceneId);
		if(zps!=null) {
			return CommonResult.success(zps);
		}
		return CommonResult.failed("该生产场景不存在");
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public CommonResult<String> modify(SceneParam params) {
		Integer sceneId = params.getSceneId();
		ZslProductionScene oldZps = sceneMapper.selectByPrimaryKey(sceneId);
		if(oldZps==null) {
			return CommonResult.failed("修改的生产场景不存在");
		}
		oldZps.setDescription(params.getDescription());
		oldZps.setSceneSort(params.getSceneSort());
		oldZps.setVideoUrl(params.getVideoUrl());
		oldZps.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		try {
			//	按id更新场景信息
			sceneMapper.updateByPrimaryKeySelective(oldZps);
			//	增删修改后的场景图片
			Integer[] delImageIds = params.getDelImageIds();
			String[] imageUrls = params.getImageUrls();
			if(delImageIds!=null && delImageIds.length>0) {
				//	校验待删除的场景图片
				ZslSceneImageExample zsiExample = new ZslSceneImageExample();
				ZslSceneImageExample.Criteria zsiCriteria = zsiExample.createCriteria();
				zsiCriteria.andSceneIdEqualTo(sceneId);
				zsiCriteria.andSceneImageIdIn(Arrays.asList(delImageIds));
				List<ZslSceneImage> zsiList = sceneImageMapper.selectByExample(zsiExample);
				if(zsiList==null || zsiList.size()<1 || zsiList.size()!=delImageIds.length) {
					new Exception("违规操作，删除的图片归属非该生产场景");
				}
				//	删除场景图片
				zsiExample.clear();
				zsiCriteria = zsiExample.createCriteria();
				zsiCriteria.andSceneImageIdIn(Arrays.asList(delImageIds));
				sceneImageMapper.deleteByExample(zsiExample);
			}
			//	保存新添加的场景图片
			if(imageUrls!=null && imageUrls.length>0) {
				//	按图片权重升序查询该场景下的图片列表
				ZslSceneImageExample zsiExample = new ZslSceneImageExample();
				ZslSceneImageExample.Criteria zsiCriteria = zsiExample.createCriteria();
				zsiCriteria.andSceneIdEqualTo(sceneId);
				zsiExample.setOrderByClause("show_sort asc");
				List<ZslSceneImage> zsiList = sceneImageMapper.selectByExample(zsiExample);
				//	获取当前场景的图片列表中权重最小值
				Integer showSort = 1;
				if(zsiList!=null && zsiList.size()>0) {
					int lastIndex = zsiList.size() - 1;
					showSort = zsiList.get(lastIndex).getShowSort();
				}
				//	保存场景图片
				for (int i=0; i<imageUrls.length; i++) {
					ZslSceneImage sceneImage = new ZslSceneImage();
					sceneImage.setSceneId(sceneId);
					sceneImage.setImageUrl(imageUrls[i]);
					sceneImage.setShowSort(++showSort);
					sceneImageMapper.insertSelective(sceneImage);
				}
			}
			return CommonResult.success("修改生产场景成功");
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.failed(e.getMessage());
		}
	}

	@Override
	public CommonResult<List<SceneForNewBatchVo>> sceneListForNewBatch(Integer goodsId) {
		try {
			Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
			if(goods==null) {
				return CommonResult.failed("不存在的商品");
			}
			List<SceneForNewBatchVo> sfnbvList = sceneDao.sceneListForNewBatch(goodsId);
			return CommonResult.success(sfnbvList);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.failed();
		}
	}
	
	@Override
	public List<SceneForEditBatchVo> sceneListForEditBatch(Integer batchId, Integer goodsId) {
		try {
			List<SceneForEditBatchVo> sfebvList = sceneDao.sceneListForEditBatch(batchId);
			List<SceneForEditBatchVo> noBoundSceneList = sceneDao.getSceneListForNoBound(goodsId, batchId);
			if(sfebvList!=null && sfebvList.size()>0) {
				//	查询商品下还未绑定生产批次
				sfebvList.addAll(noBoundSceneList);
				return sfebvList;
			}
			return noBoundSceneList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public CommonResult<traceBatchVo> traceScene(String batchNo) {
		try {
			traceBatchVo traceScene = sceneDao.traceScene(batchNo);
			if(traceScene==null) {
				return CommonResult.failed("数据不存在");
			}
			List<traceSceneVo> tsvList = traceScene.getTsvList();
			int size = 0;
			if(tsvList!=null && tsvList.size()>0) {
				size = tsvList.size();
			}
			traceScene.setEmployeCount(size);
			traceScene.setSceneCount(size);
			return CommonResult.success(traceScene);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.failed();
		}
	}

}
