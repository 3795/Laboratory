package com.github.base.designPattern.builderMode;

/**
 * Created By Q.Hao
 * Description:
 * Created At 2019/7/7
 */
public class Client {

    public static void main(String[] args) {
        Director director = new Director();
        Builder commonBuilder = new CommonRoleBuilder();
        director.construct(commonBuilder);
        Role commonRole = commonBuilder.getResult();
        System.out.println(commonRole.toString());
    }
}
