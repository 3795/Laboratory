package com.github.laboratory.readWrite.service;

import com.github.laboratory.readWrite.bean.User;
import com.github.laboratory.readWrite.config.Read;
import com.github.laboratory.readWrite.config.Write;
import com.github.laboratory.readWrite.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Write
    public void add(User user) {
        userMapper.insert(user);
    }

    @Read
    public List<User> findAll() {
        return userMapper.selectAll();
    }
}
