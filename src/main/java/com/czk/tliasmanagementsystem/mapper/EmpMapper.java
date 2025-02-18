package com.czk.tliasmanagementsystem.mapper;

import com.czk.tliasmanagementsystem.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select * from emp limit #{start}, #{pagesize}")
    List<Emp> list(Integer start, Integer pagesize);

    @Select("select count(*) from emp")
    Long total();

    Long specifiedFind(String name, short gender, short job, LocalDate entrydate, Integer deptId);

    List<Emp> specifiedList(String name, short gender, short job, LocalDate entrydate, Integer deptId,Integer start, Integer pagesize);

    void delete(Integer[] ids);

    void insert(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp findById(Integer id);

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp login(String username, String password);
}

