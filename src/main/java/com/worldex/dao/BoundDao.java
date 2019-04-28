package com.worldex.dao;

import com.worldex.vo.DataMessage;

import java.util.List;

public interface BoundDao {

    public List<DataMessage> getBound(String type);

}
