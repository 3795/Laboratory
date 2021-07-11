package com.github.base.tmp;

import org.openjdk.jol.info.ClassLayout;

/**
 * 临时写东西的类
 */
public class Tmp {

    public static void main(String[] args) {
        System.out.println("父类引用指向子类");
        Father instance = new Son();
        instance.printValue();
        instance.printValue2();
        System.out.println(instance.name);
        instance.printValue3();

        System.out.println("父类对象");
        Father father = new Father();
        father.printValue();
        father.printValue2();
        System.out.println(father.name);
        father.printValue3();

        System.out.println("子类对象");
        Son son = new Son();
        son.printValue();
        son.printValue2();
        System.out.println(son.name);
        son.printValue3();
    }
}
