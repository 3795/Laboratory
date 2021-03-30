package com.github.laboratory.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.laboratory.annotation.Write;
import com.github.laboratory.entity.User;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author 3795
 * @since 2021-03-02
 */
public interface UserService extends IService<User> {

    /**
     * 新增用户
     *
     * @param user
     */
    void add(User user);

    /**
     * 查找所有用户
     *
     * @return
     */
    List<User> findAll();

    /**
     * 根据username查找
     *
     * @param username
     * @return
     */
    User getByUsername(String username);
}
