package com.junit5;

import entity.Calculator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Junit5Demo_1_1_Base {


    @Test
    @Order(2)
    void addTest () {
        System.out.println("add方法 = " + Calculator.add(4,2));
    }

    @Test
    @Order(3)
    void subtractTest () {
        System.out.println("subtract方法 = " + Calculator.subtract(4,2));
    }

    @Test
    @Order(4)
    void multiplyTest () {
        System.out.println("multiply方法 = " + Calculator.multiply(4,2));
    }

    @Test
    @Order(5)
    void divisionTest () {
        System.out.println("division方法 = " + Calculator.division(4,2));
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

}
