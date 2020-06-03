package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ZslProductionBatchBindSid;
import com.zsl.tracedb.model.ZslProductionBatchBindSidExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZslProductionBatchBindSidMapper {
    int countByExample(ZslProductionBatchBindSidExample example);

    int deleteByExample(ZslProductionBatchBindSidExample example);

    int deleteByPrimaryKey(Integer batchSidId);

    int insert(ZslProductionBatchBindSid record);

    int insertSelective(ZslProductionBatchBindSid record);

    List<ZslProductionBatchBindSid> selectByExample(ZslProductionBatchBindSidExample example);

    ZslProductionBatchBindSid selectByPrimaryKey(Integer batchSidId);

    int updateByExampleSelective(@Param("record") ZslProductionBatchBindSid record, @Param("example") ZslProductionBatchBindSidExample example);

    int updateByExample(@Param("record") ZslProductionBatchBindSid record, @Param("example") ZslProductionBatchBindSidExample example);

    int updateByPrimaryKeySelective(ZslProductionBatchBindSid record);

    int updateByPrimaryKey(ZslProductionBatchBindSid record);
}