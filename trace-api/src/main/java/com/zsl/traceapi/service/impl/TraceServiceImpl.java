package com.zsl.traceapi.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.zsl.traceapi.config.kafka.producer.TraceCodeProducerKafka;
import com.zsl.traceapi.context.RequestContext;
import com.zsl.traceapi.context.RequestContextMgr;
import com.zsl.traceapi.dao.*;
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
import java.util.stream.Collectors;


@Service
public class TraceServiceImpl implements TraceService {

    @Autowired
    private ZslTraceMapper zslTraceMapper;

    @Autowired
    private ZslTraceDao zslTraceDao;

    @Autowired
    private ZslCurrentEIndexMapper zslCurrentEIndexMapper;

    @Autowired
    private ZslTracePointMapper zslTracePointMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private IntegralDeductRatioMapper integralDeductRatioMapper;

    @Autowired
    private IntegralLogMapper integralLogMapper;

    @Autowired
    private CodeTraceIntegralLogMapper codeTraceIntegralLogMapper;

    @Autowired
    private ZslTraceRecordMapper zslTraceRecordMapper;

    @Autowired
    private ZslTraceProductionLinkMapper zslTraceProductionLinkMapper;

    @Autowired
    private ZslProductionImageMapper zslProductionImageMapper;

    @Autowired
    private ZslTraceRelationMapper zslTraceRelationMapper;

    @Autowired
    private TraceCodeProducerKafka traceCodeProducerKafka;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private ZslTraceSubcodeDao zslTraceSubcodeDao;

    @Autowired
    private ZslTraceSubcodeMapper zslTraceSubcodeMapper;

    @Autowired
    private ZslScanRecordMapper zslScanRecordMapper;

    @Autowired
    private ZslTraceSidDao zslTraceSidDao;

    @Autowired
    private ZslTraceSidMapper zslTraceSidMapper;

    @Autowired
    private ZslTraceRecordDao zslTraceRecordDao;

    @Autowired
    private MerchantDao merchantDao;

    @Autowired
    private ZslTracePapperMapper zslTracePapperMapper;

    @Autowired
    private RedisService redisService;

    private Integer count = 0;

    private Integer countIntegral = 0;

    private List<ZslTraceSubcode> totalSubCode;

    private List<ZslTracePoint> deliverList;

    private Integer isSaled = 0;

