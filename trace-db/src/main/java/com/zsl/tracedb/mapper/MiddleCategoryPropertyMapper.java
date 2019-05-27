package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.MiddleCategoryProperty;
import com.zsl.tracedb.model.MiddleCategoryPropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MiddleCategoryPropertyMapper {
    int countByExample(MiddleCategoryPropertyExample example);

    int deleteByExample(MiddleCategoryPropertyExample example);

    int deleteByPrimaryKey(Integer categoryPropertyId);

    int insert(MiddleCategoryProperty record);

    int insertSelective(MiddleCategoryProperty record);

    List<MiddleCategoryProperty> selectByExample(MiddleCategoryPropertyExample example);

    MiddleCategoryProperty selectByPrimaryKey(Integer categoryPropertyId);

    int updateByExampleSelective(@Param("record") MiddleCategoryProperty record, @Param("example") MiddleCategoryPropertyExample example);

    int updateByExample(@Param("record") MiddleCategoryProperty record, @Param("example") MiddleCategoryPropertyExample example);

    int updateByPrimaryKeySelective(MiddleCategoryProperty record);

    int updateByPrimaryKey(MiddleCategoryProperty record);
}