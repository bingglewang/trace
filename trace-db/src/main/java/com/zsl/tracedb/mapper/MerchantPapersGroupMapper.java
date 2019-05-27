package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.MerchantPapersGroup;
import com.zsl.tracedb.model.MerchantPapersGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantPapersGroupMapper {
    int countByExample(MerchantPapersGroupExample example);

    int deleteByExample(MerchantPapersGroupExample example);

    int deleteByPrimaryKey(Integer papersGroupId);

    int insert(MerchantPapersGroup record);

    int insertSelective(MerchantPapersGroup record);

    List<MerchantPapersGroup> selectByExample(MerchantPapersGroupExample example);

    MerchantPapersGroup selectByPrimaryKey(Integer papersGroupId);

    int updateByExampleSelective(@Param("record") MerchantPapersGroup record, @Param("example") MerchantPapersGroupExample example);

    int updateByExample(@Param("record") MerchantPapersGroup record, @Param("example") MerchantPapersGroupExample example);

    int updateByPrimaryKeySelective(MerchantPapersGroup record);

    int updateByPrimaryKey(MerchantPapersGroup record);
}