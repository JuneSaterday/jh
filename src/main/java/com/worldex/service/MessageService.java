package com.worldex.service;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.worldex.vo.DataMessage;

import java.util.List;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 25 下午 3:32
 * @Description:
 */
public class MessageService {

    private BoundService boundService = new BoundService();
    /**
     * 将BoundService中查到的报文
     * 拼接成json格式
     */
    public JSONObject createMessage(){
        List<DataMessage> list = boundService.getInBound();
        for (int i = 0; i < list.size(); i++) {
            String jsonString = JSONObject.toJSONString(list.get(i), SerializerFeature.PrettyFormat,
                    SerializerFeature.WriteNullStringAsEmpty);
            System.out.println(jsonString);
            System.out.println("===============================");
            JSONObject jsonObject = JSONObject.parseObject(jsonString);
            System.out.println(jsonObject);
        }
        return null;
    }



}
