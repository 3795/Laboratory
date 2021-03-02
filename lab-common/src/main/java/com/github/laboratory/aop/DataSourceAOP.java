package com.github.laboratory.aop;

import com.github.laboratory.config.readWrite.DynamicSwitchDbTypeUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
@Component
public class DataSourceAOP {

    @Pointcut(value = "@annotation(com.github.laboratory.annotation.Read)")
    public void readPointcut() {
    }

    @Pointcut("@annotation(com.github.laboratory.annotation.Write)")
    public void writePointcut() {
    }

    /**
     * 将数据源切换成从库
     */
    @Before("readPointcut()")
    public void readAdvice() {
        DynamicSwitchDbTypeUtil.slave();
    }

    /**
     * 将数据源切换成主库
     */
    @Before("writePointcut()")
    public void writeAdvice() {
        DynamicSwitchDbTypeUtil.master();
    }
}
