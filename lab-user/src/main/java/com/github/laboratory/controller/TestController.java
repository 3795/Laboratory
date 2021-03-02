package com.github.laboratory.controller;

import com.github.laboratory.annotation.RedisLock;
import com.github.laboratory.enums.RedisLockTypeEnum;
import com.github.laboratory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis-lock")
public class TestController {

    @GetMapping
    @RedisLock(typeEnum = RedisLockTypeEnum.ONE, lockTime = 31)
    public String testRedisLock(@RequestParam("userId") String userId) {
        System.out.println("进入请求时间" + System.currentTimeMillis());
        System.out.println("睡眠前");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("睡眠后");
        return userId;
    }
}
