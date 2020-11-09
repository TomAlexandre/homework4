/**
 * projectName: Junit5Demo
 * fileName: Junit5Demo_1_1_Allure.java
 * packageName: com.junit5
 * date: 2020-11-07 2:24 下午
 */
package com.junit5;

import entity.Calculator;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Version: 1.0
 * @Author: chriswang66
 * @ClassName: Junit5Demo_1_1_Allure
 * @PackageName: com.junit5
 * @Description: Junit5Demo_1_1_Allure
 * @Date: 2020-11-09 11:18 AM
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Epic("Epic 计算器项目")
@Feature("Feature 冒烟测试用例")
public class Junit5Demo_1_1_AllureDemo {

    public static final int EXPECTED_COUNT = 1;
    @Test
    @Order(2)
    @Description("Description")
    @Story("Story 加法测试")
    @DisplayName("DisplayName 加法测试")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("www.baidu.com")
    @Link(name = "Link 社区贴" ,type = "mylink", url ="https://ceshiren.com/t/topic/7718")
    void addTest () {
        int result01 = Calculator.add(4,2);
        System.out.println("add01方法 = " + result01);

        int result02 = Calculator.add(5,2);
        System.out.println("add01方法 = " + result02);

        int result03 = Calculator.add(6,2);
        System.out.println("add01方法 = " + result03);

        assertAll("计算结果校验：",
                () -> assertEquals(6,result01),
                () -> assertEquals(6,result02),
                () -> assertEquals(7,result03)
                );
    }

    @Test
    @Order(3)
    @Description("Description减法测试")
    @Story("Story减法测试")
    @DisplayName("DisplayName减法测试")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("123")
    @Link(name ="测试社区：",type = "mylink",url = "https://ceshiren.com/t/topic/7611/4")
    void subtractTest () {
        int result = Calculator.subtract(4,2);
        System.out.println("subtract方法 = " + result);
        Allure.addAttachment("脚本名称","测试用例名称");
        Allure.addAttachment("1","image/png",this.getClass().getResourceAsStream("/dongman.png"),".png");
        assertEquals(2,result);
    }

    @Test
    @Order(4)
    void multiplyTest () {
        int result = Calculator.multiply(4,2);
        System.out.println("multiply方法 = " + result);
        assertEquals(8,result);
    }

    @Test
    @Order(5)
    void divisionTest () {
        int result = Calculator.division(4,2);
        System.out.println("division方法 = " + result);
        assertEquals(2,result);
    }

    @BeforeEach
    void clear() {
        Calculator.clear();
    }

    @Test
    @Order(6)
    void junit5Test() {
        assertEquals(1,3,"实际值与期望结果不符");
    }

    @Test
    @Order(7)
    void count() throws InterruptedException {
        for (int i = 1;i <= 3;i ++) {
            Calculator.count(1);
        }
        int result = Calculator.count(1);
        System.out.println("division方法 = " + result);
        assertEquals(4,result,"实际值与期望结果不符");

    }

    @Test
    @Order(8)
    void synCount() throws InterruptedException {
        for (int i = 1;i <= 4;i ++) {
            Calculator.count(1);
        }
        int result = Calculator.count(1);
        System.out.println("division方法 = " + result);
        assertEquals(5,result,"实际值与期望结果不符");

    }

    String getErrMsg (int expStr,int result) {
        StringBuffer sb = new StringBuffer();
        sb.append("实际值");
        sb.append(" ");
        sb.append(result);
        sb.append(" ");
        sb.append("与期望结果");
        sb.append(" ");
        sb.append(expStr);
        sb.append(" ");
        sb.append("不符");
        return sb.toString();
    }

    @Attachment(value = "Page ScreenShort",type = "pic/png")
    byte[] saveScreenShort (byte[] screenShort) {
        return screenShort;
    }

}
