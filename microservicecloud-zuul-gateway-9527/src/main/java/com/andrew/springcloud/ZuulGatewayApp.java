package com.andrew.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * ZuulGatewayApp Class
 * 访问地址 http://localhost:9527/microservicecloud-dept/dept/get/1
 * microservicecloud-dept微服务名称
 *
 * @author andrew
 * @date 2020/5/19
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayApp {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApp.class,args);
    }

}
