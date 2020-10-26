package com.github.base.designPattern.builderMode;

/**
 * Created By Q.Hao
 * Description: 指挥者
 * Created At 2019/7/7
 */
public class Director {
    public void construct(Builder builder) {
        // 这其中可以设置依赖关系，即建造时的先后关系
        builder.buildBody();
        builder.buildHead();
        builder.buildFace();
        builder.buildHp();
        builder.buildMp();
        builder.buildSp();
    }
}
