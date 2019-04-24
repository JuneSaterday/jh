package com.worldex.util;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 22 下午 4:41
 * @Description:
 */
public class DBUtil {

    private static DriverManagerDataSource dataSource = null;

    //设置数据源
    public static DataSource getDataSource() {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=DB_3000");
        dataSource.setUsername("sa");
        dataSource.setPassword("123456");
        return dataSource;
    }

    //获取JdbcTemplate
    public static JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        return jdbcTemplate;
    }

    //连接SQLServer
    public void connectDataSource(){
        SQLServerDataSource dataSource = new SQLServerDataSource();
    }

}
