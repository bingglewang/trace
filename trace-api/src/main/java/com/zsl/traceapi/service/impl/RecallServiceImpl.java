package com.zsl.traceapi.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsl.traceapi.dao.ZslBatchRecallDao;
import com.zsl.traceapi.dao.ZslProductionBatchBindSidDao;
import com.zsl.traceapi.dao.ZslProductionBatchDao;
import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.dto.DisposeRecallParam;
import com.zsl.traceapi.dto.RecallParam;
import com.zsl.traceapi.dto.RecallQueryParam;
import com.zsl.traceapi.dto.TraceSidDisposeParam;
import com.zsl.traceapi.service.RecallService;
import com.zsl.traceapi.vo.DestroyPagingVo;
import com.zsl.traceapi.vo.RecallDetailForEditVo;
import com.zsl.traceapi.vo.DisposeRecallResultVo;
import com.zsl.traceapi.vo.RecallPagingVo;
import com.zsl.tracecommon.CommonResult;
import com.zsl.tracedb.mapper.ZslBatchRecallMapper;
import com.zsl.tracedb.model.ZslBatchRecall;
import com.zsl.tracedb.model.ZslProductionBatch;
import com.zsl.tracedb.model.ZslProductionBatchBindSid;
import com.zsl.tracedb.model.ZslRecallDispose;
import com.zsl.tracedb.model.ZslRecallTraceSubcode;
import com.zsl.tracedb.model.ZslTraceSubcode;

/**
 * @author CH W
 * @description	追溯生产场景业务实现类
 * @date 2020年6月2日 下午5:08:15
 * @version 1.0
 */
@Service
public class RecallServiceImpl implements RecallService {
	@Autowired
	private ZslBatchRecallMapper batchRecallMapper;
	@Autowired
	private ZslBatchRecallDao batchRecallDao;
	@Autowired
	private ZslTraceSubcodeDao traceSubcodeDao;
	@Autowired
	private ZslProductionBatchBindSidDao productionBatchBindSidDao;
	@Autowired
	private ZslProductionBatchDao productionBatchDao;
	
	
	@Override
	public CommonResult<PageInfo<RecallPagingVo>> paging(RecallQueryParam param) {
		try {
			PageHelper.startPage(param.getPageNum(), param.getPageSize());
			List<RecallPagingVo> rpvList = batchRecallDao.listByCustomCondition(param);
			return CommonResult.success(new PageInfo<RecallPagingVo>(rpvList));
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.failed(e.getMessage());
		}
	}

	@Override
	public CommonResult<String> newRecall(RecallParam param) {
		String reg = "^[1][3,4,5,7,8][0-9]{9}$";
		if(!Pattern.matches(reg, param.getPrincipalPhone())){
			return CommonResult.failed("手机号码错误，请认真填写");
		}
		ZslProductionBatch pbCondition = new ZslProductionBatch();
		pbCondition.setBatchNo(param.getProductionBatchNo());
		pbCondition.setGoodsId(param.getGoodsId());
		List<ZslProductionBatch> pbList = productionBatchDao.listByCondition(pbCondition);
		if(pbList==null || pbList.size()<1) {
			return CommonResult.failed("违规操作，商品和生产批次不匹配");
		}
		try {
			ZslProductionBatch pbRecord = pbList.get(0);
			//	计算当前召回批次的数量
			ZslProductionBatchBindSid pbbsCondition = new ZslProductionBatchBindSid();
			pbbsCondition.setProductionBatchId(pbRecord.getBatchId());
			List<ZslProductionBatchBindSid> pbbsList = productionBatchBindSidDao.listByCondition(pbbsCondition);
			Long recallCount = 0L;
			if(pbbsList!=null && pbbsList.size()>0) {
				for(ZslProductionBatchBindSid pbbs : pbbsList) {
					recallCount += (pbbs.getSidEnd() - pbbs.getSidStart())+1;
				}
			}
			//	插入召回记录
			ZslBatchRecall brRecord = new ZslBatchRecall();
			BeanUtils.copyProperties(param, brRecord);
			brRecord.setProductionBatchId(pbRecord.getBatchId());
			brRecord.setRecallCount(recallCount.intValue());
			brRecord.setUndisposedCount(recallCount.intValue());
			brRecord.setDisposeStatus(1);
			batchRecallMapper.insert(brRecord);
			return CommonResult.success("创建完成");
		} catch (BeansException e) {
			e.printStackTrace();
			return CommonResult.failed(e.getMessage());
		}
	}