    @Override
    public CommonResult preCreatePaperCode(Long preCreateCount) {
        //插入之前首先获取最新的记
        ZslCurrentEIndex currentEIndex = zslCurrentEIndexMapper.selectByPrimaryKey(1);
        Long sidStartIndex = 0L;
        Long sidEndIndex = 0L;

        ZslTraceSid zslTraceSid = new ZslTraceSid();
        sidStartIndex = currentEIndex.getCurrentEIndex() + 1;//起始下标
        sidEndIndex = currentEIndex.getCurrentEIndex() + preCreateCount; //结束下标
        zslTraceSid.setEnableCount(preCreateCount); //剩余数量
        zslTraceSid.setCreateTime(new Date()); //生成时间
        zslTraceSid.setSidStartIndex(sidStartIndex); //sid起始下标
        zslTraceSid.setSidEndIndex(sidEndIndex); //sid结束下标
        int i = zslTraceSidMapper.insert(zslTraceSid);
        if (i > 0) {
            //修改电子下标
            ZslCurrentEIndex zslCurrentEIndex = new ZslCurrentEIndex();
            zslCurrentEIndex.setId(1);
            zslCurrentEIndex.setCurrentEIndex(sidEndIndex + 1);
            zslCurrentEIndexMapper.updateByPrimaryKeySelective(zslCurrentEIndex);
            try {
                traceCodeProducerKafka.sendMessage(zslTraceSid.getId().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return CommonResult.success(sidStartIndex);
        } else {
            return CommonResult.failed("预生成失败");
        }
    }

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
        if (queryParam.getTraceApplyStartDate() != null && StringUtils.isNotBlank(queryParam.getTraceApplyStartDate().toString())) {
            queryParam.setTraceApplyStartDate1(new Date(queryParam.getTraceApplyStartDate()));
        }
        if (queryParam.getTraceApplyEndDate() != null && StringUtils.isNotBlank(queryParam.getTraceApplyEndDate().toString())) {
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
        if (zslTraceDetail == null) {
            return -2; // 追溯码不存在
        }
        if (zslTraceDetail.getTraceHandleStatus() - 2 != 0) {
            return -3; // 追溯信息已被处理，无法修改
        }

        return zslTraceMapper.updateByPrimaryKeySelective(zslTrace);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int pass(Integer id, Long sid) {
        ZslTrace zslTraceInfo = zslTraceMapper.selectByPrimaryKey(id);
        if (zslTraceInfo != null) {
            if (zslTraceInfo.getTraceHandleStatus() == 2) {
                //将申请处理状态改为 已通过 1
                ZslTrace passParam = new ZslTrace();
                passParam.setTraceId(id);
                passParam.setTraceHandleStatus(1);
                passParam.setTraceReviewDate(new Date());
                //生成追溯码批次号
                // 剩余数量（）
                passParam.setTraceEnableCount(Integer.parseInt(zslTraceInfo.getTraceApplyCount() + ""));
                // 已经关联数量（0）
                passParam.setTraceBack1(0);
                //批次号：zs+时间戳+商家id+4位随机数
                passParam.setTraceCodeNumber("zs" + System.currentTimeMillis() * 1000 + zslTraceInfo.getTraceBusinessId() + RandomUtil.getRandNumberCode(4));
                //积分判断
                Merchant merchant = merchantMapper.selectByPrimaryKey(zslTraceInfo.getTraceBusinessId());
                if (merchant.getCertificationToPay() != 1) {
                    return -7;//商家未认证
                }
                //商家剩余免费纸质标签数量
                Long bussiPaperCount = merchant.getPaperLabelUpper();
                //需要扣除的纸质数量
                if (bussiPaperCount - 0 != 0 && zslTraceInfo.getTraceApplyType() == 1) {
                    Merchant updatePaperCount = new Merchant();
                    updatePaperCount.setMerchantId(merchant.getMerchantId());
                    if (bussiPaperCount - zslTraceInfo.getTraceApplyCount() < 0) {
                        // 将商家纸质标签数量设置为0
                        updatePaperCount.setPaperLabelUpper(0L);
                    } else {
                        updatePaperCount.setPaperLabelUpper(bussiPaperCount - zslTraceInfo.getTraceApplyCount());
                    }
                    //修改商家纸质标签上限
                    merchantMapper.updateByPrimaryKeySelective(updatePaperCount);
                }

                //将追溯批次号放入队列(电子才放入队列)
                if (zslTraceInfo.getTraceApplyType() == 2) {
                    try {
                        traceCodeProducerKafka.sendMessage(passParam.getTraceCodeNumber());
                    } catch (Exception e) {
                        return -8;  //追溯码生成错误
                    }
                } else {
                    CommonResult result = getCodePartBySid(sid, id);
                    if (result.getCode() - 200 != 0) {
                        return -11;
                    } else {
                        List<ZslTracePapper> list = (List<ZslTracePapper>) result.getData();
                        for (int i = 0; i < list.size(); i++) {
                            //插入纸质关联码段
                            list.get(i).setTraceCodeNumber(passParam.getTraceCodeNumber());
                            zslTracePapperMapper.insert(list.get(i));
                            List<ZslTraceSid> traceSidList = zslTraceSidDao.listBlankCodePart();
                            for (int j = 0; j < traceSidList.size(); j++) {
                                if (list.get(i).getTraceNumStart() - traceSidList.get(j).getSidStartIndex() > 0 && list.get(i).getTraceNumEnd() - traceSidList.get(j).getSidEndIndex() < 0) {
                                    //左边大于，右边小于
                                    updateSidByRange(traceSidList.get(j));
                                    insertSidByRange(traceSidList.get(j), traceSidList.get(j).getSidStartIndex(), list.get(i).getTraceNumStart() - 1);
                                    insertSidByRange(traceSidList.get(j), list.get(i).getTraceNumEnd() + 1, traceSidList.get(j).getSidEndIndex());
                                } else if (list.get(i).getTraceNumStart() - traceSidList.get(j).getSidStartIndex() == 0 && list.get(i).getTraceNumEnd() - traceSidList.get(j).getSidEndIndex() < 0) {
                                    //左边等于，右边小于
                                    updateSidByRange(traceSidList.get(j));
                                    insertSidByRange(traceSidList.get(j), list.get(i).getTraceNumEnd() + 1, traceSidList.get(j).getSidEndIndex());
                                } else if (list.get(i).getTraceNumStart() - traceSidList.get(j).getSidStartIndex() > 0 && list.get(i).getTraceNumEnd() - traceSidList.get(j).getSidEndIndex() == 0) {
                                    //左边大于，右边等于
                                    updateSidByRange(traceSidList.get(j));
                                    insertSidByRange(traceSidList.get(j), traceSidList.get(j).getSidStartIndex(), list.get(i).getTraceNumStart() - 1);
                                } else if (list.get(i).getTraceNumStart() - traceSidList.get(j).getSidStartIndex() == 0 && list.get(i).getTraceNumEnd() - traceSidList.get(j).getSidEndIndex() == 0) {
                                    //左边等于，右边等于
                                    updateSidByRange(traceSidList.get(j));
                                }
                            }
                        }
                    }
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

    public void updateSidByRange(ZslTraceSid traceSidInfo) {
        ZslTraceSid update = new ZslTraceSid();
        update.setId(traceSidInfo.getId());
        update.setSidPreCreate((byte) -2);
        zslTraceSidMapper.updateByPrimaryKeySelective(update);
    }

    /**
     * 插入sid空闲码段
     *
     * @param traceSidInfo
     * @param startIndex
     * @param endIndex
     */
    public void insertSidByRange(ZslTraceSid traceSidInfo, Long startIndex, Long endIndex) {
        ZslTraceSid zslTraceSid = new ZslTraceSid();
        zslTraceSid.setId(traceSidInfo.getId());
        zslTraceSid.setCreateTime(new Date());
        zslTraceSid.setSidPreCreate((byte) 1);
        zslTraceSid.setSidStartIndex(startIndex);
        zslTraceSid.setSidEndIndex(endIndex);
        zslTraceSid.setEnableCount(zslTraceSid.getSidEndIndex() - zslTraceSid.getSidStartIndex() + 1);
        zslTraceSidMapper.insert(zslTraceSid);
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

    /**
     * 根据批次号获取申请的纸质码段
     *
     * @param traceCodeNumber
     * @return
     */
    private List<ZslTracePapper> getTracePaperByTraceCodeNumber(String traceCodeNumber) {
        ZslTracePapperExample zslTracePapperExample = new ZslTracePapperExample();
        ZslTracePapperExample.Criteria criteria = zslTracePapperExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
        zslTracePapperExample.setOrderByClause("trace_num_start asc");
        return zslTracePapperMapper.selectByExample(zslTracePapperExample);
    }

    /**
     * 根据批次号获取当前关联指针
     *
     * @param traceCodeNumber
     * @return
     */
    private ZslTraceRelation getRelationByTraceCodeNumber(String traceCodeNumber) {
        ZslTraceRelationExample zslTraceRelationExample = new ZslTraceRelationExample();
        ZslTraceRelationExample.Criteria criteria = zslTraceRelationExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
        List<ZslTraceRelation> result = zslTraceRelationMapper.selectByExample(zslTraceRelationExample);
        if (org.apache.commons.collections.CollectionUtils.isNotEmpty(result)) {
            return result.get(0);
        } else {
            return null;
        }
    }


    /**
     * 获取数量和修改当前关联指针
     *
     * @param count
     * @param traceCodeNumber
     * @return
     */
    private List<ZslTracePapper> getTracePaperBy(long count, String traceCodeNumber) {
        //
        List<ZslTracePapper> relationPaperList = getTracePaperByTraceCodeNumber(traceCodeNumber);
        if (org.apache.commons.collections.CollectionUtils.isNotEmpty(relationPaperList)) {
            //统计数量
            Long countRelation = 0L;
            List<ZslTracePapper> relationParam = new ArrayList<>();
            for (int j = 0; j < relationPaperList.size(); j++) {
                long startN = 0L;
                long endN = 0L;
                ZslTracePapper zslTracePapper = new ZslTracePapper();
                //获取当前已经关联的下标
                ZslTraceRelation zslTraceRelation = getRelationByTraceCodeNumber(traceCodeNumber);
                if (zslTraceRelation != null && (zslTraceRelation.getCurrentIndexRelation() + 1 - relationPaperList.get(j).getTraceNumStart() >= 0 && zslTraceRelation.getCurrentIndexRelation() + 1 - relationPaperList.get(j).getTraceNumEnd() <= 0)) {
                    startN = zslTraceRelation.getCurrentIndexRelation() + 1;
                } else {
                    startN = relationPaperList.get(j).getTraceNumStart();
                }
                endN = relationPaperList.get(j).getTraceNumEnd();
                zslTracePapper.setTraceNumStart(startN);
                zslTracePapper.setTraceNumEnd(endN);
                for (long n = startN; n <= endN; n++) {
                    if (zslTraceRelation != null && (n - (zslTraceRelation.getCurrentIndexRelation() + 1) >= 0)) {
                        countRelation++;
                    } else if (zslTraceRelation == null) {
                        countRelation++;
                    }
                    if (countRelation - count == 0) {
                        //已经足够
                        zslTracePapper.setTraceNumEnd(n);
                        //更新关联指针
                        if (zslTraceRelation == null) {
                            ZslTraceRelation relaTionInsert = new ZslTraceRelation();
                            relaTionInsert.setTraceCodeNumber(traceCodeNumber);
                            relaTionInsert.setCurrentIndexRelation(n);
                            zslTraceRelationMapper.insert(relaTionInsert);
                        } else {
                            ZslTraceRelation relationUpdate = new ZslTraceRelation();
                            relationUpdate.setId(zslTraceRelation.getId());
                            relationUpdate.setCurrentIndexRelation(n);
                            zslTraceRelationMapper.updateByPrimaryKeySelective(relationUpdate);
                        }
                        if (zslTracePapper.getTraceNumEnd() - zslTracePapper.getTraceNumStart() >= 0) {
                            relationParam.add(zslTracePapper);
                        }
                        return relationParam;
                    }

                }
                if (zslTracePapper.getTraceNumEnd() - zslTracePapper.getTraceNumStart() >= 0) {
                    if (zslTraceRelation != null && (zslTracePapper.getTraceNumEnd() - (zslTraceRelation.getCurrentIndexRelation() + 1) < 0)) {
                    } else {
                        relationParam.add(zslTracePapper);
                    }
                }

            }
            return relationParam;
        } else {
            return null;
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
        String sendJsonStr = "";
        Long totalCountInsert = 0L;
        for (TraceRecordInsertParam item : traceRecordInsertParamList) {
            totalCountInsert += (item.getTraceToNumber() - item.getTraceFromNumber() + 1);

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
                zslTracePoint.setTracePointTime(new Date());
                if (item.getTraceToNumber() - item.getTraceFromNumber() >= 0)
                    haveRelationCount += item.getTraceToNumber() - item.getTraceFromNumber() + 1;
                zslTracePoint.setTraceGoodsId(item.getTraceGoodId()); // 所属商品id
                if (item.getTraceStallId() == null || item.getTraceStallId() == -1) {  //非农贸,则根据追溯码获取商品id
                    zslTracePoint.setTraceStallId(-1);
                } else {
                    zslTracePoint.setTraceStallId(item.getTraceStallId());
                }

                Long count = new Long(item.getTraceToNumber() - item.getTraceFromNumber() + 1);

                List<ZslTracePapper> tracePappers = getTracePaperBy(count, item.getTraceCodeNumber());

                //队列用到的对象
                TraceCodeRelation traceCodeRelation = new TraceCodeRelation();
                traceCodeRelation.setFromNumber(new Long(item.getTraceFromNumber()));
                traceCodeRelation.setToNumber(new Long(item.getTraceToNumber()));
                traceCodeRelation.setGoodsId(zslTracePoint.getTraceGoodsId());
                traceCodeRelation.setStallId(zslTracePoint.getTraceStallId());
                traceCodeRelation.setTraceCodeNumber(zslTracePoint.getTraceCodeNumber());
                traceCodeRelation.setTracePappers(tracePappers);
                //根据商家id获取账号id
                Integer accountId = merchantDao.getAccountIdByBussiId(zslTrace.get(0).getTraceBusinessId());
                zslTracePoint.setTracePointAccountId(accountId);
                zslTracePointMapper.insert(zslTracePoint);
                sendJsonStr = JSONObject.toJSONString(traceCodeRelation);
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

            //插入生产环节和生产图片
            List<ProductionLinkParam> productionLinkParams = item.getProductionLinks();
            if (CollectionUtil.isNotEmpty(productionLinkParams)) {
                for (ProductionLinkParam productionLink : productionLinkParams) {
                    boolean isObjEmpty = false;
                    try {
                        isObjEmpty = ObjectIsNullUitl.checkFieldAllNull(productionLink);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    if(isObjEmpty){
                        continue;
                    }
                    ZslTraceProductionLink zslTraceProductionLink = new ZslTraceProductionLink();
                    zslTraceProductionLink.setProductionDescripe(productionLink.getProductionDescripe());
                    zslTraceProductionLink.setProductionMan(productionLink.getProductionMan());
                    zslTraceProductionLink.setProductionName(productionLink.getProductionName());
                    zslTraceProductionLink.setProductionTime(new Date(productionLink.getProductionTime()));
                    zslTraceProductionLink.setTraceRecodeId(insertRecord.getTraceRecordId());
                    zslTraceProductionLinkMapper.insert(zslTraceProductionLink);
                    //插入图片
                    if (CollectionUtil.isNotEmpty(productionLink.getProductionPicList())) {
                        for (int i = 0; i < productionLink.getProductionPicList().size(); i++) {
                            ZslProductionImage zslProductionImage = new ZslProductionImage();
                            zslProductionImage.setImageIndex(i);
                            zslProductionImage.setImageUrl(productionLink.getProductionPicList().get(i));
                            zslProductionImage.setProductionId(zslTraceProductionLink.getId());
                            zslProductionImageMapper.insert(zslProductionImage);
                        }
                    }
                }
            }

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
            integralLog.setMqJsonStr(sendJsonStr); // mq关联子码参数
            integralLog.setCreateTime(new Date());//创建时间
            integralLog.setDeductStatus(1);//未扣减
            int integLogInsert = integralLogMapper.insert(integralLog);
            if (!(integLogInsert > 0)) {
                return -4;  //积分处理失败
            }
        }
        ZslTrace updateTrace = new ZslTrace();
        updateTrace.setTraceId(traceId);
        updateTrace.setTraceBack1(upZslTrace.getTraceBack1() + Integer.parseInt(haveRelationCount + "")); //已经关联数量
        updateTrace.setTraceEnableCount(upZslTrace.getTraceEnableCount() - Integer.parseInt(haveRelationCount + ""));//剩余数量
        int i = zslTraceMapper.updateByPrimaryKeySelective(updateTrace);
        //插入追溯记录
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
            if (insertParam.getTraceToNumber() <= 0 || insertParam.getTraceFromNumber() <= 0 || insertParam.getTraceToNumber() > zslTrace.get(0).getTraceApplyCount() || insertParam.getTraceFromNumber() > zslTrace.get(0).getTraceApplyCount()) {
                Goods goods = goodsMapper.selectByPrimaryKey(insertParam.getTraceGoodId());
                if (goods != null) {
                    return goods.getGoodsName() + "的编码不在申请数量范围内";
                }
            }
            if (insertParam.getTraceToNumber() < insertParam.getTraceFromNumber()) {
                Goods goods = goodsMapper.selectByPrimaryKey(insertParam.getTraceGoodId());
                if (goods != null) {
                    return goods.getGoodsName() + "的起始编码必须小于结束编码";
                }
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
        String is_deliver = redisService.get("Deliver_"+traceRecordPointParam.getTraceCodeNumber());
        if(StringUtils.isNotBlank(is_deliver)){
            return -12; //该批次正在发货中。。。,请稍后再试
        }
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

        //获取业务id和业务类型
        int accountId = 0;
        if (traceRecordPointParam.getAccountId() == -1) {
            //其他商家
            if (traceRecordPointParam.getOtherMerchant() == null) {
                return -9;//流通节点信息不能为空
            }
            Integer nodeAccountId = insertPointNodeAccount(traceRecordPointParam.getOtherMerchant());
            if (nodeAccountId == -11) {
                return -10;//节点处理错误(账号插入失败)
            } else if (nodeAccountId == -22) {
                return -11;//节点处理错误
            }
            accountId = nodeAccountId;
        } else {
            if (traceRecordPointParam.getAccountId() == null) {
                return -8;//流通节点错误
            }
            accountId = traceRecordPointParam.getAccountId();
        }

        IntegralDeductRatio integralDeductRatio = integralDeductRatioMapper.selectByPrimaryKey(IntegralEnum.INTEGRAL_DECUCT_RATIO_TYPE_2.getId());
        //需要扣除的积分
        Integer needCoin = Integer.parseInt((integralDeductRatio.getIntegralRatio() * (traceRecordPointParam.getTracePointToNumber() - traceRecordPointParam.getTracePointFromNumber() + 1)) + "");

        Merchant merchant = merchantMapper.selectByPrimaryKey(zslTrace.get(0).getTraceBusinessId());
        if (merchant.getMerchantCoin() - (needCoin) < 0) {
            return -4; // 积分不够，请进行充值
        }
        //摊位id，如果有则为摊位id，没有则为-1（代表非农贸）

        //MerchantStall merchantStall = merchantStallMapper.selectByPrimaryKey(traceRecordPointParam.getTraceStallId());
        MerchantStall merchantStall = null;
        if (merchantStall == null) {
            traceRecordPointParam.setTraceStallId(-1);
        }
        ZslTracePoint zslTracePoint = new ZslTracePoint();
        BeanUtils.copyProperties(traceRecordPointParam, zslTracePoint);
        zslTracePoint.setTracePointTime(new Date());
        zslTracePoint.setTracePointAccountId(accountId);
        MerchantPointDto merchantPointDto = getCirculateNodeInfo(accountId);
        if(merchantPointDto != null){
            zslTracePoint.setTracePointName(merchantPointDto.getTracePointName());
        }
       /* int i = zslTracePointMapper.insert(zslTracePoint);
        if (i < 0) {
            return -5;//追溯插入失败
        }*/

      /*  Merchant merchantUdate = new Merchant();
        merchantUdate.setMerchantId(zslTrace.get(0).getTraceBusinessId());
        merchantUdate.setMerchantCoin(merchant.getMerchantCoin() - needCoin);
        int update = merchantMapper.updateByPrimaryKeySelective(merchantUdate);
        if (update < 0) {
            return -6; //积分扣除失败
        }*/
        //扣除积分

       /* IntegralLog integralLog = new IntegralLog();
        integralLog.setDeductIntegral(Integer.parseInt((integralDeductRatio.getIntegralRatio() * (traceRecordPointParam.getTracePointToNumber() - traceRecordPointParam.getTracePointFromNumber() + 1)) + ""));//当前扣除的积分
        integralLog.setFunctionId(zslTracePoint.getTracePointId());//操作业务主键id
        integralLog.setFunctionType(ServiceEnum.INSERT_TRACE_POINT.getId());
        integralLog.setMerchantId(zslTrace.get(0).getTraceBusinessId());//商家id
        integralLog.setDeductStatus(2);//已经扣减
        integralLog.setCreateTime(new Date());//创建时间
        integralLog.setDeductTime(new Date()); //扣减时间
        int integLogInsert = integralLogMapper.insert(integralLog);*/
        int integLogInsert = 1;
        if (integLogInsert > 0) {
            //发送关联的内码
            List<String> codeNumberList = zslTraceSubcodeDao.selectSubCodeByRange(new Long(traceRecordPointParam.getTracePointFromNumber()+""),new Long(traceRecordPointParam.getTracePointToNumber()+""),traceRecordPointParam.getTraceCodeNumber());
            if(!CollectionUtils.isEmpty(codeNumberList)){
                //新开一个线程去发货关联的内码
                DeliverGoods deliverGoods = new DeliverGoods();
                deliverGoods.setAccountId(accountId);
                deliverGoods.setCodeNumber(codeNumberList);
                deliverGoods.setMode(2);
                new DeliverThread(deliverGoods,traceRecordPointParam.getTraceCodeNumber()).start();
                redisService.set("Deliver_"+traceRecordPointParam.getTraceCodeNumber(),"true");
                redisService.expire("Deliver_"+traceRecordPointParam.getTraceCodeNumber(),7200);
            }
            return integLogInsert;
        } else {
            return -7;  //积分处理失败
        }

    }

    public Integer insertPointNodeAccount(MerchantPointDto merchantPointDto) {
        RequestContext requestContext = RequestContextMgr.getLocalContext();
        String tokenLogin = requestContext.getToken();
        //String url = "https://zs.cntracechain.com/accountCenter/account/add";
        String url = "http://zs-beta.cntracechain.com/accountCenter/account/add";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("accountName", merchantPointDto.getContactNumber());
        jsonObject.put("realName", merchantPointDto.getPersonInCharge());
        jsonObject.put("accountType", 2);
        jsonObject.put("mobile", merchantPointDto.getContactNumber());
        JSONObject role = new JSONObject();
        role.put("id", RoleEnum.ROLE_BUSINESS_NODE.getId());
        jsonObject.put("role", role);
        String token = tokenLogin;
        String result = HttpClientUtil.doPostJson(url, jsonObject.toJSONString(), token);
        try {
            JSONObject resultJson = JSON.parseObject(result);
            int statusCode = Integer.parseInt(resultJson.get("statusCode").toString());
            if (statusCode - 200 == 0) {
                //更新
                String mobile = merchantPointDto.getContactNumber();
                MerchantPointDto merchantPointUpdate = merchantDao.getOtherPointByMobile(mobile);
                merchantDao.updatePointNodeByAccountId(merchantPointUpdate.getAccountId(), merchantPointDto.getTracePointName());
                return merchantPointUpdate.getAccountId();
            } else {
                return -11;//节点处理错误(账号插入失败)
            }
        } catch (Exception e) {
            return -22;//节点处理错误
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
        if ("N".equals(zslTrace.get(0).getTraceBack3())) {
            return -2;//追溯码还未生成完
        }
        //创建导出数据
        Long count = zslTrace.get(0).getTraceApplyCount();
        Workbook workbook = null;
        int totalPage = (int) Math.ceil((double) count / 100000);
        for (int currentPage = 1; currentPage <= totalPage; currentPage++) {
            ExportParams params = new ExportParams(null, "sheet" + (currentPage - 1));
            params.setStyle(ExcelStyleUtil.class);
            Long fromIndex = 0L;
            Long toIndex = 0L;
            fromIndex = new Long((currentPage - 1) * 100000 + 1);
            if (currentPage - totalPage == 0) {
                toIndex = count;
            } else {
                toIndex = new Long(currentPage * 100000);
            }
            List<Long> subIds = zslTraceSubcodeDao.exportExcel(fromIndex, toIndex, traceCode);
            List<ExcelTraceCode> list = new ArrayList<>();
            for (Long idItem : subIds) {
                ExcelTraceCode excelTraceCode = new ExcelTraceCode();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("https://scode.cntracechain.com/#/Produce?SID=");
                stringBuffer.append(idItem);
                excelTraceCode.setCode(stringBuffer.toString());
                list.add(excelTraceCode);
            }
            workbook = ExcelExportUtil.exportBigExcel(params, ExcelTraceCode.class, list);
            Row row = workbook.getSheetAt(0).getRow(0);
            workbook.getSheetAt(0).setColumnWidth(0, 16000);
        }
        ExcelExportUtil.closeExportBigExcel();

        String fileName = "追溯码.xlsx";
        //告诉浏览器下载excel
        try {
            downloadExcel(fileName, workbook, response);
        } catch (Exception e) {
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
            if (goods != null) {
                return goods.getGoodsName() + "的编码不在夫编码范围内";
            }
        }
        if (traceRecordPointParam.getTracePointFromNumber() > traceRecordPointParam.getTracePointToNumber()) {
            Goods goods = goodsMapper.selectByPrimaryKey(traceRecordPointParam.getTraceGoodsId());
            if (goods != null) {
                return goods.getGoodsName() + "的起始编码必须小于结束编码";
            }
        }

        for (int j = traceRecordPointParam.getTracePointFromNumber(); j <= traceRecordPointParam.getTracePointToNumber(); j++) {
            if (!codePointSet.add(j)) {
                return "编码已经被使用过";
            }
        }
        return result;
    }

    @Override
    public Object getTraceScanCountAndYest(Integer companyId) {
        Map<String, Object> result = new HashMap<>();

        Long totalScanCount = zslTraceDao.selectScanTotalCount(companyId);
        Long yestScanCount = zslTraceDao.selectScanYestCount(companyId);
        result.put("totalScanCount", totalScanCount);
        result.put("yestScanCount", yestScanCount);
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
                    String startDate = DateUtil.DateToString(DateUtil.getFirstDayOfMonth1(i), "yyyy-MM-dd HH:mm:ss");
                    String endDate = DateUtil.DateToString(DateUtil.getLastDayOfMonth1(i), "yyyy-MM-dd HH:mm:ss");
                    List<ZslTraceVo> yestCount = zslTraceDao.getChartData(companyId, startDate, endDate);
                    for (ZslTraceVo zslTraceyYest : yestCount) {
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
                    String startDate = DateUtil.DateToString(DateUtil.getStart(itemDate), "yyyy-MM-dd HH:mm:ss");
                    String endDate = DateUtil.DateToString(DateUtil.getEnd(itemDate), "yyyy-MM-dd HH:mm:ss");
                    List<ZslTraceVo> yestCount = zslTraceDao.getChartData(companyId, startDate, endDate);
                    for (ZslTraceVo zslTraceyYest : yestCount) {
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
                    String startDate = DateUtil.DateToString(DateUtil.getFirstDayOfMonth1(i), "yyyy-MM-dd HH:mm:ss");
                    String endDate = DateUtil.DateToString(DateUtil.getLastDayOfMonth1(i), "yyyy-MM-dd HH:mm:ss");
                    List<ZslTraceVo> yestCount = zslTraceDao.getChartData(companyId, startDate, endDate);
                    for (ZslTraceVo zslTraceyYest : yestCount) {
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
                    String startDate = DateUtil.DateToString(DateUtil.getStart(itemDate), "yyyy-MM-dd HH:mm:ss");
                    String endDate = DateUtil.DateToString(DateUtil.getEnd(itemDate), "yyyy-MM-dd HH:mm:ss");
                    List<ZslTraceVo> yestCount = zslTraceDao.getChartData(companyId, startDate, endDate);
                    for (ZslTraceVo zslTraceyYest : yestCount) {
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
                    String startDate = DateUtil.DateToString(DateUtil.getFirstDayOfMonth1(i), "yyyy-MM-dd HH:mm:ss");
                    String endDate = DateUtil.DateToString(DateUtil.getLastDayOfMonth1(i), "yyyy-MM-dd HH:mm:ss");
                    List<ZslTraceVo> yestCount = zslTraceDao.getChartData(companyId, startDate, endDate);
                    for (ZslTraceVo zslTraceyYest : yestCount) {
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
                    String startDate = DateUtil.DateToString(DateUtil.getStart(itemDate), "yyyy-MM-dd HH:mm:ss");
                    String endDate = DateUtil.DateToString(DateUtil.getEnd(itemDate), "yyyy-MM-dd HH:mm:ss");
                    List<ZslTraceVo> yestCount = zslTraceDao.getChartData(companyId, startDate, endDate);
                    for (ZslTraceVo zslTraceyYest : yestCount) {
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
                MerchantStall merchantStall = null;
               // MerchantStall merchantStall = merchantStallMapper.selectByPrimaryKey(traceRecordVo.getTraceStallId());
                if (merchantStall != null) {
                    traceRecordVo.setTraceStallName("");//摊位名称
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
        for (ZslTracePoint zslTracePoint : zslTracePointList) {
            if (goodsId.add(zslTracePoint.getTraceGoodsId())) {
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
    public CommonResult relationOutCode(String outCode, List<String> subCodeList) {
        ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectBySubCode(outCode);
        ZslTraceSubcode updateLevel = new ZslTraceSubcode();
        Set<String> traceCodeNumberSet = new HashSet<>();
        if (zslTraceSubcode == null) {
            return CommonResult.failed("外码不存在");
        } else if ("Y".equals(zslTraceSubcode.getIsLeaf())) {
            return CommonResult.failed("该码还不是外码");
        }

        if (CollectionUtils.isEmpty(subCodeList)) {
            return CommonResult.failed("没有新的子码,请点击关联子码添加新的子码");
        }

        //判断是否发过货
        List<String> codeList = new ArrayList<>();
        codeList.add(zslTraceSubcode.getTraceSubCodeNumber());
        if (isDeliverGoods(codeList)) {
            return CommonResult.failed("该码已经发过货,不能再关联"); //该码已经发过货
        }

        Integer nodeLevel = 1;
        List<TraceOutCodeUpdateParam> traceOutCodeUpdateParams = new ArrayList<>();
        List<String> errorCode = new ArrayList<>();
        for (String subCode : subCodeList) {
            ZslTraceSubcode zslTraceSubcodeItem = zslTraceSubcodeDao.selectBySubCode(subCode);
            if (zslTraceSubcodeItem == null) {
                errorCode.add(subCode);
                continue;
            }
            if (outCode.equals(subCode)) {
                return CommonResult.failed("不能关联自己");
            }
            //判断是否循环关联
            if (zslTraceSubcode.getParentId() != null && zslTraceSubcode.getParentId() - zslTraceSubcodeItem.getId() == 0) {
                return CommonResult.failed("不能循环关联");
            }
            traceCodeNumberSet.add(zslTraceSubcodeItem.getTraceCodeNumber());
            //关联子码
            if (zslTraceSubcodeItem.getNodeLevel() > nodeLevel) {
                nodeLevel = zslTraceSubcodeItem.getNodeLevel();
            }
            TraceOutCodeUpdateParam traceOutCodeUpdateParam = new TraceOutCodeUpdateParam();
            traceOutCodeUpdateParam.setParentId(zslTraceSubcode.getId());
            traceOutCodeUpdateParam.setId(zslTraceSubcodeItem.getId());
            traceOutCodeUpdateParams.add(traceOutCodeUpdateParam);
        }
        if (errorCode.size() > 0) {
            return CommonResult.failed(errorCode, "以下内码或外码不存在");
        }
        if (traceCodeNumberSet.size() >= 2) {
            return CommonResult.failed("只能关联同一个批次号的编码");
        }

        updateLevel.setId(zslTraceSubcode.getId());
        updateLevel.setNodeLevel(nodeLevel + 1);
        Iterator<String> it = traceCodeNumberSet.iterator();
        if (it.hasNext())
            updateLevel.setTraceCodeNumber(it.next());
        if (!isBussiSelf(updateLevel.getTraceCodeNumber())) {
            return CommonResult.failed("只能操作自己追溯码");
        }
        int i = zslTraceSubcodeDao.updateOutCodeBatch(traceOutCodeUpdateParams);
        zslTraceSubcodeMapper.updateByPrimaryKeySelective(updateLevel);
        return CommonResult.success("关联成功");
    }

    @Override
    public int changeOutCode(String outCode) {
        ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectBySubCode(outCode);
        if (zslTraceSubcode == null) {
            return -3;//编码不存在
        }
        if (!isBussiSelf(zslTraceSubcode.getTraceCodeNumber())) {
            return -6; //只能操作自己追溯码
        }
        if ("N".equals(zslTraceSubcode.getIsLeaf())) {
            return -1;//该码已经为外码
        }
        List<ZslTracePoint> tracePointList = zslTraceSubcodeDao.selectTracePointNodes(zslTraceSubcode.getTraceGoodId(), zslTraceSubcode.getTraceIndex(), zslTraceSubcode.getTraceCodeNumber());
        if (tracePointList.size() - 1 > 0) {
            return -5;//该码已经发过货了
        }
        ZslTraceSubcode update = new ZslTraceSubcode();
        update.setId(zslTraceSubcode.getId());
        update.setIsLeaf("N");
        int i = zslTraceSubcodeMapper.updateByPrimaryKeySelective(update);
        if (i < 0) {
            return -2;
        }
        return i;
    }

    //判断编码是否存在
    public boolean isCodeExist(OutCodeBatch outCodeBatch) {
        Long countBeTweenOut = zslTraceSubcodeDao.selectBtweenCount(outCodeBatch.getOutCodeStart(), outCodeBatch.getOutCodeEnd());
        Long countOut = outCodeBatch.getOutCodeEnd() - outCodeBatch.getOutCodeStart() + 1;
        Long countBeTweenIn = zslTraceSubcodeDao.selectBtweenCount(outCodeBatch.getInCodeStart(), outCodeBatch.getInCodeEnd());
        Long countIn = outCodeBatch.getInCodeEnd() - outCodeBatch.getInCodeStart() + 1;
        if (countBeTweenOut - countOut == 0 && countBeTweenIn - countIn == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public CommonResult changOutCodeBatch(OutCodeBatch outCodeBatch) {
        //判断需要转成外码的内码，本身是否为外码
        Set<Long> isRepeat = new HashSet<>();

        boolean isCodeExist = isCodeExist(outCodeBatch);
        //判断编码是否存在
        if (!isCodeExist) {
            return CommonResult.failed("编号不存在");
        }

        if (!isBussiSelf1(outCodeBatch.getOutCodeStart(), outCodeBatch.getOutCodeEnd())) {
            return CommonResult.failed("编号已经发过货或已经是外码或不是自己编码");
        }

        if (!isBussiSelf1(outCodeBatch.getInCodeStart(), outCodeBatch.getInCodeEnd())) {
            return CommonResult.failed("编号已经发过货或已经是外码或不是自己编码");
        }

        for (Long i = outCodeBatch.getOutCodeStart(); i <= outCodeBatch.getOutCodeEnd(); i++) {
            if (!isRepeat.add(i)) {
                return CommonResult.failed("编号不能交叉");
            }
        }

        for (Long m = outCodeBatch.getInCodeStart(); m <= outCodeBatch.getInCodeEnd(); m++) {
            if (!isRepeat.add(m)) {
                return CommonResult.failed("编号不能交叉");
            }
        }

        //进行内码转外码
        List<TraceOutCodeUpdateParam> traceOutCodeUpdateParams = new ArrayList<>();
        List<TraceOutCodeUpdateParam> traceOutCodeUpdateParamParent = new ArrayList<>();
        List<ZslTraceSubcode> outCodeList = zslTraceSubcodeDao.selectBetweenAllRecord(outCodeBatch.getOutCodeStart(),outCodeBatch.getOutCodeEnd());
        List<ZslTraceSubcode> inCodeList = zslTraceSubcodeDao.selectBetweenAllRecord(outCodeBatch.getInCodeStart(),outCodeBatch.getInCodeEnd());
        if(CollectionUtil.isEmpty(outCodeList) || CollectionUtil.isEmpty(inCodeList) || (outCodeList.size() - inCodeList.size() != 0)){
            return CommonResult.failed("数据处理错误");
        }
        int size = outCodeList.size();
        for(int i = 0;i < size;i++){
            //关联外码
            TraceOutCodeUpdateParam traceOutCodeUpdateParam = new TraceOutCodeUpdateParam();
            traceOutCodeUpdateParam.setId(inCodeList.get(i).getId());
            traceOutCodeUpdateParam.setParentId(outCodeList.get(i).getId());
            traceOutCodeUpdateParams.add(traceOutCodeUpdateParam);

            //修改为外码
            TraceOutCodeUpdateParam updateParent = new TraceOutCodeUpdateParam();
            updateParent.setId(outCodeList.get(i).getId());
            updateParent.setNodeLevel(outCodeList.get(i).getNodeLevel() + 1);
            traceOutCodeUpdateParamParent.add(updateParent);
        }

        new UpdateOutCodeIdThread(traceOutCodeUpdateParamParent).start();
        new UpdateOutRelaThread(traceOutCodeUpdateParams).start();
        return CommonResult.success("正在努力为您转码中。。。");
    }

    public int directDeliver(ZslTraceSubcode zslTraceSubcode, Integer accountId, Integer businessId, Integer mode) {
       int result = 0;
        //直接发货
        ZslTracePoint zslTracePoint = new ZslTracePoint();
        zslTracePoint.setTraceStallId(-1);
        zslTracePoint.setTraceGoodsId(zslTraceSubcode.getTraceGoodId());
        zslTracePoint.setTraceCodeNumber(zslTraceSubcode.getTraceCodeNumber());
        zslTracePoint.setTracePointAccountId(accountId); //账号id
        zslTracePoint.setTracePointTime(new Date());
        MerchantPointDto merchantPointDto = getCirculateNodeInfo(accountId);
        if(merchantPointDto != null){
            zslTracePoint.setTracePointName(merchantPointDto.getTracePointName());
        }
        //下标
        int traceIndex = Integer.parseInt(zslTraceSubcode.getTraceIndex().toString());
        //根据追溯码和编号查询父节点 商品id
        ZslTracePoint parent = zslTraceRecordDao.getTracePointBy(zslTraceSubcode.getTraceGoodId(),zslTraceSubcode.getTraceIndex(),zslTraceSubcode.getTraceCodeNumber());
        if(parent == null){
            result = -1;
        }
        zslTracePoint.setTracePointToNumber(traceIndex);
        zslTracePoint.setTracePointFromNumber(traceIndex);
        zslTracePoint.setTraceParentId(parent.getTracePointId());

        if (mode == 2) {
            //流通节点
            deliverList.add(zslTracePoint);
            result = 1;
        } else if (mode == 1) {
            //已经售出
            ZslTraceSubcode updateSale = new ZslTraceSubcode();
            updateSale.setId(zslTraceSubcode.getId());
            updateSale.setIsSaled(1);
            updateSale.setSaleTime(new Date());
            result = zslTraceSubcodeMapper.updateByPrimaryKeySelective(updateSale);
        }
        return result;
    }


    public void getTreeList(List<ZslTraceSubcode> traceSubcodes, Integer accountId, Integer businessId, Integer mode) {
        for (ZslTraceSubcode zslTraceSubcode : traceSubcodes) {
            if ("Y".equals(zslTraceSubcode.getIsLeaf())) {
                directDeliver(zslTraceSubcode, accountId, businessId, mode);
            } else {
                List<ZslTraceSubcode> children = zslTraceSubcodeDao.selectByParenId(zslTraceSubcode.getId());
                getTreeList(children, accountId, businessId, mode);
            }
        }
    }

    public boolean checkCode(List<ZslTraceSubcode> traceSubcodes) {
        for (ZslTraceSubcode zslTraceSubcode : traceSubcodes) {
            if ("Y".equals(zslTraceSubcode.getIsLeaf())) {
            } else {
                List<ZslTraceSubcode> children = zslTraceSubcodeDao.selectByParenId(zslTraceSubcode.getId());
                if (CollectionUtils.isEmpty(children)) {
                    return false;
                }
            }
        }
        return true;
    }

    //判断是否为商家得批次号
    public boolean isBussiSelf1(Long start, Long end) {
        //获取用户登录信息
        RequestContext requestContext = RequestContextMgr.getLocalContext();
        JSONObject loginUser = requestContext.getJsonObject();
        Integer accountType = Integer.parseInt(loginUser.get("accountType").toString());
        int merchantId = 0;
        String roleName = (loginUser.getJSONObject("role").get("roleName")).toString();
        if (accountType == 2) {
            if ((RoleEnum.ROLE_BUSINESS.getValue()).equals(roleName) || (RoleEnum.ROLE_BUSINESS_STAFF.getValue()).equals(roleName)) {
                //商家
                merchantId = Integer.parseInt((loginUser.getJSONObject("merchant").get("merchantId")).toString());
                Long countOnly = zslTraceSubcodeDao.onlyMyselfCode(start, end, merchantId);
                if (countOnly - (end - start + 1) == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        return true;
    }


    //判断是否为商家得批次号
    public boolean isBussiSelf(String traceCodeNumber) {
        //获取用户登录信息
        RequestContext requestContext = RequestContextMgr.getLocalContext();
        JSONObject loginUser = requestContext.getJsonObject();
        Integer accountType = Integer.parseInt(loginUser.get("accountType").toString());
        int merchantId = 0;
        String roleName = (loginUser.getJSONObject("role").get("roleName")).toString();
        if (accountType == 2) {
            if ((RoleEnum.ROLE_BUSINESS.getValue()).equals(roleName)) {
                //商家
                merchantId = Integer.parseInt((loginUser.getJSONObject("merchant").get("merchantId")).toString());
            } else {
                return true;
            }

        }
        ZslTraceExample zslTraceExample = new ZslTraceExample();
        ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
        List<ZslTrace> traces = zslTraceMapper.selectByExample(zslTraceExample);
        if (!CollectionUtils.isEmpty(traces)) {
            if (traces.get(0).getTraceBusinessId() - merchantId == 0) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    //判断是否发过货(不需要)
    public boolean isDeliverGoods(List<String> codeList) {
        boolean result = false;
        for (int i = 0; i < codeList.size(); i++) {
            ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectBySubCode(codeList.get(i));
            // 是否为内码
            if ("Y".equals(zslTraceSubcode.getIsLeaf())) {
                result = hasTracePoint(zslTraceSubcode);
            } else {
                List<ZslTraceSubcode> digui = new ArrayList<>();
                digui.add(zslTraceSubcode);
                result = getChildTracePoint(digui);
            }
        }
        return result;
    }

    public boolean getChildTracePoint(List<ZslTraceSubcode> zslTraceSubcodeList) {
        boolean result = false;
        for (ZslTraceSubcode zslTraceSubcode : zslTraceSubcodeList) {
            if ("Y".equals(zslTraceSubcode.getIsLeaf())) {
                result = hasTracePoint(zslTraceSubcode);
            } else {
                List<ZslTraceSubcode> children = zslTraceSubcodeDao.selectByParenId(zslTraceSubcode.getId());
                result = getChildTracePoint(children);
            }
        }
        return result;
    }

    public boolean hasTracePoint(ZslTraceSubcode zslTraceSubcode) {
        List<ZslTracePoint> tracePointList = zslTraceSubcodeDao.selectTracePointNodes(zslTraceSubcode.getTraceGoodId(), zslTraceSubcode.getTraceIndex(), zslTraceSubcode.getTraceCodeNumber());
        if (tracePointList.size() - 1 > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int deliverGoods(DeliverGoods deliverGoods) {
        deliverList = new ArrayList<>();
        List<String> codeList = deliverGoods.getCodeNumber();
        int result = -1;

        if (CollectionUtils.isEmpty(deliverGoods.getCodeNumber())) {
            return -5; //发货码为空
        }

        countIntegral = 0;
        String traceCodeNumber = "";
        for (String subCode : codeList) {
            ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectBySubCode(subCode);
           /* if (!isBussiSelf(zslTraceSubcode.getTraceCodeNumber())) {
                return -6; //只能操作自己追溯码
            } else {
                traceCodeNumber = zslTraceSubcode.getTraceCodeNumber();
                countCodeIntegral(zslTraceSubcode);
            }*/
            traceCodeNumber = zslTraceSubcode.getTraceCodeNumber();
            countCodeIntegral(zslTraceSubcode);
        }

        //判断积分够不够扣除
        ZslTraceExample zslTraceExample = new ZslTraceExample();
        ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
        List<ZslTrace> zslTrace = zslTraceMapper.selectByExample(zslTraceExample);
        if (CollectionUtils.isEmpty(zslTrace)) {
            return -8; //追溯码不存在
        }
        //判断积分是否够
        if (!hasIntegral(zslTrace.get(0), countIntegral)) {
            return -7; //积分不够，请进行充值
        }

        int accountId = 0;
        if (deliverGoods.getAccountId() == -1) {
            //其他商家
            if (deliverGoods.getOtherMerchant() == null) {
                return -9;//流通节点信息不能为空
            }
            Integer nodeAccountId = insertPointNodeAccount(deliverGoods.getOtherMerchant());
            if (nodeAccountId == -11) {
                return -11;//节点处理错误(账号插入失败)
            } else if (nodeAccountId == -22) {
                return -12;//节点处理错误
            }
            accountId = nodeAccountId;
        } else {
            if (deliverGoods.getAccountId() == null) {
                return -10;//流通节点错误
            }
            accountId = deliverGoods.getAccountId();
        }


        for (int i = 0; i < codeList.size(); i++) {
            ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectBySubCode(codeList.get(i));
            // 是否为内码
            if ("Y".equals(zslTraceSubcode.getIsLeaf())) {
                result = directDeliver(zslTraceSubcode, accountId, zslTrace.get(0).getTraceBusinessId(), deliverGoods.getMode());
            } else {
                List<ZslTraceSubcode> digui = new ArrayList<>();
                if (StringUtils.isBlank(zslTraceSubcode.getTraceCodeNumber())) {
                    return -2; //外码还没有关联内码
                }
                digui.add(zslTraceSubcode);
                if (!checkCode(digui)) {
                    return -3; //请先关联内码
                }
                getTreeList(digui, accountId, zslTrace.get(0).getTraceBusinessId(), deliverGoods.getMode());
                result = 1;
            }
        }

        //合并插入追溯点
        Map<Integer, List<ZslTracePoint>> map = NumberConverUtil.groupBillingDataByExcpBatchCode(deliverList);
        for(Integer key:map.keySet()){
            List<ZslTracePoint> groupPoints = map.get(key);
            Set<Integer> groupSet =  groupPoints.stream()
                                                .map(p -> p.getTracePointFromNumber())
                                                .collect(Collectors.toSet());
            //获取基础追溯信息
            ZslTracePoint baseZslPoint = null;
            for(ZslTracePoint zslTracePoint : deliverList){
                if(zslTracePoint.getTraceParentId() - key == 0){
                    baseZslPoint = zslTracePoint;
                    break;
                }
            }

            List<String> pointStrs = NumberConverUtil.getConvertNum(groupSet);
            for(String pstr : pointStrs){
                ZslTracePoint insertP = new ZslTracePoint();
                BeanUtils.copyProperties(baseZslPoint,insertP);
                Integer fromNumber = Integer.parseInt(pstr.split("-")[0]);
                Integer toNumber = Integer.parseInt(pstr.split("-")[1]);
                insertP.setTracePointFromNumber(fromNumber);
                insertP.setTracePointToNumber(toNumber);
                zslTracePointMapper.insert(insertP);
                deductDeliverIntegral(toNumber - fromNumber + 1,insertP.getTracePointId(),zslTrace.get(0).getTraceBusinessId());
            }
        }


        return result;
    }


    public boolean deductDeliverIntegral(Integer deductIntegral, Integer tracePointId, Integer businessId) {
        Merchant merchant = merchantMapper.selectByPrimaryKey(businessId);
        Merchant merchantUdate = new Merchant();
        merchantUdate.setMerchantId(businessId);
        merchantUdate.setMerchantCoin(merchant.getMerchantCoin() - deductIntegral);
        int update = merchantMapper.updateByPrimaryKeySelective(merchantUdate);
        if (update < 0) {
            return false; //积分扣除失败
        }
        //扣除积分
        IntegralLog integralLog = new IntegralLog();
        integralLog.setDeductIntegral(deductIntegral);//当前扣除的积分
        integralLog.setFunctionId(tracePointId);//操作业务主键id
        integralLog.setFunctionType(ServiceEnum.INSERT_TRACE_POINT.getId());
        integralLog.setMerchantId(businessId);//商家id
        integralLog.setDeductStatus(2);//已经扣减
        integralLog.setCreateTime(new Date());//创建时间
        integralLog.setDeductTime(new Date()); //扣减时间
        int integLogInsert = integralLogMapper.insert(integralLog);
        if (integLogInsert > 0) {
            return true;
        } else {
            return false;  //积分处理失败
        }
    }


    public boolean hasIntegral(ZslTrace trace, Integer deductIntegral) {


        IntegralDeductRatio integralDeductRatio = integralDeductRatioMapper.selectByPrimaryKey(IntegralEnum.INTEGRAL_DECUCT_RATIO_TYPE_2.getId());
        //需要扣除的积分
        Integer needCoin = Integer.parseInt((integralDeductRatio.getIntegralRatio() * deductIntegral) + "");
        Merchant merchant = merchantMapper.selectByPrimaryKey(trace.getTraceBusinessId());
        if (merchant.getMerchantCoin() - (needCoin) < 0) {
            return false; // 积分不够，请进行充值
        }
        return true;
    }


    @Override
    public int insertScanRecord(ScanRecordInsertParam scanRecordInsertParam) {
        ZslScanRecord zslScanRecord = new ZslScanRecord();
        zslScanRecord.setScanAddress(scanRecordInsertParam.getScanAddress());
        zslScanRecord.setSid(scanRecordInsertParam.getSid());
        if (scanRecordInsertParam.getScanTime() != null && StringUtils.isNotBlank(scanRecordInsertParam.getScanTime().toString())) {
            zslScanRecord.setScanTime(new Date(scanRecordInsertParam.getScanTime()));
        } else {
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
        for (ZslScanRecord zslScanRecord : scanRecordList) {
            ScanRecordQueryParam scanRecordQueryParam = new ScanRecordQueryParam();
            scanRecordQueryParam.setScanAddress(zslScanRecord.getScanAddress());
            if (zslScanRecord.getScanTime() != null) {
                scanRecordQueryParam.setScanTime(DateUtil.DateToString(zslScanRecord.getScanTime(), "yyyy-MM-dd HH:mm:ss"));
            } else {
                scanRecordQueryParam.setScanTime("");
            }
            result.add(scanRecordQueryParam);
        }
        result = result.stream().sorted((s1, s2) -> DateUtil.compare(s1.getScanTime(), s2.getScanTime())).collect(Collectors.toList());
        return result;
    }


    @Override
    public CommonResult getTraceGoodInfo(Long sid, HttpServletRequest request) {
        ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectById(sid);
        if (zslTraceSubcode != null && "Y".equals(zslTraceSubcode.getIsLeaf())) {
            if (zslTraceSubcode.getTraceGoodId() == null) {
                return CommonResult.failed("该追溯码尚未录入信息");
            }

            //扣除商家积分
            IntegralDeductRatio integralDeductRatio = integralDeductRatioMapper.selectByPrimaryKey(IntegralEnum.INTEGRAL_DECUCT_RATIO_TYPE_5.getId());
            ZslTraceExample zslTraceExample = new ZslTraceExample();
            ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
            criteria.andTraceCodeNumberEqualTo(zslTraceSubcode.getTraceCodeNumber());
            List<ZslTrace> zslTraceList = zslTraceMapper.selectByExample(zslTraceExample);
            if (CollectionUtils.isEmpty(zslTraceList)) {
                return CommonResult.failed("追溯码错误");
            }
            int needCoin = Integer.parseInt(integralDeductRatio.getIntegralRatio() + "");
            if (zslTraceSubcode.getScanCount() == 0) {
                Merchant merchant = merchantMapper.selectByPrimaryKey(zslTraceList.get(0).getTraceBusinessId());
                Merchant merchantUdate = new Merchant();
                merchantUdate.setMerchantId(zslTraceList.get(0).getTraceBusinessId());
                merchantUdate.setMerchantCoin(merchant.getMerchantCoin() - needCoin);
                int update = merchantMapper.updateByPrimaryKeySelective(merchantUdate);
            } else {
                needCoin = 0;
            }
            //扣除积分
            CodeTraceIntegralLog integralLog = new CodeTraceIntegralLog();
            integralLog.setDeductIntegral(needCoin);//当前扣除的积分
            integralLog.setFunctionId(Integer.parseInt(zslTraceSubcode.getId() + ""));//操作业务主键id
            integralLog.setMerchantId(zslTraceList.get(0).getTraceBusinessId());//商家id
            integralLog.setDeductStatus(2);//已经扣减
            integralLog.setCreateTime(new Date());//创建时间
            integralLog.setDeductTime(new Date()); //扣减时间
            int integLogInsert = codeTraceIntegralLogMapper.insert(integralLog);

            //更新扫码次数
            ZslTraceSubcode updateScanCount = new ZslTraceSubcode();
            updateScanCount.setId(zslTraceSubcode.getId());
            updateScanCount.setScanCount(zslTraceSubcode.getScanCount() + 1);
            zslTraceSubcodeMapper.updateByPrimaryKeySelective(updateScanCount);

            Map<String, Object> result = new HashMap<>();
            //没有被扫过的
            Long notScannedCount = zslTraceSubcodeDao.goodsScanCount(zslTraceSubcode.getTraceGoodId(), zslTraceSubcode.getTraceCodeNumber(),zslTraceSubcode.getTraceIndex());
            // 总共的
            Long TotalCount = zslTraceSubcodeDao.goodsTotalCount(zslTraceSubcode.getTraceGoodId(), zslTraceSubcode.getTraceCodeNumber(),zslTraceSubcode.getTraceIndex());
            String traceCode = zslTraceSubcode.getTraceSubCodeNumber();
            // 第几次扫码
            Long scanCount = zslTraceSubcode.getScanCount() + 1;
            //追溯信息（流通环节信息）
            List<ScanPointQueryParam> tracePointNodes = new ArrayList<>();
            List<ZslTracePoint> tracePointList = zslTraceSubcodeDao.selectTracePointNodes(zslTraceSubcode.getTraceGoodId(), zslTraceSubcode.getTraceIndex(), zslTraceSubcode.getTraceCodeNumber());
            for (ZslTracePoint zslTracePoint : tracePointList) {
                ScanPointQueryParam scanPointQueryParam = new ScanPointQueryParam();
                MerchantPointDto merchantPointDto = getCirculateNodeInfoDiffAgent(zslTracePoint.getTracePointAccountId());
                if (merchantPointDto == null) {
                    scanPointQueryParam.setTracePointName(zslTracePoint.getTracePointName());
                } else {
                    scanPointQueryParam.setTracePointName(merchantPointDto.getTracePointName());
                    scanPointQueryParam.setContactNumber(merchantPointDto.getContactNumber());
                    scanPointQueryParam.setDetailAddress(merchantPointDto.getDetailAddress());
                    scanPointQueryParam.setPersonInCharge(merchantPointDto.getPersonInCharge());
                }

                if (zslTracePoint.getTracePointTime() != null) {
                    scanPointQueryParam.setTracePointTime(DateUtil.DateToString(zslTracePoint.getTracePointTime(), "yyyy-MM-dd HH:mm:ss"));
                } else {
                    scanPointQueryParam.setTracePointTime("");
                }
                tracePointNodes.add(scanPointQueryParam);
            }
            //首次查询时间和地点
            List<ScanRecordQueryParam> scanList = getScanRecordBySid(sid);
            if(CollectionUtils.isEmpty(scanList)){
                result.put("firstScan","");
            }else{
                result.put("firstScan",scanList.get(scanList.size() - 1));
            }
            //哈希值
            String hashcode = CryptoUtil.calculateHash(zslTraceSubcode.getTraceSid(),zslTraceSubcode.getTraceCodeNumber());
            result.put("hashcode", hashcode);
            //所在区块
            String block = TraceCodeUtil.generateBlock(zslTraceSubcode.getTraceCodeNumber(),TotalCount);
            result.put("block", block);
            //生产环节信息
            ZslTraceRecord zslTraceRecord = zslTraceRecordDao.selectRecordForProduct(zslTraceSubcode.getTraceGoodId(), zslTraceSubcode.getTraceIndex(), zslTraceSubcode.getTraceCodeNumber());
            if (zslTraceRecord == null) {
                result.put("productionInfo", "");
            } else {
                //根据记录id查询生产环节
                ZslTraceProductionLinkExample zslTraceProductionLinkExample = new ZslTraceProductionLinkExample();
                ZslTraceProductionLinkExample.Criteria criteria1 = zslTraceProductionLinkExample.createCriteria();
                criteria1.andTraceRecodeIdEqualTo(zslTraceRecord.getTraceRecordId());
                List<ZslTraceProductionLink> productionLinkList = zslTraceProductionLinkMapper.selectByExample(zslTraceProductionLinkExample);
                if (CollectionUtil.isEmpty(productionLinkList)) {
                    result.put("productionInfo", new ArrayList<>());
                } else {
                    List<ProductionLinkVo> productionInfo = new ArrayList<>();
                    for (ZslTraceProductionLink pItem : productionLinkList) {
                        ProductionLinkVo productionLinkVo = new ProductionLinkVo();
                        productionLinkVo.setProductionDescripe(pItem.getProductionDescripe());
                        productionLinkVo.setProductionMan(pItem.getProductionMan());
                        productionLinkVo.setProductionName(pItem.getProductionName());
                        productionLinkVo.setProductionTime(DateUtil.DateToString(pItem.getProductionTime(), "yyyy-MM-dd HH:mm:ss"));
                        List<String> productPicList = new ArrayList<>();
                        ZslProductionImageExample zslProductionImageExample = new ZslProductionImageExample();
                        ZslProductionImageExample.Criteria criteria2 = zslProductionImageExample.createCriteria();
                        criteria2.andProductionIdEqualTo(pItem.getId());
                        zslProductionImageExample.setOrderByClause("image_index asc");
                        List<ZslProductionImage> productionImageList = zslProductionImageMapper.selectByExample(zslProductionImageExample);
                        if (CollectionUtil.isEmpty(productionImageList)) {
                            productionLinkVo.setProductionPicList(productPicList);
                        } else {
                            for (ZslProductionImage zslProductionImage : productionImageList) {
                                productPicList.add(zslProductionImage.getImageUrl());
                            }
                            productionLinkVo.setProductionPicList(productPicList);
                        }
                        productionInfo.add(productionLinkVo);
                    }
                    result.put("productionInfo", productionInfo);
                }
            }

            ClientInfo clientInfo = ClientInfoUtil.get(request.getHeader("user-agent"));
            String ip = IpUtil.getRequestIp(request);
            String address = "";
            address = "{\n" +
                    "            \"area\": \"\",\n" +
                    "            \"country\": \"XX\",\n" +
                    "            \"isp_id\": \"local\",\n" +
                    "            \"city\": \"内网IP\",\n" +
                    "            \"ip\": \"" + ip + "\",\n" +
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
            result.put("isSaled", zslTraceSubcode.getIsSaled());
            if (zslTraceSubcode.getIsSaled() - 1 == 0) {
                result.put("saledTime", DateUtil.DateToString(zslTraceSubcode.getSaleTime(), "yyyy-MM-dd HH:mm:ss"));
            } else {
                result.put("saledTime", "");
            }
            result.put("netAndAddressInfo", jsonObject);
            result.put("clientInfo", clientInfo);
            result.put("notScannedCount", notScannedCount);
            result.put("TotalCount", TotalCount);
            result.put("traceCode", traceCode);
            result.put("scanCount", scanCount);
            result.put("tracePointNodes", tracePointNodes);

            return CommonResult.success(result);
        } else {
            return CommonResult.failed("该编码是外码");
        }
    }



    /**
     * 账号id 获取流通节点信息(区分于代理商别名)
     *
     * @param accountId
     */
    public MerchantPointDto getCirculateNodeInfoDiffAgent(int accountId) {
        MerchantPointDto result = null;
        Account account = accountMapper.selectByPrimaryKey(accountId);
        if (account == null) {
            return result;
        }
        if (account.getRoleId().equals(RoleEnum.ROLE_BUSINESS.getId())) {
            result = merchantDao.getMerchantPoint(accountId);
        } else if (account.getRoleId().equals(RoleEnum.ROLE_BUSINESS_STAFF.getId())) {
            result = merchantDao.getEmployPoint(accountId);
        } else if (account.getRoleId().equals(RoleEnum.ROLE_BUSINESS_NODE.getId())) {
            result = merchantDao.getOtherPoint(accountId);
        } else if(account.getRoleId().equals(RoleEnum.ROLE_BUSINESS_AGENT.getId())){
            result = merchantDao.getOtherPointDiffAgent(accountId);
        }
        return result;
    }


    /**
     * 账号id 获取流通节点信息
     *
     * @param accountId
     */
    @Override
    public MerchantPointDto getCirculateNodeInfo(int accountId) {
        MerchantPointDto result = null;
        Account account = accountMapper.selectByPrimaryKey(accountId);
        if (account == null) {
            return result;
        }
        if (account.getRoleId().equals(RoleEnum.ROLE_BUSINESS.getId())) {
            result = merchantDao.getMerchantPoint(accountId);
        } else if (account.getRoleId().equals(RoleEnum.ROLE_BUSINESS_STAFF.getId())) {
            result = merchantDao.getEmployPoint(accountId);
        } else if (account.getRoleId().equals(RoleEnum.ROLE_BUSINESS_NODE.getId()) || account.getRoleId().equals(RoleEnum.ROLE_BUSINESS_AGENT.getId())) {
            result = merchantDao.getOtherPoint(accountId);
        }
        return result;
    }


    @Override
    public CommonResult getSubCodeById(Long sid) {
        count = 0;
        isSaled = 0;
        ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectById(sid);
        if (zslTraceSubcode == null) {
            return CommonResult.failed("编码不存在");
        }

       /* if (!isBussiSelf(zslTraceSubcode.getTraceCodeNumber())) {
            return CommonResult.failed("只能操作自己追溯码");
        }*/

        if (zslTraceSubcode.getTraceGoodId() == null) {
            return CommonResult.failed("请先录入或扣除积分");
        }

        countCode(zslTraceSubcode);
        if (isSaled - 1 == 0) {
            return CommonResult.failed("已售出！");
        }

        ZslTraceSubcodeVo result = new ZslTraceSubcodeVo();
        BeanUtils.copyProperties(zslTraceSubcode, result);
        result.setCount(count);
        List<String> codeList = new ArrayList<>();
        codeList.add(zslTraceSubcode.getTraceSubCodeNumber());
        result.setIsEnable(1); //正常
        return CommonResult.success(result);
    }

    @Override
    public CommonResult getIdByPage(String traceCodeNumber, String traceSubCode) {
        if (StringUtils.isBlank(traceCodeNumber)) {
            return CommonResult.failed("追溯码不能为空");
        }

        ZslTraceExample zslTraceExample = new ZslTraceExample();
        ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
        List<ZslTrace> zslTraceList = zslTraceMapper.selectByExample(zslTraceExample);
        if (CollectionUtils.isEmpty(zslTraceList)) {
            return CommonResult.failed("追溯码不存在");
        }

        List<ZslTraceSubcode> zslTraceSubcodeList = zslTraceSubcodeDao.searchByIndexOrCode(traceSubCode, traceCodeNumber);
        if (CollectionUtils.isEmpty(zslTraceSubcodeList)) {
            return CommonResult.success(null);
        }

        totalSubCode = new ArrayList<>();
        ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeList.get(0);
        searchTreeNode(zslTraceSubcode);

        List<ZslTreeNode> treeNodes = new ArrayList<>();
        for (ZslTraceSubcode item : totalSubCode) {
            ZslTreeNode node = new ZslTreeNode();
            BeanUtils.copyProperties(item, node);
            treeNodes.add(node);
        }
        List<ZslTreeNode> list = null;
        try {
            list = TreeUtils.buildTree(treeNodes, "com.zsl.traceapi.util.ZslTreeNode", "id", "parentId", "children");
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed();
        }
        return CommonResult.success(list);
    }

    @Override
    public CommonResult getTracePointRecordBySid(Long sid) {
        ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeMapper.selectByPrimaryKey(sid);
        List<ZslTracePoint> tracePointList = zslTraceSubcodeDao.selectTracePointNodes(zslTraceSubcode.getTraceGoodId(), zslTraceSubcode.getTraceIndex(), zslTraceSubcode.getTraceCodeNumber());
        Map<String, Object> resultMap = new HashMap<>();
        List<ZslTracePointVo> result = new ArrayList<>();
        String goodsName = "";
        for (ZslTracePoint zslTracePoint : tracePointList) {
            Goods goods = goodsMapper.selectByPrimaryKey(zslTracePoint.getTraceGoodsId());
            if (goods != null) {
                goodsName = goods.getGoodsName();
            }

            ZslTracePointVo resultItem = new ZslTracePointVo();
            MerchantPointDto merchantPointDto = getCirculateNodeInfoDiffAgent(zslTracePoint.getTracePointAccountId());
            if (merchantPointDto == null) {
                resultItem.setTracePointName(zslTracePoint.getTracePointName());
            } else {
                resultItem.setTracePointName(merchantPointDto.getTracePointName());
                resultItem.setContactNumber(merchantPointDto.getContactNumber());
                resultItem.setDetailAddress(merchantPointDto.getDetailAddress());
                resultItem.setPersonInCharge(merchantPointDto.getPersonInCharge());
            }

            if (zslTracePoint.getTracePointTime() != null) {
                resultItem.setTracePointTime(DateUtil.DateToString(zslTracePoint.getTracePointTime(), "yyyy-MM-dd HH:mm:ss"));
            } else {
                resultItem.setTracePointTime("");
            }
            result.add(resultItem);
        }
        resultMap.put("list", result);
        resultMap.put("code", zslTraceSubcode.getTraceSubCodeNumber());
        resultMap.put("goodsName", goodsName);
        return CommonResult.success(resultMap);
    }


    @Override
    public CommonResult getSuCodeByPage1(Integer pageNum, Integer pageSize, String traceCodeNumber) {
        //设置排序，大小，页数
        PageHelper.startPage(pageNum, pageSize, null);
        List<ZslTraceSubcode> itemList = zslTraceSubcodeDao.getSuCodeByPage1(traceCodeNumber);

        CommonPage commonPage = CommonPage.restPage(itemList);

        // 用于转换树结构
        List<ZslTreeNode> result = new ArrayList<>();
        for (ZslTraceSubcode item : itemList) {
            List<ZslTreeNode> resultItem = transeTreeNode(item);
            if (resultItem != null) {
                result.addAll(resultItem);
            }
        }
        commonPage.setList(result);
        return CommonResult.success(commonPage);
    }


    @Override
    public CommonResult deleteCodeRelation(Long id) {
        ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeMapper.selectByPrimaryKey(id);
        if (!isBussiSelf(zslTraceSubcode.getTraceCodeNumber())) {
            return CommonResult.failed("只能操作自己追溯码");
        }

        //判断是否发过货
        List<String> codeList = new ArrayList<>();
        codeList.add(zslTraceSubcode.getTraceSubCodeNumber());
        if (isDeliverGoods(codeList)) {
            return CommonResult.failed("已经发过货，不能删除"); //该码已经发过货
        }

        int i = zslTraceSubcodeDao.deleteCodeRelation(id);
        if (i > 0) {
            return CommonResult.success("修改成功");
        } else {
            return CommonResult.failed("修改失败");
        }
    }

    @Override
    public CommonResult getTreeListCode(RelationOutCode relationOutCode) {
        List<ZslTraceSubcode> pageList = new ArrayList<>();
        //外码树结构
        ZslTraceSubcode outSubCode = zslTraceSubcodeDao.selectBySubCode(relationOutCode.getOutCode());
        if (outSubCode != null) {
            List<ZslTraceSubcode> pageListOutCode = zslTraceSubcodeDao.selectByParenId(outSubCode.getId());
            pageList.addAll(pageListOutCode);
        }

        //子码树结构
        for (String subCode : relationOutCode.getSubCodeList()) {
            ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectBySubCode(subCode);
            pageList.add(zslTraceSubcode);
        }
        List<ZslTreeNode> result = new ArrayList<>();
        for (ZslTraceSubcode item : pageList) {
            List<ZslTreeNode> resultItem = transeTreeNode(item);
            if (resultItem != null) {
                result.addAll(resultItem);
            }
        }
        return CommonResult.success(result);
    }

    @Override
    public int hasDeductionIntegral(TraceRecordPointParam traceRecordPointParam) {
        ZslTracePointExample zslTracePointExample = new ZslTracePointExample();
        ZslTracePointExample.Criteria criteria = zslTracePointExample.createCriteria();
        criteria.andTraceParentIdIsNull();
        criteria.andTracePointIdEqualTo(traceRecordPointParam.getTraceParentId());
        List<ZslTracePoint> zslTracePoints = zslTracePointMapper.selectByExample(zslTracePointExample);
        if (CollectionUtils.isEmpty(zslTracePoints)) {
            return 1; //正常
        }
        //拿到追溯记录id
        ZslTraceRecordExample zslTraceRecordExample = new ZslTraceRecordExample();
        ZslTraceRecordExample.Criteria criteria1 = zslTraceRecordExample.createCriteria();
        criteria1.andTraceCodeNumberEqualTo(zslTracePoints.get(0).getTraceCodeNumber());//批次号
        criteria1.andTraceGoodIdEqualTo(zslTracePoints.get(0).getTraceGoodsId());//商品id
        criteria1.andTraceFromNumberEqualTo(zslTracePoints.get(0).getTracePointFromNumber());
        criteria1.andTraceToNumberEqualTo(zslTracePoints.get(0).getTracePointToNumber());
        List<ZslTraceRecord> zslTraceRecordList = zslTraceRecordMapper.selectByExample(zslTraceRecordExample);
        if (CollectionUtils.isEmpty(zslTraceRecordList)) {
            return -1;//父节点错误
        }

        //扣除积分列表查询是否扣除了积分
        IntegralLogExample integralLogExample = new IntegralLogExample();
        IntegralLogExample.Criteria criteria2 = integralLogExample.createCriteria();
        criteria2.andFunctionIdEqualTo(zslTraceRecordList.get(0).getTraceRecordId());
        criteria2.andFunctionTypeEqualTo(ServiceEnum.TRACE_RECORD.getId());
        List<IntegralLog> integralLogs = integralLogMapper.selectByExample(integralLogExample);
        if (CollectionUtils.isEmpty(integralLogs)) {
            return -2; //积分错误
        }
        if (integralLogs.get(0).getDeductStatus() != null && (integralLogs.get(0).getDeductStatus() - 2) != 0) {
            return -3; //积分为扣除
        }
        return 1;//正常
    }

    @Override
    public CommonResult getCodePartBySid(Long sid, Integer traceId) {
        ZslTrace zslTrace = zslTraceMapper.selectByPrimaryKey(traceId);
        if (zslTrace == null) {
            return CommonResult.failed("追溯信息不存在");
        }
        if (zslTrace.getTraceApplyType() - 2 == 0) {
            return CommonResult.failed("追溯类型不对");
        }
        //判断空闲码段是否足够
        Long countNum1 = 0L;
        int rangeCount = 0;
        List<ZslTraceSid> zslTraceSids = zslTraceSidDao.listByCount();
        if (!CollectionUtils.isEmpty(zslTraceSids)) {
            for (int i = 0; i < zslTraceSids.size(); i++) {
                Long startIndex = 0L;
                if (zslTraceSids.get(i).getSidStartIndex() - sid <= 0 && zslTraceSids.get(i).getSidEndIndex() - sid >= 0) {
                    rangeCount++;
                }
                if (zslTraceSids.get(i).getSidStartIndex() - sid < 0) {
                    startIndex = sid;
                } else {
                    startIndex = zslTraceSids.get(i).getSidStartIndex();
                }
                Long endIndex = zslTraceSids.get(i).getSidEndIndex();
                for (Long j = startIndex; j <= endIndex; j++) {
                    if (zslTrace.getTraceApplyCount() - countNum1 == 0) {
                        break;
                    }
                    countNum1++;
                }
            }
        }
        if (rangeCount < 1) {
            return CommonResult.failed("编码不在范围");
        }
        if (countNum1 - zslTrace.getTraceApplyCount() < 0) {
            return CommonResult.failed("空闲码段不足");
        }

        //获取覆盖码段
        List<ZslTraceSid> blankList = zslTraceSidDao.listBlankCodePart();
        List<ZslTracePapper> codePartParamList = new ArrayList<>();
        Long countNum = 0L;
        for (int i = 0; i < blankList.size(); i++) {
            ZslTracePapper codePartParam = new ZslTracePapper();
            Long startIndex = 0L;
            if (zslTraceSids.get(i).getSidStartIndex() - sid < 0) {
                startIndex = sid;
            } else {
                startIndex = blankList.get(i).getSidStartIndex();
            }
            Long endIndex = blankList.get(i).getSidEndIndex();
            codePartParam.setTraceNumStart(startIndex);
            codePartParam.setTraceNumEnd(endIndex);
            for (Long j = startIndex; j <= endIndex; j++) {
                if (zslTrace.getTraceApplyCount() - countNum == 0) {
                    codePartParam.setTraceNumEnd(j - 1);
                    break;
                }
                countNum++;
            }
            codePartParam.setTraceCount(codePartParam.getTraceNumEnd() - codePartParam.getTraceNumStart() + 1);
            if (codePartParam.getTraceCount() > 0) {
                codePartParamList.add(codePartParam);
            }
        }
        return CommonResult.success(codePartParamList);
    }

    @Override
    public CommonResult getNextSidByCodeNumber(String traceCodeNumber) {
        ZslTraceRelationExample zslTraceRelationExample = new ZslTraceRelationExample();
        ZslTraceRelationExample.Criteria criteria = zslTraceRelationExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
        List<ZslTraceRelation> resultList = zslTraceRelationMapper.selectByExample(zslTraceRelationExample);
        if (CollectionUtils.isEmpty(resultList)) {
            ZslTracePapperExample zslTracePapperExample = new ZslTracePapperExample();
            ZslTracePapperExample.Criteria criteria1 = zslTracePapperExample.createCriteria();
            criteria1.andTraceCodeNumberEqualTo(traceCodeNumber);
            zslTracePapperExample.setOrderByClause("trace_num_start asc");
            List<ZslTracePapper> zslTracePapperList = zslTracePapperMapper.selectByExample(zslTracePapperExample);
            if (CollectionUtils.isEmpty(zslTracePapperList)) {
                return CommonResult.failed("sid错误");
            } else {
                return CommonResult.success(zslTracePapperList.get(0).getTraceNumStart());
            }
        } else {
            return CommonResult.success(resultList.get(0).getCurrentIndexRelation() + 1);
        }
    }

    List<ZslTreeNode> transeTreeNode(ZslTraceSubcode zslTraceSubcode) {
        totalSubCode = new ArrayList<>();
        searchTreeNode(zslTraceSubcode);

        List<ZslTreeNode> treeNodes = new ArrayList<>();
        for (ZslTraceSubcode item : totalSubCode) {
            ZslTreeNode node = new ZslTreeNode();
            BeanUtils.copyProperties(item, node);
            node.setName(item.getTraceSubCodeNumber());
            treeNodes.add(node);
        }
        List<ZslTreeNode> list = null;
        try {
            list = TreeUtils.buildTree(treeNodes, "com.zsl.traceapi.util.ZslTreeNode", "id", "parentId", "children");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }


    public void searchTreeNode(ZslTraceSubcode zslTraceSubcode) {
        totalSubCode.add(zslTraceSubcode);
        List<ZslTraceSubcode> subcodeList = zslTraceSubcodeDao.selectByParenId(zslTraceSubcode.getId());
        for (ZslTraceSubcode forItem : subcodeList) {
            searchTreeNode(forItem);
        }
    }

    void countCode(ZslTraceSubcode zslTraceSubcode) {
        if ("Y".equals(zslTraceSubcode.getIsLeaf())) {
            count++;
            if (zslTraceSubcode.getIsSaled() - 1 == 0) {
                isSaled = zslTraceSubcode.getIsSaled();
            }
        } else {
            //取出关联的子码
            List<ZslTraceSubcode> children = zslTraceSubcodeDao.selectByParenId(zslTraceSubcode.getId());
            for (ZslTraceSubcode item : children) {
                countCode(item);
            }
        }
    }

    void countCodeIntegral(ZslTraceSubcode zslTraceSubcode) {
        if ("Y".equals(zslTraceSubcode.getIsLeaf())) {
            countIntegral++;
        } else {
            //取出关联的子码
            List<ZslTraceSubcode> children = zslTraceSubcodeDao.selectByParenId(zslTraceSubcode.getId());
            for (ZslTraceSubcode item : children) {
                countCode(item);
            }
        }
    }
}
