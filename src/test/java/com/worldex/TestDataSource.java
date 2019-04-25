package com.worldex;

import com.worldex.util.DBUtil;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.Date;

public class TestDataSource {

    @Test
    public void testDataSource(){
        DataSource dataSource = DBUtil.getDataSource();

        JdbcTemplate jdbcTemplate = DBUtil.getJdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        Long count = jdbcTemplate.queryForObject("select count(*) from t_mf_in", Long.class);
        System.out.println(count);
        System.out.println(new Date());
        System.out.println(LocalDateTime.now());
    }
}
