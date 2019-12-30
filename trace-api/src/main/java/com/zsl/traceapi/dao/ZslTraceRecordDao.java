package com.zsl.traceapi.dao;

import com.zsl.traceapi.dto.TraceRecordInsertParam;
import com.zsl.tracedb.model.ZslTracePoint;
import com.zsl.tracedb.model.ZslTraceRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 追溯记录自定义dao
 */
public interface ZslTraceRecordDao {
    int insertList(@Param("list") List<TraceRecordInsertParam> traceRecordInsertParamList);
    ZslTraceRecord selectRecordForProduct(@Param("traceGoodsId") Integer traceGoodsId,@Param("traceIndex") Long traceIndex,@Param("traceCodeNumber") String traceCodeNumber);
    ZslTracePoint getTracePointBy(@Param("traceGoodsId") Integer traceGoodsId,@Param("traceIndex") Long traceIndex,@Param("traceCodeNumber") String traceCodeNumber);
    List<ZslTracePoint> getTracePointByParentId(@Param("traceParentId") Integer traceParentId);
}
