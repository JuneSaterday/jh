package com.worldex.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

public class PropertyUtil {
    private static final Logger logger = LoggerFactory.getLogger(PropertyUtil.class);

    public static String[] loadProperties() {
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
            e.printStackTrace();
        }
        return db;
    }

}
