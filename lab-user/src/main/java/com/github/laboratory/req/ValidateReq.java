package com.github.laboratory.req;

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
@ToString
public class ValidateReq {

    @NotEmpty(message = "姓名不能为空")
    private String username;

    @NotNull(message = "状态不能为空")
    private Integer statue;
}
