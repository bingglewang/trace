package com.zsl.traceapi.dao;

import com.zsl.traceapi.dto.*;
import com.zsl.tracedb.model.ZslTraceSubcode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 追溯记录自定义dao
 */
public interface ZslTraceSubcodeDao {
    int insertCodeBatch(@Param("list") List<TraceSubcodeInsertParam> traceSubcodeInsertParams);
    int insertCodeBatch1(@Param("list") List<TraceOutCodeByCount> traceOutCodeByCounts);
    ZslTraceSubcode selectByCodeNumber(@Param("traceCodeNumber") String traceCodeNumber);
    List<ZslTraceSubcode> selectByParenId(@Param("parentId") Long parentId);
    ZslTraceSubcode selectBySubCode(@Param("traceSubCode") String traceSubCode);
    ZslTraceSubcode selectById(@Param("id") Long id);
    int deleteByCodeNumber(@Param("traceCodeNumber") String traceCodeNumber);
    List<ExcelTraceCode> exportExcel(@Param("fromIndex") Long fromIndex,@Param("toIndex") Long toIndex,@Param("traceCodeNumber") String traceCodeNumber);
    List<Long> selectByRange(@Param("fromIndex") Long fromIndex,@Param("toIndex") Long toIndex,@Param("traceCodeNumber") String traceCodeNumber);
    int updateGoodsAndStall(@Param(value = "list") List<TraceSubcodeUpdateParam> traceSubcodeUpdateParams);
    int updateOutCodeBatch(@Param(value = "list") List<TraceOutCodeUpdateParam> traceOutCodeUpdateParams);
}
