package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ZslTraceSubcode;
import com.zsl.tracedb.model.ZslTraceSubcodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZslTraceSubcodeMapper {
    int countByExample(ZslTraceSubcodeExample example);

    int deleteByExample(ZslTraceSubcodeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ZslTraceSubcode record);

    int insertSelective(ZslTraceSubcode record);

    List<ZslTraceSubcode> selectByExample(ZslTraceSubcodeExample example);

    ZslTraceSubcode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ZslTraceSubcode record, @Param("example") ZslTraceSubcodeExample example);

    int updateByExample(@Param("record") ZslTraceSubcode record, @Param("example") ZslTraceSubcodeExample example);

    int updateByPrimaryKeySelective(ZslTraceSubcode record);

    int updateByPrimaryKey(ZslTraceSubcode record);
}