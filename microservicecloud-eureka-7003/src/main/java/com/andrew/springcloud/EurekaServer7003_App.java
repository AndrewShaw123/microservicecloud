package com.andrew.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * EurekaServer7003_App Class
 *
 * @author andrew
 * @date 2020/5/16
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7003_App {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7003_App.class,args);
    }

}
