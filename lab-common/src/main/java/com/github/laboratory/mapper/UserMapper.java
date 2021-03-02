package com.github.laboratory.mapper;

import com.github.laboratory.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author 3795
 * @since 2021-03-02
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}
