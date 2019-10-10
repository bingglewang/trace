package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ZslTraceRelation;
import com.zsl.tracedb.model.ZslTraceRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZslTraceRelationMapper {
    int countByExample(ZslTraceRelationExample example);

    int deleteByExample(ZslTraceRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZslTraceRelation record);

    int insertSelective(ZslTraceRelation record);

    List<ZslTraceRelation> selectByExample(ZslTraceRelationExample example);

    ZslTraceRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZslTraceRelation record, @Param("example") ZslTraceRelationExample example);

    int updateByExample(@Param("record") ZslTraceRelation record, @Param("example") ZslTraceRelationExample example);

    int updateByPrimaryKeySelective(ZslTraceRelation record);

    int updateByPrimaryKey(ZslTraceRelation record);
}