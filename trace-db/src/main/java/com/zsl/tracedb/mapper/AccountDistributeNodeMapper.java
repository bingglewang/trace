package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.AccountDistributeNode;
import com.zsl.tracedb.model.AccountDistributeNodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountDistributeNodeMapper {
    int countByExample(AccountDistributeNodeExample example);

    int deleteByExample(AccountDistributeNodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AccountDistributeNode record);

    int insertSelective(AccountDistributeNode record);

    List<AccountDistributeNode> selectByExample(AccountDistributeNodeExample example);

    AccountDistributeNode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AccountDistributeNode record, @Param("example") AccountDistributeNodeExample example);

    int updateByExample(@Param("record") AccountDistributeNode record, @Param("example") AccountDistributeNodeExample example);

    int updateByPrimaryKeySelective(AccountDistributeNode record);

    int updateByPrimaryKey(AccountDistributeNode record);
}