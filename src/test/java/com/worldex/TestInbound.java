package com.worldex;

import com.worldex.util.DBUtil;
import com.worldex.vo.DataMessage;
import com.worldex.vo.DataMessageMapper;
import com.worldex.vo.MessageDetail;
import com.worldex.vo.MessageDetailMapper;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sound.midi.Soundbank;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 25 上午 10:18
 * @Description:
 */
public class TestInbound {

    private static JdbcTemplate jdbcTemplate = DBUtil.getJdbcTemplate();
    @Test
    public void test(){
        JdbcTemplate jdbcTemplate;
        jdbcTemplate = DBUtil.getJdbcTemplate();
        List list = (List) jdbcTemplate.execute(new CallableStatementCreator() {
            @Override
            public CallableStatement createCallableStatement(Connection connection) throws SQLException {
                String storedProc = "exec P_CEVAInOut @Flag='Inbound',@OS_NO='',@JobNo=''";
                CallableStatement callableStatement = connection.prepareCall(storedProc);
                return callableStatement;
            }
        }, new CallableStatementCallback<Object>() {
            @Override
            public Object doInCallableStatement(CallableStatement callableStatement) throws SQLException, DataAccessException {
                boolean b = callableStatement.execute();
                System.out.println(b);
                List<DataMessage> list = new ArrayList<>();
//                DataMessage dataMessage = null;
                callableStatement.execute();
                ResultSet resultSet = callableStatement.getResultSet();
                int columnCount = resultSet.getMetaData().getColumnCount();
                while(resultSet.next()){
                    list.add(new DataMessageMapper().mapRow(resultSet,columnCount++));
//                    System.out.println(resultSet.getString("vc_no") + resultSet.getString("JobNo"));
                }
                return list;
            }
        });
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void testDetail(){
        getInBound();
    }

    public void getInBound() {
//        jdbcTemplate = DBUtil.getJdbcTemplate();
        List<DataMessage> list;
        list = (List<DataMessage>)jdbcTemplate.execute(new CallableStatementCreator() {
            @Override
            public CallableStatement createCallableStatement(Connection connection) throws SQLException {
                String storedProc = "exec P_CEVAInOut @Flag='Inbound',@OS_NO='',@JobNo=''";
                CallableStatement callableStatement = connection.prepareCall(storedProc);
                return callableStatement;
            }
        }, new CallableStatementCallback<Object>() {
            @Override
            public Object doInCallableStatement(CallableStatement callableStatement) throws SQLException, DataAccessException {
                List<DataMessage> list = new ArrayList<>();
                DataMessage dataMessage = null;
                callableStatement.execute();
                ResultSet resultSet = callableStatement.getResultSet();
                int columnCount = resultSet.getMetaData().getColumnCount();
                while(resultSet.next()){
                    list.add(new DataMessageMapper().mapRow(resultSet,columnCount++));
//                    System.out.println(resultSet.getString("vc_no") + resultSet.getString("JobNo"));
                }
                return list;
            }
        });
        System.out.println(list.size());
        //调用得到明细的方法
        list = getInBoundDetail(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getPODetails());
        }
    }

    /**
     * 根据Flag和OS_NO调用存储过程
     * 得到入库报文明细的信息
     */
    private List<DataMessage> getInBoundDetail(List<DataMessage> list){
        if(null == list)
            return null;
//        List<MessageDetail> details = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            final String osNo = list.get(i).getVc_no();
//            jdbcTemplate = DBUtil.getJdbcTemplate();
            List<MessageDetail> messageDetails = (List<MessageDetail>)jdbcTemplate.execute(new CallableStatementCreator() {
                @Override
                public CallableStatement createCallableStatement(Connection connection) throws SQLException {
                    String storedProc = "exec P_CEVAInOut @Flag='Inbound',@OS_NO=?,@JobNo=''";
                    CallableStatement callableStatement = connection.prepareCall(storedProc);
                    callableStatement.setString(1,osNo);
                    return callableStatement;
                }
            }, new CallableStatementCallback<Object>() {
                @Override
                public Object doInCallableStatement(CallableStatement callableStatement) throws SQLException, DataAccessException {
                    List<MessageDetail> details = new ArrayList<>();
                    callableStatement.execute();
                    ResultSet resultSet = callableStatement.getResultSet();
                    int columnCount = resultSet.getMetaData().getColumnCount();
                    while(resultSet.next()){
                        details.add(new MessageDetailMapper().mapRow(resultSet,columnCount++));
                    }
                    return details;
                }
            });
            list.get(i).setPODetails(messageDetails);
        }
        return list;
    }


}
