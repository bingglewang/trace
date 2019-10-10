package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ZslTraceProductionLink;
import com.zsl.tracedb.model.ZslTraceProductionLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZslTraceProductionLinkMapper {
    int countByExample(ZslTraceProductionLinkExample example);

    int deleteByExample(ZslTraceProductionLinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZslTraceProductionLink record);

    int insertSelective(ZslTraceProductionLink record);

    List<ZslTraceProductionLink> selectByExample(ZslTraceProductionLinkExample example);

    ZslTraceProductionLink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZslTraceProductionLink record, @Param("example") ZslTraceProductionLinkExample example);

    int updateByExample(@Param("record") ZslTraceProductionLink record, @Param("example") ZslTraceProductionLinkExample example);

    int updateByPrimaryKeySelective(ZslTraceProductionLink record);

    int updateByPrimaryKey(ZslTraceProductionLink record);
}