package com.cloud.yanger.commons.util;

import com.cloud.yanger.commons.constants.AppConstants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 获取本地环境配置信息
 */
public class PropertiesUtils {

    private static Properties props;

    private final static String CONF_PATH = AppConstants.CONF_PATH;

    static {
        loadProps();
    }

    synchronized static private void loadProps() {
        props = new Properties();
        try (InputStream in = new FileInputStream(new File(CONF_PATH))) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }
}
