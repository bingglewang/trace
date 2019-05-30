package com.zsl.traceapi.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.github.pagehelper.PageHelper;
import com.zsl.traceapi.dao.ZslTraceDao;
import com.zsl.traceapi.dao.ZslTraceRecordDao;
import com.zsl.traceapi.dto.*;
import com.zsl.traceapi.service.TraceService;
import com.zsl.traceapi.util.ExcelStyleUtil;
import com.zsl.traceapi.util.FilePathUtils;
import com.zsl.traceapi.util.TraceCodeUtil;
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
                passParam.setTraceCodeNumber("ZS"+System.currentTimeMillis());
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

        for(TraceRecordInsertParam item : traceRecordInsertParamList){
            ZslTraceExample zslTraceExample = new ZslTraceExample();
            ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
            criteria.andTraceCodeNumberEqualTo(item.getTraceCodeNumber());
            List<ZslTrace> zslTrace = zslTraceMapper.selectByExample(zslTraceExample);
            if(CollectionUtils.isEmpty(zslTrace)){
                return -2; //追溯码不存在
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
                zslTracePoint.setTraceGoodsId(item.getTraceGoodId()); // 所属商品id
                zslTracePointMapper.insert(zslTracePoint);
            }else{
                return -1;//商品不存在
            }
        }
        return zslTraceRecordDao.insertList(traceRecordInsertParamList);
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
        //摊位id，如果有则为摊位id，没有则为-1（代表非农贸）
        MerchantStall merchantStall = merchantStallMapper.selectByPrimaryKey(traceRecordPointParam.getTraceStallId());
        if(merchantStall == null){
            traceRecordPointParam.setTraceStallId(-1);
        }
        ZslTracePoint zslTracePoint = new ZslTracePoint();
        BeanUtils.copyProperties(traceRecordPointParam,zslTracePoint);
        return zslTracePointMapper.insert(zslTracePoint);
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
            excelTraceCode.setCode(codeList.get(0));
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
