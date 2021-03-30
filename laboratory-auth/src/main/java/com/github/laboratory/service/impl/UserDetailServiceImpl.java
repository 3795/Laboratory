package com.github.laboratory.service.impl;

import com.github.laboratory.entity.User;
import com.github.laboratory.mapper.UserMapper;
import com.github.laboratory.service.UserDetailService;
import com.github.laboratory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * @author qihao
 * @description 用户信息详情
 * @date 2021/3/30 15:26
 */
@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails getUserByUsername(String username) {
        User user = userService.getByUsername(username);
        if (user == null) {
            return null;
        }

        return null;
    }
}
