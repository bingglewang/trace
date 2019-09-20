package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ZslTraceSid;
import com.zsl.tracedb.model.ZslTraceSidExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZslTraceSidMapper {
    int countByExample(ZslTraceSidExample example);

    int deleteByExample(ZslTraceSidExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ZslTraceSid record);

    int insertSelective(ZslTraceSid record);

    List<ZslTraceSid> selectByExample(ZslTraceSidExample example);

    ZslTraceSid selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ZslTraceSid record, @Param("example") ZslTraceSidExample example);

    int updateByExample(@Param("record") ZslTraceSid record, @Param("example") ZslTraceSidExample example);

    int updateByPrimaryKeySelective(ZslTraceSid record);

    int updateByPrimaryKey(ZslTraceSid record);
}