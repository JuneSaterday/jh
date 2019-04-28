package com.worldex.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.*;
import com.worldex.util.DataTypeUtil;
import com.worldex.util.JsonUtil;
import com.worldex.vo.DataMessage;
import org.apache.log4j.Logger;

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
    private static final Logger logger = Logger.getLogger(MessageService.class);
    private BoundService boundService = new BoundService();
    SerializeFilter[] InFilters = new JsonUtil().inFilters;
    SerializeFilter[] OutFilters = new JsonUtil().outFilters;
    /**
     * 将BoundService中查到的报文
     * 拼接成json格式
     */
    public List<String> createMessage(String type,int gap) {

        List<DataMessage> list = boundService.getBound(type);
        if(null == list){
            return null;
        }
        List<String> messageList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String jsonString;
            StringBuilder prefix;
            if("Inbound".equals(type)){
                jsonString = JSON.toJSONString(list.get(i), InFilters,
                        SerializerFeature.PrettyFormat, SerializerFeature.WriteNullStringAsEmpty);
                prefix = DataTypeUtil.jsonPrefix(i);
            }else {
                jsonString = JSON.toJSONString(list.get(i), OutFilters,
                        SerializerFeature.PrettyFormat, SerializerFeature.WriteNullStringAsEmpty);
                prefix = DataTypeUtil.jsonPrefix(i + gap + 1);
            }
            messageList.add(prefix.append(DataTypeUtil.removeFirstChar(jsonString) + "}").toString());
        }
        System.out.println(messageList);
        return messageList;
    }
}
