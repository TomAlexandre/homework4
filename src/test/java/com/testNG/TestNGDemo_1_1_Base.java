package com.testNG;

import entity.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TestNGDemo_1_1_Base {

    @Test
    void addTestNG () {
        SoftAssert assertion = new SoftAssert();
        int test001 = Calculator.add(4,2);
        int test002 = Calculator.add(4,3);
        int test003 = Calculator.add(4,4);
        System.out.println("add001方法 = " + test001);
        System.out.println("add002方法 = " + test002);
        System.out.println("add003方法 = " + test003);
        assertion.assertEquals(test001,6);
        assertion.assertEquals(test002,8);
        assertion.assertEquals(test003,9);
        assertion.assertAll();

    }

    @Test
    void subtractTestNG () {
        int suntractTest = Calculator.subtract(4,2);
        System.out.println("subtract方法 = " + suntractTest);
        Assert.assertEquals(suntractTest,6);
    }


    @Test
    void multiplyTest () {
        System.out.println("multiply方法 = " + Calculator.multiply(4,2));
    }

    @Test
    void divisionTest () {
        System.out.println("division方法 = " + Calculator.division(4,2));
    }

    @BeforeMethod
    void clear() {
        Calculator.clear();
    }

}
