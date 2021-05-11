package com.github.laboratory.assemble;

import com.github.laboratory.assemble.color.Red;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Description:
 * Created At 2021/5/11
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({Red.class, ColorRegisterConfiguration.class, ColorImportSelector.class, ColorImportBeanDefinitionRegistrar.class})
public @interface EnableColor {
}
