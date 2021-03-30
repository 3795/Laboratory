package com.github.laboratory.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author qihao
 * @description 用户详情
 * @date 2021/3/30 15:26
 */
public interface UserDetailService {

    UserDetails getUserByUsername(String username);
}
