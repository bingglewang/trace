package com.zsl.traceapi.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.zsl.traceapi.config.rabbitmq.producer.TraceCodeProducer;
import com.zsl.traceapi.config.rabbitmq.producer.TraceUpdateProducer;
import com.zsl.traceapi.context.RequestContext;
import com.zsl.traceapi.context.RequestContextMgr;
import com.zsl.traceapi.dao.ZslTraceDao;
import com.zsl.traceapi.dao.ZslTraceRecordDao;
import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.dto.*;
import com.zsl.traceapi.service.TraceService;
import com.zsl.traceapi.util.*;
import com.zsl.traceapi.vo.GoodsTracePieVo;
import com.zsl.traceapi.vo.GoodsVo;
import com.zsl.traceapi.vo.TraceRecordVo;
import com.zsl.traceapi.vo.ZslTraceVo;
import com.zsl.tracedb.mapper.*;
import com.zsl.tracedb.model.*;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
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

import static com.zsl.traceapi.util.IntegralEnum.INTEGRAL_DECUCT_RATIO_TYPE_2;

@Service
public class TraceServiceImpl implements TraceService {
    @Autowired
    private ZslTraceMapper zslTraceMapper;

    @Autowired
    private ZslTraceDao zslTraceDao;

    @Autowired
    private ZslTraceRecordDao zslTraceRecordDao;

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
    private TraceCodeProducer traceCodeProducer;

    @Autowired
    private TraceUpdateProducer traceUpdateProducer;

    @Autowired
    private ZslTraceSubcodeDao zslTraceSubcodeDao;

    @Autowired
    private ZslTraceSubcodeMapper zslTraceSubcodeMapper;

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
                queryParam.setZongBu(true);
            }
        }

        //是否为附码小程序端
        String isMiniProgram = request.getParameter("isMiniProgram");
        if(StringUtils.isBlank(isMiniProgram)){
            //默认为pc端
            isMiniProgram = "N";
        }else{
            isMiniProgram = "Y";
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
                //判断纸质标签是否超过上限
                Long totalApplyCount = zslTraceDao.busiTotalTraceCount(merchant.getMerchantId());

                if (zslTraceInfo.getTraceApplyType() == 1 && (totalApplyCount - merchant.getPaperLabelUpper() > 0) && merchant.getMerchantCoin() - ((zslTraceInfo.getTraceApplyCount() - merchant.getPaperLabelUpper()) * integralDeductRatio.getIntegralRatio()) < 0) {
                    return -4; // 积分不够，请进行充值
                }

                if (zslTraceInfo.getTraceApplyType() == 1 && (totalApplyCount - merchant.getPaperLabelUpper() > 0) &&  merchant.getMerchantCoin() - ((zslTraceInfo.getTraceApplyCount() - merchant.getPaperLabelUpper()) * integralDeductRatio.getIntegralRatio()) > 0) {
                    Merchant merchantUdate = new Merchant();
                    merchantUdate.setMerchantId(zslTraceInfo.getTraceBusinessId());
                    Long kouchu = (zslTraceInfo.getTraceApplyCount() - merchant.getPaperLabelUpper()) * integralDeductRatio.getIntegralRatio();
                    merchantUdate.setMerchantCoin(Integer.parseInt((merchant.getMerchantCoin() - (kouchu)) + ""));
                    int update = merchantMapper.updateByPrimaryKeySelective(merchantUdate);
                    if (update < 0) {
                        return -6; //积分扣除失败
                    }
                    IntegralLog integralLog = new IntegralLog();
                    integralLog.setDeductIntegral(Integer.parseInt(((zslTraceInfo.getTraceApplyCount() - merchant.getPaperLabelUpper()) * integralDeductRatio.getIntegralRatio()) + ""));//当前扣除的积分
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
                    traceCodeProducer.sendMessage(passParam.getTraceCodeNumber(), 100);
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
                    traceUpdateProducer.sendMessage(sendJsonStr,100);
                }catch (Exception e){
                }
            } else {
                return -1;//商品不存在
            }

            //扣除积分
            IntegralDeductRatio integralDeductRatio = integralDeductRatioMapper.selectByPrimaryKey(IntegralEnum.INTEGRAL_DECUCT_RATIO_TYPE_2.getId());
            IntegralLog integralLog = new IntegralLog();
            if (item.getTraceToNumber() - item.getTraceFromNumber() >= 0) {
                integralLog.setDeductIntegral(Integer.parseInt((integralDeductRatio.getIntegralRatio() * (item.getTraceFromNumber() - item.getTraceToNumber() + 1)) + ""));//当前扣除的积分
                decutPoint += Integer.parseInt((integralDeductRatio.getIntegralRatio() * (item.getTraceToNumber() - item.getTraceFromNumber() + 1)) + "");
            }
            integralLog.setFunctionId(traceId);//操作业务主键id
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
        zslTraceMapper.updateByPrimaryKeySelective(updateTrace);
        int i = zslTraceRecordDao.insertList(traceRecordInsertParamList);
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
    public int generateOutCode(List<MiniCodeInsertParam> miniCodeInsertParams) {
        //生成外码
        for(int i = 0;i < miniCodeInsertParams.size();i++){
           List<Long> subcodeIds = zslTraceSubcodeDao.selectByRange(new Long(miniCodeInsertParams.get(i).getTraceFromNumber()),new Long(miniCodeInsertParams.get(i).getTraceToNumber()),miniCodeInsertParams.get(i).getTraceCodeNumber());
           List<TraceOutCodeUpdateParam> traceOutCodeUpdateParams = new ArrayList<>();
           Integer radio = miniCodeInsertParams.get(i).getOutCodeRadio();
           for(int j = 0;j < subcodeIds.size();j++){
                //生成外码
                if((i+1) % radio == 0){

                }
            }
        }
        return 0;
    }
}
