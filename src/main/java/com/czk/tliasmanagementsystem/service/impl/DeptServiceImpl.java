package com.czk.tliasmanagementsystem.service.impl;

import com.czk.tliasmanagementsystem.mapper.DeptMapper;
import com.czk.tliasmanagementsystem.mapper.EmpMapper;
import com.czk.tliasmanagementsystem.pojo.Dept;
import com.czk.tliasmanagementsystem.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        deptMapper.delete(id);

        Integer[] ids = {id};
        empMapper.delete(ids);

    }

    @Override
    public void insert(Dept dept){

        LocalDateTime now = LocalDateTime.now();
        dept.setCreateTime(now);
        dept.setUpdateTime(now);

        deptMapper.insert(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept){
        LocalDateTime now = LocalDateTime.now();
        dept.setUpdateTime(now);

        deptMapper.update(dept);
    }

}
