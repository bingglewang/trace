package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.MaterialWarehouseOut;
import com.zsl.tracedb.model.MaterialWarehouseOutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialWarehouseOutMapper {
    int countByExample(MaterialWarehouseOutExample example);

    int deleteByExample(MaterialWarehouseOutExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MaterialWarehouseOut record);

    int insertSelective(MaterialWarehouseOut record);

    List<MaterialWarehouseOut> selectByExample(MaterialWarehouseOutExample example);

    MaterialWarehouseOut selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MaterialWarehouseOut record, @Param("example") MaterialWarehouseOutExample example);

    int updateByExample(@Param("record") MaterialWarehouseOut record, @Param("example") MaterialWarehouseOutExample example);

    int updateByPrimaryKeySelective(MaterialWarehouseOut record);

    int updateByPrimaryKey(MaterialWarehouseOut record);
}