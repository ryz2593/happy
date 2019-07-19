package com.ryz2593.happy;

/**
 * @author ryz2593
 * @date 2019/7/19
 * @desc
 */
public interface DataSourcePool {
    PooledConnection getDataSource();
}
