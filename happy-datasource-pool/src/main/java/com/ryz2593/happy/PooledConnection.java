package com.ryz2593.happy;

import lombok.*;

import java.sql.Connection;

/**
 * @author ryz2593
 * @date 2019/7/19
 * @desc
 */

@ToString
public class PooledConnection {
    //连接对象
    private Connection connection;

    //连接状态
    private boolean state;

    public PooledConnection() {
    }

    public PooledConnection(Connection connection, boolean state) {
        this.connection = connection;
        this.state = state;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void releaseConnection() {
        System.out.println("连接释放。。。。");
        this.state = false;
    }

}
