package com.andrew.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * EurekaServer7001_App Class
 *
 * @author andrew
 * @date 2020/5/15
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7001_App {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001_App.class,args);
    }

}
