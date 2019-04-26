package com.worldex;

import java.text.DecimalFormat;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 26 上午 10:53
 * @Description:
 */
public class DoubleTest {

    public static void main(String[] args) {
        String s = "{\"json\":\"1\",}";
        System.out.println(s);
        String s1 = s.replaceFirst("\\{","");
        System.out.println(s1);
    }
}
