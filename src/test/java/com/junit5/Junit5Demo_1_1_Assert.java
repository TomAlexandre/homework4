package com.junit5;

import entity.Calculator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Junit5Demo_1_1_Assert {

    public static final int EXPECTED_COUNT = 1;
    @Test
    @Order(2)
    void addTest () {
        int result = Calculator.add(4,2);
        System.out.println("add方法 = " + result);
        assertEquals(6,result);
    }

    @Test
    @Order(3)
    void subtractTest () {
        int result = Calculator.subtract(4,2);
        System.out.println("subtract方法 = " + result);
        assertEquals(2,result);
    }

    @Test
    @Order(4)
    void multiplyTest () {
        int result = Calculator.multiply(4,2);
        System.out.println("multiply方法 = " + result);
        assertEquals(8,result);
    }

    @Test
    @Order(5)
    void divisionTest () {
        int result = Calculator.division(4,2);
        System.out.println("division方法 = " + result);
        assertEquals(2,result);
    }

    @Test
    @Order(1)
    void clear() {
        Calculator.clear();
    }

    @Test
    @Order(6)
    void junit5Test() {
        assertEquals(1,3,"实际值与期望结果不符");
    }

    @Test
    @Order(6)
    void count() throws InterruptedException {
        int result = Calculator.count(1);
        for (int i = 1;i <= 3;i ++) {
            result = Calculator.count(1);
        }
        System.out.println("division方法 = " + result);
        assertEquals(4,result,"实际值与期望结果不符");

    }

    String getErrMsg (int expStr,int result) {
        StringBuffer sb = new StringBuffer();
        sb.append("实际值");
        sb.append(" ");
        sb.append(result);
        sb.append(" ");
        sb.append("与期望结果");
        sb.append(" ");
        sb.append(expStr);
        sb.append(" ");
        sb.append("不符");
        return sb.toString();
    }

}
