package com.ryz2593.happy.study.threadlocal.transfer.web;

import com.ryz2593.happy.study.threadlocal.transfer.service.AccountService;

/**
 * @author ryz2593
 * @date 2020/4/1 16:06
 */
public class AccountWeb {
    public static void main(String[] args) {
        //模拟数据 aaa 给 bbb

        String outUser = "aaa";
        String inUser = "bbb";
        int money = 100;

        AccountService as = new AccountService();
        boolean result = as.transfer(outUser, inUser, money);

        if (result == false) {
            System.out.println("转账失败");
        } else {
            System.out.println("转账成功");
        }
    }
}
