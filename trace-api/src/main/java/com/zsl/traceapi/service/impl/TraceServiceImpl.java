package com.zsl.traceapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.zsl.traceapi.dao.ZslTraceDao;
import com.zsl.traceapi.dao.ZslTraceRecordDao;
import com.zsl.traceapi.dto.PageParams;
import com.zsl.traceapi.dto.QueryParam;
import com.zsl.traceapi.dto.TraceRecordInsertParam;
import com.zsl.traceapi.dto.TraceRecordPointParam;
import com.zsl.traceapi.service.TraceService;
import com.zsl.traceapi.vo.ZslTraceVo;
import com.zsl.tracedb.mapper.*;
import com.zsl.tracedb.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
}
