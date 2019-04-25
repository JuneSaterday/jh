package com.worldex;

import java.text.DecimalFormat;

public class TestOne {
    public static void main(String[] args) {
        Double d = 210.000;
        String s = String.valueOf(new DecimalFormat("#0.0000").format(d));
        System.out.println(s);
    }
}
