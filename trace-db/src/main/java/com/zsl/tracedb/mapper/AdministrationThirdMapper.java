package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.AdministrationThird;
import com.zsl.tracedb.model.AdministrationThirdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdministrationThirdMapper {
    int countByExample(AdministrationThirdExample example);

    int deleteByExample(AdministrationThirdExample example);

    int deleteByPrimaryKey(Integer thirdAdministrationId);

    int insert(AdministrationThird record);

    int insertSelective(AdministrationThird record);

    List<AdministrationThird> selectByExample(AdministrationThirdExample example);

    AdministrationThird selectByPrimaryKey(Integer thirdAdministrationId);

    int updateByExampleSelective(@Param("record") AdministrationThird record, @Param("example") AdministrationThirdExample example);

    int updateByExample(@Param("record") AdministrationThird record, @Param("example") AdministrationThirdExample example);

    int updateByPrimaryKeySelective(AdministrationThird record);

    int updateByPrimaryKey(AdministrationThird record);
}