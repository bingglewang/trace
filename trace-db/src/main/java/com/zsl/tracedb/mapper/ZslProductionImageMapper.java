package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ZslProductionImage;
import com.zsl.tracedb.model.ZslProductionImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZslProductionImageMapper {
    int countByExample(ZslProductionImageExample example);

    int deleteByExample(ZslProductionImageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZslProductionImage record);

    int insertSelective(ZslProductionImage record);

    List<ZslProductionImage> selectByExample(ZslProductionImageExample example);

    ZslProductionImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZslProductionImage record, @Param("example") ZslProductionImageExample example);

    int updateByExample(@Param("record") ZslProductionImage record, @Param("example") ZslProductionImageExample example);

    int updateByPrimaryKeySelective(ZslProductionImage record);

    int updateByPrimaryKey(ZslProductionImage record);
}