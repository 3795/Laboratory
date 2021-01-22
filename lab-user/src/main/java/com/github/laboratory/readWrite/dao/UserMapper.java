package com.github.laboratory.readWrite.dao;

import com.github.laboratory.readWrite.bean.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User> {
}
