package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.AdministrationFourth;
import com.zsl.tracedb.model.AdministrationFourthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdministrationFourthMapper {
    int countByExample(AdministrationFourthExample example);

    int deleteByExample(AdministrationFourthExample example);

    int deleteByPrimaryKey(Integer fourthAdministrationId);

    int insert(AdministrationFourth record);

    int insertSelective(AdministrationFourth record);

    List<AdministrationFourth> selectByExample(AdministrationFourthExample example);

    AdministrationFourth selectByPrimaryKey(Integer fourthAdministrationId);

    int updateByExampleSelective(@Param("record") AdministrationFourth record, @Param("example") AdministrationFourthExample example);

    int updateByExample(@Param("record") AdministrationFourth record, @Param("example") AdministrationFourthExample example);

    int updateByPrimaryKeySelective(AdministrationFourth record);

    int updateByPrimaryKey(AdministrationFourth record);
}