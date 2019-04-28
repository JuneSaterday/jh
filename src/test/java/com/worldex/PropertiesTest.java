package com.worldex;

import com.worldex.util.PropertyUtil;
import org.junit.Test;

public class PropertiesTest {

    @Test
    public void test(){
        String[] key = PropertyUtil.loadJdbcProperties();
        for (int i = 0; i < key.length; i++) {
            System.out.println(key[i]);
        }
    }
}
