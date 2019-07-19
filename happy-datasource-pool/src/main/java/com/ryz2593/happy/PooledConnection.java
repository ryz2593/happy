package com.ryz2593.happy;

import lombok.*;

import java.sql.Connection;

/**
 * @author ryz2593
 * @date 2019/7/19
 * @desc
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PooledConnection {
    //连接对象
    private Connection connection;

    //连接状态
    private boolean state;

    public void releaseConnection() {
        System.out.println("连接释放。。。。");
        this.state = false;
    }

}
