package com.zsl.traceapi.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.github.pagehelper.PageHelper;
import com.zsl.traceapi.dao.ZslTraceDao;
import com.zsl.traceapi.dao.ZslTraceRecordDao;
import com.zsl.traceapi.dto.*;
import com.zsl.traceapi.service.TraceService;
import com.zsl.traceapi.util.*;
import com.zsl.traceapi.vo.ZslTraceVo;
import com.zsl.tracedb.mapper.*;
import com.zsl.tracedb.model.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public ZslTraceVo getZslTraceById(Integer id) {
        return  zslTraceDao.getZslTraceDetailById(id);
    }

    @Override
    public List<ZslTraceVo> getZslTraceByPage(QueryParam queryParam, PageParams pageParams) {
        //设置排序，大小，页数
        if (pageParams.getPageSize() != null) {
            PageHelper.startPage(pageParams.getPageNum(), pageParams.getPageSize(), pageParams.getOrderBy());
        }

        //获取数据
        List<ZslTraceVo> result = zslTraceDao.getListByPage(queryParam);
        return result;
    }

    @Override
    public ZslTrace insert(ZslTrace zslTrace) {
        int i = zslTraceMapper.insertSelective(zslTrace);
        if(i > 0){
            return zslTrace;
        }else{
            return null;
        }
    }

    @Override
    public int update(ZslTrace zslTrace) {
        return zslTraceMapper.updateByPrimaryKeySelective(zslTrace);
    }

    @Override
    public int pass(Integer id) {
        ZslTrace zslTraceInfo = zslTraceMapper.selectByPrimaryKey(id);
        if(zslTraceInfo != null){
            if(zslTraceInfo.getTraceHandleStatus() == 2){
                //将申请处理状态改为 已通过 1
                ZslTrace passParam = new ZslTrace();
                passParam.setTraceId(id);
                passParam.setTraceHandleStatus(1);
                passParam.setTraceReviewDate(new Date());
                //生成追溯码批次号
                //批次号：zs+时间戳+商家id+4位随机数
                passParam.setTraceCodeNumber("zs"+System.currentTimeMillis()*1000+zslTraceInfo.getTraceBusinessId()+RandomUtil.getRandNumberCode(4));
                //积分判断
                IntegralDeductRatio integralDeductRatio =  integralDeductRatioMapper.selectByPrimaryKey(IntegralEnum.INTEGRAL_DECUCT_RATIO_TYPE_3.getId());
                Merchant merchant =  merchantMapper.selectByPrimaryKey(zslTraceInfo.getTraceBusinessId());
                if(zslTraceInfo.getTraceApplyType() == 1 && merchant.getMerchantCoin() - ((zslTraceInfo.getTraceApplyCount() - Constant.UPPER_LIMIT)* integralDeductRatio.getIntegralRatio())  < 0){
                    return -4; // 积分不够，请进行充值
                }

                if(zslTraceInfo.getTraceApplyType() == 1 && merchant.getMerchantCoin() - ((zslTraceInfo.getTraceApplyCount() - Constant.UPPER_LIMIT)* integralDeductRatio.getIntegralRatio())  > 0){
                    Merchant merchantUdate = new Merchant();
                    merchantUdate.setMerchantId(zslTraceInfo.getTraceBusinessId());
                    Long kouchu = (zslTraceInfo.getTraceApplyCount() - Constant.UPPER_LIMIT)* integralDeductRatio.getIntegralRatio();
                    merchantUdate.setMerchantCoin(Integer.parseInt((merchant.getMerchantCoin() - (kouchu))+ ""));
                    int  update = merchantMapper.updateByPrimaryKeySelective(merchantUdate);
                    if(update < 0 ){
                        return -6; //积分扣除失败
                    }
                    IntegralLog integralLog = new IntegralLog();
                    integralLog.setDeductIntegral(Integer.parseInt(((zslTraceInfo.getTraceApplyCount() - Constant.UPPER_LIMIT)* integralDeductRatio.getIntegralRatio())+""));//当前扣除的积分
                    integralLog.setFunctionId(zslTraceInfo.getTraceId());//操作业务主键id
                    integralLog.setFunctionType(ServiceEnum.APPLY_PAPER.getId());
                    integralLog.setMerchantId(zslTraceInfo.getTraceBusinessId());//商家id
                    integralLog.setDeductStatus(2);//已经扣减
                    integralLog.setDeductTime(new Date()); //扣减时间
                    int integLogInsert =  integralLogMapper.insert(integralLog);
                    if(integLogInsert < 0){
                        return -5;  //积分处理失败
                    }
                }

                int i = zslTraceMapper.updateByPrimaryKeySelective(passParam);
                if(i > 0){
                    return i;
                }else{
                    return -3;//审核失败，服务器错误
                }

            }else{
                return -1;//已经审核，不用重复审核
            }
        }else{
            return -2;//审核信息不存在
        }
    }

    @Override
    public int refuse(Integer id, String remark) {
        ZslTrace zslTraceInfo = zslTraceMapper.selectByPrimaryKey(id);
        if(zslTraceInfo != null){
            if(zslTraceInfo.getTraceHandleStatus() == 2){
                //将申请处理状态改为 已撤回 3
                ZslTrace passParam = new ZslTrace();
                passParam.setTraceId(id);
                passParam.setTraceHandleStatus(3);
                passParam.setTraceRefuseRemark(remark);
                passParam.setTraceReviewDate(new Date());
                int i = zslTraceMapper.updateByPrimaryKeySelective(passParam);
                if(i > 0){
                    return i;
                }else{
                    return -3;//审核失败，服务器错误
                }

            }else{
                return -1;//已经审核，不用重复审核
            }
        }else{
            return -2;//审核信息不存在
        }
    }

    @Override
    public int traceRecordInsert(List<TraceRecordInsertParam> traceRecordInsertParamList) {
        Integer traceId = 0;
        Long total = 0L;
        Long haveRelationCount = 0L;
        for(TraceRecordInsertParam item : traceRecordInsertParamList){
            ZslTraceExample zslTraceExample = new ZslTraceExample();
            ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
            criteria.andTraceCodeNumberEqualTo(item.getTraceCodeNumber());
            List<ZslTrace> zslTrace = zslTraceMapper.selectByExample(zslTraceExample);
            if(CollectionUtils.isEmpty(zslTrace)){
                return -2; //追溯码不存在
            }else{
                traceId = zslTrace.get(0).getTraceId();
                total = zslTrace.get(0).getTraceApplyCount();
            }
            //查询商家名字（根据商品id）
            Goods goods = goodsMapper.selectByPrimaryKey(item.getTraceGoodId());
            if(goods != null){
                int merchantId = goods.getMerchantId();
                Merchant merchant = merchantMapper.selectByPrimaryKey(merchantId);
                ZslTracePoint zslTracePoint = new ZslTracePoint();
                zslTracePoint.setTraceParentId(null); //父节点id
                zslTracePoint.setTracePointName(merchant.getMerchantName()); //商家名称
                zslTracePoint.setTracePointToNumber(item.getTraceToNumber()); //起始编码
                zslTracePoint.setTracePointFromNumber(item.getTraceFromNumber());  //结束编码
                if(item.getTraceFromNumber() - item.getTraceToNumber() != 0)
                haveRelationCount += item.getTraceFromNumber() - item.getTraceToNumber() + 1;
                zslTracePoint.setTraceGoodsId(item.getTraceGoodId()); // 所属商品id
                zslTracePointMapper.insert(zslTracePoint);
            }else{
                return -1;//商品不存在
            }

            //扣除积分
            IntegralDeductRatio integralDeductRatio =  integralDeductRatioMapper.selectByPrimaryKey(IntegralEnum.INTEGRAL_DECUCT_RATIO_TYPE_2.getId());
            IntegralLog integralLog = new IntegralLog();
            if(item.getTraceFromNumber() - item.getTraceToNumber() != 0)
            integralLog.setDeductIntegral(Integer.parseInt((integralDeductRatio.getIntegralRatio()*(item.getTraceFromNumber() - item.getTraceToNumber() + 1))+""));//当前扣除的积分
            integralLog.setFunctionId(traceId);//操作业务主键id
            integralLog.setFunctionType(ServiceEnum.TRACE_RECORD.getId());
            integralLog.setMerchantId(zslTrace.get(0).getTraceBusinessId());//商家id
            integralLog.setDeductStatus(1);//未扣减
            int integLogInsert =  integralLogMapper.insert(integralLog);
            if(integLogInsert > 0){
                return integLogInsert;
            }else {
                return -4;  //积分处理失败
            }

        }
        ZslTrace updateTrace = new ZslTrace();
        updateTrace.setTraceId(traceId);
        updateTrace.setTraceBack1(Integer.parseInt(haveRelationCount+"")); //已经关联数量
        updateTrace.setTraceEnableCount(Integer.parseInt((total - haveRelationCount)+"" ));//剩余数量
        zslTraceMapper.updateByPrimaryKeySelective(updateTrace);
        int i = zslTraceRecordDao.insertList(traceRecordInsertParamList);
        if(i > 0){
          return i;
        }else {
            return -3; //追溯记录处理失败
        }
    }

    @Override
    public int traceRecordPointInsert(TraceRecordPointParam traceRecordPointParam) {
        Goods goods = goodsMapper.selectByPrimaryKey(traceRecordPointParam.getTraceGoodsId());
        if(goods == null){
            return -1; //商品不存在
        }
        ZslTracePoint zslTracePointDetail = zslTracePointMapper.selectByPrimaryKey(traceRecordPointParam.getTraceParentId());
        if(zslTracePointDetail == null){
            return -2; //父追溯点不存在
        }
        //判断积分够不够扣除
        ZslTraceExample zslTraceExample = new ZslTraceExample();
        ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(traceRecordPointParam.getTraceCodeNumber());
        List<ZslTrace> zslTrace = zslTraceMapper.selectByExample(zslTraceExample);
        if(CollectionUtils.isEmpty(zslTrace)){
            return -3; //追溯码不存在
        }
        Merchant merchant =  merchantMapper.selectByPrimaryKey(zslTrace.get(0).getTraceBusinessId());
        if(merchant.getMerchantCoin() - (traceRecordPointParam.getTracePointFromNumber() - traceRecordPointParam.getTracePointToNumber() +1)  < 0){
            return -4; // 积分不够，请进行充值
        }
        //摊位id，如果有则为摊位id，没有则为-1（代表非农贸）
        MerchantStall merchantStall = merchantStallMapper.selectByPrimaryKey(traceRecordPointParam.getTraceStallId());
        if(merchantStall == null){
            traceRecordPointParam.setTraceStallId(-1);
        }
        ZslTracePoint zslTracePoint = new ZslTracePoint();
        BeanUtils.copyProperties(traceRecordPointParam,zslTracePoint);
        int i = zslTracePointMapper.insert(zslTracePoint);
        if(i < 0 ){
            return -5;//追溯插入失败
        }
        Merchant merchantUdate = new Merchant();
        merchantUdate.setMerchantId(zslTrace.get(0).getTraceBusinessId());
        merchant.setMerchantCoin(merchant.getMerchantCoin() - (traceRecordPointParam.getTracePointFromNumber() - traceRecordPointParam.getTracePointToNumber() +1));
        int  update = merchantMapper.updateByPrimaryKeySelective(merchantUdate);
        if(update < 0 ){
            return -6; //积分扣除失败
        }
        //扣除积分
        IntegralDeductRatio integralDeductRatio =  integralDeductRatioMapper.selectByPrimaryKey(IntegralEnum.INTEGRAL_DECUCT_RATIO_TYPE_2.getId());
        IntegralLog integralLog = new IntegralLog();
        integralLog.setDeductIntegral(Integer.parseInt((integralDeductRatio.getIntegralRatio()*(traceRecordPointParam.getTracePointFromNumber() - traceRecordPointParam.getTracePointToNumber() +1))+""));//当前扣除的积分
        integralLog.setFunctionId(zslTracePoint.getTracePointId());//操作业务主键id
        integralLog.setFunctionType(ServiceEnum.INSERT_TRACE_POINT.getId());
        integralLog.setMerchantId(zslTrace.get(0).getTraceBusinessId());//商家id
        integralLog.setDeductStatus(2);//已经扣减
        integralLog.setDeductTime(new Date()); //扣减时间
        int integLogInsert =  integralLogMapper.insert(integralLog);
        if(integLogInsert > 0){
            return integLogInsert;
        }else {
            return -7;  //积分处理失败
        }

    }

    @Override
    public FileInfo exportPointCode(String traceCode,HttpServletResponse response) {
        //创建集合用于追溯码导出
        List<ExcelTraceCode> excelTraceCodes = new ArrayList<>();
        ZslTraceExample zslTraceExample = new ZslTraceExample();
        ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(traceCode);
        List<ZslTrace> zslTrace = zslTraceMapper.selectByExample(zslTraceExample);
        if(CollectionUtils.isEmpty(zslTrace)){
            return null; //追溯码不存在
        }
        List<String> codeList =  TraceCodeUtil.generateTraceCode(zslTrace.get(0).getTraceApplyCount());
        if(CollectionUtils.isEmpty(codeList)){
            return null;
        }
        for(int i = 0;i<codeList.size();i++){
            ExcelTraceCode excelTraceCode = new ExcelTraceCode();
            excelTraceCode.setIndex(i+1+"");
            excelTraceCode.setCode(codeList.get(i));
            excelTraceCodes.add(excelTraceCode);
        }

        // 设置导出配置
        ExportParams params = new ExportParams("1、追溯码\n" +
                "2、*****\n"
                , traceCode+"的追溯码");
        params.setStyle(ExcelStyleUtil.class);
        Workbook workbook = ExcelExportUtil.exportExcel(params,
                ExcelTraceCode.class, excelTraceCodes);
        Row row = workbook.getSheetAt(0).getRow(0);
        row.setHeight((short) 2000);
        workbook.getSheetAt(0).setColumnWidth(1, 6000);
        workbook.getSheetAt(0).setColumnWidth(2, 6000);

        File localFile = null;
        try{
            localFile = File.createTempFile("temp",null);
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.setContentType("multipart/form-data;charset=UTF-8");
            //response.addHeader("Content-Disposition", "attachment;fileName=" + traceCode+"的追溯码.xls");// 设置文件名
            response.setHeader("Content-Disposition", "attachment;fileName=" + new String((traceCode+"的追溯码.xls").getBytes("GB2312"),"ISO-8859-1"));
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            //写到临时文件
            FileOutputStream fos = new FileOutputStream(localFile);
            workbook.write(fos);
            fos.close();
            //
            fis = new FileInputStream(localFile);
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new FileInfo();
    }
}
