package com.ryz2593.happy.study.threadlocal.transfer.dao;

import com.ryz2593.happy.study.threadlocal.transfer.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author ryz2593
 * @date 2020/4/1 16:04
 */
public class AccountDao {

    /**
     * 转出操作
     * @param outUser
     * @param money
     * @throws SQLException
     */
    public void out(String outUser, int money) throws Exception {
        String sql = "update user set money = money - ? where username = ?";

        Connection conn = JdbcUtils.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, money);
        pstm.setString(2, outUser);

        pstm.executeUpdate();

        JdbcUtils.release(pstm, conn);
    }

    /**
     * 转入操作
     * @param inUser
     * @param money
     * @throws SQLException
     */
    public void in(String inUser, int money) throws Exception {
        String sql = "update user set money = money + ? where username = ?";
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, money);
        pstm.setString(2, inUser);

        pstm.executeUpdate();

        JdbcUtils.release(pstm, conn);
    }

}
