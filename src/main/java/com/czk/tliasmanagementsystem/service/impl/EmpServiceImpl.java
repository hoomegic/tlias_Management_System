package com.czk.tliasmanagementsystem.service.impl;

import com.czk.tliasmanagementsystem.mapper.EmpMapper;
import com.czk.tliasmanagementsystem.pojo.Emp;
import com.czk.tliasmanagementsystem.pojo.PageBean;
import com.czk.tliasmanagementsystem.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Override
    public Emp login(Emp emp) {

        String username = emp.getUsername();
        String password = emp.getPassword();

        Emp e = empMapper.login(username, password);
        return e;
    }

    @Override
    public Emp findById(Integer id) {
        Emp emp = empMapper.findById(id);
        return emp;
    }

    @Override
    public void insert(Emp emp) {
        LocalDateTime now = LocalDateTime.now();
        emp.setCreateTime(now);
        emp.setUpdateTime(now);
        empMapper.insert(emp);
    }

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(String name, short gender, short job, LocalDate entrydate, Integer deptId, Integer page, Integer pagesize) {
        Integer start = ( page - 1 ) * pagesize;

        Long total = empMapper.specifiedFind(name,gender,job,entrydate,deptId);

        List<Emp> list = empMapper.specifiedList(name,gender,job,entrydate,deptId, start, pagesize);

        System.out.println(name+"+"+gender+"+"+job+"+"+entrydate);
        System.out.println(page+"-"+pagesize);

        PageBean pageBean = new PageBean(total,list);

        return pageBean;

    }

    @Override
    public void delete(Integer[] ids){
        empMapper.delete(ids);
    }
}
