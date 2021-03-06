package com.andrew.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Config3344_App Class
 *
 * @author andrew
 * @date 2020/5/20
 */
@SpringBootApplication
@EnableConfigServer
public class Config3344_App {
    public static void main(String[] args) {
        SpringApplication.run(Config3344_App.class,args);
    }

}
