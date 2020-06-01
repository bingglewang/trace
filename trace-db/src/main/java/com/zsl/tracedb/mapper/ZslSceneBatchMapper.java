package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ZslSceneBatch;
import com.zsl.tracedb.model.ZslSceneBatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZslSceneBatchMapper {
    int countByExample(ZslSceneBatchExample example);

    int deleteByExample(ZslSceneBatchExample example);

    int deleteByPrimaryKey(Integer sceneBatchId);

    int insert(ZslSceneBatch record);

    int insertSelective(ZslSceneBatch record);

    List<ZslSceneBatch> selectByExample(ZslSceneBatchExample example);

    ZslSceneBatch selectByPrimaryKey(Integer sceneBatchId);

    int updateByExampleSelective(@Param("record") ZslSceneBatch record, @Param("example") ZslSceneBatchExample example);

    int updateByExample(@Param("record") ZslSceneBatch record, @Param("example") ZslSceneBatchExample example);

    int updateByPrimaryKeySelective(ZslSceneBatch record);

    int updateByPrimaryKey(ZslSceneBatch record);
}