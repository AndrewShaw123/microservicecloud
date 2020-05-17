package com.andrew.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * DeptProvider8001_App Class
 * 启动@EnableCircuitBreaker 对Hystrix熔断机制的支持
 *
 * @author andrew
 * @date 2020/5/15
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker
public class DeptProvider8001_hystrix_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001_hystrix_App.class,args);
    }

}
