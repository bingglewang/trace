package com.zsl.traceapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.zsl.traceapi.dao.ZslTraceDao;
import com.zsl.traceapi.dto.PageParams;
import com.zsl.traceapi.dto.QueryParam;
import com.zsl.traceapi.service.TraceService;
import com.zsl.traceapi.vo.ZslTraceVo;
import com.zsl.tracedb.mapper.MerchantMapper;
import com.zsl.tracedb.mapper.ZslTraceMapper;
import com.zsl.tracedb.model.ZslTrace;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TraceServiceImpl implements TraceService {
    @Autowired
    private ZslTraceMapper zslTraceMapper;

    @Autowired
    private ZslTraceDao zslTraceDao;

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
}
