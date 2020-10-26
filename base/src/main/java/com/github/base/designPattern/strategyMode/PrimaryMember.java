package com.github.base.designPattern.strategyMode;

/**
 * Created By Q.Hao
 * Description: 初级会员
 * Created At 2019/7/3
 */
public class PrimaryMember implements Member {

    @Override
    public double calPrice(double price) {
        System.out.println("初级会员不打折");
        return price;
    }
}
