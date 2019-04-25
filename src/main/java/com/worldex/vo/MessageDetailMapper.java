package com.worldex.vo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 25 上午 11:30
 * @Description:
 */
public class MessageDetailMapper implements RowMapper {
    @Override
    public MessageDetail mapRow(ResultSet rs, int i) throws SQLException {
        MessageDetail detail = new MessageDetail();
        detail.setPurchaseOrderNumber(rs.getString("PurchaseOrderNumber"));
        detail.setSKUNumber(rs.getString("SKUNumber"));
//        detail.setGoodsName(rs.getString("GoodsName"));
        detail.setActPOQty(rs.getInt("ActPOQty"));
        detail.setActPOGW(rs.getDouble("ActPOGW"));
        detail.setActPOCBM(rs.getDouble("ActPOCBM"));
        detail.setActPOMeasurement(rs.getString("ActPOMeasurement"));
        detail.setActPO_InOutDate(rs.getTimestamp("ActPO_InOutDate"));
        detail.setDetailFutureUse1(rs.getString("DetailFutureUse1"));
        detail.setDetailFutureUse2(rs.getString("DetailFutureUse2"));
        detail.setDetailFutureUse3(rs.getString("DetailFutureUse3"));
        return detail;
    }
}
