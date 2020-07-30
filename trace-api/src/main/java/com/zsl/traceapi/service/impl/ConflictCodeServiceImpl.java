package com.zsl.traceapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.zsl.traceapi.dto.ConflictCodeDetailParam;
import com.zsl.traceapi.dto.ConflictCodeParam;
import com.zsl.traceapi.dto.PageParams;
import com.zsl.traceapi.service.ConflictCodeService;
import com.zsl.tracecommon.CommonPage;
import com.zsl.tracecommon.CommonResult;
import com.zsl.tracedb.mapper.ZslConflictCodeDetailMapper;
import com.zsl.tracedb.mapper.ZslConflictCodeMapper;
import com.zsl.tracedb.model.ZslConflictCode;
import com.zsl.tracedb.model.ZslConflictCodeDetail;
import com.zsl.tracedb.model.ZslConflictCodeDetailExample;
import com.zsl.tracedb.model.ZslConflictCodeExample;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ConflictCodeServiceImpl
 * @Description TODO
 * @Author binggleW
 * @Date 2020-07-30 11:02
 * @Version 1.0
 **/
@Service
public class ConflictCodeServiceImpl implements ConflictCodeService {


    @Autowired
    private ZslConflictCodeMapper zslConflictCodeMapper;

    @Autowired
    private ZslConflictCodeDetailMapper zslConflictCodeDetailMapper;

    @Override
    public Object getConflictCodeByPage(PageParams pageParams, ConflictCodeParam queryParam) {
        //设置排序，大小，页数
        if (pageParams.getPageSize() != null) {
            PageHelper.startPage(pageParams.getPageNum(), pageParams.getPageSize(), pageParams.getOrderBy());
        }

        ZslConflictCodeExample zslConflictCodeExample = new ZslConflictCodeExample();
        ZslConflictCodeExample.Criteria criteria = zslConflictCodeExample.createCriteria();

        if(queryParam.getSid() != null){
            criteria.andTraceSidEqualTo(queryParam.getSid());
        }

        if(StringUtils.isNotBlank(queryParam.getTraceCodeNumber())){
            criteria.andTraceCodeNumberEqualTo(queryParam.getTraceCodeNumber());
        }

        if(StringUtils.isNotBlank(queryParam.getProductBatchNo())){
            criteria.andProductBatchCodeEqualTo(queryParam.getProductBatchNo());
        }

        if(StringUtils.isNotBlank(queryParam.getGoodsName())){
            criteria.andTraceGoodNameLike("%" + queryParam.getGoodsName() + "%");
        }

        List<ZslConflictCode> zslConflictCodes = zslConflictCodeMapper.selectByExample(zslConflictCodeExample);

        return CommonResult.success(CommonPage.restPage(zslConflictCodes));
    }

    @Override
    public Object getConflictCodeDetailByPage(PageParams pageParams, ConflictCodeDetailParam queryParam,Integer conflictCodeId) {
        //设置排序，大小，页数
        if (pageParams.getPageSize() != null) {
            PageHelper.startPage(pageParams.getPageNum(), pageParams.getPageSize(), pageParams.getOrderBy());
        }

        ZslConflictCodeDetailExample zslConflictCodeDetailExample = new ZslConflictCodeDetailExample();
        ZslConflictCodeDetailExample.Criteria criteria =  zslConflictCodeDetailExample.createCriteria();

        criteria.andConflictCodeIdEqualTo(conflictCodeId);
        if(StringUtils.isNotBlank(queryParam.getAddress())){
            criteria.andConflictAddressLike("%"+ queryParam.getAddress());
        }

        if(queryParam.getStartTime() != null){
            criteria.andConflictDateGreaterThanOrEqualTo(queryParam.getStartTime());
        }

        if(queryParam.getEndTime() != null){
            criteria.andConflictDateLessThanOrEqualTo(queryParam.getEndTime());
        }

        List<ZslConflictCodeDetail> details = zslConflictCodeDetailMapper.selectByExample(zslConflictCodeDetailExample);

        return CommonResult.success(CommonPage.restPage(details));
    }
}
