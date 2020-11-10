/**
 * projectName: Junit5Demo
 * fileName: TestNG_1_1_MixParallel.java
 * packageName: com.junit5
 * date: 2020-11-07 2:24 下午
 */
package com.testNG;

import entity.Calculator;
import entity.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @Version: 1.0
 * @Author: chriswang66
 * @ClassName: TestNG_1_1_MixParallel
 * @PackageName: com.junit5
 * @Description: TestNG_1_1_MixParallel
 * @Date: 2020-11-09 11:18 AM
 */

public class TestNG_1_1_Data {
    @DataProvider(name = "dataProvider")
    public static Object[][] getData () throws Exception{
        return FakerUtils.getTestData("\\src\\main\\resources\\data\\divideparam.csv");
    }

    @Test(threadPoolSize = 1,invocationCount = 1,dataProvider = "dataProvider")
    void diviTest (String x,String y) {
        int result001 = Calculator.division(Integer.valueOf(x),Integer.valueOf(y));
        System.out.println(result001 + "； count当前线程id ：" + Thread.currentThread().getId());
    }

    @Test(threadPoolSize = 2,invocationCount = 5,timeOut = 14000)
    void subtractTest () {
        int result = Calculator.subtract(4,2);
        System.out.println(result + "； count当前线程id ：" + Thread.currentThread().getId());
        Assert.assertEquals(result,2);
    }
}
