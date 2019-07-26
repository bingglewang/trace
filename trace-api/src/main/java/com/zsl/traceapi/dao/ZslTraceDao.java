package com.zsl.traceapi.dao;


import com.zsl.traceapi.dto.MerchantRankVo;
import com.zsl.traceapi.dto.QueryParam;
import com.zsl.traceapi.vo.GoodsTracePieVo;
import com.zsl.traceapi.vo.NewTraceRecordVo;
import com.zsl.traceapi.vo.ZslTraceVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 追溯自定义查询Dao
 * Created by wangbinggui on 2019/5/28.
 */
public interface ZslTraceDao {

    ZslTraceVo getZslTraceDetailById(@Param("id") Integer id);

    List<ZslTraceVo> getListByPage(@Param("queryParam") QueryParam queryParam);

    List<MerchantRankVo> getMerchantRankList(@Param("companyId")Integer companyId, @Param("startDate") String startDate, @Param("endDate") String endDate);

    List<GoodsTracePieVo> getPieChart(@Param("companyId")Integer companyId);

    List<NewTraceRecordVo> getNewTraceRecord(@Param("allianceBusinessId")Integer allianceBusinessId,@Param("merchantId")Integer merchantId);

    Long busiTotalTraceCount(@Param("traceBusinessId") Integer traceBusinessId);
}
