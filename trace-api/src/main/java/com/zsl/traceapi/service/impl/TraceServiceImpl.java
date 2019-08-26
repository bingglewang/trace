package com.zsl.traceapi.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.zsl.traceapi.config.kafka.producer.TraceCodeProducerKafka;
import com.zsl.traceapi.config.kafka.producer.TraceUpdateProducerKafka;
import com.zsl.traceapi.context.RequestContext;
import com.zsl.traceapi.context.RequestContextMgr;
import com.zsl.traceapi.dao.ZslTraceDao;
import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.dto.*;
import com.zsl.traceapi.service.RedisService;
import com.zsl.traceapi.service.TraceService;
import com.zsl.traceapi.util.*;
import com.zsl.traceapi.vo.*;
import com.zsl.tracecommon.CommonPage;
import com.zsl.tracecommon.CommonResult;
import com.zsl.tracedb.mapper.*;
import com.zsl.tracedb.model.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

@Service
public class TraceServiceImpl implements TraceService {
    @Autowired
    private RedisService redisService;

    @Autowired
    private ZslTraceMapper zslTraceMapper;

    @Autowired
    private ZslTraceDao zslTraceDao;

    @Autowired
    private ZslTracePointMapper zslTracePointMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private MerchantStallMapper merchantStallMapper;

    @Autowired
    private IntegralDeductRatioMapper integralDeductRatioMapper;

    @Autowired
    private IntegralLogMapper integralLogMapper;

    @Autowired
    private ZslTraceRecordMapper zslTraceRecordMapper;

    @Autowired
    private TraceCodeProducerKafka traceCodeProducerKafka;

    @Autowired
    private TraceUpdateProducerKafka traceUpdateProducerKafka;

    @Autowired
    private ZslTraceSubcodeDao zslTraceSubcodeDao;

    @Autowired
    private ZslTraceSubcodeMapper zslTraceSubcodeMapper;

    @Autowired
    private ZslScanRecordMapper zslScanRecordMapper;

    private Integer count;

    private List<ZslTraceSubcode> totalSubCode;

    private List<ZslTraceSubcode> pageList;

    private Integer searchCount;

    @Override
    public ZslTraceVo getZslTraceById(Integer id) {
        return zslTraceDao.getZslTraceDetailById(id);
    }

