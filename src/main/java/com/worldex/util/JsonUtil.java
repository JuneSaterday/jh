package com.worldex.util;

import com.alibaba.fastjson.serializer.BeforeFilter;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.worldex.constant.HTTPStatusCode;
import com.worldex.vo.DataMessage;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 26 上午 11:37
 * @Description:
 */
public class JsonUtil {

    public SerializeFilter[] inFilters = new SerializeFilter[]{new myVauleFilter(), new InBeforeFilter()};
    public SerializeFilter[] outFilters = new SerializeFilter[]{new myVauleFilter(), new OutBeforeFilter()};

    /**
     * 调用接口后，根据返回结果的状态码
     */
    public static Map<String,String> getResponse(String content, String messageType) {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(content).getAsJsonObject();
        Map<String,String> map = new HashMap();
        String status, result;
        if ("account".equals(messageType)) {
            status = jsonObject.get("status").getAsString();
            if (HTTPStatusCode.SUCCESS.equals(status)) {
                result = jsonObject.get("result").getAsJsonObject().get("currSessionID").getAsString();
            } else {
                result = jsonObject.get("result").getAsString();
            }
        } else {
            status = jsonObject.get("status").getAsString();
            result = jsonObject.get("result").getAsString();
        }
        map.put("status",status);
        map.put("result",result);
        return map;
    }


    //将json字符串保存到文件中
}

class InBeforeFilter extends BeforeFilter {
    @Override
    public void writeBefore(Object o) {
        if (o instanceof DataMessage) {
            writeKeyValue("Type", "In");
        }
    }
}

class OutBeforeFilter extends BeforeFilter {
    @Override
    public void writeBefore(Object o) {
        if (o instanceof DataMessage) {
            writeKeyValue("Type", "Out");
        }
    }
}

/**
 * 当报文类的属性为double，只保留两位小数
 * 且小数位值为0时，只显示整数部分
 */
class myVauleFilter implements ValueFilter {
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
