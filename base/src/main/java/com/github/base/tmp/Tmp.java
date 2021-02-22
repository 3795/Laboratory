package com.github.base.tmp;

import org.openjdk.jol.info.ClassLayout;

/**
 * 临时写东西的类
 */
public class Tmp {

    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
    }
}
