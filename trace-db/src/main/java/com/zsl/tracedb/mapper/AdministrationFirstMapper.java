package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.AdministrationFirst;
import com.zsl.tracedb.model.AdministrationFirstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdministrationFirstMapper {
    int countByExample(AdministrationFirstExample example);

    int deleteByExample(AdministrationFirstExample example);

    int deleteByPrimaryKey(Integer nationId);

    int insert(AdministrationFirst record);

    int insertSelective(AdministrationFirst record);

    List<AdministrationFirst> selectByExample(AdministrationFirstExample example);

    AdministrationFirst selectByPrimaryKey(Integer nationId);

    int updateByExampleSelective(@Param("record") AdministrationFirst record, @Param("example") AdministrationFirstExample example);

    int updateByExample(@Param("record") AdministrationFirst record, @Param("example") AdministrationFirstExample example);

    int updateByPrimaryKeySelective(AdministrationFirst record);

    int updateByPrimaryKey(AdministrationFirst record);
}