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
    ZslTraceSubcode selectByCodeNumber(@Param("traceCodeNumber") String traceCodeNumber);
    int deleteByCodeNumber(@Param("traceCodeNumber") String traceCodeNumber);
    List<ExcelTraceCode> exportExcel(@Param("fromIndex") Long fromIndex,@Param("toIndex") Long toIndex,@Param("traceCodeNumber") String traceCodeNumber);
    List<Long> selectByRange(@Param("fromIndex") Long fromIndex,@Param("toIndex") Long toIndex,@Param("traceCodeNumber") String traceCodeNumber);
    int updateGoodsAndStall(@Param(value = "list") List<TraceSubcodeUpdateParam> traceSubcodeUpdateParams);
}
