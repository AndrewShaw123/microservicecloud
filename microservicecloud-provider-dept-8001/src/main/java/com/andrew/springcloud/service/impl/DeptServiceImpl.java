package com.andrew.springcloud.service.impl;

import com.andrew.springcloud.dao.DeptDao;
import com.andrew.springcloud.entities.Dept;
import com.andrew.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DeptServiceImpl Class
 *
 * @author andrew
 * @date 2020/5/15
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean add(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> list() {
        return deptDao.findAll();
    }
}
