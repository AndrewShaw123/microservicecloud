package com.andrew.springcloud.controller;

import com.andrew.springcloud.entities.Dept;
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
     * RestTemplate 提供HTTP访问restful接口
     * （url,requestMap,ResponseBean.class）
     *  请求地址，请求参数，HTTP响应转换成的对象类型
     */

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add",method = RequestMethod.POST)
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX_NAME+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable Long id){
        return restTemplate.getForObject(REST_URL_PREFIX_NAME+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX_NAME+"/dept/list",List.class);
    }

    @RequestMapping(value = "/consumer/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX_NAME+"/dept/discovery",Object.class);
    }




}
