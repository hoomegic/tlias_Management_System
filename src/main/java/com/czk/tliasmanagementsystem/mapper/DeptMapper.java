package com.czk.tliasmanagementsystem.mapper;

import com.czk.tliasmanagementsystem.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("select * from dept")
    List<Dept> list();

    @Select("delete from dept where id = #{id}")
    void delete(Integer id);

    @Select("insert into dept (name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    @Select("select * from dept where id = #{id}")
    Dept getById(Integer id);

    @Update("update dept SET name = #{name},update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
