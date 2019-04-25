package com.worldex.vo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 25 上午 11:01
 * @Description:DataMessage类的属性与存储过程查询的结果集映射关系类
 */
public class DataMessageMapper implements RowMapper<DataMessage> {
    @Override
    public DataMessage mapRow(ResultSet rs, int i) throws SQLException {
        DataMessage dataMessage = new DataMessage();
        dataMessage.setVc_no(rs.getString("vc_no"));
        dataMessage.setJobNo(rs.getString("JobNo"));
        dataMessage.setMasterWaybill(rs.getString("MasterWaybill"));
        dataMessage.setHouseWaybill(rs.getString("HouseWaybill"));
        dataMessage.setContainerType(rs.getString("ContainerType"));
        dataMessage.setContainerNumber(rs.getString("ContainerNumber"));
        dataMessage.setSealNo(rs.getString("SealNo"));
        dataMessage.setFactory(rs.getString("Factory"));
        dataMessage.setOriginPort(rs.getString("OriginPort"));
        dataMessage.setDestPort(rs.getString("DestPort"));
        dataMessage.setETD(rs.getDate("ETD"));
        dataMessage.setOutboundDate(rs.getDate("OutboundDate"));
        dataMessage.setRemark(rs.getString("Remark"));
        dataMessage.setFutureUse1(rs.getString("FutureUse1"));
        dataMessage.setFutureUse2(rs.getInt("FutureUse2"));
        dataMessage.setFutureUse3(rs.getString("FutureUse3"));
        return dataMessage;
    }
}
