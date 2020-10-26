package com.github.base.designPattern.strategyMode;

/**
 * Created By Q.Hao
 * Description: 书店
 * Created At 2019/7/3
 */
public class BookStore {

    public static void main(String[] args) {

        // 高级会员
        Member advancedMember = new AdvancedMember();
        Cashier cashier = new Cashier(advancedMember);
        System.out.println(cashier.quote(100));

        // 中级会员
        Member intermediateMember = new IntermediateMember();
        Cashier cashier1 = new Cashier(intermediateMember);
        System.out.println(cashier1.quote(100));

        // 普通会员
        Member primaryMember = new PrimaryMember();
        Cashier cashier2 = new Cashier(primaryMember);
        System.out.println(cashier2.quote(100));
    }
}
