package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.CodeTraceIntegralLog;
import com.zsl.tracedb.model.CodeTraceIntegralLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CodeTraceIntegralLogMapper {
    int countByExample(CodeTraceIntegralLogExample example);

    int deleteByExample(CodeTraceIntegralLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CodeTraceIntegralLog record);

    int insertSelective(CodeTraceIntegralLog record);

    List<CodeTraceIntegralLog> selectByExample(CodeTraceIntegralLogExample example);

    CodeTraceIntegralLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CodeTraceIntegralLog record, @Param("example") CodeTraceIntegralLogExample example);

    int updateByExample(@Param("record") CodeTraceIntegralLog record, @Param("example") CodeTraceIntegralLogExample example);

    int updateByPrimaryKeySelective(CodeTraceIntegralLog record);

    int updateByPrimaryKey(CodeTraceIntegralLog record);
}