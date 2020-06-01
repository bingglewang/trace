package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ZslProductionScene;
import com.zsl.tracedb.model.ZslProductionSceneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZslProductionSceneMapper {
    int countByExample(ZslProductionSceneExample example);

    int deleteByExample(ZslProductionSceneExample example);

    int deleteByPrimaryKey(Integer sceneId);

    int insert(ZslProductionScene record);

    int insertSelective(ZslProductionScene record);

    List<ZslProductionScene> selectByExampleWithBLOBs(ZslProductionSceneExample example);

    List<ZslProductionScene> selectByExample(ZslProductionSceneExample example);

    ZslProductionScene selectByPrimaryKey(Integer sceneId);

    int updateByExampleSelective(@Param("record") ZslProductionScene record, @Param("example") ZslProductionSceneExample example);

    int updateByExampleWithBLOBs(@Param("record") ZslProductionScene record, @Param("example") ZslProductionSceneExample example);

    int updateByExample(@Param("record") ZslProductionScene record, @Param("example") ZslProductionSceneExample example);

    int updateByPrimaryKeySelective(ZslProductionScene record);

    int updateByPrimaryKeyWithBLOBs(ZslProductionScene record);

    int updateByPrimaryKey(ZslProductionScene record);
}