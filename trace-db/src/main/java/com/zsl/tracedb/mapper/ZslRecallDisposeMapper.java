package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ZslRecallDispose;
import com.zsl.tracedb.model.ZslRecallDisposeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZslRecallDisposeMapper {
    int countByExample(ZslRecallDisposeExample example);

    int deleteByExample(ZslRecallDisposeExample example);

    int deleteByPrimaryKey(Integer recallDisposeId);

    int insert(ZslRecallDispose record);

    int insertSelective(ZslRecallDispose record);

    List<ZslRecallDispose> selectByExample(ZslRecallDisposeExample example);

    ZslRecallDispose selectByPrimaryKey(Integer recallDisposeId);

    int updateByExampleSelective(@Param("record") ZslRecallDispose record, @Param("example") ZslRecallDisposeExample example);

    int updateByExample(@Param("record") ZslRecallDispose record, @Param("example") ZslRecallDisposeExample example);

    int updateByPrimaryKeySelective(ZslRecallDispose record);

    int updateByPrimaryKey(ZslRecallDispose record);
}