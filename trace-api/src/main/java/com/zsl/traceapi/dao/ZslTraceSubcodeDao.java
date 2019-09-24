package com.zsl.traceapi.dao;

import com.zsl.traceapi.dto.*;
import com.zsl.tracedb.model.ZslTracePoint;
import com.zsl.tracedb.model.ZslTraceSubcode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 追溯记录自定义dao
 */
public interface ZslTraceSubcodeDao {
    int insertCodeBatch(@Param("list") List<TraceSubcodeInsertParam> traceSubcodeInsertParams);
    int insertCodeBatch1(@Param("list") List<TraceOutCodeByCount> traceOutCodeByCounts);
    int insertCodePreSidBatch(@Param("list") List<TracePreSidInsertParam> tracePreSidInsertParams);
    ZslTraceSubcode selectByCodeNumber(@Param("traceCodeNumber") String traceCodeNumber);
    List<ZslTraceSubcode> selectByParenId(@Param("parentId") Long parentId);
    int deleteCodeRelation(@Param("id") Long id);
    ZslTraceSubcode selectBySubCode(@Param("traceSubCode") String traceSubCode);
    ZslTraceSubcode selectById(@Param("id") Long id);
    int deleteByCodeNumber(@Param("traceCodeNumber") String traceCodeNumber);
    List<Long> exportExcel(@Param("fromIndex") Long fromIndex,@Param("toIndex") Long toIndex,@Param("traceCodeNumber") String traceCodeNumber);
    List<ZslTraceSubcode> searchByIndexOrCode(@Param("traceIndexOrCode") String traceIndexOrCode,@Param("traceCodeNumber") String traceCodeNumber);
    List<ZslTraceSubcode> getSuCodeByPage(@Param("pageSize") Integer pageSize,@Param("toNumber") Integer toNumber,@Param("fromNumber") Integer fromNumber,@Param("traceCodeNumber") String traceCodeNumber);
    Long getTotalCount(@Param("toNumber") Integer toNumber,@Param("fromNumber") Integer fromNumber,@Param("traceCodeNumber") String traceCodeNumber);
    Long selectMaxToNumberByRecord(@Param("traceCodeNumber") String traceCodeNumber);
    Long selectMinFromNumberByRecord(@Param("traceCodeNumber") String traceCodeNumber);
    List<Long> selectByRange(@Param("fromIndex") Long fromIndex,@Param("toIndex") Long toIndex,@Param("traceCodeNumber") String traceCodeNumber);
    List<Long> selectBySidRange(@Param("startSidIndex") Long startSidIndex,@Param("endSidIndex") Long endSidIndex);
    int updateGoodsAndStall(@Param(value = "list") List<TraceSubcodeUpdateParam> traceSubcodeUpdateParams);
    int updateGoodsAndStallSid(@Param(value = "list") List<TraceSubcodeUpdateParamSid> traceSubcodeUpdateParams);
    int updateOutCodeBatch(@Param(value = "list") List<TraceOutCodeUpdateParam> traceOutCodeUpdateParams);
    int updateOutCodeById(@Param("list") List<TraceOutCodeUpdateParam> traceOutCodeUpdateParams);
    Long goodsScanCount(@Param("goodsId") Integer goodsId,@Param("traceCodeNumber") String traceCodeNumber);
    Long goodsTotalCount(@Param("goodsId") Integer goodsId,@Param("traceCodeNumber") String traceCodeNumber);
    List<ZslTracePoint> selectTracePointNodes(@Param("traceGoodsId") Integer traceGoodsId,@Param("traceIndex") Long traceIndex,@Param("traceCodeNumber") String traceCodeNumber);
}
