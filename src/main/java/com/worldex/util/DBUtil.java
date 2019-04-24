package com.worldex.util;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 22 下午 4:41
 * @Description:
 */
public class DBUtil {

    private DriverManagerDataSource dataSource = null;

    //设置数据源
    public void setDataSource() {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("");
        dataSource.setUrl("");
        dataSource.setUsername("");
        dataSource.setPassword("");
    }

    //获取JdbcTemplate
    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    //连接SQLServer
    public void connectDataSource(){
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.
    }

}
