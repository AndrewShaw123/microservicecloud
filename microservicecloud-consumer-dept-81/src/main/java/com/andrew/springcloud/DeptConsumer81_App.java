package com.andrew.springcloud;

import com.andrew.mycustomrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * DeptConsumer81_App Class
 *
 * 自定义负载均衡算法
 * 添加注解@RibbonClient
 *
 * @author andrew
 * @date 2020/5/15
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration = MyRule.class)
public class DeptConsumer81_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer81_App.class,args);
    }

}
