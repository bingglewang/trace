package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ZslSceneImage;
import com.zsl.tracedb.model.ZslSceneImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZslSceneImageMapper {
    int countByExample(ZslSceneImageExample example);

    int deleteByExample(ZslSceneImageExample example);

    int deleteByPrimaryKey(Integer sceneImageId);

    int insert(ZslSceneImage record);

    int insertSelective(ZslSceneImage record);

    List<ZslSceneImage> selectByExample(ZslSceneImageExample example);

    ZslSceneImage selectByPrimaryKey(Integer sceneImageId);

    int updateByExampleSelective(@Param("record") ZslSceneImage record, @Param("example") ZslSceneImageExample example);

    int updateByExample(@Param("record") ZslSceneImage record, @Param("example") ZslSceneImageExample example);

    int updateByPrimaryKeySelective(ZslSceneImage record);

    int updateByPrimaryKey(ZslSceneImage record);
}