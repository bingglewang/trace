package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.MiddleGoodsPropertyValue;
import com.zsl.tracedb.model.MiddleGoodsPropertyValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MiddleGoodsPropertyValueMapper {
    int countByExample(MiddleGoodsPropertyValueExample example);

    int deleteByExample(MiddleGoodsPropertyValueExample example);

    int deleteByPrimaryKey(Integer goodsPropertyValueId);

    int insert(MiddleGoodsPropertyValue record);

    int insertSelective(MiddleGoodsPropertyValue record);

    List<MiddleGoodsPropertyValue> selectByExample(MiddleGoodsPropertyValueExample example);

    MiddleGoodsPropertyValue selectByPrimaryKey(Integer goodsPropertyValueId);

    int updateByExampleSelective(@Param("record") MiddleGoodsPropertyValue record, @Param("example") MiddleGoodsPropertyValueExample example);

    int updateByExample(@Param("record") MiddleGoodsPropertyValue record, @Param("example") MiddleGoodsPropertyValueExample example);

    int updateByPrimaryKeySelective(MiddleGoodsPropertyValue record);

    int updateByPrimaryKey(MiddleGoodsPropertyValue record);
}