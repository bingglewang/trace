package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ZslConflictCode;
import com.zsl.tracedb.model.ZslConflictCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZslConflictCodeMapper {
    int countByExample(ZslConflictCodeExample example);

    int deleteByExample(ZslConflictCodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZslConflictCode record);

    int insertSelective(ZslConflictCode record);

    List<ZslConflictCode> selectByExample(ZslConflictCodeExample example);

    ZslConflictCode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZslConflictCode record, @Param("example") ZslConflictCodeExample example);

    int updateByExample(@Param("record") ZslConflictCode record, @Param("example") ZslConflictCodeExample example);

    int updateByPrimaryKeySelective(ZslConflictCode record);

    int updateByPrimaryKey(ZslConflictCode record);
}