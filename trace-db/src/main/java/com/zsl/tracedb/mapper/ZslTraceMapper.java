package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ZslTrace;
import com.zsl.tracedb.model.ZslTraceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZslTraceMapper {
    int countByExample(ZslTraceExample example);

    int deleteByExample(ZslTraceExample example);

    int deleteByPrimaryKey(Integer traceId);

    int insert(ZslTrace record);

    int insertSelective(ZslTrace record);

    List<ZslTrace> selectByExample(ZslTraceExample example);

    ZslTrace selectByPrimaryKey(Integer traceId);

    int updateByExampleSelective(@Param("record") ZslTrace record, @Param("example") ZslTraceExample example);

    int updateByExample(@Param("record") ZslTrace record, @Param("example") ZslTraceExample example);

    int updateByPrimaryKeySelective(ZslTrace record);

    int updateByPrimaryKey(ZslTrace record);
}