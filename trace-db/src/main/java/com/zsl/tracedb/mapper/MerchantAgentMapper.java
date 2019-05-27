package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.MerchantAgent;
import com.zsl.tracedb.model.MerchantAgentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantAgentMapper {
    int countByExample(MerchantAgentExample example);

    int deleteByExample(MerchantAgentExample example);

    int deleteByPrimaryKey(Integer merchantAgentId);

    int insert(MerchantAgent record);

    int insertSelective(MerchantAgent record);

    List<MerchantAgent> selectByExample(MerchantAgentExample example);

    MerchantAgent selectByPrimaryKey(Integer merchantAgentId);

    int updateByExampleSelective(@Param("record") MerchantAgent record, @Param("example") MerchantAgentExample example);

    int updateByExample(@Param("record") MerchantAgent record, @Param("example") MerchantAgentExample example);

    int updateByPrimaryKeySelective(MerchantAgent record);

    int updateByPrimaryKey(MerchantAgent record);
}