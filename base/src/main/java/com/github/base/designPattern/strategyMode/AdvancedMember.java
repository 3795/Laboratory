package com.github.base.designPattern.strategyMode;

/**
 * Created By Q.Hao
 * Description: 高级会员
 * Created At 2019/7/3
 */
public class AdvancedMember implements Member {
    @Override
    public double calPrice(double price) {
        System.out.println("高级会员打二折");
        return 0.8 * price;
    }
}
