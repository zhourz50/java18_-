package com.example.springboot18.service;

import com.example.springboot18.dao.IUserDao;
import com.example.springboot18.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 主要的业务逻辑处理
@Service
public class UserService {

    @Autowired
    private IUserDao userDao;

    @Transactional
    public int save(User user) {
        return userDao.save(user);
    }

    public List<User> selectByCondition(User user) {
        return userDao.selectByCondition(user);
    }

    public User selectById(Integer userId) {
        return userDao.selectById(userId);
    }

    public List<User> info(User user) { return userDao.selectByCondition(user);
    }

}
