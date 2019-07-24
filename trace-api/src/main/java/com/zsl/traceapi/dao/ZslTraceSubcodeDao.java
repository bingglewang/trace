package com.zsl.traceapi.dao;

import com.zsl.traceapi.dto.TraceRecordInsertParam;
import com.zsl.traceapi.dto.TraceSubcodeInsertParam;
import com.zsl.tracedb.model.ZslTraceSubcode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 追溯记录自定义dao
 */
public interface ZslTraceSubcodeDao {
    int insertCodeBatch(@Param("list") List<TraceSubcodeInsertParam> traceSubcodeInsertParams);
    ZslTraceSubcode selectByCodeNumber(@Param("traceCodeNumber") String traceCodeNumber);
    int deleteByCodeNumber(@Param("traceCodeNumber") String traceCodeNumber);
}
