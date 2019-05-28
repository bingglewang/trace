package com.zsl.traceapi.dao;


import com.zsl.traceapi.dto.QueryParam;
import com.zsl.traceapi.vo.ZslTraceVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 追溯自定义查询Dao
 * Created by wangbinggui on 2019/5/28.
 */
public interface ZslTraceDao {

    ZslTraceVo getZslTraceDetailById(@Param("id") Integer id);

    List<ZslTraceVo> getListByPage(@Param("queryParam") QueryParam queryParam);
 }
