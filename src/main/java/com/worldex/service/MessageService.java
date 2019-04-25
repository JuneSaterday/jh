package com.worldex.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.worldex.vo.DataMessage;
import com.worldex.vo.User;

import java.text.DecimalFormat;
import java.util.List;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 25 下午 3:32
 * @Description:
 */
public class MessageService {

    private BoundService boundService = new BoundService();

    /**
     * 当报文类的属性为double，且小数位值为0时，
     *  只显示整数部分
     */
    ValueFilter vFilter = new ValueFilter() {
        @Override
        public Object process(Object o, String s, Object value) {
            if("ActPOGW".equals(s) || "ActPOCBM".equals(s)){
                return  new DecimalFormat("#0.000000").format(value);

            }
            return value;
        }
    };

    /**
     * 将BoundService中查到的报文
     * 拼接成json格式
     */
    public JSONObject createMessage(){
        List<DataMessage> list = boundService.getInBound();
        for (int i = 0; i < list.size(); i++) {
            String jsonString = JSON.toJSONString(list.get(i),vFilter, SerializerFeature.PrettyFormat,
                    SerializerFeature.WriteNullStringAsEmpty);
            System.out.println(jsonString);
            System.out.println("===============================");
            JSONObject jsonObject = JSONObject.parseObject(jsonString);
            System.out.println(jsonObject);
        }
        return null;
    }
}
