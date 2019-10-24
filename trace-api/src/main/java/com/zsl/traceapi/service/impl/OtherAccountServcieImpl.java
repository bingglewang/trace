package com.zsl.traceapi.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSONObject;
import com.zsl.traceapi.context.RequestContext;
import com.zsl.traceapi.context.RequestContextMgr;
import com.zsl.traceapi.dao.MerchantDao;
import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.dto.MerchantPointDto;
import com.zsl.traceapi.dto.RoleEnum;
import com.zsl.traceapi.service.OtherAccountServcie;
import com.zsl.tracedb.mapper.AccountMapper;
import com.zsl.tracedb.mapper.AccountSubMerchantMapper;
import com.zsl.tracedb.mapper.MerchantMapper;
import com.zsl.tracedb.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private AccountSubMerchantMapper accountSubMerchantMapper;

    private boolean isNewestNode = true;

    @Override
    public MerchantPointDto getNodeByMobile(String mobile) {
        MerchantPointDto result = null;
        AccountExample accountExample = new AccountExample();
        AccountExample.Criteria criteria = accountExample.createCriteria();
        criteria.andMobileEqualTo(mobile);
        List<Account> accountList = accountMapper.selectByExample(accountExample);
        if(CollectionUtil.isEmpty(accountList)){
            return result;
        }
        Account account = accountList.get(0);
        if(account == null){
            return result;
        }
        if (account.getRoleId().equals(RoleEnum.ROLE_BUSINESS.getId())) {
            result = merchantDao.getMerchantPoint(account.getId());
        }else if(account.getRoleId().equals(RoleEnum.ROLE_BUSINESS_STAFF.getId())){
            result = merchantDao.getEmployPoint(account.getId());
        }else if (account.getRoleId().equals(RoleEnum.ROLE_BUSINESS_NODE.getId()) || account.getRoleId().equals(RoleEnum.ROLE_BUSINESS_AGENT.getId())) {
            result = merchantDao.getOtherPoint(account.getId());
        }
        return result;
    }


    public void getChildTrace(List<ZslTraceSubcode> zslTraceSubcodeList) {
        for (ZslTraceSubcode zslTraceSubcode : zslTraceSubcodeList) {
            if ("Y".equals(zslTraceSubcode.getIsLeaf())) {
                boolean result1 = isnewestDigui(zslTraceSubcode);
                if(!result1){
                    isNewestNode = result1;
                }
            } else {
                List<ZslTraceSubcode> children = zslTraceSubcodeDao.selectByParenId(zslTraceSubcode.getId());
                getChildTrace(children);
            }
        }
    }


    @Override
    public boolean isCurrentNodeNewest(Long sid) {
        isNewestNode = true;
        ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectById(sid);
        // 是否为内码
        boolean result = false;
        if ("Y".equals(zslTraceSubcode.getIsLeaf())) {
            result = isnewestDigui(zslTraceSubcode);
        } else {
            List<ZslTraceSubcode> digui = new ArrayList<>();
            digui.add(zslTraceSubcode);
            getChildTrace(digui);
            result = isNewestNode;
        }
        return result;
    }


    public boolean isnewestDigui(ZslTraceSubcode zslTraceSubcode){
        ZslTracePoint newestNode = zslTraceSubcodeDao.selectNewestPointNode(zslTraceSubcode.getTraceGoodId(),zslTraceSubcode.getTraceIndex(),zslTraceSubcode.getTraceCodeNumber());
        if (newestNode != null) {
            //获取用户登录信息
            RequestContext requestContext = RequestContextMgr.getLocalContext();
            JSONObject loginUser = requestContext.getJsonObject();
            String roleName = (loginUser.getJSONObject("role").get("roleName")).toString();
            Integer accountType = Integer.parseInt(loginUser.get("accountType").toString());
            Integer accountId = Integer.parseInt(loginUser.get("id").toString());
            if (accountType == 2) {
                //如果角色是节点，代理商，则判断账号id是否一致就行
                if(RoleEnum.ROLE_BUSINESS_AGENT.getValue().equals(roleName) || RoleEnum.ROLE_BUSINESS_NODE.getValue().equals(roleName)){
                    if(accountId - newestNode.getTracePointAccountId() == 0){
                        return true;
                    }
                }else if(RoleEnum.ROLE_BUSINESS.getValue().equals(roleName)){
                    //如果是商家得话，则可以发商家自己得，也可以发员工的
                    Integer loginMerchantId = Integer.parseInt((loginUser.getJSONObject("merchant").get("merchantId")).toString());
                    if(accountId - newestNode.getTracePointAccountId() == 0){
                        return true;
                    }else{
                        Account account = accountMapper.selectByPrimaryKey(newestNode.getTracePointAccountId());
                        if(account != null){
                            //当前最新节点是员工
                            if(account.getRoleId().equals(RoleEnum.ROLE_BUSINESS_STAFF.getId())){
                                // 根据accountId 获取员工的商家id
                                AccountSubMerchantExample accountSubMerchantExample = new AccountSubMerchantExample();
                                AccountSubMerchantExample.Criteria criteria = accountSubMerchantExample.createCriteria();
                                criteria.andAccountIdEqualTo(account.getId());
                                List<AccountSubMerchant> subMerchants = accountSubMerchantMapper.selectByExample(accountSubMerchantExample);
                                if(CollectionUtil.isNotEmpty(subMerchants)){
                                    Integer merchantIdOfEmploy = subMerchants.get(0).getMerchantId();
                                    if(loginMerchantId - merchantIdOfEmploy == 0){
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }else if(RoleEnum.ROLE_BUSINESS_STAFF.getValue().equals(roleName)){
                    //如果是员工的话可以发自己，也可以发商家的
                    if(accountId - newestNode.getTracePointAccountId() == 0){
                        return true;
                    }else{
                        Account account = accountMapper.selectByPrimaryKey(newestNode.getTracePointAccountId());
                        if(account != null){
                            if(account.getRoleId().equals(RoleEnum.ROLE_BUSINESS.getId())){
                                // 根据accountId 获取员工的商家id
                                AccountSubMerchantExample accountSubMerchantExample = new AccountSubMerchantExample();
                                AccountSubMerchantExample.Criteria criteria = accountSubMerchantExample.createCriteria();
                                criteria.andAccountIdEqualTo(accountId);
                                List<AccountSubMerchant> subMerchants = accountSubMerchantMapper.selectByExample(accountSubMerchantExample);
                                if(CollectionUtil.isNotEmpty(subMerchants)){
                                        if( subMerchants.get(0).getMerchantId() - subMerchants.get(0).getMerchantId() == 0){
                                            return true;
                                        }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

}
