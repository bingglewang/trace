package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ZslConflictCodeDetail;
import com.zsl.tracedb.model.ZslConflictCodeDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZslConflictCodeDetailMapper {
    int countByExample(ZslConflictCodeDetailExample example);

    int deleteByExample(ZslConflictCodeDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZslConflictCodeDetail record);

    int insertSelective(ZslConflictCodeDetail record);

    List<ZslConflictCodeDetail> selectByExample(ZslConflictCodeDetailExample example);

    ZslConflictCodeDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZslConflictCodeDetail record, @Param("example") ZslConflictCodeDetailExample example);

    int updateByExample(@Param("record") ZslConflictCodeDetail record, @Param("example") ZslConflictCodeDetailExample example);

    int updateByPrimaryKeySelective(ZslConflictCodeDetail record);

    int updateByPrimaryKey(ZslConflictCodeDetail record);
}