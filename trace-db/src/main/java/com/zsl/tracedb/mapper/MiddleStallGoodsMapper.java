package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.MiddleStallGoods;
import com.zsl.tracedb.model.MiddleStallGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MiddleStallGoodsMapper {
    int countByExample(MiddleStallGoodsExample example);

    int deleteByExample(MiddleStallGoodsExample example);

    int deleteByPrimaryKey(Integer stallGoodsId);

    int insert(MiddleStallGoods record);

    int insertSelective(MiddleStallGoods record);

    List<MiddleStallGoods> selectByExample(MiddleStallGoodsExample example);

    MiddleStallGoods selectByPrimaryKey(Integer stallGoodsId);

    int updateByExampleSelective(@Param("record") MiddleStallGoods record, @Param("example") MiddleStallGoodsExample example);

    int updateByExample(@Param("record") MiddleStallGoods record, @Param("example") MiddleStallGoodsExample example);

    int updateByPrimaryKeySelective(MiddleStallGoods record);

    int updateByPrimaryKey(MiddleStallGoods record);
}