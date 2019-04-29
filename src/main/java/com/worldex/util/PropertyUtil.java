package com.worldex.util;

import org.apache.log4j.Logger;
import java.io.*;
import java.util.Properties;

public class PropertyUtil {
    private static final Logger logger = Logger.getLogger(PropertyUtil.class);

    public static String[] loadJdbcProperties() {
        Properties properties = new Properties();
        String[] db = new String[4];
        try {
            InputStream in = PropertyUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(in);
            db[0] = properties.getProperty("driverClassName");
            db[1] = properties.getProperty("url");
            db[2] = properties.getProperty("userName");
            db[3] = properties.getProperty("password");
        } catch (FileNotFoundException e) {
            logger.info("没有找到jdbc.properties文件");
        } catch (IOException e) {
            logger.info("读取jdbc.properties文件异常",e);
        }
        return db;
    }

    public static String[] loadHttpProperties() {
        Properties properties = new Properties();
        String[] http = new String[4];
        try {
            InputStream in = PropertyUtil.class.getClassLoader().getResourceAsStream("http.properties");
            properties.load(in);
            http[0] = properties.getProperty("id");
            http[1] = properties.getProperty("password");
            http[2] = properties.getProperty("userUrl");
            http[3] = properties.getProperty("messageUrl");
        } catch (FileNotFoundException e) {
            logger.info("没有找到http.properties文件");
        } catch (IOException e) {
            logger.info(e);
        }
        return http;
    }

}
