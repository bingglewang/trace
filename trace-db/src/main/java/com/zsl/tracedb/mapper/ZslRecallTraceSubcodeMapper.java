package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ZslRecallTraceSubcode;
import com.zsl.tracedb.model.ZslRecallTraceSubcodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZslRecallTraceSubcodeMapper {
    int countByExample(ZslRecallTraceSubcodeExample example);

    int deleteByExample(ZslRecallTraceSubcodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZslRecallTraceSubcode record);

    int insertSelective(ZslRecallTraceSubcode record);

    List<ZslRecallTraceSubcode> selectByExample(ZslRecallTraceSubcodeExample example);

    ZslRecallTraceSubcode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZslRecallTraceSubcode record, @Param("example") ZslRecallTraceSubcodeExample example);

    int updateByExample(@Param("record") ZslRecallTraceSubcode record, @Param("example") ZslRecallTraceSubcodeExample example);

    int updateByPrimaryKeySelective(ZslRecallTraceSubcode record);

    int updateByPrimaryKey(ZslRecallTraceSubcode record);
}