package com.worldex.util;

import com.alibaba.fastjson.serializer.BeforeFilter;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.worldex.vo.DataMessage;

import java.text.DecimalFormat;

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