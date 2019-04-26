package com.worldex.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.*;
import com.worldex.util.DataTypeUtil;
import com.worldex.util.JsonUtil;
import com.worldex.vo.DataMessage;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 25 下午 3:32
 * @Description:
 */
public class MessageService {

    private BoundService boundService = new BoundService();
    SerializeFilter[] filters = new JsonUtil().filters;

    /**
     * 将BoundService中查到的报文
     * 拼接成json格式
     */
    public List<String> createMessage() {
        List<DataMessage> list = boundService.getInBound();
        List<String> messageList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String jsonString = JSON.toJSONString(list.get(i), filters,
                    SerializerFeature.PrettyFormat, SerializerFeature.WriteNullStringAsEmpty);
            StringBuilder prefix = DataTypeUtil.jsonPrefix();
            messageList.add(prefix.append(DataTypeUtil.removeFirstChar(jsonString) + "}").toString());
        }
        System.out.println(messageList);
        return messageList;
    }

}
