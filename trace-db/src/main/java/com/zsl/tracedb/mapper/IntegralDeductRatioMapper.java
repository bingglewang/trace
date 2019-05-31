package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.IntegralDeductRatio;
import com.zsl.tracedb.model.IntegralDeductRatioExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntegralDeductRatioMapper {
    int countByExample(IntegralDeductRatioExample example);

    int deleteByExample(IntegralDeductRatioExample example);

    int deleteByPrimaryKey(Integer integralDeductRatioId);

    int insert(IntegralDeductRatio record);

    int insertSelective(IntegralDeductRatio record);

    List<IntegralDeductRatio> selectByExample(IntegralDeductRatioExample example);

    IntegralDeductRatio selectByPrimaryKey(Integer integralDeductRatioId);

    int updateByExampleSelective(@Param("record") IntegralDeductRatio record, @Param("example") IntegralDeductRatioExample example);

    int updateByExample(@Param("record") IntegralDeductRatio record, @Param("example") IntegralDeductRatioExample example);

    int updateByPrimaryKeySelective(IntegralDeductRatio record);

    int updateByPrimaryKey(IntegralDeductRatio record);
}