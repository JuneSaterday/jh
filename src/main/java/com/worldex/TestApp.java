package com.worldex;

import com.worldex.util.DataTypeUtil;
import com.worldex.util.PropertyUtil;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Date;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 28 下午 3:14
 * @Description:
 */
public class TestApp {
    private static final Logger logger = Logger.getLogger(App.class);
    public static void main(String[] args) {
        String[] key = PropertyUtil.loadJdbcProperties();
        System.out.println(DataTypeUtil.dateFormatString(new Date()));
//        System.out.println(Arrays.toString(key));
        logger.info(Arrays.toString(key));
    }
}
