package com.lxl.sample.muti.dao.db1;

import com.lxl.sample.muti.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by lxl on 16/10/8.
 */
@Mapper
public interface UserDao {
    @Select("SELECT * FROM `User` WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Select("select `name`,age from `User` WHERE `name` = #{name}")
    List<Map> findAgeByName(@Param("name") String name);

    @Insert("INSERT INTO `User`(`name`,age) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);
}