    @Override
    public List<ZslTraceVo> getZslTraceByPage(QueryParam queryParam, PageParams pageParams, HttpServletRequest request) {
        //设置排序，大小，页数
        if (pageParams.getPageSize() != null) {
            PageHelper.startPage(pageParams.getPageNum(), pageParams.getPageSize(), pageParams.getOrderBy());
        }

        //获取用户登录信息
        RequestContext requestContext = RequestContextMgr.getLocalContext();
        JSONObject loginUser = requestContext.getJsonObject();
        Integer accountType = Integer.parseInt(loginUser.get("accountType").toString());
        if (accountType == 1) {
            //加盟商
            Integer allianceBusinessId = Integer.parseInt((loginUser.getJSONObject("allianceBusiness").get("allianceBusinessId")).toString());
            queryParam.setAllianceId(allianceBusinessId);
        } else if (accountType == 2) {
            //商家
            Integer merchantId = Integer.parseInt((loginUser.getJSONObject("merchant").get("merchantId")).toString());
            queryParam.setMerchantId(merchantId);
        } else if (accountType == 0) {
            if ((RoleEnum.ROLE_HEADQUARTERS_OPERATE.getValue()).equals((loginUser.getJSONObject("role").get("roleName")).toString())) {
                queryParam.setIsZongBu("Y");
            }
        }

        //时间戳处理
        if(queryParam.getTraceApplyStartDate() != null && StringUtils.isNotBlank(queryParam.getTraceApplyStartDate().toString())){
            queryParam.setTraceApplyStartDate1(new Date(queryParam.getTraceApplyStartDate()));
        }
        if(queryParam.getTraceApplyEndDate() != null && StringUtils.isNotBlank(queryParam.getTraceApplyEndDate().toString())) {
            queryParam.setTraceApplyEndDate1(new Date(queryParam.getTraceApplyEndDate()));
        }
        //获取数据
        List<ZslTraceVo> result = zslTraceDao.getListByPage(queryParam);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ZslTrace insert(ZslTrace zslTrace) {
        int i = zslTraceMapper.insertSelective(zslTrace);
        if (i > 0) {
            return zslTrace;
        } else {
            return null;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(ZslTrace zslTrace) {
        ZslTrace zslTraceDetail = zslTraceMapper.selectByPrimaryKey(zslTrace.getTraceId());
        if(zslTraceDetail == null){
            return -2; // 追溯码不存在
        }
        if(zslTraceDetail.getTraceHandleStatus() - 2 != 0){
            return -3; // 追溯信息已被处理，无法修改
        }
        return zslTraceMapper.updateByPrimaryKeySelective(zslTrace);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int pass(Integer id) {
        ZslTrace zslTraceInfo = zslTraceMapper.selectByPrimaryKey(id);
        if (zslTraceInfo != null) {
            if (zslTraceInfo.getTraceHandleStatus() == 2) {
                //将申请处理状态改为 已通过 1
                ZslTrace passParam = new ZslTrace();
                passParam.setTraceId(id);
                passParam.setTraceHandleStatus(1);
                passParam.setTraceReviewDate(new Date());
                //生成追溯码批次号
                //批次号：zs+时间戳+商家id+4位随机数
                passParam.setTraceCodeNumber("zs" + System.currentTimeMillis() * 1000 + zslTraceInfo.getTraceBusinessId() + RandomUtil.getRandNumberCode(4));
                //积分判断
                IntegralDeductRatio integralDeductRatio = integralDeductRatioMapper.selectByPrimaryKey(IntegralEnum.INTEGRAL_DECUCT_RATIO_TYPE_3.getId());
                Merchant merchant = merchantMapper.selectByPrimaryKey(zslTraceInfo.getTraceBusinessId());
                if (merchant.getCertificationToPay() != 1) {
                    return -7;//商家未认证
                }
               /* //判断纸质标签是否超过上限
                Long totalApplyCount = zslTraceDao.busiTotalTraceCount(merchant.getMerchantId());*/
                //商家剩余免费纸质标签数量
                Long bussiPaperCount = merchant.getPaperLabelUpper();
                //需要扣除的纸质数量
                Long requirePaperCount = 0L;
                if(bussiPaperCount - 0 != 0 && zslTraceInfo.getTraceApplyType() == 1){
                    Merchant updatePaperCount = new Merchant();
                    updatePaperCount.setMerchantId(merchant.getMerchantId());
                    if(bussiPaperCount - zslTraceInfo.getTraceApplyCount() < 0 ){
                        // 将商家纸质标签数量设置为0
                        updatePaperCount.setPaperLabelUpper(0L);
                        requirePaperCount = zslTraceInfo.getTraceApplyCount() - bussiPaperCount;
                    }else{
                        updatePaperCount.setPaperLabelUpper(bussiPaperCount - zslTraceInfo.getTraceApplyCount());
                    }
                    //修改商家纸质标签上限
                    merchantMapper.updateByPrimaryKeySelective(updatePaperCount);
                }else{
                    requirePaperCount = zslTraceInfo.getTraceApplyCount();
                }

                if (zslTraceInfo.getTraceApplyType() == 1 && (requirePaperCount > 0) && merchant.getMerchantCoin() - ((requirePaperCount) * integralDeductRatio.getIntegralRatio()) < 0) {
                    return -4; // 积分不够，请进行充值
                }

                if (zslTraceInfo.getTraceApplyType() == 1 && (requirePaperCount > 0) &&  merchant.getMerchantCoin() - ((requirePaperCount) * integralDeductRatio.getIntegralRatio()) > 0) {
                    Merchant merchantUdate = new Merchant();
                    merchantUdate.setMerchantId(zslTraceInfo.getTraceBusinessId());
                    Long kouchu = (requirePaperCount) * integralDeductRatio.getIntegralRatio();
                    merchantUdate.setMerchantCoin(Integer.parseInt((merchant.getMerchantCoin() - (kouchu)) + ""));
                    int update = merchantMapper.updateByPrimaryKeySelective(merchantUdate);
                    if (update < 0) {
                        return -6; //积分扣除失败
                    }
                    IntegralLog integralLog = new IntegralLog();
                    integralLog.setDeductIntegral(Integer.parseInt(((requirePaperCount) * integralDeductRatio.getIntegralRatio()) + ""));//当前扣除的积分
                    integralLog.setFunctionId(zslTraceInfo.getTraceId());//操作业务主键id
                    integralLog.setFunctionType(ServiceEnum.APPLY_PAPER.getId());
                    integralLog.setMerchantId(zslTraceInfo.getTraceBusinessId());//商家id
                    integralLog.setDeductStatus(2);//已经扣减
                    integralLog.setDeductTime(new Date()); //扣减时间
                    int integLogInsert = integralLogMapper.insert(integralLog);
                    if (integLogInsert < 0) {
                        return -5;  //积分处理失败
                    }
                }
                //将追溯批次号放入队列
                try {
                    traceCodeProducerKafka.sendMessage(passParam.getTraceCodeNumber());
                }catch (Exception e){
                    return -8;  //追溯码生成错误
                }
                int i = zslTraceMapper.updateByPrimaryKeySelective(passParam);
                if (i > 0) {
                    return i;
                } else {
                    return -3;//审核失败，服务器错误
                }

            } else {
                return -1;//已经审核，不用重复审核
            }
        } else {
            return -2;//审核信息不存在
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int cancel(Integer id) {
        ZslTrace zslTraceInfo = zslTraceMapper.selectByPrimaryKey(id);
        if (zslTraceInfo != null) {
            if (zslTraceInfo.getTraceHandleStatus() == 2) {
                //将申请处理状态改为 已撤回3
                ZslTrace passParam = new ZslTrace();
                passParam.setTraceId(id);
                passParam.setTraceHandleStatus(3);
                int i = zslTraceMapper.updateByPrimaryKeySelective(passParam);
                if (i > 0) {
                    return i;
                } else {
                    return -3;//撤回失败，服务器错误
                }

            } else {
                return -1;//已经撤回，不用重复撤回
            }
        } else {
            return -2;//申请信息不存在
        }
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int refuse(Integer id, String remark) {
        ZslTrace zslTraceInfo = zslTraceMapper.selectByPrimaryKey(id);
        if (zslTraceInfo != null) {
            if (zslTraceInfo.getTraceHandleStatus() == 2) {
                //将申请处理状态改为 已拒绝 4
                ZslTrace passParam = new ZslTrace();
                passParam.setTraceId(id);
                passParam.setTraceHandleStatus(4);
                passParam.setTraceRefuseRemark(remark);
                passParam.setTraceReviewDate(new Date());
                int i = zslTraceMapper.updateByPrimaryKeySelective(passParam);
                if (i > 0) {
                    return i;
                } else {
                    return -3;//审核失败，服务器错误
                }

            } else {
                return -1;//已经审核，不用重复审核
            }
        } else {
            return -2;//审核信息不存在
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int
    traceRecordInsert(List<TraceRecordInsertParam> traceRecordInsertParamList) {
        Integer traceId = 0;
        Long haveRelationCount = 0L;
        Integer decutPoint = 0;
        ZslTrace upZslTrace = null;
        for (TraceRecordInsertParam item : traceRecordInsertParamList) {
            ZslTraceExample zslTraceExample = new ZslTraceExample();
            ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
            criteria.andTraceCodeNumberEqualTo(item.getTraceCodeNumber());
            List<ZslTrace> zslTrace = zslTraceMapper.selectByExample(zslTraceExample);
            if (CollectionUtils.isEmpty(zslTrace)) {
                return -2; //追溯码不存在
            } else {
                upZslTrace = zslTrace.get(0);
                traceId = zslTrace.get(0).getTraceId();
            }
            //查询商家名字（根据商品id）
            Goods goods = goodsMapper.selectByPrimaryKey(item.getTraceGoodId());
            if (goods != null) {
                int merchantId = goods.getMerchantId();
                Merchant merchant = merchantMapper.selectByPrimaryKey(merchantId);
                ZslTracePoint zslTracePoint = new ZslTracePoint();
                zslTracePoint.setTraceParentId(null); //父节点id
                zslTracePoint.setTracePointName(merchant.getMerchantName()); //商家名称
                zslTracePoint.setTracePointToNumber(item.getTraceToNumber()); //起始编码
                zslTracePoint.setTracePointFromNumber(item.getTraceFromNumber());  //结束编码
                zslTracePoint.setTraceCodeNumber(item.getTraceCodeNumber());//追溯批次码
                if (item.getTraceToNumber() - item.getTraceFromNumber() >= 0)
                    haveRelationCount += item.getTraceToNumber() - item.getTraceFromNumber() + 1;
                zslTracePoint.setTraceGoodsId(item.getTraceGoodId()); // 所属商品id
                if (item.getTraceStallId() == null || item.getTraceStallId() == -1) {  //非农贸,则根据追溯码获取商品id
                    zslTracePoint.setTraceStallId(-1);
                }else{
                    zslTracePoint.setTraceStallId(item.getTraceStallId());
                }
                //队列用到的对象
                TraceCodeRelation traceCodeRelation = new TraceCodeRelation();
                traceCodeRelation.setFromNumber(new Long(item.getTraceFromNumber()));
                traceCodeRelation.setToNumber(new Long(item.getTraceToNumber()));
                traceCodeRelation.setGoodsId(zslTracePoint.getTraceGoodsId());
                traceCodeRelation.setStallId(zslTracePoint.getTraceStallId());
                traceCodeRelation.setTraceCodeNumber(zslTracePoint.getTraceCodeNumber());

                zslTracePointMapper.insert(zslTracePoint);
                //将关联信息放入队列
                try {
                    String sendJsonStr = JSONObject.toJSONString(traceCodeRelation);
                    traceUpdateProducerKafka.sendMessage(sendJsonStr);
                }catch (Exception e){
                }
            } else {
                return -1;//商品不存在
            }

            // 拆入追溯记录
            ZslTraceRecord insertRecord = new ZslTraceRecord();
            insertRecord.setTraceToNumber(item.getTraceToNumber());
            insertRecord.setTraceFromNumber(item.getTraceFromNumber());
            insertRecord.setTraceCodeNumber(item.getTraceCodeNumber());
            insertRecord.setTraceGoodId(item.getTraceGoodId());
            insertRecord.setTraceStallId(item.getTraceStallId());
            zslTraceRecordMapper.insert(insertRecord);

            //扣除积分
            IntegralDeductRatio integralDeductRatio = integralDeductRatioMapper.selectByPrimaryKey(IntegralEnum.INTEGRAL_DECUCT_RATIO_TYPE_2.getId());
            IntegralLog integralLog = new IntegralLog();
            if (item.getTraceToNumber() - item.getTraceFromNumber() >= 0) {
                integralLog.setDeductIntegral(Integer.parseInt((integralDeductRatio.getIntegralRatio() * (item.getTraceToNumber() - item.getTraceFromNumber() + 1)) + ""));//当前扣除的积分
                decutPoint += Integer.parseInt((integralDeductRatio.getIntegralRatio() * (item.getTraceToNumber() - item.getTraceFromNumber() + 1)) + "");
            }
            integralLog.setFunctionId(insertRecord.getTraceRecordId());//操作业务主键id(追溯记录id)
            integralLog.setFunctionType(ServiceEnum.TRACE_RECORD.getId());
            integralLog.setMerchantId(zslTrace.get(0).getTraceBusinessId());//商家id
            integralLog.setDeductStatus(1);//未扣减
            int integLogInsert = integralLogMapper.insert(integralLog);
            if (!(integLogInsert > 0)) {
                return -4;  //积分处理失败
            }
        }
        ZslTrace updateTrace = new ZslTrace();
        updateTrace.setTraceId(traceId);
        updateTrace.setTraceBack1(upZslTrace.getTraceBack1()+Integer.parseInt(haveRelationCount + "")); //已经关联数量
        updateTrace.setTraceEnableCount(upZslTrace.getTraceEnableCount() - Integer.parseInt(haveRelationCount + ""));//剩余数量
        int i = zslTraceMapper.updateByPrimaryKeySelective(updateTrace);
        //插入追溯记录
       //
        if (i > 0) {
            return decutPoint;
        } else {
            return -3; //追溯记录处理失败
        }
    }

    @Override
    public String isCodeRepeat(List<TraceRecordInsertParam> traceRecordInsertParamList) {
        String result = "编码没有冲突";
        Set codeSet = new HashSet();

        ZslTraceExample zslTraceExample = new ZslTraceExample();
        ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
        if (traceRecordInsertParamList.size() <= 0) {
            return "添加记录不能为空";
        }
        criteria.andTraceCodeNumberEqualTo(traceRecordInsertParamList.get(0).getTraceCodeNumber());
        List<ZslTrace> zslTrace = zslTraceMapper.selectByExample(zslTraceExample);
        if (CollectionUtils.isEmpty(zslTrace)) {
            return "追溯批次码错误";
        }

        //查询已经关联的编码放入set中
        ZslTraceRecordExample zslTraceRecordExample = new ZslTraceRecordExample();
        ZslTraceRecordExample.Criteria criteria1 = zslTraceRecordExample.createCriteria();
        criteria1.andTraceCodeNumberEqualTo(traceRecordInsertParamList.get(0).getTraceCodeNumber());
        List<ZslTraceRecord> zslTraceRecordList = zslTraceRecordMapper.selectByExample(zslTraceRecordExample);
        if (!CollectionUtils.isEmpty(zslTraceRecordList)) {
            for (ZslTraceRecord item : zslTraceRecordList) {
                for (int i = item.getTraceFromNumber(); i <= item.getTraceToNumber(); i++) {
                    if (!codeSet.add(i)) {
                        return "编码已经被使用过";
                    }
                }
            }
        }

        for (TraceRecordInsertParam insertParam : traceRecordInsertParamList) {
            if (insertParam.getTraceToNumber() <= 0 || insertParam.getTraceFromNumber() <= 0 || insertParam.getTraceToNumber() > zslTrace.get(0).getTraceApplyCount() || insertParam.getTraceFromNumber() >= zslTrace.get(0).getTraceApplyCount()) {
                Goods goods = goodsMapper.selectByPrimaryKey(insertParam.getTraceGoodId());
                if (goods != null)
                    return goods.getGoodsName() + "的编码不在申请数量范围内";
            }
            if (insertParam.getTraceToNumber() < insertParam.getTraceFromNumber()) {
                Goods goods = goodsMapper.selectByPrimaryKey(insertParam.getTraceGoodId());
                if (goods != null)
                    return goods.getGoodsName() + "的起始编码必须小于结束编码";
            }
            for (int j = insertParam.getTraceFromNumber(); j <= insertParam.getTraceToNumber(); j++) {
                if (!codeSet.add(j)) {
                    return "编码已经被使用过";
                }
            }
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int traceRecordPointInsert(TraceRecordPointParam traceRecordPointParam) {
        Goods goods = goodsMapper.selectByPrimaryKey(traceRecordPointParam.getTraceGoodsId());
        if (goods == null) {
            return -1; //商品不存在
        }
        ZslTracePoint zslTracePointDetail = zslTracePointMapper.selectByPrimaryKey(traceRecordPointParam.getTraceParentId());
        if (zslTracePointDetail == null) {
            return -2; //父追溯点不存在
        }
        //判断积分够不够扣除
        ZslTraceExample zslTraceExample = new ZslTraceExample();
        ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(traceRecordPointParam.getTraceCodeNumber());
        List<ZslTrace> zslTrace = zslTraceMapper.selectByExample(zslTraceExample);
        if (CollectionUtils.isEmpty(zslTrace)) {
            return -3; //追溯码不存在
        }
        //修改追溯状态为pc端（字段back4）
        ZslTrace traceUpdate = new ZslTrace();
        traceUpdate.setTraceId(zslTrace.get(0).getTraceId());
        traceUpdate.setTraceBack4("N");
        zslTraceMapper.updateByPrimaryKeySelective(traceUpdate);

        Merchant merchant = merchantMapper.selectByPrimaryKey(zslTrace.get(0).getTraceBusinessId());
        if (merchant.getMerchantCoin() - (traceRecordPointParam.getTracePointToNumber() - traceRecordPointParam.getTracePointFromNumber() + 1) < 0) {
            return -4; // 积分不够，请进行充值
        }
        //摊位id，如果有则为摊位id，没有则为-1（代表非农贸）

        MerchantStall merchantStall = merchantStallMapper.selectByPrimaryKey(traceRecordPointParam.getTraceStallId());
        if (merchantStall == null) {
            traceRecordPointParam.setTraceStallId(-1);
        }
        ZslTracePoint zslTracePoint = new ZslTracePoint();
        BeanUtils.copyProperties(traceRecordPointParam, zslTracePoint);
        zslTracePoint.setTracePointTime(new Date());
        int i = zslTracePointMapper.insert(zslTracePoint);
        if (i < 0) {
            return -5;//追溯插入失败
        }

        IntegralDeductRatio integralDeductRatio = integralDeductRatioMapper.selectByPrimaryKey(IntegralEnum.INTEGRAL_DECUCT_RATIO_TYPE_2.getId());

        Merchant merchantUdate = new Merchant();
        merchantUdate.setMerchantId(zslTrace.get(0).getTraceBusinessId());
        //需要扣除的积分
        Integer needCoin = Integer.parseInt((integralDeductRatio.getIntegralRatio() * (traceRecordPointParam.getTracePointToNumber() - traceRecordPointParam.getTracePointFromNumber() + 1)) + "");
        merchantUdate.setMerchantCoin(merchant.getMerchantCoin() - needCoin);
        int update = merchantMapper.updateByPrimaryKeySelective(merchantUdate);
        if (update < 0) {
            return -6; //积分扣除失败
        }
        //扣除积分

        IntegralLog integralLog = new IntegralLog();
        integralLog.setDeductIntegral(Integer.parseInt((integralDeductRatio.getIntegralRatio() * (traceRecordPointParam.getTracePointToNumber() - traceRecordPointParam.getTracePointFromNumber() + 1)) + ""));//当前扣除的积分
        integralLog.setFunctionId(zslTracePoint.getTracePointId());//操作业务主键id
        integralLog.setFunctionType(ServiceEnum.INSERT_TRACE_POINT.getId());
        integralLog.setMerchantId(zslTrace.get(0).getTraceBusinessId());//商家id
        integralLog.setDeductStatus(2);//已经扣减
        integralLog.setDeductTime(new Date()); //扣减时间
        int integLogInsert = integralLogMapper.insert(integralLog);
        if (integLogInsert > 0) {
            return integLogInsert;
        } else {
            return -7;  //积分处理失败
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int exportPointCode(String traceCode, HttpServletResponse response) {
        //判断追溯信息是否存在
        ZslTraceExample zslTraceExample = new ZslTraceExample();
        ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(traceCode);
        List<ZslTrace> zslTrace = zslTraceMapper.selectByExample(zslTraceExample);
        if (CollectionUtils.isEmpty(zslTrace)) {
            return -1; //追溯码不存在
        }
        if("N".equals(zslTrace.get(0).getTraceBack3())){
            return -2;//追溯码还未生成完
        }
        //创建导出数据
        Long count = zslTrace.get(0).getTraceApplyCount();
        Workbook workbook = null;
        int totalPage = (int)Math.ceil((double)count/100000);
        for(int currentPage = 1; currentPage <= totalPage; currentPage++){
            ExportParams params = new ExportParams(null, "sheet"+(currentPage - 1));
            params.setStyle(ExcelStyleUtil.class);
            Long fromIndex = 0L;
            Long toIndex = 0L;
            fromIndex = new Long((currentPage - 1)*100000 + 1);
            if(currentPage - totalPage == 0){
                toIndex = count;
            }else{
                toIndex = new Long(currentPage*100000);
            }
            List<ExcelTraceCode> list =  zslTraceSubcodeDao.exportExcel(fromIndex,toIndex,traceCode);
            workbook = ExcelExportUtil.exportBigExcel(params,ExcelTraceCode.class,list);
            Row row = workbook.getSheetAt(0).getRow(0);
            workbook.getSheetAt(0).setColumnWidth(0, 6000);
        }
        ExcelExportUtil.closeExportBigExcel();

        String fileName = "追溯码.xlsx";
        //告诉浏览器下载excel
        try {
            downloadExcel(fileName, workbook, response);
        }catch (Exception e){
        }
        return 1;
    }

    protected void downloadExcel(String filename, Workbook workbook, HttpServletResponse response) throws Exception {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "utf-8"));
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
    @Override
    public String isPointRepeat(TraceRecordPointParam traceRecordPointParam) {
        String result = "编码没有冲突";
        Set codePointSet = new HashSet();

        //获取他父节点的追溯点信息
        ZslTracePointExample zslTracePointExample = new ZslTracePointExample();
        ZslTracePointExample.Criteria criteria = zslTracePointExample.createCriteria();
        criteria.andTracePointIdEqualTo(traceRecordPointParam.getTraceParentId());
        List<ZslTracePoint> zslTracePoints = zslTracePointMapper.selectByExample(zslTracePointExample);
        if (CollectionUtils.isEmpty(zslTracePoints)) {
            return "父追溯点不存在";
        }

        //查询已经关联的子节点放入set中
        ZslTracePointExample directChildrenExample = new ZslTracePointExample();
        ZslTracePointExample.Criteria criteria1 = directChildrenExample.createCriteria();
        criteria1.andTraceParentIdEqualTo(traceRecordPointParam.getTraceParentId());
        List<ZslTracePoint> directChildrens = zslTracePointMapper.selectByExample(directChildrenExample);
        if (!CollectionUtils.isEmpty(zslTracePoints)) {
            for (ZslTracePoint direct : directChildrens) {
                for (int i = direct.getTracePointFromNumber(); i <= direct.getTracePointToNumber(); i++) {
                    if (!codePointSet.add(i)) {
                        return "编码已经被使用过";
                    }
                }
            }
        }

        if (!(traceRecordPointParam.getTracePointFromNumber() >= zslTracePoints.get(0).getTracePointFromNumber() && traceRecordPointParam.getTracePointFromNumber() <= zslTracePoints.get(0).getTracePointToNumber()) || !(traceRecordPointParam.getTracePointToNumber() >= zslTracePoints.get(0).getTracePointFromNumber() && traceRecordPointParam.getTracePointToNumber() <= zslTracePoints.get(0).getTracePointToNumber())) {
            Goods goods = goodsMapper.selectByPrimaryKey(traceRecordPointParam.getTraceGoodsId());
            if (goods != null)
                return goods.getGoodsName() + "的编码不在夫编码范围内";
        }
        if (traceRecordPointParam.getTracePointFromNumber() > traceRecordPointParam.getTracePointToNumber()) {
            Goods goods = goodsMapper.selectByPrimaryKey(traceRecordPointParam.getTraceGoodsId());
            if (goods != null)
                return goods.getGoodsName() + "的起始编码必须小于结束编码";
        }

        for (int j = traceRecordPointParam.getTracePointFromNumber(); j <= traceRecordPointParam.getTracePointToNumber(); j++) {
            if (!codePointSet.add(j)) {
                return "编码已经被使用过";
            }
        }
        return result;
    }

    @Override
    public Object getTraceTotalCountAndPrice(Integer companyId) {
        //companyId 1:null,查询全部，0:总部,其他具体加盟商id
        Map<String, Object> result = new HashMap<>();
        ZslTraceExample zslTraceExample = new ZslTraceExample();
        ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
        Long totalTraceCount = 0L;
        Long yestTraceCount = 0L;
        if (companyId == null) {
            criteria.andTraceHandleStatusEqualTo(1);//审核通过
            List<ZslTrace> total = zslTraceMapper.selectByExample(zslTraceExample);
            for (ZslTrace zslTraceTotal : total) {
                totalTraceCount += zslTraceTotal.getTraceApplyCount();
            }
            criteria.andTraceReviewDateGreaterThanOrEqualTo(DateUtil.defaultStartDate());
            criteria.andTraceReviewDateLessThanOrEqualTo(DateUtil.defaultEndDate());
            List<ZslTrace> yestCount = zslTraceMapper.selectByExample(zslTraceExample);
            for (ZslTrace zslTraceyYest : yestCount) {
                yestTraceCount += zslTraceyYest.getTraceApplyCount();
            }
        } else if (companyId == 0) {
            criteria.andTraceBack2IsNull();
            criteria.andTraceHandleStatusEqualTo(1);//审核通过
            List<ZslTrace> total = zslTraceMapper.selectByExample(zslTraceExample);
            for (ZslTrace zslTraceTotal : total) {
                totalTraceCount += zslTraceTotal.getTraceApplyCount();
            }
            criteria.andTraceReviewDateGreaterThanOrEqualTo(DateUtil.defaultStartDate());
            criteria.andTraceReviewDateLessThanOrEqualTo(DateUtil.defaultEndDate());
            List<ZslTrace> yestCount = zslTraceMapper.selectByExample(zslTraceExample);
            for (ZslTrace zslTraceyYest : yestCount) {
                yestTraceCount += zslTraceyYest.getTraceApplyCount();
            }
        } else {
            criteria.andTraceBack2EqualTo(companyId);
            criteria.andTraceHandleStatusEqualTo(1);//审核通过
            List<ZslTrace> total = zslTraceMapper.selectByExample(zslTraceExample);
            for (ZslTrace zslTraceTotal : total) {
                totalTraceCount += zslTraceTotal.getTraceApplyCount();
            }
            criteria.andTraceReviewDateGreaterThanOrEqualTo(DateUtil.defaultStartDate());
            criteria.andTraceReviewDateLessThanOrEqualTo(DateUtil.defaultEndDate());
            List<ZslTrace> yestCount = zslTraceMapper.selectByExample(zslTraceExample);
            for (ZslTrace zslTraceyYest : yestCount) {
                yestTraceCount += zslTraceyYest.getTraceApplyCount();
            }
        }
        result.put("totalTraceCount", totalTraceCount);
        result.put("yestTraceCount", yestTraceCount);
        return result;
    }

    @Override
    public Object getChartData(Integer companyId, Integer chartType) {
        Map<String, Object> result = new HashMap<>();
        //chartType 1：周，2：月，3：年
        List<Date> basicList = DateUtil.getBasicList(chartType, null, null);
        List<Integer> chartTitleList = new ArrayList<>();
        List<Long> chartDataList = new ArrayList<>();
        if (companyId == null) {
            if (chartType == 3) {
                for (int i = 1; i <= 12; i++) {
                    chartTitleList.add(i);
                    Long traceCount = 0L;
                    ZslTraceExample zslTraceExample = new ZslTraceExample();
                    ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
                    criteria.andTraceHandleStatusEqualTo(1);//审核通过
                    criteria.andTraceReviewDateGreaterThanOrEqualTo(DateUtil.getFirstDayOfMonth1(i));
                    criteria.andTraceReviewDateLessThanOrEqualTo(DateUtil.getLastDayOfMonth1(i));
                    List<ZslTrace> yestCount = zslTraceMapper.selectByExample(zslTraceExample);
                    for (ZslTrace zslTraceyYest : yestCount) {
                        traceCount += zslTraceyYest.getTraceApplyCount();
                    }
                    chartDataList.add(traceCount);
                }
            } else {
                for (Date itemDate : basicList) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(itemDate);
                    int mDay = cal.get(Calendar.DAY_OF_MONTH);//获取当前月份的日期号码
                    chartTitleList.add(mDay);
                    Long traceCount = 0L;
                    ZslTraceExample zslTraceExample = new ZslTraceExample();
                    ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
                    criteria.andTraceHandleStatusEqualTo(1);//审核通过
                    criteria.andTraceReviewDateGreaterThanOrEqualTo(DateUtil.getStart(itemDate));
                    criteria.andTraceReviewDateLessThanOrEqualTo(DateUtil.getEnd(itemDate));
                    List<ZslTrace> yestCount = zslTraceMapper.selectByExample(zslTraceExample);
                    for (ZslTrace zslTraceyYest : yestCount) {
                        traceCount += zslTraceyYest.getTraceApplyCount();
                    }
                    chartDataList.add(traceCount);
                }
            }
        } else if (companyId == 0) {
            if (chartType == 3) {
                for (int i = 1; i <= 12; i++) {
                    chartTitleList.add(i);
                    Long traceCount = 0L;
                    ZslTraceExample zslTraceExample = new ZslTraceExample();
                    ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
                    criteria.andTraceBack2IsNull();
                    criteria.andTraceHandleStatusEqualTo(1);//审核通过
                    criteria.andTraceReviewDateGreaterThanOrEqualTo(DateUtil.getFirstDayOfMonth1(i));
                    criteria.andTraceReviewDateLessThanOrEqualTo(DateUtil.getLastDayOfMonth1(i));
                    List<ZslTrace> yestCount = zslTraceMapper.selectByExample(zslTraceExample);
                    for (ZslTrace zslTraceyYest : yestCount) {
                        traceCount += zslTraceyYest.getTraceApplyCount();
                    }
                    chartDataList.add(traceCount);
                }
            } else {
                for (Date itemDate : basicList) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(itemDate);
                    int mDay = cal.get(Calendar.DAY_OF_MONTH);//获取当前月份的日期号码
                    chartTitleList.add(mDay);
                    Long traceCount = 0L;
                    ZslTraceExample zslTraceExample = new ZslTraceExample();
                    ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
                    criteria.andTraceBack2IsNull();
                    criteria.andTraceHandleStatusEqualTo(1);//审核通过
                    criteria.andTraceReviewDateGreaterThanOrEqualTo(DateUtil.getStart(itemDate));
                    criteria.andTraceReviewDateLessThanOrEqualTo(DateUtil.getEnd(itemDate));
                    List<ZslTrace> yestCount = zslTraceMapper.selectByExample(zslTraceExample);
                    for (ZslTrace zslTraceyYest : yestCount) {
                        traceCount += zslTraceyYest.getTraceApplyCount();
                    }
                    chartDataList.add(traceCount);
                }
            }
        } else {
            if (chartType == 3) {
                for (int i = 1; i <= 12; i++) {
                    chartTitleList.add(i);
                    Long traceCount = 0L;
                    ZslTraceExample zslTraceExample = new ZslTraceExample();
                    ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
                    criteria.andTraceBack2EqualTo(companyId);
                    criteria.andTraceHandleStatusEqualTo(1);//审核通过
                    criteria.andTraceReviewDateGreaterThanOrEqualTo(DateUtil.getFirstDayOfMonth1(i));
                    criteria.andTraceReviewDateLessThanOrEqualTo(DateUtil.getLastDayOfMonth1(i));
                    List<ZslTrace> yestCount = zslTraceMapper.selectByExample(zslTraceExample);
                    for (ZslTrace zslTraceyYest : yestCount) {
                        traceCount += zslTraceyYest.getTraceApplyCount();
                    }
                    chartDataList.add(traceCount);
                }
            } else {
                for (Date itemDate : basicList) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(itemDate);
                    int mDay = cal.get(Calendar.DAY_OF_MONTH);//获取当前月份的日期号码
                    chartTitleList.add(mDay);
                    Long traceCount = 0L;
                    ZslTraceExample zslTraceExample = new ZslTraceExample();
                    ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
                    criteria.andTraceBack2EqualTo(companyId);
                    criteria.andTraceHandleStatusEqualTo(1);//审核通过
                    criteria.andTraceReviewDateGreaterThanOrEqualTo(DateUtil.getStart(itemDate));
                    criteria.andTraceReviewDateLessThanOrEqualTo(DateUtil.getEnd(itemDate));
                    List<ZslTrace> yestCount = zslTraceMapper.selectByExample(zslTraceExample);
                    for (ZslTrace zslTraceyYest : yestCount) {
                        traceCount += zslTraceyYest.getTraceApplyCount();
                    }
                    chartDataList.add(traceCount);
                }
            }
        }
        result.put("chartTitleList", chartTitleList);
        result.put("chartDataList", chartDataList);
        return result;
    }

    @Override
    public List<MerchantRankVo> getBusiTraceRank(Integer companyId, Integer chartType, PageParams pageParams) {
        String startDate = "";
        String endDate = "";
        //设置排序，大小，页数
        if (pageParams.getPageSize() != null) {
            PageHelper.startPage(pageParams.getPageNum(), pageParams.getPageSize(), pageParams.getOrderBy());
        }

        if (chartType == 1) {//周
            startDate = DateUtils.getWeekStart();
            endDate = DateUtils.getWeekEnd();
        } else if (chartType == 2) { //月
            startDate = DateUtils.getMonthStart();
            endDate = DateUtils.getMonthEnd();
        } else {
            startDate = DateUtils.getYearStart();
            endDate = DateUtils.getYearEnd();
        }
        List<MerchantRankVo> merchantRankVoList = zslTraceDao.getMerchantRankList(companyId, startDate, endDate);
        return merchantRankVoList;
    }

    @Override
    public Object getPieChart(Integer companyId) {
        List<GoodsTracePieVo> result = null;
        result = zslTraceDao.getPieChart(companyId);
        return result;
    }

    @Override
    public Object getNewTraceRecord() {
        //获取用户登录信息
        RequestContext requestContext = RequestContextMgr.getLocalContext();
        JSONObject loginUser = requestContext.getJsonObject();
        Integer accountType = Integer.parseInt(loginUser.get("accountType").toString());
        Integer allianceBusinessId = 0;
        Integer merchantId = 0;
        if (accountType == 1) {
            //加盟商
            allianceBusinessId = Integer.parseInt((loginUser.getJSONObject("allianceBusiness").get("allianceBusinessId")).toString());
        } else if (accountType == 2) {
            //商家
            merchantId = Integer.parseInt((loginUser.getJSONObject("merchant").get("merchantId")).toString());
        } else {
            //总部
            allianceBusinessId = null;
            merchantId = null;
        }
        return zslTraceDao.getNewTraceRecord(allianceBusinessId, merchantId);
    }

    @Override
    public Object getMonthTrace() {
        //获取用户登录信息
        RequestContext requestContext = RequestContextMgr.getLocalContext();
        JSONObject loginUser = requestContext.getJsonObject();
        Integer accountType = Integer.parseInt(loginUser.get("accountType").toString());

        Long monthTraceCoiiunt = 0L;
        ZslTraceExample zslTraceExample = new ZslTraceExample();
        ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
        criteria.andTraceHandleStatusEqualTo(1);//审核通过
        criteria.andTraceReviewDateGreaterThanOrEqualTo(DateUtil.getString2Date(DateUtils.getMonthStart()));
        criteria.andTraceReviewDateLessThanOrEqualTo(DateUtil.getString2Date(DateUtils.getMonthEnd()));
        if (accountType == 1) {
            //加盟商
            Integer allianceBusinessId = Integer.parseInt((loginUser.getJSONObject("allianceBusiness").get("allianceBusinessId")).toString());
            criteria.andTraceBack2EqualTo(allianceBusinessId);
        } else if (accountType == 2) {
            //商家
            Integer merchantId = Integer.parseInt((loginUser.getJSONObject("merchant").get("merchantId")).toString());
            criteria.andTraceBusinessIdEqualTo(merchantId);
        } else {
            //总部
            criteria.andTraceBack2IsNull();
        }

        List<ZslTrace> zslTraceList = zslTraceMapper.selectByExample(zslTraceExample);
        for (ZslTrace zslTrace : zslTraceList) {
            monthTraceCoiiunt += zslTrace.getTraceApplyCount();
        }
        return monthTraceCoiiunt;
    }

    @Override
    public List<TraceRecordVo> getTraceRecodeByCode(String traceCodeNumber, PageParams pageParams) {
        //设置排序，大小，页数
        if (pageParams.getPageSize() != null) {
            PageHelper.startPage(pageParams.getPageNum(), pageParams.getPageSize(), pageParams.getOrderBy());
        }

        ZslTraceRecordExample zslTraceRecordExample = new ZslTraceRecordExample();
        ZslTraceRecordExample.Criteria criteria = zslTraceRecordExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
        List<ZslTraceRecord> result = zslTraceRecordMapper.selectByExample(zslTraceRecordExample);
        List<TraceRecordVo> traceRecordVoList = new ArrayList<>();
        for (ZslTraceRecord zslTraceRecord : result) {
            TraceRecordVo traceRecordVo = new TraceRecordVo();
            BeanUtils.copyProperties(zslTraceRecord, traceRecordVo);
            Goods goods = goodsMapper.selectByPrimaryKey(traceRecordVo.getTraceGoodId());
            if (goods != null) {
                traceRecordVo.setTraceGoodsName(goods.getGoodsName());//商品名称
            } else {
                traceRecordVo.setTraceGoodsName("");//商品名称
            }
            if (traceRecordVo.getTraceStallId() == null || traceRecordVo.getTraceStallId() == -1) {
                traceRecordVo.setTraceStallName("");//摊位名称
            } else {
                //根据摊位查询摊位名称
                MerchantStall merchantStall = merchantStallMapper.selectByPrimaryKey(traceRecordVo.getTraceStallId());
                if (merchantStall != null) {
                    traceRecordVo.setTraceStallName(merchantStall.getStallName());//摊位名称
                } else {
                    traceRecordVo.setTraceStallName("");//摊位名称
                }
            }
            traceRecordVoList.add(traceRecordVo);
        }
        return traceRecordVoList;
    }

    @Override
    public List<GoodsVo> getGoodsByTraceCodeNumber(String traceCodeNumber) {
        Set<Integer> goodsId = new HashSet<>();
        List<GoodsVo> result = new ArrayList<>();
        ZslTracePointExample zslTracePointExample = new ZslTracePointExample();
        ZslTracePointExample.Criteria criteria = zslTracePointExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
        List<ZslTracePoint> zslTracePointList = zslTracePointMapper.selectByExample(zslTracePointExample);
        for(ZslTracePoint zslTracePoint : zslTracePointList){
            if(goodsId.add(zslTracePoint.getTraceGoodsId())){
                Goods goods = goodsMapper.selectByPrimaryKey(zslTracePoint.getTraceGoodsId());
                GoodsVo resultItem = new GoodsVo();
                resultItem.setId(goods.getGoodsId());
                resultItem.setName(goods.getGoodsName());
                result.add(resultItem);
            }
        }
        return result;
    }

    @Override
    public Object generateOutCode(List<MiniCodeInsertParam> miniCodeInsertParams) {
        //生成外码
        List<String> result = new ArrayList<>();
        for(int i = 0;i < miniCodeInsertParams.size();i++){
           List<Long> subcodeIds = zslTraceSubcodeDao.selectByRange(new Long(miniCodeInsertParams.get(i).getTraceFromNumber()),new Long(miniCodeInsertParams.get(i).getTraceToNumber()),miniCodeInsertParams.get(i).getTraceCodeNumber());
           List<TraceOutCodeUpdateParam> traceOutCodeUpdateParams = new ArrayList<>();
           Integer radio = miniCodeInsertParams.get(i).getOutCodeRadio();
           for(int j = 0;j < subcodeIds.size();j++){
               // 批量更新子码的父码
               TraceOutCodeUpdateParam traceOutCodeUpdateParam = new TraceOutCodeUpdateParam();
               traceOutCodeUpdateParam.setId(subcodeIds.get(j));
               traceOutCodeUpdateParams.add(traceOutCodeUpdateParam);
                //生成外码
                if((j+1) % radio == 0 || (j+1) == subcodeIds.size()){
                    //外码
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(RandomUtil.getRandNumberCode(4));
                    stringBuffer.append(System.currentTimeMillis() * 1000);
                    stringBuffer.append(j + 1);
                    result.add(stringBuffer.toString());
                    new OutCodeThread(miniCodeInsertParams.get(i).getTraceCodeNumber(),(j+1),miniCodeInsertParams.get(i).getTraceGoodId(),miniCodeInsertParams.get(i).getTraceStallId(),traceOutCodeUpdateParams).start();
                    //清除list
                    traceOutCodeUpdateParams.clear();
                }
            }
        }
        return result;
    }

    @Override
    public Object generateOutCodeByCount(Integer count) {
        List<String> outCodeList = new ArrayList<>();
        List<TraceOutCodeByCount> insertParam = new ArrayList<>();
        for(int i = 0;i < count;i++) {
            TraceOutCodeByCount traceOutCodeByCount = new TraceOutCodeByCount();
            //外码
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(RandomUtil.getRandNumberCode(4));
            stringBuffer.append(System.currentTimeMillis() * 1000);
            stringBuffer.append(i + 1);
            outCodeList.add(stringBuffer.toString());
            traceOutCodeByCount.setSubCodeNumber(stringBuffer.toString());
            //是否叶子节点
            traceOutCodeByCount.setIsLeaf("N");
            insertParam.add(traceOutCodeByCount);
        }
        int m  = zslTraceSubcodeDao.insertCodeBatch1(insertParam);
        if(m < 0)
            return null;
        return outCodeList;
    }

    @Override
    public CommonResult relationOutCode(String outCode, List<String> subCodeList) {
        ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectBySubCode(outCode);
        ZslTraceSubcode updateLevel = new ZslTraceSubcode();
        Set<String> traceCodeNumberSet = new HashSet<>();
        if(zslTraceSubcode == null){
            return CommonResult.failed("外码不存在");
        }else if("Y".equals(zslTraceSubcode.getIsLeaf())){
            return CommonResult.failed("该码还不是外码");
        }

        if(CollectionUtils.isEmpty(subCodeList)){
            return CommonResult.failed("没有新的子码,请点击关联子码添加新的子码");
        }

        //判断是否发过货
        List<String> codeList = new ArrayList<>();
        codeList.add(zslTraceSubcode.getTraceSubCodeNumber());
        if(isDeliverGoods(codeList)){
            return CommonResult.failed("该码已经发过货,不能再关联"); //该码已经发过货
        }

        Integer nodeLevel = 1;
        List<TraceOutCodeUpdateParam> traceOutCodeUpdateParams = new ArrayList<>();
        List<String> errorCode = new ArrayList<>();
        for(String subCode : subCodeList){
            ZslTraceSubcode zslTraceSubcodeItem = zslTraceSubcodeDao.selectBySubCode(subCode);
            if(zslTraceSubcodeItem == null){
                errorCode.add(subCode);
                continue;
            }
            if(outCode.equals(subCode)){
                return CommonResult.failed("不能关联自己");
            }
            //判断是否循环关联
            if(zslTraceSubcode.getParentId() != null && zslTraceSubcode.getParentId() - zslTraceSubcodeItem.getId() == 0){
                return CommonResult.failed("不能循环关联");
            }
            traceCodeNumberSet.add(zslTraceSubcodeItem.getTraceCodeNumber());
            //关联子码
            if(zslTraceSubcodeItem.getNodeLevel() > nodeLevel){
                nodeLevel = zslTraceSubcodeItem.getNodeLevel();
            }
            TraceOutCodeUpdateParam traceOutCodeUpdateParam = new TraceOutCodeUpdateParam();
            traceOutCodeUpdateParam.setParentId(zslTraceSubcode.getId());
            traceOutCodeUpdateParam.setId(zslTraceSubcodeItem.getId());
            traceOutCodeUpdateParams.add(traceOutCodeUpdateParam);
        }
        if(errorCode.size() > 0){
            return CommonResult.failed(errorCode,"以下内码或外码不存在");
        }
        if(traceCodeNumberSet.size() >= 2){
            return CommonResult.failed("只能关联同一个批次号的编码");
        }

        updateLevel.setId(zslTraceSubcode.getId());
        updateLevel.setNodeLevel(nodeLevel + 1);
        Iterator<String> it = traceCodeNumberSet.iterator();
        if(it.hasNext())
          updateLevel.setTraceCodeNumber(it.next());
        if(!isBussiSelf(updateLevel.getTraceCodeNumber())){
            return CommonResult.failed("只能操作自己追溯码");
        }
        int i = zslTraceSubcodeDao.updateOutCodeBatch(traceOutCodeUpdateParams);
        zslTraceSubcodeMapper.updateByPrimaryKeySelective(updateLevel);
        //修改为小程序端
        updateTraceBack4(updateLevel.getTraceCodeNumber());
        return CommonResult.success("关联成功");
    }

    @Override
    public int changeOutCode(String outCode) {
        ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectBySubCode(outCode);
        if(zslTraceSubcode == null){
            return -3;//编码不存在
        }
        if(!isBussiSelf(zslTraceSubcode.getTraceCodeNumber())){
            return -6; //只能操作自己追溯码
        }
        if("N".equals(zslTraceSubcode.getIsLeaf())){
            return -1;//该码已经为外码
        }
        List<ZslTracePoint> tracePointList = zslTraceSubcodeDao.selectTracePointNodes(zslTraceSubcode.getTraceGoodId(),zslTraceSubcode.getTraceIndex(),zslTraceSubcode.getTraceCodeNumber());
        if(tracePointList.size() - 1 > 0){
            return -5;//该码已经发过货了
        }
        ZslTraceExample zslTraceExample = new ZslTraceExample();
        ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(zslTraceSubcode.getTraceCodeNumber());
        List<ZslTrace> zslTraceList = zslTraceMapper.selectByExample(zslTraceExample);
        if(!CollectionUtils.isEmpty(zslTraceList)){
            if("N".equals(zslTraceList.get(0).getTraceBack4())){
                return -4; //该批次号不能在小程序端操作
            }
        }
        ZslTraceSubcode update = new ZslTraceSubcode();
        update.setId(zslTraceSubcode.getId());
        update.setIsLeaf("N");
        int i = zslTraceSubcodeMapper.updateByPrimaryKeySelective(update);
        if(i < 0){
            return -2;
        }
        updateTraceBack4(zslTraceList.get(0).getTraceCodeNumber());
        return i;
    }

    //判断编码是否存在
    public boolean isCodeExist(OutCodeBatch outCodeBatch){
        for(Long i = outCodeBatch.getOutCodeStart();i <= outCodeBatch.getOutCodeEnd();i++ ){
            ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectById(i);
            if(zslTraceSubcode == null)
                return false;
        }
        for(Long m = outCodeBatch.getInCodeStart();m <= outCodeBatch.getInCodeEnd();m++){
            ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectById(m);
            if(zslTraceSubcode == null)
                return false;
        }
        return true;
    }

    @Override
    public CommonResult changOutCodeBatch(OutCodeBatch outCodeBatch) {
        //判断需要转成外码的内码，本身是否为外码
        Set<Long> isRepeat = new HashSet<>();
        List<Long> conflictSids = new ArrayList<>();
        List<Long> confilctSidPoint = new ArrayList<>();
        String traceCodeNumber = "";
        for(Long i = outCodeBatch.getOutCodeStart();i <= outCodeBatch.getOutCodeEnd();i++ ){
            if(!isRepeat.add(i)){
                return CommonResult.failed("编号不能交叉");
            }
            ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectById(i);
            if(!isBussiSelf(zslTraceSubcode.getTraceCodeNumber())){
                return CommonResult.failed("只能操作自己追溯码");
            }
            List<ZslTracePoint> tracePointList = zslTraceSubcodeDao.selectTracePointNodes(zslTraceSubcode.getTraceGoodId(),zslTraceSubcode.getTraceIndex(),zslTraceSubcode.getTraceCodeNumber());
            if(tracePointList.size() - 1 > 0){
                confilctSidPoint.add(i);
            }
            traceCodeNumber = zslTraceSubcode.getTraceCodeNumber();
            if("N".equals(zslTraceSubcode.getIsLeaf())){
                conflictSids.add(i);
            }
        }
        if(!CollectionUtils.isEmpty(confilctSidPoint)){
            return CommonResult.failed(confilctSidPoint,"这些编号已经发过货了");
        }
        if(CollectionUtils.isEmpty(conflictSids)){
            ZslTraceExample zslTraceExample = new ZslTraceExample();
            ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
            criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
            List<ZslTrace> zslTraceList = zslTraceMapper.selectByExample(zslTraceExample);
            if(!CollectionUtils.isEmpty(zslTraceList)){
                if("N".equals(zslTraceList.get(0).getTraceBack4())){
                    return CommonResult.failed("该批次号不能在小程序端操作");
                }
            }
            //进行内码转外码
            List<TraceOutCodeUpdateParam> traceOutCodeUpdateParams = new ArrayList<>();
            List<TraceOutCodeUpdateParam> traceOutCodeUpdateParamParent = new ArrayList<>();
            Long outCodeNum = outCodeBatch.getOutCodeStart();
            for(Long m = outCodeBatch.getInCodeStart();m <= outCodeBatch.getInCodeEnd();m++){
                if(!isRepeat.add(m)){
                    return CommonResult.failed("编号不能交叉");
                }else{
                    TraceOutCodeUpdateParam traceOutCodeUpdateParam = new TraceOutCodeUpdateParam();
                    traceOutCodeUpdateParam.setId(m);
                    traceOutCodeUpdateParam.setParentId(outCodeNum);
                    traceOutCodeUpdateParams.add(traceOutCodeUpdateParam);
                    TraceOutCodeUpdateParam updateParent = new TraceOutCodeUpdateParam();
                    updateParent.setId(outCodeNum);
                    ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectById(m);
                    updateParent.setNodeLevel(zslTraceSubcode.getNodeLevel() + 1);
                    traceOutCodeUpdateParamParent.add(updateParent);
                    outCodeNum++;
                }
            }
            boolean isCodeExist = isCodeExist(outCodeBatch);
            //判断编码是否存在
            if(!isCodeExist){
                return CommonResult.failed("编号不存在");
            }
            int j = zslTraceSubcodeDao.updateOutCodeById(traceOutCodeUpdateParamParent);
            int i = zslTraceSubcodeDao.updateOutCodeBatch(traceOutCodeUpdateParams);
            //修改为小程序端
            updateTraceBack4(zslTraceList.get(0).getTraceCodeNumber());
            return CommonResult.success("转换成功");
        }else{
            return CommonResult.failed(conflictSids,"这些编号已经为外码了");
        }
    }

    public int directDeliver(ZslTraceSubcode zslTraceSubcode,String bussName){
        //直接发货
        ZslTracePoint zslTracePoint = new ZslTracePoint();
        zslTracePoint.setTraceStallId(-1);
        zslTracePoint.setTraceGoodsId(zslTraceSubcode.getTraceGoodId());
        zslTracePoint.setTraceCodeNumber(zslTraceSubcode.getTraceCodeNumber());
        zslTracePoint.setTracePointName(bussName);
        zslTracePoint.setTracePointToNumber(Integer.parseInt(zslTraceSubcode.getTraceIndex().toString()));
        zslTracePoint.setTracePointFromNumber(Integer.parseInt(zslTraceSubcode.getTraceIndex().toString()));
        //根据追溯码和编号查询父节点 商品id
        ZslTracePoint parent = new ZslTracePoint();
        ZslTracePointExample zslTracePointExample = new ZslTracePointExample();
        ZslTracePointExample.Criteria criteria = zslTracePointExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(zslTraceSubcode.getTraceCodeNumber());
        criteria.andTraceGoodsIdEqualTo(zslTraceSubcode.getTraceGoodId());
        criteria.andTracePointFromNumberEqualTo(Integer.parseInt(zslTraceSubcode.getTraceIndex().toString()));
        criteria.andTracePointToNumberEqualTo(Integer.parseInt(zslTraceSubcode.getTraceIndex().toString()));
        criteria.andTraceParentIdIsNotNull();
        List<ZslTracePoint> zslTracePoints = zslTracePointMapper.selectByExample(zslTracePointExample);
        if(CollectionUtils.isEmpty(zslTracePoints)){
            ZslTracePointExample zslTracePointExample1 = new ZslTracePointExample();
            ZslTracePointExample.Criteria criteria1 = zslTracePointExample1.createCriteria();
            criteria1.andTraceCodeNumberEqualTo(zslTraceSubcode.getTraceCodeNumber());
            criteria1.andTraceGoodsIdEqualTo(zslTraceSubcode.getTraceGoodId());
            criteria1.andTraceParentIdIsNull();
            List<ZslTracePoint> zslTracePoints1 = zslTracePointMapper.selectByExample(zslTracePointExample1);
            if(!(CollectionUtils.isEmpty(zslTracePoints1))){
                parent = zslTracePoints1.get(0);
            }
        }else{
            parent = zslTracePoints.get(0);
        }
        zslTracePoint.setTracePointTime(new Date());
        zslTracePoint.setTraceParentId(parent.getTracePointId());
        int result = zslTracePointMapper.insert(zslTracePoint);
        return result;
    }

    public void getTreeList(List<ZslTraceSubcode> traceSubcodes ,String bussName ) {
        for(ZslTraceSubcode zslTraceSubcode : traceSubcodes){
            if("Y".equals(zslTraceSubcode.getIsLeaf())){
                directDeliver(zslTraceSubcode,bussName);
            }else{
                List<ZslTraceSubcode> children = zslTraceSubcodeDao.selectByParenId(zslTraceSubcode.getId());
                getTreeList(children,bussName);
            }
        }
    }

    public boolean checkCode(List<ZslTraceSubcode> traceSubcodes){
        for(ZslTraceSubcode zslTraceSubcode : traceSubcodes){
            if("Y".equals(zslTraceSubcode.getIsLeaf())){
            }else{
                List<ZslTraceSubcode> children = zslTraceSubcodeDao.selectByParenId(zslTraceSubcode.getId());
                if(CollectionUtils.isEmpty(children)){
                    return false;
                }
            }
        }
        return true;
    }


    //判断是否为商家得批次号
    public boolean isBussiSelf(String traceCodeNumber){
        //获取用户登录信息
        RequestContext requestContext = RequestContextMgr.getLocalContext();
        JSONObject loginUser = requestContext.getJsonObject();
        Integer accountType = Integer.parseInt(loginUser.get("accountType").toString());
        int merchantId = 0;
        if (accountType == 2) {
            //商家
            merchantId = Integer.parseInt((loginUser.getJSONObject("merchant").get("merchantId")).toString());
        }
        ZslTraceExample zslTraceExample = new ZslTraceExample();
        ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
        List<ZslTrace> traces = zslTraceMapper.selectByExample(zslTraceExample);
        if(!CollectionUtils.isEmpty(traces)){
            if(traces.get(0).getTraceBusinessId() - merchantId == 0){
                return true;
            }else{
                return false;
            }
        }
        return true;
    }

    //判断是否发过货
    public boolean isDeliverGoods(List<String> codeList){
        boolean result = false;
        for(int i = 0;i < codeList.size();i++){
            ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectBySubCode(codeList.get(i));
            // 是否为内码
            if("Y".equals(zslTraceSubcode.getIsLeaf())){
                result =  hasTracePoint(zslTraceSubcode);
            }else{
                List<ZslTraceSubcode> digui = new ArrayList<>();
                digui.add(zslTraceSubcode);
                result = getChildTracePoint(digui);
            }
        }
        return result;
    }

    public boolean getChildTracePoint(List<ZslTraceSubcode> zslTraceSubcodeList){
        for(ZslTraceSubcode zslTraceSubcode : zslTraceSubcodeList){
            if("Y".equals(zslTraceSubcode.getIsLeaf())){
                return  hasTracePoint(zslTraceSubcode);
            }else{
                List<ZslTraceSubcode> children = zslTraceSubcodeDao.selectByParenId(zslTraceSubcode.getId());
                return getChildTracePoint(children);
            }
        }
        return false;
    }

    public boolean hasTracePoint(ZslTraceSubcode zslTraceSubcode){
        List<ZslTracePoint> tracePointList = zslTraceSubcodeDao.selectTracePointNodes(zslTraceSubcode.getTraceGoodId(),zslTraceSubcode.getTraceIndex(),zslTraceSubcode.getTraceCodeNumber());
        if(tracePointList.size() - 1 > 0){
            return true;
        }else{
           return false;
        }
    }

    @Override
    public int deliverGoods(DeliverGoods deliverGoods) {
        List<String> codeList = deliverGoods.getCodeNumber();
        int result = -1;

        if(CollectionUtils.isEmpty(deliverGoods.getCodeNumber())){
            return -5; //发货码为空
        }

        for(String subCode : codeList){
            ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectBySubCode(subCode);
            if(!isBussiSelf(zslTraceSubcode.getTraceCodeNumber())){
                return -6; //只能操作自己追溯码
            }
        }


        //判断是否已经发过货
        if(isDeliverGoods(codeList)){
            return -4; //不要重复发货
        }

        for(int i = 0;i < codeList.size();i++){
            ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectBySubCode(codeList.get(i));
            // 是否为内码
            if("Y".equals(zslTraceSubcode.getIsLeaf())){
                result =  directDeliver(zslTraceSubcode,deliverGoods.getBussName());
            }else{
                List<ZslTraceSubcode> digui = new ArrayList<>();
                if(StringUtils.isBlank(zslTraceSubcode.getTraceCodeNumber())){
                    return -2; //外码还没有关联内码
                }
                digui.add(zslTraceSubcode);
                if(!checkCode(digui)){
                    return -3; //请先关联内码
                }
                getTreeList(digui,deliverGoods.getBussName());
                result = 1;
            }
            if( result > 0){
                updateTraceBack4(zslTraceSubcode.getTraceCodeNumber());
            }
        }
        return result;
    }

    //修改追溯状态为小程序端（字段back4） Y
    public void updateTraceBack4(String traceCodeNumber){
        ZslTraceExample zslTraceExample = new ZslTraceExample();
        ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
        List<ZslTrace> zslTraceList = zslTraceMapper.selectByExample(zslTraceExample);
        if(!CollectionUtils.isEmpty(zslTraceList)){
            ZslTrace traceUpdate = new ZslTrace();
            traceUpdate.setTraceId(zslTraceList.get(0).getTraceId());
            traceUpdate.setTraceBack4("Y");
            zslTraceMapper.updateByPrimaryKeySelective(traceUpdate);
        }
    }

    @Override
    public int insertScanRecord(ScanRecordInsertParam scanRecordInsertParam) {
        ZslScanRecord zslScanRecord = new ZslScanRecord();
        zslScanRecord.setScanAddress(scanRecordInsertParam.getScanAddress());
        zslScanRecord.setSid(scanRecordInsertParam.getSid());
        if(scanRecordInsertParam.getScanTime() != null && StringUtils.isNotBlank(scanRecordInsertParam.getScanTime().toString())){
            zslScanRecord.setScanTime(new Date(scanRecordInsertParam.getScanTime()));
        }
        int i = zslScanRecordMapper.insert(zslScanRecord);
        return i;
    }

    @Override
    public List<ScanRecordQueryParam> getScanRecordBySid(Long sid) {
        ZslScanRecordExample zslScanRecordExample = new ZslScanRecordExample();
        ZslScanRecordExample.Criteria criteria = zslScanRecordExample.createCriteria();
        criteria.andSidEqualTo(sid);
        List<ZslScanRecord> scanRecordList = zslScanRecordMapper.selectByExample(zslScanRecordExample);
        List<ScanRecordQueryParam> result = new ArrayList<>();
        for(ZslScanRecord zslScanRecord : scanRecordList){
            ScanRecordQueryParam scanRecordQueryParam = new ScanRecordQueryParam();
            scanRecordQueryParam.setScanAddress(zslScanRecord.getScanAddress());
            scanRecordQueryParam.setScanTime(DateUtil.DateToString(zslScanRecord.getScanTime(),"yyyy-MM-dd HH:mm:ss"));
            result.add(scanRecordQueryParam);
        }
        return result;
    }

    @Override
    public CommonResult getTraceGoodInfo(Long sid,HttpServletRequest request) {
        ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectById(sid);
        if(zslTraceSubcode != null && "Y".equals(zslTraceSubcode.getIsLeaf())){
            Map<String,Object> result = new HashMap<>();
            //没有被扫过的
            Long notScannedCount = zslTraceSubcodeDao.goodsScanCount(zslTraceSubcode.getTraceGoodId());
            // 总共的
            Long TotalCount = zslTraceSubcodeDao.goodsTotalCount(zslTraceSubcode.getTraceGoodId());
            String traceCode = zslTraceSubcode.getTraceSubCodeNumber();
            // 第几次扫码
            Long  scanCount  = zslTraceSubcode.getScanCount() + 1;
            //追溯信息
             List<ScanPointQueryParam> tracePointNodes = new ArrayList<>();
            List<ZslTracePoint> tracePointList = zslTraceSubcodeDao.selectTracePointNodes(zslTraceSubcode.getTraceGoodId(),zslTraceSubcode.getTraceIndex(),zslTraceSubcode.getTraceCodeNumber());
            for(ZslTracePoint zslTracePoint : tracePointList){
                ScanPointQueryParam scanPointQueryParam = new ScanPointQueryParam();
                scanPointQueryParam.setTracePointName(zslTracePoint.getTracePointName());
                scanPointQueryParam.setTracePointTime(DateUtil.DateToString(zslTracePoint.getTracePointTime(),"yyyy-MM-dd HH:mm:ss"));
                tracePointNodes.add(scanPointQueryParam);
            }
            ClientInfo clientInfo =  ClientInfoUtil.get(request.getHeader("user-agent"));
            AddressUtils addressUtils = new AddressUtils();
            String ip = IpUtil.getRequestIp(request);
            String address = "";
            try {
                address = addressUtils.getAddresses("ip=" + ip, "utf-8");
                JSONObject jsonObject = JSONObject.parseObject(address);
                jsonObject = jsonObject.getJSONObject("data");
                result.put("netAndAddressInfo",jsonObject);
            }
            catch (Exception e) {
                address = "{\n" +
                        "            \"area\": \"\",\n" +
                        "            \"country\": \"XX\",\n" +
                        "            \"isp_id\": \"local\",\n" +
                        "            \"city\": \"内网IP\",\n" +
                        "            \"ip\": \"192.168.2.173\",\n" +
                        "            \"isp\": \"无法识别\",\n" +
                        "            \"county\": \"内网IP\",\n" +
                        "            \"region_id\": \"xx\",\n" +
                        "            \"area_id\": \"\",\n" +
                        "            \"county_id\": \"local\",\n" +
                        "            \"region\": \"XX\",\n" +
                        "            \"country_id\": \"xx\",\n" +
                        "            \"city_id\": \"local\"\n" +
                        "        }";
                JSONObject jsonObject = JSONObject.parseObject(address);
                result.put("netAndAddressInfo",jsonObject);
                e.printStackTrace();
            }
            result.put("clientInfo",clientInfo);
            result.put("notScannedCount",notScannedCount);
            result.put("TotalCount",TotalCount);
            result.put("traceCode",traceCode);
            result.put("scanCount",scanCount);
            result.put("tracePointNodes",tracePointNodes);
            //更新扫码次数
            ZslTraceSubcode updateScanCount = new ZslTraceSubcode();
            updateScanCount.setId(zslTraceSubcode.getId());
            updateScanCount.setScanCount(zslTraceSubcode.getScanCount() + 1);
            zslTraceSubcodeMapper.updateByPrimaryKeySelective(updateScanCount);
            return CommonResult.success(result);
        }else{
            return CommonResult.failed("编码错误");
        }
    }

    @Override
    public CommonResult getSubCodeById(Long sid) {
        count = 0;
        ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectById(sid);
        if(zslTraceSubcode == null){
            return CommonResult.failed("编码不存在");
        }

        if(!isBussiSelf(zslTraceSubcode.getTraceCodeNumber())){
            return CommonResult.failed("只能操作自己追溯码");
        }

        if(zslTraceSubcode.getTraceGoodId() == null){
            return CommonResult.failed("该码还没录入");
        }
        ZslTraceExample zslTraceExample = new ZslTraceExample();
        ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(zslTraceSubcode.getTraceCodeNumber());
        List<ZslTrace> traceList = zslTraceMapper.selectByExample(zslTraceExample);
        if(traceList.size() > 0){
            if("N".equals(traceList.get(0).getTraceBack4())){
                return CommonResult.failed("该批次号非小程序端");
            }
        }
        countCode(zslTraceSubcode);
        ZslTraceSubcodeVo result  = new ZslTraceSubcodeVo();
        BeanUtils.copyProperties(zslTraceSubcode,result);
        result.setCount(count);
        List<String> codeList = new ArrayList<>();
        codeList.add(zslTraceSubcode.getTraceSubCodeNumber());
        //判断是否已经发过货
        if(isDeliverGoods(codeList)){
            result.setIsEnable(-1); //该码已经发过货
        }else{
            result.setIsEnable(1); //正常
        }
        return CommonResult.success(result);
    }

    @Override
    public CommonResult getIdByPage(String traceCodeNumber,String traceSubCode) {
        if(StringUtils.isBlank(traceCodeNumber)){
            return CommonResult.failed("追溯码不能为空");
        }

        ZslTraceExample zslTraceExample = new ZslTraceExample();
        ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
        List<ZslTrace> zslTraceList = zslTraceMapper.selectByExample(zslTraceExample);
        if(CollectionUtils.isEmpty(zslTraceList)){
            return CommonResult.failed("追溯码不存在");
        }

        List<ZslTraceSubcode> zslTraceSubcodeList = zslTraceSubcodeDao.searchByIndexOrCode(traceSubCode,traceCodeNumber);
        if(CollectionUtils.isEmpty(zslTraceSubcodeList)){
            return CommonResult.success(null);
        }

        totalSubCode = new ArrayList<>();
        ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeList.get(0);
        searchTreeNode(zslTraceSubcode);

        List<ZslTreeNode> treeNodes = new ArrayList<>();
        for(ZslTraceSubcode item: totalSubCode){
            ZslTreeNode node = new ZslTreeNode();
            BeanUtils.copyProperties(item,node);
            treeNodes.add(node);
        }
        List<ZslTreeNode> list = null;
        try {
            list  =   TreeUtils.buildTree(treeNodes,"com.zsl.traceapi.util.ZslTreeNode","id","parentId","children");
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.failed();
        }
        return CommonResult.success(list);
    }

    @Override
    public CommonResult getTracePointRecordBySid(Long sid) {
        ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectById(sid);
        List<ZslTracePoint> tracePointList = zslTraceSubcodeDao.selectTracePointNodes(zslTraceSubcode.getTraceGoodId(),zslTraceSubcode.getTraceIndex(),zslTraceSubcode.getTraceCodeNumber());
        Map<String,Object> resultMap = new HashMap<>();
        List<ZslTracePointVo> result = new ArrayList<>();
        String goodsName = "";
        for(ZslTracePoint zslTracePoint : tracePointList){
            ZslTracePointVo resultItem  = new ZslTracePointVo();
            BeanUtils.copyProperties(zslTracePoint,resultItem);
            Goods goods = goodsMapper.selectByPrimaryKey(resultItem.getTraceGoodsId());
            if(goods != null)
            resultItem.setGoodsName(goods.getGoodsName());
            goodsName = goods.getGoodsName();
            result.add(resultItem);
        }
        resultMap.put("list",result);
        resultMap.put("code",zslTraceSubcode.getTraceSubCodeNumber());
        resultMap.put("goodsName",goodsName);
        return CommonResult.success(resultMap);
    }

    public void getCodePageRecursion(Integer pageNum,Integer pageSize,Integer toNumber,Integer fromNumber,String traceCodeNumber){
        List<ZslTraceSubcode> itemList = zslTraceSubcodeDao.getSuCodeByPage(pageSize,toNumber,fromNumber,traceCodeNumber);
        if((searchCount - 100 >= 0) && CollectionUtils.isEmpty(itemList))
            return ;

        pageList.addAll(itemList);

        if(pageList.size() - pageSize < 0){
            searchCount++;
            Integer fromNumberItem = toNumber + 1;
            Integer toNumberItem = fromNumberItem + pageSize;
            getCodePageRecursion(pageNum,pageSize,toNumberItem,fromNumberItem,traceCodeNumber);
        }else{
            int redisPageNum = 1;
            if(fromNumber / pageSize == 0){
                redisPageNum = fromNumber / pageSize;
            }else{
                redisPageNum = fromNumber / pageSize + 1;
            }
            if(redisPageNum - pageNum != 0) {
                redisService.set("YM" + traceCodeNumber, redisPageNum + "");
                // 重新刷新token时间
                redisService.expire("YM" + traceCodeNumber, 7200);
            }
            pageList = pageList.subList(0,pageSize);
            return ;
        }
    }

    @Override
    public CommonResult getSuCodeByPage(Integer pageNum, Integer pageSize,String traceCodeNumber) {
        String redisPageNumStr = redisService.get("YM"+traceCodeNumber);
        Integer pageNum1 = 0;
        if(StringUtils.isNotBlank(redisPageNumStr)){
            pageNum1 = Integer.parseInt(redisPageNumStr);
        }else{
            pageNum1 = pageNum;
        }

        Integer fromNumber = (pageNum1 > 1 ? (pageNum1 - 1) * pageSize : 1);
        Integer toNumber = fromNumber + pageSize;
        pageList = new ArrayList<>();
        searchCount = 0;
        getCodePageRecursion(pageNum,pageSize,toNumber,fromNumber,traceCodeNumber);

        List<ZslTreeNode> result = new ArrayList<>();
        for(ZslTraceSubcode item : pageList){
            List<ZslTreeNode> resultItem = transeTreeNode(item);
            if(resultItem != null){
                result.addAll(resultItem);
            }
        }
        CommonPage pageResult = new CommonPage();
        pageResult.setList(result);
        pageResult.setPageNum(pageNum);
        pageResult.setPageSize(pageSize);
        String totalCountStr = redisService.get(traceCodeNumber);
        Long totalCount = 0L;
        if(StringUtils.isBlank(totalCountStr)){
            ZslTraceExample zslTraceExample = new ZslTraceExample();
            ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
            criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
            List<ZslTrace> traces = zslTraceMapper.selectByExample(zslTraceExample);
            if(!CollectionUtils.isEmpty(traces)) {
                totalCount = zslTraceSubcodeDao.getTotalCount(Integer.parseInt(traces.get(0).getTraceApplyCount() + ""), fromNumber, traceCodeNumber);
                redisService.set(traceCodeNumber,totalCount+"");
                // 重新刷新token时间
                redisService.expire(traceCodeNumber,7200);
            }
        }else{
            totalCount = Long.parseLong(totalCountStr);
        }
        pageResult.setTotal(totalCount);
        Long totalPage = (totalCount + pageSize - 1) / pageSize;
        pageResult.setTotalPage(Integer.parseInt(totalPage+""));
        return CommonResult.success(pageResult);
    }

    @Override
    public CommonResult deleteCodeRelation(Long id) {
        ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectById(id);
        if(!isBussiSelf(zslTraceSubcode.getTraceCodeNumber())){
         return CommonResult.failed("只能操作自己追溯码");
        }

        //判断是否发过货
        List<String> codeList = new ArrayList<>();
        codeList.add(zslTraceSubcode.getTraceSubCodeNumber());
        if(isDeliverGoods(codeList)){
            return CommonResult.failed("已经发过货，不能删除"); //该码已经发过货
        }

        int i = zslTraceSubcodeDao.deleteCodeRelation(id);
        if(i > 0){
            return CommonResult.success("修改成功");
        }else{
            return CommonResult.failed("修改失败");
        }
    }

    @Override
    public CommonResult getTreeListCode(RelationOutCode relationOutCode) {
        List<ZslTraceSubcode> pageList = new ArrayList<>();
        //外码树结构
        ZslTraceSubcode outSubCode = zslTraceSubcodeDao.selectBySubCode(relationOutCode.getOutCode());
        if(outSubCode != null){
            List<ZslTraceSubcode> pageListOutCode =  zslTraceSubcodeDao.selectByParenId(outSubCode.getId());
            pageList.addAll(pageListOutCode);
        }

        //子码树结构
        for(String subCode : relationOutCode.getSubCodeList()){
            ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectBySubCode(subCode);
            pageList.add(zslTraceSubcode);
        }
        List<ZslTreeNode> result = new ArrayList<>();
        for(ZslTraceSubcode item : pageList){
            List<ZslTreeNode> resultItem = transeTreeNode(item);
            if(resultItem != null){
                result.addAll(resultItem);
            }
        }
        return CommonResult.success(result);
    }

    List<ZslTreeNode> transeTreeNode(ZslTraceSubcode zslTraceSubcode){
        totalSubCode = new ArrayList<>();
        searchTreeNode(zslTraceSubcode);

        List<ZslTreeNode> treeNodes = new ArrayList<>();
        for(ZslTraceSubcode item: totalSubCode){
            ZslTreeNode node = new ZslTreeNode();
            BeanUtils.copyProperties(item,node);
            node.setName(item.getTraceSubCodeNumber());
            treeNodes.add(node);
        }
        List<ZslTreeNode> list = null;
        try {
            list  =   TreeUtils.buildTree(treeNodes,"com.zsl.traceapi.util.ZslTreeNode","id","parentId","children");
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return list;
    }



    public void searchTreeNode(ZslTraceSubcode zslTraceSubcode){
        totalSubCode.add(zslTraceSubcode);
        List<ZslTraceSubcode> subcodeList = zslTraceSubcodeDao.selectByParenId(zslTraceSubcode.getId());
        for(ZslTraceSubcode forItem : subcodeList){
            searchTreeNode(forItem);
        }
    }

    void countCode(ZslTraceSubcode zslTraceSubcode){
        if("Y".equals(zslTraceSubcode.getIsLeaf())){
           count++;
        }else{
            //取出关联的子码
            List<ZslTraceSubcode> children = zslTraceSubcodeDao.selectByParenId(zslTraceSubcode.getId());
            for(ZslTraceSubcode item : children){
                countCode(item);
            }
        }
    }

    class OutCodeThread extends Thread{
        private String traceCodeNumber;
        private Integer number;
        private Integer goodsId;
        private Integer stallId;
        List<TraceOutCodeUpdateParam> traceOutCodeUpdateParams;
        OutCodeThread(String traceCodeNumber,Integer number,Integer goodsId,Integer stallId,List<TraceOutCodeUpdateParam> traceOutCodeUpdateParams){
            this.traceCodeNumber = traceCodeNumber;
            this.number = number;
            this.goodsId = goodsId;
            this.stallId = stallId;
            this.traceOutCodeUpdateParams = traceOutCodeUpdateParams;
        }
        public void run(){
            ZslTraceSubcode zslTraceSubcode = new ZslTraceSubcode();
            //追溯码
            zslTraceSubcode.setTraceSubCodeNumber(traceCodeNumber);
            //外码
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(RandomUtil.getRandNumberCode(4));
            stringBuffer.append(System.currentTimeMillis() * 1000);
            stringBuffer.append(number);
            zslTraceSubcode.setTraceSubCodeNumber(stringBuffer.toString());
            //是否叶子节点
            zslTraceSubcode.setIsLeaf("N");
            //节点层级
            zslTraceSubcode.setNodeLevel(2);
            zslTraceSubcode.setTraceIndex(new Long(number));
            //商品id和摊位id
            zslTraceSubcode.setTraceGoodId(goodsId);
            zslTraceSubcode.setTraceStallId(stallId);
            int m = zslTraceSubcodeMapper.insert(zslTraceSubcode);
            // 批量更新子码的父码
            for(TraceOutCodeUpdateParam traceOutCodeUpdateParam1 : traceOutCodeUpdateParams){
                traceOutCodeUpdateParam1.setParentId(zslTraceSubcode.getId());
            }
            int n = zslTraceSubcodeDao.updateOutCodeBatch(traceOutCodeUpdateParams);
        }
    }
}
