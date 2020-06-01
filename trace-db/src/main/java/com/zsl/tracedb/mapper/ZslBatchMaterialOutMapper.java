package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ZslBatchMaterialOut;
import com.zsl.tracedb.model.ZslBatchMaterialOutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZslBatchMaterialOutMapper {
    int countByExample(ZslBatchMaterialOutExample example);

    int deleteByExample(ZslBatchMaterialOutExample example);

    int deleteByPrimaryKey(Integer batchMaterialOutId);

    int insert(ZslBatchMaterialOut record);

    int insertSelective(ZslBatchMaterialOut record);

    List<ZslBatchMaterialOut> selectByExample(ZslBatchMaterialOutExample example);

    ZslBatchMaterialOut selectByPrimaryKey(Integer batchMaterialOutId);

    int updateByExampleSelective(@Param("record") ZslBatchMaterialOut record, @Param("example") ZslBatchMaterialOutExample example);

    int updateByExample(@Param("record") ZslBatchMaterialOut record, @Param("example") ZslBatchMaterialOutExample example);

    int updateByPrimaryKeySelective(ZslBatchMaterialOut record);

    int updateByPrimaryKey(ZslBatchMaterialOut record);
}