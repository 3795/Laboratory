package com.github.base.designPattern.strategyMode;

/**
 * Created By Q.Hao
 * Description: 计算价格的类
 * Created At 2019/7/3
 */
public class Cashier {

    // 策略对象
    private Member member;

    public Cashier(Member member) {
        this.member = member;
    }

    public double quote(double price) {
        return this.member.calPrice(price);
    }
}
