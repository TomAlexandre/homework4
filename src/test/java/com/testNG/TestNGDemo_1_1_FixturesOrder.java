package com.testNG; /**
 * projectName: TestNGDemo
 * fileName: TestNGDemo_1_1.java
 * packageName: PACKAGE_NAME
 * date: 2020-11-01 7:48 上午
 */

import org.testng.annotations.*;
/**
 * 1、编写基础脚本
 * 2、增加断言
 */

/**
 * @version: V1.0
 * @author: wenxiaolong
 * @className: TestNGDemo_1_1
 * @packageName: PACKAGE_NAME
 * @description: TestNGDemo_1_1
 * @data: 2020-11-01 7:48 上午
 **/
public class TestNGDemo_1_1_FixturesOrder {
    
    @BeforeSuite
    public void beforeSuite() {
        System.out.println(" beforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(" afterSuite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println(" beforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println(" afterTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println(" beforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println(" afterClass");
    }

    @BeforeMethod
    public void beofreMethod() {
        System.out.println(" beforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(" afterMethod");
    }

    @Test
    public void test1() {
        System.out.println(" method1");
    }

    @Test
    public void test2() {
        System.out.println(" methods2");
    }
}