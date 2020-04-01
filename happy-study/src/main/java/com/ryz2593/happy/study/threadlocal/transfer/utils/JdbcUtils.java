package com.ryz2593.happy.study.threadlocal.transfer.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ryz2593
 * @date 2020/4/1 16:05
 */
public class JdbcUtils {

    /**
     * c3p0数据库连接池对象属性
     */
    private static final ComboPooledDataSource ds = new ComboPooledDataSource("mysql");

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }


    /**
     * 释放资源
     *
     * @param ios
     */
    public static void release(AutoCloseable... ios) {
        for (AutoCloseable io : ios) {
            if (io != null) {
                try {
                    io.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 提交事务并释放链接
     * @param conn
     */
    public static void commitAndClose(Connection conn) {
        try {
            if (conn != null) {
                //提交事务
                conn.commit();
                //关闭连接
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务并释放链接
     * @param conn
     */
    public static void rollbackAndClose(Connection conn) {
        try {
            if (conn != null) {
                //事务回滚
                conn.rollback();
                //关闭连接
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
