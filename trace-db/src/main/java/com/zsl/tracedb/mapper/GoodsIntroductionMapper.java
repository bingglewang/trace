package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.GoodsIntroduction;
import com.zsl.tracedb.model.GoodsIntroductionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsIntroductionMapper {
    int countByExample(GoodsIntroductionExample example);

    int deleteByExample(GoodsIntroductionExample example);

    int deleteByPrimaryKey(Integer introductionId);

    int insert(GoodsIntroduction record);

    int insertSelective(GoodsIntroduction record);

    List<GoodsIntroduction> selectByExampleWithBLOBs(GoodsIntroductionExample example);

    List<GoodsIntroduction> selectByExample(GoodsIntroductionExample example);

    GoodsIntroduction selectByPrimaryKey(Integer introductionId);

    int updateByExampleSelective(@Param("record") GoodsIntroduction record, @Param("example") GoodsIntroductionExample example);

    int updateByExampleWithBLOBs(@Param("record") GoodsIntroduction record, @Param("example") GoodsIntroductionExample example);

    int updateByExample(@Param("record") GoodsIntroduction record, @Param("example") GoodsIntroductionExample example);

    int updateByPrimaryKeySelective(GoodsIntroduction record);

    int updateByPrimaryKeyWithBLOBs(GoodsIntroduction record);

    int updateByPrimaryKey(GoodsIntroduction record);
}