package com.worldex.service;

import com.worldex.dao.BoundDao;
import com.worldex.util.DBUtil;
import com.worldex.vo.DataMessage;
import com.worldex.vo.DataMessageMapper;
import com.worldex.vo.MessageDetail;
import com.worldex.vo.MessageDetailMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 22 下午 4:39
 * @Description:
 */
public class BoundService implements BoundDao {

    private static JdbcTemplate jdbcTemplate = DBUtil.jdbcTemplate;

    @Override
    public List<DataMessage> getBound(final String type) {
//        jdbcTemplate = DBUtil.getJdbcTemplate();
        List<DataMessage> list;
        list = (List<DataMessage>)jdbcTemplate.execute(new CallableStatementCreator() {
            @Override
            public CallableStatement createCallableStatement(Connection connection) throws SQLException {
                String storedProc = "exec P_CEVAInOut @Flag=?,@OS_NO='',@JobNo=''";
                CallableStatement callableStatement = connection.prepareCall(storedProc);
                callableStatement.setString(1,type);
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
                }
                System.out.println(list);
                return list;
            }
        });
        //调用得到明细的方法
        getBoundDetail(list,type);
        return list;
    }

    /**
     * 根据Flag和OS_NO调用存储过程
     * 得到入库报文明细的信息
     */
    private List<DataMessage> getBoundDetail(List<DataMessage> list, final String type){
        if(null == list)
            return null;
//        List<MessageDetail> details = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            final String osNo = list.get(i).getVc_no();
            final String jobNo = list.get(i).getJobNo();
//            jdbcTemplate = DBUtil.getJdbcTemplate();
            List<MessageDetail> messageDetails = (List<MessageDetail>)jdbcTemplate.execute(new CallableStatementCreator() {
                @Override
                public CallableStatement createCallableStatement(Connection connection) throws SQLException {
                    String storedProc = "exec P_CEVAInOut @Flag=?,@OS_NO=?,@JobNo=?";
                    CallableStatement callableStatement = connection.prepareCall(storedProc);
                    callableStatement.setString(1,type);
                    callableStatement.setString(2,osNo);
                    if("Outbound".equals(type)){
                        callableStatement.setString(3,jobNo);
                    }else {
                        callableStatement.setString(3,"");
                    }
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

    public List<DataMessage> getOutBound() {
        List<DataMessage> list;
        list = (List<DataMessage>)jdbcTemplate.execute(new CallableStatementCreator() {
            @Override
            public CallableStatement createCallableStatement(Connection connection) throws SQLException {
                String storedProc = "exec P_CEVAInOut @Flag='Outbound',@OS_NO='',@JobNo=''";
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
                }
                System.out.println(list);
                return list;
            }
        });
        //调用得到明细的方法
        getOutBoundDetail(list);
        return list;
    }

    /**
     * 根据Flag和OS_NO调用存储过程
     * 得到出库报文明细的信息
     */
    private List<DataMessage> getOutBoundDetail(List<DataMessage> list){
        if(null == list)
            return null;
//        List<MessageDetail> details = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            final String osNo = list.get(i).getVc_no();
            final String jobNo = list.get(i).getJobNo();
//            jdbcTemplate = DBUtil.getJdbcTemplate();
            List<MessageDetail> messageDetails = (List<MessageDetail>)jdbcTemplate.execute(new CallableStatementCreator() {
                @Override
                public CallableStatement createCallableStatement(Connection connection) throws SQLException {
                    String storedProc = "exec P_CEVAInOut @Flag='Outbound',@OS_NO=?,@JobNo=?";
                    CallableStatement callableStatement = connection.prepareCall(storedProc);
                    callableStatement.setString(1,osNo);
                    callableStatement.setString(2,jobNo);
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
