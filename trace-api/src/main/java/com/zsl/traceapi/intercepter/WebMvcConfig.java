package com.zsl.traceapi.intercepter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public CenterAdminLoginInterceptor centerAdminLoginInterceptor() {
        return new CenterAdminLoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器
        registry.addInterceptor(centerAdminLoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/trace/insertScanRecord")
                .excludePathPatterns("/trace/getScanRecordBySid")
                .excludePathPatterns("/trace/getTraceGoodInfo");
    }
}
