package com.demo.io.gateway;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class DubboGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboGatewayApplication.class, args);
    }
}
