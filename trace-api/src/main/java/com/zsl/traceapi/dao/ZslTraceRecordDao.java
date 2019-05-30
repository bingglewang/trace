package com.zsl.traceapi.dao;

import com.zsl.traceapi.dto.TraceRecordInsertParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 追溯记录自定义dao
 */
public interface ZslTraceRecordDao {
    int insertList(@Param("list") List<TraceRecordInsertParam> traceRecordInsertParamList);
}
