package com.worldex;

import com.worldex.service.BoundService;
import com.worldex.util.DBUtil;
import com.worldex.vo.DataMessage;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TestOutbound {
    private static JdbcTemplate jdbcTemplate = DBUtil.jdbcTemplate;
    private BoundService boundService = new BoundService();
    @Test
    public void test(){
        List<DataMessage> list  =  boundService.getOutBound();
        System.out.println(list);
    }

}
