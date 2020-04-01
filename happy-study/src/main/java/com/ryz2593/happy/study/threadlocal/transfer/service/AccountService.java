package com.ryz2593.happy.study.threadlocal.transfer.service;

import com.ryz2593.happy.study.threadlocal.transfer.dao.AccountDao;
import com.ryz2593.happy.study.threadlocal.transfer.utils.JdbcUtils;

import java.sql.Connection;

/**
 * 开启事务的注意点：
 * 为了保证所有的操作在一个事务中，案例中使用的链接必须是同一个：
 *    service层开启事务的connection需要跟dao层访问数据库的connection保持一致
 * 线程并发情况下，每个线程只能操作各自的connection
 *
 * @author ryz2593
 * @date 2020/4/1 16:05
 */
public class AccountService {
    public boolean transfer(String outUser, String inUser, int money) {
        AccountDao ad = new AccountDao();
        Connection conn = null;
        try {
            //1.开启事务
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);

            //转出
            ad.out(outUser, money);

            //算术异常：模拟转出成功，转入失败
            int i = 1 / 0;
            //转入
            ad.in(inUser, money);

            //2.成功提交
            JdbcUtils.commitAndClose(conn);
        } catch (Exception e) {
            e.printStackTrace();
            //2. 或者失败回滚
            JdbcUtils.rollbackAndClose(conn);
            return false;
        }

        return true;
    }
}
