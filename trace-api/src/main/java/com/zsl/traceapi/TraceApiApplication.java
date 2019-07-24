package com.zsl.traceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TraceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TraceApiApplication.class, args);
    }
}
