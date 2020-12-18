package com.github.base.tmp;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 临时写东西的类
 */
public class Tmp {

    public List<String> stringList = new ArrayList<>();

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    /**
     * 获取方法的返回类型
     *
     * @throws NoSuchMethodException
     */
    public static void getMethodReturnType() throws NoSuchMethodException {
        Method method = Tmp.class.getMethod("getStringList", null);
        System.out.println("方法返回类型：" + method.getReturnType());
        Type returnType = method.getGenericReturnType();
        System.out.println("方法实际返回类型：" + returnType);
        if (returnType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) returnType;
            Type[] typeArguments = type.getActualTypeArguments();
            for (Type typeArgument : typeArguments) {
                Class typeArgClass = (Class) typeArgument;
                System.out.println("泛型类型：" + typeArgClass);
            }
        }
    }

    /**
     * 获取成员变量的泛型类信息
     *
     * @throws Exception
     */
    public static void getGenericFieldTypes() throws Exception {
        Field field = Tmp.class.getField("stringList");
        Type genericsFieldType = field.getGenericType();
        if (genericsFieldType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericsFieldType;
            Type[] fieldArgTypes = parameterizedType.getActualTypeArguments();
            for (Type fieldArgType : fieldArgTypes) {
                Class fieldArgClass = (Class) fieldArgType;
                System.out.println("泛型字段的类型：" + fieldArgClass);
            }
        }
    }

    /**
     * 获取方法参数的泛型类型信息
     *
     * @throws Exception
     */
    public static void getMethodParameterTypes() throws Exception {
        Method method = Tmp.class.getMethod("setStringList", List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericType : genericParameterTypes) {
            if (genericType instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericType;
                Type[] types = parameterizedType.getActualTypeArguments();
                for (Type type : types) {
                    Class realType = (Class) type;
                    System.out.println("方法参数的类型：" + realType);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
//        getMethodReturnType();
//        getGenericFieldTypes();
        getMethodParameterTypes();
//        Test1<String> test1 = new Test1<>();
//        test1.setT("11111");
//        Class<? extends Test1> aClass = test1.getClass();
//        for (Field field : aClass.getDeclaredFields()) {
//            System.out.println("Test1属性：" + field.getName() + "的类型为:" + field.getType().getName());
//        }
//
//        Test2<String> test2 = new Test2<>();
//        test2.setT("22222");
//        Class<? extends Test2> aClass2 = test2.getClass();
//        for (Field field : aClass2.getDeclaredFields()) {
//            System.out.println("Test1属性：" + field.getName() + "的类型为:" + field.getType().getName());
//        }


    }
}
