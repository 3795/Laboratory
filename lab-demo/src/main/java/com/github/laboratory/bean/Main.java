package com.github.laboratory.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description: 主函数
 * Created At 2021/7/11
 */
public class Main {
    public static void main(String[] args) {
        // 获取BeanFactory
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("application.xml");
        // 获取对应的实例化对象
        Object demo = beanFactory.getBean("demo");
        System.out.println(demo instanceof Person);
        System.out.println(demo.toString());

        // 从FactoryBean中获取对象
        Person demoFromFactory = beanFactory.getBean("demoFromFactory", Person.class);
        System.out.println(demoFromFactory.toString());

        // 获取对应的personFactory
        // 注意这个地方用了一个&，在BeanFactory中，定义使用&前缀，表示要取对应的FactoryBean
        // 使用&返回创建这个Bean的Factory，不使用则返回这个工厂生产的Bean
        Object bean = beanFactory.getBean("&demoFromFactory");
        System.out.println(bean instanceof PersonFactoryBean);
        PersonFactoryBean personFactoryBean = (PersonFactoryBean) bean;
        System.out.println("初始化参数：" + personFactoryBean.getInitStr());
    }
}
