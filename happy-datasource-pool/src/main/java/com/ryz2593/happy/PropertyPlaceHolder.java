package com.ryz2593.happy;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author ryz2593
 * @date 2019/7/19
 * @desc
 */
public class PropertyPlaceHolder extends Properties {
    public static final String CONFIG_LOCATION = "dataSource.properties";

    private static PropertyPlaceHolder holder = new PropertyPlaceHolder();

    private PropertyPlaceHolder() {
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(CONFIG_LOCATION);
            this.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PropertyPlaceHolder getInstance() {
        return holder;
    }
}
