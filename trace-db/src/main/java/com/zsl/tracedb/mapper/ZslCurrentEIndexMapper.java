package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ZslCurrentEIndex;
import com.zsl.tracedb.model.ZslCurrentEIndexExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZslCurrentEIndexMapper {
    int countByExample(ZslCurrentEIndexExample example);

    int deleteByExample(ZslCurrentEIndexExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZslCurrentEIndex record);

    int insertSelective(ZslCurrentEIndex record);

    List<ZslCurrentEIndex> selectByExample(ZslCurrentEIndexExample example);

    ZslCurrentEIndex selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZslCurrentEIndex record, @Param("example") ZslCurrentEIndexExample example);

    int updateByExample(@Param("record") ZslCurrentEIndex record, @Param("example") ZslCurrentEIndexExample example);

    int updateByPrimaryKeySelective(ZslCurrentEIndex record);

    int updateByPrimaryKey(ZslCurrentEIndex record);
}