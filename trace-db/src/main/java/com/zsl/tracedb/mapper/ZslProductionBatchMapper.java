package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ZslProductionBatch;
import com.zsl.tracedb.model.ZslProductionBatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZslProductionBatchMapper {
    int countByExample(ZslProductionBatchExample example);

    int deleteByExample(ZslProductionBatchExample example);

    int deleteByPrimaryKey(Integer batchId);

    int insert(ZslProductionBatch record);

    int insertSelective(ZslProductionBatch record);

    List<ZslProductionBatch> selectByExample(ZslProductionBatchExample example);

    ZslProductionBatch selectByPrimaryKey(Integer batchId);

    int updateByExampleSelective(@Param("record") ZslProductionBatch record, @Param("example") ZslProductionBatchExample example);

    int updateByExample(@Param("record") ZslProductionBatch record, @Param("example") ZslProductionBatchExample example);

    int updateByPrimaryKeySelective(ZslProductionBatch record);

    int updateByPrimaryKey(ZslProductionBatch record);
}