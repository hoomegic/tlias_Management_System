package com.czk.tliasmanagementsystem.service;

import com.czk.tliasmanagementsystem.pojo.Emp;
import com.czk.tliasmanagementsystem.pojo.PageBean;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface EmpService {

    void delete(Integer[] ids);

    PageBean page(String name, short gender, short job, LocalDate entrydate, Integer deptId, Integer page, Integer pagesize);

    void insert(Emp emp);

    Emp findById(Integer id);

    Emp login(Emp emp);

}
