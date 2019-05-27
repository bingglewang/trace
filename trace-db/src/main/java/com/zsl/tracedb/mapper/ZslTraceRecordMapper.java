package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ZslTraceRecord;
import com.zsl.tracedb.model.ZslTraceRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZslTraceRecordMapper {
    int countByExample(ZslTraceRecordExample example);

    int deleteByExample(ZslTraceRecordExample example);

    int deleteByPrimaryKey(Integer traceRecordId);

    int insert(ZslTraceRecord record);

    int insertSelective(ZslTraceRecord record);

    List<ZslTraceRecord> selectByExample(ZslTraceRecordExample example);

    ZslTraceRecord selectByPrimaryKey(Integer traceRecordId);

    int updateByExampleSelective(@Param("record") ZslTraceRecord record, @Param("example") ZslTraceRecordExample example);

    int updateByExample(@Param("record") ZslTraceRecord record, @Param("example") ZslTraceRecordExample example);

    int updateByPrimaryKeySelective(ZslTraceRecord record);

    int updateByPrimaryKey(ZslTraceRecord record);
}