package com.github.laboratory.annotation;

import com.github.laboratory.validator.CheckNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验数字范围的自定义注解
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CheckNumberValidator.class})     // 指向校验的类
public @interface CheckNumber {
    long min() default 1;

    long max() default 1000;

    String message() default "数字不符合范围";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
