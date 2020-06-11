package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.MaterialWarehouse;
import com.zsl.tracedb.model.MaterialWarehouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialWarehouseMapper {
    int countByExample(MaterialWarehouseExample example);

    int deleteByExample(MaterialWarehouseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MaterialWarehouse record);

    int insertSelective(MaterialWarehouse record);

    List<MaterialWarehouse> selectByExample(MaterialWarehouseExample example);

    MaterialWarehouse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MaterialWarehouse record, @Param("example") MaterialWarehouseExample example);

    int updateByExample(@Param("record") MaterialWarehouse record, @Param("example") MaterialWarehouseExample example);

    int updateByPrimaryKeySelective(MaterialWarehouse record);

    int updateByPrimaryKey(MaterialWarehouse record);
}