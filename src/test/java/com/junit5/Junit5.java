package com.junit5;

import com.entity.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Junit5 {
    @Test
    void addTest () {
        try {
            int result = Calculator.add(4,2);
            int count = Calculator.count(4);
            assertAll("返回值校验：",
                    () -> assertEquals(1,result,"实际值与期望结果不符"),
                    () -> assertEquals(10,count,"实际值与期望结果不符")
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void junit5Test() {
        assertEquals(1,3,"实际值与期望结果不符");
    }

}
