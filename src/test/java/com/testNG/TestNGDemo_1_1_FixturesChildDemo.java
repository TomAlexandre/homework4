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
public class TestNGDemo_1_1_FixturesChildDemo extends TestNGDemo_1_1_FixturesOrder {
    
    @BeforeSuite
    public void chaildBeforeSuite() {
        System.out.println("chaild beforeSuite");
    }

    @AfterSuite
    public void chaildAfterSuite() {
        System.out.println("chaild afterSuite");
    }

    @BeforeTest
    public void chaildBeforeTest() {
        System.out.println("chaild beforeTest");
    }

    @AfterTest
    public void chaildAfterTest() {
        System.out.println("chaild afterTest");
    }

    @BeforeClass
    public void chaildBeforeClass() {
        System.out.println("chaild beforeClass");
    }

    @AfterClass
    public void chaildAfterClass() {
        System.out.println("chaild afterClass");
    }

    @BeforeMethod
    public void chaildBeofreMethod() {
        System.out.println("chaild beforeMethod");
    }

    @AfterMethod
    public void chaildAfterMethod() {
        System.out.println("chaild afterMethod");
    }

    @Test
    public void chaildTest1() {
        System.out.println("chaild method1");
    }

    @Test
    public void chaildTest2() {
        System.out.println("chaild methods2");
    }
}