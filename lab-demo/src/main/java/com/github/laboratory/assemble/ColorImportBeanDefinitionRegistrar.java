package com.github.laboratory.assemble;

import com.github.laboratory.assemble.color.Green;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Description:
 * Created At 2021/5/11
 */
public class ColorImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 自定义名称替换原来的Bean名称
        registry.registerBeanDefinition("GrEEn", new RootBeanDefinition(Green.class));
    }
}
