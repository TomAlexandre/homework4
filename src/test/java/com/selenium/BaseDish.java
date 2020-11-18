package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @Version: 1.0
 * @Author: chriswang66
 * @ClassName: BaseDish
 * @PackageName: com.selenium
 * @Description: BaseDish演练
 * @Date: 2020-11-16 10:23 AM
 */
public class BaseDish {

    WebDriver webDriver;
    public static int INIT_NUM0=0;
    public static int INIT_NUM1=1;
    public String DELETE_STEP="删除@确定";
    public String MODIFY_STEP="修改名称@保存";
    public String TEXT="";

    public BaseDish(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public BaseDish() {
    }

    String getText (By by) {
        return webDriver.findElement(by).getText();
    }

    void click (By by,int i) {
        webDriver.findElements(by).get(i).click();
    }

    void sendKeys (By by,int i,String content) {
        webDriver.findElements(by).get(i).sendKeys(content);;
    }
}