	@Override
	public CommonResult<String> delete(Integer recallId) {
		try {
			batchRecallMapper.deleteByPrimaryKey(recallId);
			return CommonResult.success("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.failed(e.getMessage());
		}
	}

	@Override
	public CommonResult<RecallDetailForEditVo> detailForEdit(Integer recallId) {
		return CommonResult.success(batchRecallDao.detailForEdit(recallId));
	}

	@Override
	public CommonResult<String> modify(RecallParam param) {
		String reg = "^[1][3,4,5,7,8][0-9]{9}$";
		if(!Pattern.matches(reg, param.getPrincipalPhone())){
			return CommonResult.failed("手机号码错误，请认真填写");
		}
		try {
			ZslBatchRecall br = batchRecallMapper.selectByPrimaryKey(param.getBatchRecallId());
			if(br==null) {
				return CommonResult.failed("违规操作，召回记录不存在");
			}
			br.setPrincipalPhone(param.getPrincipalPhone());
			br.setPrincipal(param.getPrincipal());
			br.setCause(param.getCause());
			batchRecallMapper.updateByPrimaryKey(br);
			return CommonResult.success("修改完成");
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.failed(e.getMessage());
		}
	}

	@Override
	public CommonResult<DisposeRecallResultVo> recallDetailForNewDispose(Integer recallId) {
		DisposeRecallResultVo disposeDetail = batchRecallDao.disposeDetail(recallId);
		disposeDetail.setDdvList(null);
		return CommonResult.success(disposeDetail);
	}
	
	@Override
	public CommonResult<String> disposeRecallInfo(Integer recallId, List<DisposeRecallParam> params) {
		try {
			ZslBatchRecall recall = batchRecallMapper.selectByPrimaryKey(recallId);
			if(recall==null) {
				return CommonResult.failed("违规操作，召回记录不存在");
			}
			if(params!=null && params.size()>0) {
				Integer undisposedCount = recall.getUndisposedCount();	//	召回未处理数量
				Integer disposeCount = 0;	//	当前提交处理的数量（多次处理记录累加）
				List<ZslRecallDispose> rdList = new ArrayList<>();
				for(DisposeRecallParam drp : params) {
					disposeCount += drp.getDisposeCount();
					if(disposeCount > undisposedCount) {
						return CommonResult.failed("违规操作，当前提交处理的数量超过召回未处理数量");
					}
					ZslRecallDispose rdRecord = new ZslRecallDispose();
					BeanUtils.copyProperties(drp, rdRecord);
					rdRecord.setDisposeTimeScope(drp.getStartTime()+"----"+drp.getEndTime());
					Date date = new Date();
					rdRecord.setDisposeBatchNo("CL" + new SimpleDateFormat("yyyyMMddHHmmss").format(date));
					rdRecord.setBatchRecallId(recallId);
					rdRecord.setCreateTime(date);
					rdList.add(rdRecord);
				}
				batchRecallDao.batchInsertDispose(rdList);
				recall.setUndisposedCount(undisposedCount - disposeCount);
				int disposeStatus = recall.getUndisposedCount()==0 ? 2 : 3;
				recall.setDisposeStatus(disposeStatus);
				batchRecallMapper.updateByPrimaryKey(recall);
			}
			return CommonResult.success("提交处理完成");
		} catch (BeansException e) {
			e.printStackTrace();
			return CommonResult.failed(e.getMessage());
		}
	}

	@Override
	public CommonResult<DisposeRecallResultVo> disposeDetail(Integer recallId) {
		return CommonResult.success(batchRecallDao.disposeDetail(recallId));
	}

	@Override
	public CommonResult<PageInfo<DestroyPagingVo>> destroyPaging(RecallQueryParam param) {
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		List<DestroyPagingVo> dpvList = batchRecallDao.destroyPaging(param);
		return CommonResult.success(new PageInfo<DestroyPagingVo>(dpvList));
	}

	@Override
	public CommonResult<Map<String, Object>> traceSidByCsv(TraceSidDisposeParam param) {
		try {
			//	解析csv文件数据
			BufferedReader br = new BufferedReader(new InputStreamReader(param.getTmpFile().getInputStream()));
			List<Long> traceSidList = new ArrayList<>();
			String str = "";
			for(int i=0; (str = br.readLine())!=null; i++) {
				if(i==0) continue;
				traceSidList.add(Long.valueOf(str));
			}
			br.close();
			if(traceSidList.size()==0) {
				return CommonResult.failed("上传文件为空数据");
			}
			//	校验追溯sid数据，并插入关联表记录
			List<ZslRecallTraceSubcode> rtsList = new ArrayList<>();
			List<Long> noExistSidList = new ArrayList<>();
			List<Long> processedList = new ArrayList<>();
			for(Long traceSid : traceSidList) {
				ZslTraceSubcode tsRecord = traceSubcodeDao.recordBySid(traceSid);
				if(tsRecord!=null) {
					ZslRecallTraceSubcode existRts = batchRecallDao.recallTraceBySubcodeId(tsRecord.getId().intValue());
					if(existRts!=null) {
						//	召回已处理过的追溯sid列表
						processedList.add(traceSid);
						continue;
					}
					//	成功处理追溯sid
					ZslRecallTraceSubcode rtsRecord = new ZslRecallTraceSubcode();
					rtsRecord.setRecallId(param.getRecallId());
					rtsRecord.setRecallType(param.getRecallType());
					rtsRecord.setSubcodeId(tsRecord.getId().intValue());
					rtsRecord.setCreateTime(new Date());
					rtsList.add(rtsRecord);
				}else {
					//	不存在系统中的追溯sid列表
					noExistSidList.add(traceSid);
				}
			}
			if(rtsList.size()>0) {
				batchRecallDao.batchInsertRecallSubcode(rtsList);
			}
			//	返回数据
			Map<String, Object> traceSidInfoVo = new HashMap<>();
			traceSidInfoVo.put("noExistSidList", noExistSidList);	//	不存在系统中的追溯sid列表
			traceSidInfoVo.put("processedList", processedList);		//	召回已处理过的追溯sid列表
			traceSidInfoVo.put("successCount", rtsList.size());		//	成功处理的sid数量
			return CommonResult.success(traceSidInfoVo);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.failed(e.getMessage());
		}
	}
	
}
