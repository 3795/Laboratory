package com.github.laboratory.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.laboratory.entity.User;
import com.github.laboratory.mapper.UserMapper;
import com.github.laboratory.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author 3795
 * @since 2021-03-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void add(User user) {
        this.save(user);
    }

    @Override
    public List<User> findAll() {
        return this.list();
    }
}
