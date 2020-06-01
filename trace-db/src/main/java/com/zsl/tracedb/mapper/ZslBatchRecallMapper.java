package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ZslBatchRecall;
import com.zsl.tracedb.model.ZslBatchRecallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZslBatchRecallMapper {
    int countByExample(ZslBatchRecallExample example);

    int deleteByExample(ZslBatchRecallExample example);

    int deleteByPrimaryKey(Integer batchRecallId);

    int insert(ZslBatchRecall record);

    int insertSelective(ZslBatchRecall record);

    List<ZslBatchRecall> selectByExampleWithBLOBs(ZslBatchRecallExample example);

    List<ZslBatchRecall> selectByExample(ZslBatchRecallExample example);

    ZslBatchRecall selectByPrimaryKey(Integer batchRecallId);

    int updateByExampleSelective(@Param("record") ZslBatchRecall record, @Param("example") ZslBatchRecallExample example);

    int updateByExampleWithBLOBs(@Param("record") ZslBatchRecall record, @Param("example") ZslBatchRecallExample example);

    int updateByExample(@Param("record") ZslBatchRecall record, @Param("example") ZslBatchRecallExample example);

    int updateByPrimaryKeySelective(ZslBatchRecall record);

    int updateByPrimaryKeyWithBLOBs(ZslBatchRecall record);

    int updateByPrimaryKey(ZslBatchRecall record);
}