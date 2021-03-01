package com.github.laboratory.controller;

import com.github.laboratory.req.ValidateReq;
import com.github.laboratory.vo.ServerResponseVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author qihao
 * @description 测试Validate自定义注解
 * @date 2021/2/24 11:23
 * 参考：https://blog.csdn.net/qq_21187515/article/details/109673109?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-5.control&dist_request_id=a4e1d2a3-5f87-4b8d-9f6c-bf7588dade5f&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-5.control
 */
@RequestMapping("/validate")
@RestController
public class ValidationController {

    @PostMapping
    public ServerResponseVO testValidate(@RequestBody @Valid ValidateReq validateReq) {
        return ServerResponseVO.success(validateReq);
    }
}
