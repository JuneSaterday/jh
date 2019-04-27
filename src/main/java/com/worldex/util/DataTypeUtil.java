package com.worldex.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 26 上午 10:11
 * @Description:
 */
public class DataTypeUtil {

    public static String dateFormatString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static String dateFormatClientId(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(date);
    }

    public static String removeFirstChar(String string) {
        return string.replaceFirst("\\{", "");
    }

    /**
     * 生成数据报文的前缀部分
     * @return
     */
    public static StringBuilder jsonPrefix(int i) {
        StringBuilder sb = new StringBuilder();
        Date date = new Date();
        date.setTime(date.getTime() + i*1000);
        String dateString = DataTypeUtil.dateFormatString(date);
        String idString = DataTypeUtil.dateFormatClientId(date);
        sb.append("{\n" +
                "\t\"client\": \"Chinex\",\n" +
                "\t\"client_id\": 100001,\n" +
                "\t\"client_key\":").append("\"JH").append(idString).append("\"").
                append(",\n" + "\t\"version\": 1,\n" +
                        "\t\"CFSData\": {\n" +
                        "\t\t\"createdOn\":").append("\"").append(dateString).
                append("\",");
        return sb;
    }
}
