package com.czk.tliasmanagementsystem.controller;

import com.czk.tliasmanagementsystem.pojo.Emp;
import com.czk.tliasmanagementsystem.pojo.Result;
import com.czk.tliasmanagementsystem.service.EmpService;
import com.czk.tliasmanagementsystem.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){

        Emp e = empService.login(emp);

        if(e != null){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("username",e.getUsername());
            claims.put("name",e.getName());

            String jwt = JwtUtils.generateJWT(claims);
            return Result.success(jwt);

        }

        return Result.error("用户名或者密码错误");

    }
}
