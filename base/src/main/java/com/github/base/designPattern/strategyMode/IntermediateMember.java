package com.github.base.designPattern.strategyMode;

/**
 * Created By Q.Hao
 * Description: 中级会员
 * Created At 2019/7/3
 */
public class IntermediateMember implements Member {
    @Override
    public double calPrice(double price) {
        System.out.println("中级会员打一折");
        return 0.9 * price;
    }
}
