package com.zsl.traceapi.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置类
 * Created by wangbinggui on 2019/5/27.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.zsl.tracedb.mapper","com.zsl.traceapi.dao"})
public class MyBatisConfig {
}
