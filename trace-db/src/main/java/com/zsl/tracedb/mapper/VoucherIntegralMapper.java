package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.VoucherIntegral;
import com.zsl.tracedb.model.VoucherIntegralExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VoucherIntegralMapper {
    int countByExample(VoucherIntegralExample example);

    int deleteByExample(VoucherIntegralExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VoucherIntegral record);

    int insertSelective(VoucherIntegral record);

    List<VoucherIntegral> selectByExample(VoucherIntegralExample example);

    VoucherIntegral selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VoucherIntegral record, @Param("example") VoucherIntegralExample example);

    int updateByExample(@Param("record") VoucherIntegral record, @Param("example") VoucherIntegralExample example);

    int updateByPrimaryKeySelective(VoucherIntegral record);

    int updateByPrimaryKey(VoucherIntegral record);
}