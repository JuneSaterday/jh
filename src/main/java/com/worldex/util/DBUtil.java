package com.worldex.util;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.worldex.vo.DataMessage;
import com.worldex.vo.DataMessageMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }
}
