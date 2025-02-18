package com.czk.tliasmanagementsystem.service;

import com.czk.tliasmanagementsystem.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> list();

    void delete(Integer id);

    void insert(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);
}
