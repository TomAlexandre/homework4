/**
 * projectName: Junit5Demo
 * fileName: Junit5Demo_1_1_Fixtures.java
 * packageName: com.junit5
 * date: 2020-11-07 2:24 下午
 */
package com.junit5;

import entity.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Version: 1.0
 * @Author: chriswang66
 * @ClassName: Junit5Demo_1_1_Fixtures
 * @PackageName: com.junit5
 * @Description: Junit5Demo_1_1_Fixtures演练
 * @Date: 2020-11-09 11:18 AM
 */

public class Junit5Demo_1_1_Fixtures {

    @BeforeAll
    static void beforeAll () {
        System.out.println("执行BeforeAll");
    }

    @AfterAll
    static void afteAall () {
        System.out.println("执行AfterAll");
    }

    @BeforeEach
    void beforeEach () {
        System.out.println("执行BeforeEach");
    }

    @AfterEach
    void afterEach () {
        System.out.println("执行AfterEach");
    }

    @Test
    void test001 () {
        System.out.println("run Test001方法");
    }

    @Test
    void test002 () {
        System.out.println("run Test002方法");
    }

    @Test
    void test003 () {
        System.out.println("run Test003方法");
    }
}
