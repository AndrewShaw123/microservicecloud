package com.andrew.springcloud.controller;

import com.andrew.springcloud.entities.Dept;
import com.andrew.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * DeptController_Consumer Class
 *
 * @author andrew
 * @date 2020/5/15
 */
@RestController
public class DeptController_Consumer {

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    private static final String REST_URL_PREFIX_NAME = "http://MICROSERVICECLOUD-DEPT";

    /**
     *  不使用RestTemplate,这里使用Feign调用接口
     */

    @Autowired
    private DeptClientService deptClientService;


    @RequestMapping(value = "/consumer/dept/add",method = RequestMethod.POST)
    public boolean add(Dept dept){
        return deptClientService.add(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable Long id){
        return deptClientService.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return deptClientService.list();
    }




}
