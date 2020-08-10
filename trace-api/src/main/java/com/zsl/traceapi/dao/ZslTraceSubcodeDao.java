package com.zsl.traceapi.dao;

import com.zsl.traceapi.dto.*;
import com.zsl.traceapi.vo.SpurtCodeVo;
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
    Long selectBtweenCount(@Param("start") Long start,@Param("end") Long end);
    List<ZslTraceSubcode> selectBetweenAllRecord(@Param("start") Long start,@Param("end") Long end);
    Long onlyMyselfCode(@Param("start") Long start,@Param("end") Long end,@Param("merchantId") Integer merchantId);
    ZslTraceSubcode selectById(@Param("id") Long id);
    int deleteByCodeNumber(@Param("traceCodeNumber") String traceCodeNumber);
    List<Long> exportExcel(@Param("fromIndex") Long fromIndex,@Param("toIndex") Long toIndex,@Param("traceCodeNumber") String traceCodeNumber);
    List<ZslTraceSubcode> searchByIndexOrCode(@Param("traceIndexOrCode") String traceIndexOrCode,@Param("traceCodeNumber") String traceCodeNumber);
    List<ZslTraceSubcode> getSuCodeByPage(@Param("pageSize") Integer pageSize,@Param("toNumber") Integer toNumber,@Param("fromNumber") Integer fromNumber,@Param("traceCodeNumber") String traceCodeNumber);
    List<ZslTraceSubcode> getSuCodeByPage1(@Param("traceCodeNumber") String traceCodeNumber);
    Long getTotalCount(@Param("toNumber") Integer toNumber,@Param("fromNumber") Integer fromNumber,@Param("traceCodeNumber") String traceCodeNumber);
    Long selectMaxToNumberByRecord(@Param("traceCodeNumber") String traceCodeNumber);
    Long selectMinFromNumberByRecord(@Param("traceCodeNumber") String traceCodeNumber);
    List<Long> selectByRange(@Param("fromIndex") Long fromIndex,@Param("toIndex") Long toIndex,@Param("traceCodeNumber") String traceCodeNumber);
    List<String> selectSubCodeByRange(@Param("fromIndex") Long fromIndex,@Param("toIndex") Long toIndex,@Param("traceCodeNumber") String traceCodeNumber);
    Long selectSidByIndex(@Param("traceIndex") Long traceIndex,@Param("traceCodeNumber") String traceCodeNumber);
    List<Long> selectBySidRange(@Param("startSidIndex") Long startSidIndex,@Param("endSidIndex") Long endSidIndex);
    int updateGoodsAndStall(@Param(value = "list") List<TraceSubcodeUpdateParam> traceSubcodeUpdateParams);
    int updateGoodsAndStallSid(@Param(value = "list") List<TraceSubcodeUpdateParamSid> traceSubcodeUpdateParams);
    int updateOutCodeBatch(@Param(value = "list") List<TraceOutCodeUpdateParam> traceOutCodeUpdateParams);
    int updateOutCodeById(@Param("list") List<TraceOutCodeUpdateParam> traceOutCodeUpdateParams);
    Long goodsScanCount(@Param("goodsId") Integer goodsId,@Param("traceCodeNumber") String traceCodeNumber,@Param("traceIndex") Long traceIndex);
    Long goodsTotalCount(@Param("goodsId") Integer goodsId,@Param("traceCodeNumber") String traceCodeNumber,@Param("traceIndex") Long traceIndex);
    List<ZslTracePoint> selectTracePointNodes(@Param("traceGoodsId") Integer traceGoodsId,@Param("traceIndex") Long traceIndex,@Param("traceCodeNumber") String traceCodeNumber);
    ZslTracePoint selectNewestPointNode(@Param("traceGoodsId") Integer traceGoodsId,@Param("traceIndex") Long traceIndex,@Param("traceCodeNumber") String traceCodeNumber);

    /**
     * 喷码
     */
    List<SpurtCodeVo> getSidsByTraceCodeNumber(@Param("traceCodeNumber") String traceCodeNumber);

    SpurtCodeVo getSubCodeBySidAndCode(@Param("traceCodeNumber") String traceCodeNumber,@Param("traceSid") Long traceSid);
	
    /**
     * --追溯sid查询记录
	 * @param traceSid
	 * @return
	 */
	ZslTraceSubcode recordBySid(Long traceSid);
}
