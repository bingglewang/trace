package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.AllianceBusinesslSite;
import com.zsl.tracedb.model.AllianceBusinesslSiteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AllianceBusinesslSiteMapper {
    int countByExample(AllianceBusinesslSiteExample example);

    int deleteByExample(AllianceBusinesslSiteExample example);

    int deleteByPrimaryKey(Integer allianceBusinesslSiteId);

    int insert(AllianceBusinesslSite record);

    int insertSelective(AllianceBusinesslSite record);

    List<AllianceBusinesslSite> selectByExample(AllianceBusinesslSiteExample example);

    AllianceBusinesslSite selectByPrimaryKey(Integer allianceBusinesslSiteId);

    int updateByExampleSelective(@Param("record") AllianceBusinesslSite record, @Param("example") AllianceBusinesslSiteExample example);

    int updateByExample(@Param("record") AllianceBusinesslSite record, @Param("example") AllianceBusinesslSiteExample example);

    int updateByPrimaryKeySelective(AllianceBusinesslSite record);

    int updateByPrimaryKey(AllianceBusinesslSite record);
}