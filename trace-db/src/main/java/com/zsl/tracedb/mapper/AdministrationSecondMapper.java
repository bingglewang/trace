package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.AdministrationSecond;
import com.zsl.tracedb.model.AdministrationSecondExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdministrationSecondMapper {
    int countByExample(AdministrationSecondExample example);

    int deleteByExample(AdministrationSecondExample example);

    int deleteByPrimaryKey(Integer secondAdministrationId);

    int insert(AdministrationSecond record);

    int insertSelective(AdministrationSecond record);

    List<AdministrationSecond> selectByExample(AdministrationSecondExample example);

    AdministrationSecond selectByPrimaryKey(Integer secondAdministrationId);

    int updateByExampleSelective(@Param("record") AdministrationSecond record, @Param("example") AdministrationSecondExample example);

    int updateByExample(@Param("record") AdministrationSecond record, @Param("example") AdministrationSecondExample example);

    int updateByPrimaryKeySelective(AdministrationSecond record);

    int updateByPrimaryKey(AdministrationSecond record);
}