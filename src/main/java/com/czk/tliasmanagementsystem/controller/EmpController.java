package com.czk.tliasmanagementsystem.controller;

import com.czk.tliasmanagementsystem.anno.Log;
import com.czk.tliasmanagementsystem.pojo.Emp;
import com.czk.tliasmanagementsystem.pojo.PageBean;
import com.czk.tliasmanagementsystem.pojo.Result;
import com.czk.tliasmanagementsystem.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/emps")
    public Result find(@ModelAttribute Emp emp, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pagesize){

        PageBean pageBean = empService.page(emp.getName(),emp.getGender(),emp.getJob(),emp.getEntrydate(),emp.getDeptId(),page,pagesize);

        return Result.success(pageBean);
    }

    @Log
    @DeleteMapping("/emps/{ids}")
    public Result delete(@PathVariable Integer[] ids){
        empService.delete(ids);
        return Result.success();
    }

    @Log
    @PostMapping("/emps")
    public Result insert(@RequestBody Emp emp){
        empService.insert(emp);
        return Result.success();
    }

    @GetMapping("/emps/{id}")
    public Result findById(@PathVariable Integer id){
        Emp emp = empService.findById(id);
        return Result.success(emp);
    }

    @Log
    @PutMapping("/upload")
    public Result update(MultipartFile image) throws IOException {
        String originalFilename = image.getOriginalFilename();
        String extname = originalFilename.substring(originalFilename.lastIndexOf("."));
        String s = UUID.randomUUID().toString() + extname;

        image.transferTo(new File("D:/"+s));
        return Result.success();
    }
}
