package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ZslTracePoint;
import com.zsl.tracedb.model.ZslTracePointExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZslTracePointMapper {
    int countByExample(ZslTracePointExample example);

    int deleteByExample(ZslTracePointExample example);

    int deleteByPrimaryKey(Integer tracePointId);

    int insert(ZslTracePoint record);

    int insertSelective(ZslTracePoint record);

    List<ZslTracePoint> selectByExample(ZslTracePointExample example);

    ZslTracePoint selectByPrimaryKey(Integer tracePointId);

    int updateByExampleSelective(@Param("record") ZslTracePoint record, @Param("example") ZslTracePointExample example);

    int updateByExample(@Param("record") ZslTracePoint record, @Param("example") ZslTracePointExample example);

    int updateByPrimaryKeySelective(ZslTracePoint record);

    int updateByPrimaryKey(ZslTracePoint record);
}