package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.MerchantImage;
import com.zsl.tracedb.model.MerchantImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantImageMapper {
    int countByExample(MerchantImageExample example);

    int deleteByExample(MerchantImageExample example);

    int deleteByPrimaryKey(Integer merchantImageId);

    int insert(MerchantImage record);

    int insertSelective(MerchantImage record);

    List<MerchantImage> selectByExample(MerchantImageExample example);

    MerchantImage selectByPrimaryKey(Integer merchantImageId);

    int updateByExampleSelective(@Param("record") MerchantImage record, @Param("example") MerchantImageExample example);

    int updateByExample(@Param("record") MerchantImage record, @Param("example") MerchantImageExample example);

    int updateByPrimaryKeySelective(MerchantImage record);

    int updateByPrimaryKey(MerchantImage record);
}