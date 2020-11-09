/**
 * projectName: Junit5Demo
 * fileName: Junit5Demo_1_1_ExtendFixtures.java
 * packageName: com.junit5
 * date: 2020-11-07 2:24 下午
 */
package com.junit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Version: 1.0
 * @Author: chriswang66
 * @ClassName: Junit5Demo_1_1_ExtendFixtures
 * @PackageName: com.junit5
 * @Description: Junit5Demo_1_1_ExtendFixtures
 * @Date: 2020-11-09 11:18 AM
 */

public class Junit5Demo_1_1_ExtendFixtures extends Junit5Demo_1_1_Fixtures{

    @BeforeAll
    static void childBeforeAll () {
        System.out.println("执行childBeforeAll");
    }

    @AfterAll
    static void childAfteAall () {
        System.out.println("执行childAfterAll");
    }

    @BeforeEach
    void childBeforeEach () {
        System.out.println("执行childBeforeEach");
    }

    @AfterEach
    void childAfterEach () {
        System.out.println("执行childAfterEach");
    }

    @Test
    void childTest001 () {
        System.out.println("child run Test001方法");
    }

    @Test
    void childTest002 () {
        System.out.println("child run Test002方法");
    }

    @Test
    void childTest003 () {
        System.out.println("child run Test003方法");
    }
}
