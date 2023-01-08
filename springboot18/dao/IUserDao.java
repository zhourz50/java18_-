package com.example.springboot18.dao;

import com.example.springboot18.model.User;

import java.util.List;

// 提供sql语句
public interface IUserDao {

    public int save(User user);

    public List<User> selectByCondition(User user);

    public User selectById(Integer id);



}
