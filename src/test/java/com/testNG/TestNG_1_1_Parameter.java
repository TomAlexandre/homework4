/**
 * projectName: Junit5Demo
 * fileName: TestNG_1_1_MixParallel.java
 * packageName: com.junit5
 * date: 2020-11-07 2:24 下午
 */
package com.testNG;

import entity.Calculator;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @Version: 1.0
 * @Author: chriswang66
 * @ClassName: TestNG_1_1_MixParallel
 * @PackageName: com.junit5
 * @Description: TestNG_1_1_MixParallel
 * @Date: 2020-11-09 11:18 AM
 */

public class TestNG_1_1_Parameter {
    @Test(threadPoolSize = 1,invocationCount = 1)
    @Parameters({"x","y","result"})
    void addTest (int x,int y,int result) {
        int result001 = Calculator.add(x,y);
        System.out.println(result + "； count当前线程id ：" + Thread.currentThread().getId());
        Assert.assertEquals(result,result001);
    }

    @Test(threadPoolSize = 2,invocationCount = 5,timeOut = 14000)
    void subtractTest () {
        int result = Calculator.subtract(4,2);
        System.out.println(result + "； count当前线程id ：" + Thread.currentThread().getId());
        Assert.assertEquals(result,2);
    }
}
