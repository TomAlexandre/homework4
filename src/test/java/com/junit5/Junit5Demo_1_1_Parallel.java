/**
 * projectName: Junit5Demo
 * fileName: Junit5Demo_1_1_ExtendFixtures.java
 * packageName: com.junit5
 * date: 2020-11-07 2:24 下午
 */
package com.junit5;

import entity.Calculator;
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

public class Junit5Demo_1_1_Parallel {

    @RepeatedTest(10)
    void counttest () throws InterruptedException {
        System.out.println(Calculator.count(1));
    }

    @RepeatedTest(10)
    void synCounttest () throws InterruptedException {
        System.out.println(Calculator.synCount(1));
    }
}
