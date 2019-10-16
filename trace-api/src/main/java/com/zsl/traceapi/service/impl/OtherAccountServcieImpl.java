package com.zsl.traceapi.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSONObject;
import com.zsl.traceapi.context.RequestContext;
import com.zsl.traceapi.context.RequestContextMgr;
import com.zsl.traceapi.dao.MerchantDao;
import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.dto.MerchantPointDto;
import com.zsl.traceapi.dto.RoleEnum;
import com.zsl.traceapi.dto.TracePointEnum;
import com.zsl.traceapi.service.OtherAccountServcie;
import com.zsl.tracedb.model.ZslTracePoint;
import com.zsl.tracedb.model.ZslTraceSubcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName OtherAccountServcieImpl
 * @Description 流通节点(其他)
 * @Author binggleW
 * @Date 2019-10-15 17:15
 * @Version 1.0
 **/
@Service
public class OtherAccountServcieImpl implements OtherAccountServcie {

    @Autowired
    private MerchantDao merchantDao;

    @Autowired
    private ZslTraceSubcodeDao zslTraceSubcodeDao;

    @Override
    public MerchantPointDto getNodeByMobile(String mobile) {
        MerchantPointDto result = merchantDao.getMerchantPointByMobile(mobile);
        if(result == null){
            result = merchantDao.getEmployPointByMobile(mobile);
            if(result == null){
                result = merchantDao.getAgentPointByMobile(mobile);
                if(result == null){
                    result = merchantDao.getOtherPointByMobile(mobile);
                }
            }
        }
        return result;
    }

    @Override
    public boolean isCurrentNodeNewest(Long sid) {
        ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectById(sid);
        List<ZslTracePoint> tracePointList = zslTraceSubcodeDao.selectTracePointNodes(zslTraceSubcode.getTraceGoodId(), zslTraceSubcode.getTraceIndex(), zslTraceSubcode.getTraceCodeNumber());
        if (CollectionUtil.isNotEmpty(tracePointList)) {
            ZslTracePoint newestNode = tracePointList.get(tracePointList.size() - 1);
            //获取用户登录信息
            RequestContext requestContext = RequestContextMgr.getLocalContext();
            JSONObject loginUser = requestContext.getJsonObject();
            String roleName = (loginUser.getJSONObject("role").get("roleName")).toString();
            Integer accountType = Integer.parseInt(loginUser.get("accountType").toString());
            if (accountType == 2) {
                if(TracePointEnum.MERCHANT.getType().equals(newestNode.getTracePointServiceType())){
                    //商家和员工可以互通
                    if(RoleEnum.ROLE_BUSINESS.getValue().equals(roleName)){
                        int merchantId = Integer.parseInt((loginUser.getJSONObject("merchant").get("merchantId")).toString());
                        if(merchantId == newestNode.getTracePointServiceId()){
                            return true;
                        }
                    }else if((RoleEnum.ROLE_BUSINESS_STAFF.getValue()).equals(roleName)){
                        //TODO
                        //商家子账号也可以发货
                    }
                }else if(TracePointEnum.EMPLOYMENT.getType().equals(newestNode.getTracePointServiceType())){
                    //TODO
                    //子账号的商家也可以发货
                }else if(TracePointEnum.AGENT.getType().equals(newestNode.getTracePointServiceType())){
                    if ((RoleEnum.ROLE_BUSINESS_AGENT.getValue()).equals(roleName)) {
                        //商家代理
                        //TODO
                        //判断servcieid是否相等
                    }
                }else if(TracePointEnum.OTHER.getType().equals(newestNode.getTracePointServiceType())){
                    if ((RoleEnum.ROLE_BUSINESS_NODE.getValue()).equals(roleName)) {
                        //商家节点
                        //TODO
                        //判断servcieid是否相等
                    }
                }
            }
        }
        return false;
    }

}
