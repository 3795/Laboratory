package com.github.laboratory.bean;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

import java.util.Objects;

/**
 * Description: FactoryBean
 * 可以将Bean实例化的过程更加细致，自定义
 * Created At 2021/7/11
 */
@Data
public class PersonFactoryBean implements FactoryBean<Person> {

    private String initStr;

    @Override
    public Person getObject() throws Exception {
        Objects.requireNonNull(initStr);
        String[] split = initStr.split(",");
        Person p = new Person();
        p.setAge(Integer.parseInt(split[0]));
        p.setName(split[1]);
        // 此处可以处理Bean实例化过程中的其他事情
        return p;
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }
}
