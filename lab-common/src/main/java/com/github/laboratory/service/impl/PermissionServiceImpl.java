package com.github.laboratory.service.impl;

import com.github.laboratory.entity.Permission;
import com.github.laboratory.mapper.PermissionMapper;
import com.github.laboratory.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限信息表 服务实现类
 * </p>
 *
 * @author 3795
 * @since 2021-03-29
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}
