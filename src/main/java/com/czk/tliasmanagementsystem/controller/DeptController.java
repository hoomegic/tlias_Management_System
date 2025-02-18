package com.czk.tliasmanagementsystem.controller;

import com.czk.tliasmanagementsystem.anno.Log;
import com.czk.tliasmanagementsystem.pojo.Dept;
import com.czk.tliasmanagementsystem.pojo.Result;
import com.czk.tliasmanagementsystem.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping()
    public Result list()
    {
        //log.info("查询所有部门信息");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        deptService.delete(id);

        return Result.success();
    }
    @Log
    @PostMapping()
    public Result insert(@RequestBody Dept dept){
        deptService.insert(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @Log
    @PutMapping()
    public Result update(@RequestBody Dept dept){
        deptService.update(dept);
        return Result.success();
    }

}
