package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.MerchantStall;
import com.zsl.tracedb.model.MerchantStallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantStallMapper {
    int countByExample(MerchantStallExample example);

    int deleteByExample(MerchantStallExample example);

    int deleteByPrimaryKey(Integer stallId);

    int insert(MerchantStall record);

    int insertSelective(MerchantStall record);

    List<MerchantStall> selectByExample(MerchantStallExample example);

    MerchantStall selectByPrimaryKey(Integer stallId);

    int updateByExampleSelective(@Param("record") MerchantStall record, @Param("example") MerchantStallExample example);

    int updateByExample(@Param("record") MerchantStall record, @Param("example") MerchantStallExample example);

    int updateByPrimaryKeySelective(MerchantStall record);

    int updateByPrimaryKey(MerchantStall record);
}