package com.andrew.springcloud.dao;

import com.andrew.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * DeptDao Class
 *
 * @author andrew
 * @date 2020/5/15
 */
@Mapper
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();


}
