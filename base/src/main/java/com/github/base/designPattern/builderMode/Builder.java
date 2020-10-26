package com.github.base.designPattern.builderMode;

/**
 * Created By Q.Hao
 * Description: 抽象建造者
 * Created At 2019/7/7
 */
public abstract class Builder {
    private Role role = new Role();

    public abstract void buildHead();

    public abstract void buildFace();

    public abstract void buildBody();

    public abstract void buildHp();

    public abstract void buildSp();

    public abstract void buildMp();

    public Role getResult() {
        return role;
    }
}
