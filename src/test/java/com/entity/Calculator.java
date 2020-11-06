package com.entity;

public class Calculator {
    public static int result = 0;

    public static int add (int x,int y) {
        result = x + y;
        return result;
    }

    public static int subtract (int x,int y) {
        result = x - y;
        return result;
    }

    public static int multiply (int x,int y) {
        result = x * y;
        return result;
    }

    public static int division (int x,int y) {
        result = x / y;
        return result;
    }

    public static int count (int x) throws InterruptedException{
        Thread.sleep(1000);
        result = result + x;
        return result;
    }
}
