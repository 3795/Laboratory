package com.github.laboratory.req;

import com.github.laboratory.annotation.CheckNumber;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author qihao
 * @description 测试自定义验证的输入
 * @date 2021/2/24 11:25
 */
@Data
public class ValidateReq {

    @NotEmpty(message = "username不能为空")
    private String username;

    @NotNull(message = "status不能为空")
    private Integer status;

    @CheckNumber(min = 0, max = 120, message = "age不合法")
    @NotNull
    private Integer age;

    @Override
    public String toString() {
        return "ValidateReq{" +
                "username='" + username + '\'' +
                ", status=" + status +
                ", age=" + age +
                '}';
    }
}
