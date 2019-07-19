package com.ryz2593.happy;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ryz2593
 * @date 2019/7/19
 * @desc
 */
public class DataSourcePoolImpl implements DataSourcePool, PoolConstant {


    /**
     * 读多写少
     */
    private List<PooledConnection> poolList = new CopyOnWriteArrayList<>();
    private Lock lock = new ReentrantLock();

    transient int initSize = DEFAULT_INIT_SIZE;
    transient int stepSize = DEFAULT_STEP_SIZE;
    transient int maxSize = DEFAULT_MAX_SIZE;
    transient long timeout = DEFAULT_TIMEOUT;

    public DataSourcePoolImpl() {
        loadDriver();
        initPool();
    }

    private void initPool() {
        //获取用户连接池配置
        String initSizeString = PropertyPlaceHolder.getInstance().getProperty(INIT_SIZE);
        String stepSizeString = PropertyPlaceHolder.getInstance().getProperty(STEP_SIZE);
        String maxSizeString = PropertyPlaceHolder.getInstance().getProperty(MAX_SIZE);
        String timeoutString = PropertyPlaceHolder.getInstance().getProperty(TIMEOUT);
        //处理最后配置
        initSize = initSizeString == null ? initSize : Integer.parseInt(initSizeString);
        stepSize = stepSizeString == null ? stepSize : Integer.parseInt(stepSizeString);
        maxSize = maxSizeString == null ? maxSize : Integer.parseInt(maxSizeString);
        timeout = timeoutString == null ? timeout : Long.parseLong(timeoutString);

        //初始化连接对象
        try {
            createConnections(initSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载驱动（jdbc4.0）
     */
    private void loadDriver() {
        String driverClass = PropertyPlaceHolder.getInstance().getProperty(DRIVER_CLASS);
        try {
            Driver driver = (Driver) this.getClass().getClassLoader().loadClass(driverClass).newInstance();
            DriverManager.registerDriver(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PooledConnection getDataSource() {
        PooledConnection connection = null;
        try {
            lock.lock();
            connection = getAvailableConnection();
            while (connection == null) {
                //没有达到最大连接数，继续创建连接对象
                createConnections(stepSize);
                connection = getAvailableConnection();

                if (connection == null) {
                    TimeUnit.MILLISECONDS.sleep(60);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return connection;
    }

    /**
     * 创建连接对象的方法
     */
    private void createConnections(int count) throws SQLException {
        if (poolList.size() + count <= maxSize) {
            for (int i = 0; i < count; i++) {
                System.out.println("创建了连接==>" + i + "<===");
                //创建一个数据库连接对象
                Connection connection = DriverManager.getConnection(
                        PropertyPlaceHolder.getInstance().getProperty(URL),
                        PropertyPlaceHolder.getInstance().getProperty(USER),
                        PropertyPlaceHolder.getInstance().getProperty(PASSWORD));

                //创建数据库连接池的连接对象
                PooledConnection pooledConnection = new PooledConnection(connection, false);
                poolList.add(pooledConnection);
            }
        }
    }

    /**
     * 获取连接池中可用连接对象
     *
     * @return
     */
    private PooledConnection getAvailableConnection() throws SQLException {
        for (PooledConnection pooledConnection : poolList) {
            if (!pooledConnection.isState()) {
                Connection connection = pooledConnection.getConnection();
                //判断连接对象是否可用
                if (!connection.isValid((int) timeout)) {
                    connection = DriverManager.getConnection(
                            PropertyPlaceHolder.getInstance().getProperty(URL),
                            PropertyPlaceHolder.getInstance().getProperty(USER),
                            PropertyPlaceHolder.getInstance().getProperty(PASSWORD)
                    );
                    pooledConnection.setConnection(connection);
                }
                pooledConnection.setState(true);
                return pooledConnection;
            }
        }

        return null;
    }
}
