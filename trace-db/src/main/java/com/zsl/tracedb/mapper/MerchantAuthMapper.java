package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.MerchantAuth;
import com.zsl.tracedb.model.MerchantAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantAuthMapper {
    int countByExample(MerchantAuthExample example);

    int deleteByExample(MerchantAuthExample example);

    int deleteByPrimaryKey(Integer merchantAuthId);

    int insert(MerchantAuth record);

    int insertSelective(MerchantAuth record);

    List<MerchantAuth> selectByExampleWithBLOBs(MerchantAuthExample example);

    List<MerchantAuth> selectByExample(MerchantAuthExample example);

    MerchantAuth selectByPrimaryKey(Integer merchantAuthId);

    int updateByExampleSelective(@Param("record") MerchantAuth record, @Param("example") MerchantAuthExample example);

    int updateByExampleWithBLOBs(@Param("record") MerchantAuth record, @Param("example") MerchantAuthExample example);

    int updateByExample(@Param("record") MerchantAuth record, @Param("example") MerchantAuthExample example);

    int updateByPrimaryKeySelective(MerchantAuth record);

    int updateByPrimaryKeyWithBLOBs(MerchantAuth record);

    int updateByPrimaryKey(MerchantAuth record);
}