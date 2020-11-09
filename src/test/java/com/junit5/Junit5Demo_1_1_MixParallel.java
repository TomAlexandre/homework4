/**
 * projectName: Junit5Demo
 * fileName: Junit5Demo_1_1_MixParallel.java
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
 * @ClassName: Junit5Demo_1_1_MixParallel
 * @PackageName: com.junit5
 * @Description: Junit5Demo_1_1_MixParallel
 * @Date: 2020-11-09 11:18 AM
 */

public class Junit5Demo_1_1_MixParallel {
    @RepeatedTest(10)
    void addTest () {
        int result = Calculator.add(4,2);
        System.out.println(result);
        assertEquals(6,result);
    }

    @RepeatedTest(10)
    void subtractTest () {
        int result = Calculator.subtract(4,2);
        System.out.println(result);
        assertEquals(2,result);
    }
}
