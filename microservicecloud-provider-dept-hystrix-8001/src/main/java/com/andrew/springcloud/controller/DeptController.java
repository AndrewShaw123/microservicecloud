package com.andrew.springcloud.controller;

import com.andrew.springcloud.entities.Dept;
import com.andrew.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * DeptController Class
 *
 * @HystrixCommand
 * 断路器
 * 调用服务方法失败并抛出异常后，会自动调用注解标的fallbackMethod指定的方法
 *
 * @author andrew
 * @date 2020/5/15
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept add(@PathVariable("id") Long id){
        Dept dept = deptService.get(id);
        if(dept==null){
            throw new RuntimeException("该ID："+id+"没有对应的信息");
        }
        return dept;
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> add(){
        return deptService.list();
    }


    //-----------------------------------------------------------------------------------

    public Dept processHystrix_Get(@PathVariable("id")Long id){
        return new Dept().setDeptno(id).setDname("该ID："+id+"没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }

    //-----------------------------------------------------------------------------------


    /*
    * Eureka服务发现
    * @EnableDiscoveryClient
    * */
    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");

        for (ServiceInstance element :instances){
            System.out.println(element.getServiceId());
            System.out.println(element.getHost());
            System.out.println(element.getPort());
            System.out.println(element.getUri());
        }
        return this.discoveryClient;

    }

}
