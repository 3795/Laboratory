package com.github.laboratory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qihao
 * @description TODO
 * @date 2021/3/29 16:48
 */
@Service
public class TestService {

    @Autowired
    private UserService userService;

    public void list() {
        userService.findAll().forEach(System.out::println);
    }
}
