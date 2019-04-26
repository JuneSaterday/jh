package com.worldex.util;

import com.alibaba.fastjson.serializer.BeforeFilter;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.worldex.vo.DataMessage;
import com.worldex.vo.HTTPResult;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 26 上午 11:37
 * @Description:
 */
public class JsonUtil {

    /**
     * 当报文类的属性为double，只保留两位小数
     * 且小数位值为0时，只显示整数部分
     */
//     ValueFilter vFilter = new ValueFilter() {
//        @Override
//        public Object process(Object o, String s, Object value) {
//            if ("ActPOGW".equals(s) || "ActPOCBM".equals(s)) {
//                DecimalFormat df = new DecimalFormat();
//                df.setMaximumFractionDigits(2);
//                df.setMaximumIntegerDigits(20);
//                return df.format(value);
//            }
//            return value;
//        }
//    };
//     BeforeFilter beforeFilter = new BeforeFilter() {
//        @Override
//        public void writeBefore(Object o) {
//            if (o instanceof DataMessage) {
//                writeKeyValue("Type", "In");
//            }
//        }
//    };
     public SerializeFilter[] filters = new SerializeFilter[]{new myVauleFilter(), new myBeforeFilter()};

    /**
     * 调用接口后，根据返回结果的状态码
     */
    public static List<String> getResponse(String content, String messageType){
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(content).getAsJsonObject();
        List<String> list = new ArrayList<>();
        String status,result;
        if("account".equals(messageType)){
            status = jsonObject.get("status").getAsString();
            result = jsonObject.get("result").getAsJsonObject().get("currSessionID").getAsString();
        } else {
            status = jsonObject.get("status").getAsString();
            result = jsonObject.get("result").getAsString();
        }
        list.add(status);
        list.add(result);
        return list;
    }


}
class myBeforeFilter extends BeforeFilter{
    @Override
    public void writeBefore(Object o) {
        if (o instanceof DataMessage) {
            writeKeyValue("Type", "In");
        }
    }
}

/**
 * 当报文类的属性为double，只保留两位小数
 * 且小数位值为0时，只显示整数部分
 */
class myVauleFilter implements ValueFilter{
    @Override
    public Object process(Object o, String s, Object value) {
        if ("ActPOGW".equals(s) || "ActPOCBM".equals(s)) {
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);
            df.setMaximumIntegerDigits(20);
            return df.format(value);
        }
        return value;
    }
}