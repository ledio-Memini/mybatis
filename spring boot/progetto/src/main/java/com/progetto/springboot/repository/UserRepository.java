package com.progetto.springboot.repository;

import java.util.List;
import com.progetto.springboot.entity.User;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


@Mapper
public interface UserRepository {

    @Select("select * from persona")
    public List<User> findAll();

    @Select("SELECT * FROM persona WHERE id = #{id}")
    public User findById(long id);

    @Delete("DELETE FROM persona WHERE id = #{id}")
    public int deleteById(long id);

    @Insert("INSERT INTO persona(id, firstName, lastName,emailId) " +
         " VALUES (#{id}, #{firstName}, #{lastName}, #{emailId})")
    public int insert(User user);

    @Update("Update persona set firstName=#{firstName}, " +
         " lastName=#{lastName}, emailId=#{emailId} where id=#{id}")
    public int update(User user);
}
