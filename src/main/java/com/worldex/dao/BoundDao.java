package com.worldex.dao;

import com.worldex.vo.DataMessage;

import java.util.List;

public interface BoundDao {

    //查询货运收据数据
//    public List<DataMessage> getInBound();
//
//    //查询装载计划数据
//    public List<DataMessage> getOutBound();

    public List<DataMessage> getBound(String type);


//    public List<DataMessage> getBound(String flag, String osNo, String jobNo);
}
