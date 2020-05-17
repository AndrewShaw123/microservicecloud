package com.andrew.springcloud.service;

import com.andrew.springcloud.entities.Dept;

import java.util.List;

/**
 * DeptService Class
 *
 * @author andrew
 * @date 2020/5/15
 */
public interface DeptService {

    public boolean add(Dept dept);

    public Dept get(Long id);

    public List<Dept> list();

}
