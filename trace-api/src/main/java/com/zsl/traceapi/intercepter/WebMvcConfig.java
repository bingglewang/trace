package com.zsl.traceapi.intercepter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器
        registry.addInterceptor(centerAdminLoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/trace/insertScanRecord")
                .excludePathPatterns("/spurtCode/list")
                .excludePathPatterns("/spurtCode/isExist")
                .excludePathPatterns("/trace/getScanRecordBySid")
                .excludePathPatterns("/trace/getTraceGoodInfo")
                .excludePathPatterns("/trace/preCreatePaperCode") //不开放
                .excludePathPatterns("/trace/testTraceUpdate")  //不开放
                .excludePathPatterns("/trace/testTraceCreate")  //不开放
                .excludePathPatterns("/trace/getCodePartBySid")  //不开放
                .excludePathPatterns("/trace/getNextSidByCodeNumber")  //不开放
                .excludePathPatterns("/trace/relationMqSubCode")
                .excludePathPatterns("/error")
                .excludePathPatterns("/getIpInfo.php");
    }

    @Bean
    public CenterAdminLoginInterceptor centerAdminLoginInterceptor() {
        return new CenterAdminLoginInterceptor();
    }
}
