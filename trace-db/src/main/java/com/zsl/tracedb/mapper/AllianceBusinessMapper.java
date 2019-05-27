package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.AllianceBusiness;
import com.zsl.tracedb.model.AllianceBusinessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AllianceBusinessMapper {
    int countByExample(AllianceBusinessExample example);

    int deleteByExample(AllianceBusinessExample example);

    int deleteByPrimaryKey(Integer allianceBusinessId);

    int insert(AllianceBusiness record);

    int insertSelective(AllianceBusiness record);

    List<AllianceBusiness> selectByExample(AllianceBusinessExample example);

    AllianceBusiness selectByPrimaryKey(Integer allianceBusinessId);

    int updateByExampleSelective(@Param("record") AllianceBusiness record, @Param("example") AllianceBusinessExample example);

    int updateByExample(@Param("record") AllianceBusiness record, @Param("example") AllianceBusinessExample example);

    int updateByPrimaryKeySelective(AllianceBusiness record);

    int updateByPrimaryKey(AllianceBusiness record);
}