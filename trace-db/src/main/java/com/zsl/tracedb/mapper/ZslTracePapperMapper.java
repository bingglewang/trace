package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ZslTracePapper;
import com.zsl.tracedb.model.ZslTracePapperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZslTracePapperMapper {
    int countByExample(ZslTracePapperExample example);

    int deleteByExample(ZslTracePapperExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZslTracePapper record);

    int insertSelective(ZslTracePapper record);

    List<ZslTracePapper> selectByExample(ZslTracePapperExample example);

    ZslTracePapper selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZslTracePapper record, @Param("example") ZslTracePapperExample example);

    int updateByExample(@Param("record") ZslTracePapper record, @Param("example") ZslTracePapperExample example);

    int updateByPrimaryKeySelective(ZslTracePapper record);

    int updateByPrimaryKey(ZslTracePapper record);
}