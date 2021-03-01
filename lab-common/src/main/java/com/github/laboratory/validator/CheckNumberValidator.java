package com.github.laboratory.validator;

import com.github.laboratory.annotation.CheckNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 校验注解
 */
public class CheckNumberValidator implements ConstraintValidator<CheckNumber, Object> {

    private CheckNumber checkNumber;

    @Override
    public void initialize(CheckNumber annotation) {
        this.checkNumber = annotation;
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        try {
            long target = Long.parseLong(o.toString());
            return target >= checkNumber.min() && target <= checkNumber.max();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
