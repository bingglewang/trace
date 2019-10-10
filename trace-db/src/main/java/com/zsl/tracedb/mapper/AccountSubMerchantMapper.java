package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.AccountSubMerchant;
import com.zsl.tracedb.model.AccountSubMerchantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountSubMerchantMapper {
    int countByExample(AccountSubMerchantExample example);

    int deleteByExample(AccountSubMerchantExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AccountSubMerchant record);

    int insertSelective(AccountSubMerchant record);

    List<AccountSubMerchant> selectByExample(AccountSubMerchantExample example);

    AccountSubMerchant selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AccountSubMerchant record, @Param("example") AccountSubMerchantExample example);

    int updateByExample(@Param("record") AccountSubMerchant record, @Param("example") AccountSubMerchantExample example);

    int updateByPrimaryKeySelective(AccountSubMerchant record);

    int updateByPrimaryKey(AccountSubMerchant record);
}