package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ZslScanRecord;
import com.zsl.tracedb.model.ZslScanRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZslScanRecordMapper {
    int countByExample(ZslScanRecordExample example);

    int deleteByExample(ZslScanRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ZslScanRecord record);

    int insertSelective(ZslScanRecord record);

    List<ZslScanRecord> selectByExample(ZslScanRecordExample example);

    ZslScanRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ZslScanRecord record, @Param("example") ZslScanRecordExample example);

    int updateByExample(@Param("record") ZslScanRecord record, @Param("example") ZslScanRecordExample example);

    int updateByPrimaryKeySelective(ZslScanRecord record);

    int updateByPrimaryKey(ZslScanRecord record);
}