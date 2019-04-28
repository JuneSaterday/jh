package com.worldex;



import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private static final Logger logger = Logger.getLogger(Test.class);
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("403");
        list.add("Forbidden token");
        System.out.println(list.size());
        System.out.println(list.get(0));
        logger.info(list);
    }
}
