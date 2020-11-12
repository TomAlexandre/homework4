package com.selenium;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Version: 1.0
 * @Author: chriswang66
 * @ClassName: TestSearch
 * @PackageName: com.selenium
 * @Description: TestSearch演练
 * @Date: 2020-11-11 8:33 PM
 */
public class TestSearch {
    public static WebDriver webDriver;

    @BeforeAll
    public static void startUp () {
        System.setProperty("webdriver.chrome.driver","E:/exe/chromedriver_win32/chromedriver.exe/");
    }
    @Test
    void testSearch () {
        try {
            webDriver = new ChromeDriver();
            webDriver.get("https://ceshiren.com");
            ((ChromeDriver) webDriver).findElementByCssSelector(".search-dropdown .svg-node").click();
            ((ChromeDriver) webDriver).findElementByCssSelector("#search-term").sendKeys("selenium");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }

    @Test
    void testLogin () throws IOException, InterruptedException {
            webDriver = new ChromeDriver();
            webDriver.get("https://work.weixin.qq.com/wework_admin/frame");
            Thread.sleep(20000);
            Set<Cookie> cookie = webDriver.manage().getCookies();
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            objectMapper.writeValue(new File("cookie.yaml"),cookie);
    }

    @Test
    void testLoginEd () throws IOException, InterruptedException {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("https://work.weixin.qq.com/wework_admin/frame");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        TypeReference typeReference = new TypeReference<List<HashMap<String,Object>>>(){};
        List<HashMap<String,Object>> cookies = (List<HashMap<String, Object>>) objectMapper.readValue(new File("cookie.yaml"),typeReference);
        System.out.println(cookies);
        cookies.forEach(cookieMap-> {
            webDriver.manage().addCookie(new Cookie(cookieMap.get("name").toString(),cookieMap.get("value").toString()));
        });
        Thread.sleep(25000);
        webDriver.navigate().refresh();
    }

    @Test
    void addMember () throws InterruptedException, IOException {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("https://work.weixin.qq.com/wework_admin/frame");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        TypeReference typeReference = new TypeReference<List<HashMap<String,Object>>>(){};
        List<HashMap<String,Object>> cookies = (List<HashMap<String, Object>>) objectMapper.readValue(new File("cookie.yaml"),typeReference);
        System.out.println(cookies);
        cookies.forEach(cookieMap-> {
            webDriver.manage().addCookie(new Cookie(cookieMap.get("name").toString(),cookieMap.get("value").toString()));
        });
        Thread.sleep(25000);
        webDriver.navigate().refresh();
        webDriver.findElements(By.xpath("//span[@class='index_service_cnt_item_title']")).get(0).click();
        webDriver.findElements(By.xpath("//input[@class='ww_compatibleTxt_ipt']")).get(0).sendKeys("王磊1");
        webDriver.findElements(By.xpath("//input[@class='ww_compatibleTxt_ipt']")).get(1).sendKeys("ww");
        webDriver.findElements(By.xpath("//input[@class='qui_inputText ww_inputText']")).get(0).sendKeys("ww1");
        webDriver.findElements(By.xpath("//a[@class='qui_btn ww_btn ww_btn_Blue js_btn_continue']")).get(0).click();
        Thread.sleep(5000);
        webDriver.navigate().refresh();
    }

    @AfterAll
    public static void tearDown () {
        webDriver.quit();
    }

}
