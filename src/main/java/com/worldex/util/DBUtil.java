package com.worldex.util;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;


/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 22 下午 4:41
 * @Description:
 */
public class DBUtil {

    public static DriverManagerDataSource dataSource = null;
    public static JdbcTemplate jdbcTemplate = getJdbcTemplate();

    //设置数据源
    public static DataSource getDataSource() {
        String[] key = PropertyUtil.loadProperties();
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(key[0]);
        dataSource.setUrl(key[1]);
        dataSource.setUsername(key[2]);
        dataSource.setPassword(key[3]);
        return dataSource;
    }

    //获取JdbcTemplate
    public static JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }
}
