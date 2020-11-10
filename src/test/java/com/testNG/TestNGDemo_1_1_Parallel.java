/**
 * projectName: Junit5Demo
 * fileName: TestNGDemo_1_1_ExtendFixtures.java
 * packageName: com.junit5
 * date: 2020-11-07 2:24 下午
 */
package com.testNG;

import entity.Calculator;
import org.junit.jupiter.api.*;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Version: 1.0
 * @Author: chriswang66
 * @ClassName: TestNGDemo_1_1_ExtendFixtures
 * @PackageName: com.junit5
 * @Description: TestNGDemo_1_1_ExtendFixtures
 * @Date: 2020-11-09 11:18 AM
 */

public class TestNGDemo_1_1_Parallel {

    @Test(threadPoolSize = 3,invocationCount = 10,timeOut = 6000)
    void counttest () throws InterruptedException {
        System.out.println(Calculator.count(1) + "； count当前线程id ：" + Thread.currentThread().getId());
    }

    @Test(threadPoolSize = 3,invocationCount = 10,timeOut = 60000)
    void synCounttest () throws InterruptedException {
        System.out.println(Calculator.synCount(1) + "； syn当前线程id ：" + Thread.currentThread().getId());
    }
}
