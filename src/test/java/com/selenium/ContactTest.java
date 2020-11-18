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

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Version: 1.0
 * @Author: chriswang66
 * @ClassName: ContactTest
 * @PackageName: com.selenium
 * @Description: TestSearch演练
 * @Date: 2020-11-11 8:33 PM
 */
public class ContactTest {
    public static WebDriver webDriver;
    public static int INIT_NUM0=0;
    public static int INIT_NUM1=1;
    public String TEXT="";

    static void testLogin () throws IOException, InterruptedException {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://work.weixin.qq.com/wework_admin/frame");
        Thread.sleep(20000);
        Set<Cookie> cookie = webDriver.manage().getCookies();
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.writeValue(new File("cookie.yaml"),cookie);
        System.exit(0);
    }

    @BeforeAll
    public static void startUp () throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver","E:/exe/chromedriver_win32/chromedriver.exe/");
        File file = new File("cookie.yaml");
        if (file.exists()) {
            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            webDriver.get("https://work.weixin.qq.com/wework_admin/frame");
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            TypeReference typeReference = new TypeReference<List<HashMap<String,Object>>>(){};
            List<HashMap<String,Object>> cookies = (List<HashMap<String, Object>>) objectMapper.readValue(file,typeReference);
            cookies.forEach(cookieMap-> {
                webDriver.manage().addCookie(new Cookie(cookieMap.get("name").toString(),cookieMap.get("value").toString()));
            });
            Thread.sleep(25000);
            webDriver.navigate().refresh();
        } else {
            testLogin();
        }

    }

    @Test
    void addMember () throws InterruptedException, IOException {
        click(By.xpath("//span[@class='index_service_cnt_item_title']"),INIT_NUM0);
        sendKeys(By.xpath("//input[@class='ww_compatibleTxt_ipt']"),INIT_NUM0,"王磊1");
        sendKeys(By.xpath("//input[@class='ww_compatibleTxt_ipt']"),INIT_NUM1,"ww");
        sendKeys(By.xpath("//input[@class='qui_inputText ww_inputText']"),0,"ww1");
        sendKeys(By.xpath("//input[@class='qui_inputText ww_inputText ww_telInput_mainNumber']"),INIT_NUM0,"13212780853");
        click(By.xpath("//a[@class='qui_btn ww_btn ww_btn_Blue js_btn_continue']"),INIT_NUM0);
        /*webDriver.findElements(By.xpath("//span[@class='index_service_cnt_item_title']")).get(0).click();
        webDriver.findElements(By.xpath("//input[@class='ww_compatibleTxt_ipt']")).get(0).sendKeys("王磊1");
        webDriver.findElements(By.xpath("//input[@class='ww_compatibleTxt_ipt']")).get(1).sendKeys("ww");
        webDriver.findElements(By.xpath("//input[@class='qui_inputText ww_inputText']")).get(0).sendKeys("ww1");
        webDriver.findElements(By.xpath("//input[@class='qui_inputText ww_inputText ww_telInput_mainNumber']")).get(0).sendKeys("13212780853");
        webDriver.findElements(By.xpath("//a[@class='qui_btn ww_btn ww_btn_Blue js_btn_continue']")).get(0).click();*/
        Thread.sleep(5000);
        webDriver.navigate().refresh();
    }

    @Test
    void searchDep () throws InterruptedException {
        click(By.linkText("通讯录"), INIT_NUM0);
        sendKeys(By.id("memberSearchInput"), INIT_NUM0,"销售部");
        Thread.sleep(1000);
        click(By.cssSelector(".ww_searchResult_item_Curr"),INIT_NUM0);
        TEXT = getText(By.cssSelector(".member_colRight_cnt_main_text"));
        assertTrue(TEXT.contains("无任何成员"));

    }

    @Test
    void addDep () {
        click(By.linkText("通讯录"), INIT_NUM0);
        click(By.linkText("添加"), INIT_NUM0);
        click(By.linkText("添加部门"), INIT_NUM0);
        sendKeys(By.xpath("//input[@class='qui_inputText ww_inputText']"),INIT_NUM0,"销售部");
        click(By.linkText("选择所属部门"), INIT_NUM0);
        click(By.xpath("//a[@class='jstree-anchor']"),INIT_NUM0);
        click(By.linkText("确定"), INIT_NUM0);
    }
    @Test
    /*void departmentSearch (){
        click(By.id("a"));
        sendKeys(By.id("b"), "");

        String content = webDriver.findElement(By.id("")).getText();
        sendKeys(By.id(""), "");


    }*/

    String getText (By by) {
        return webDriver.findElement(by).getText();
    }

    void click (By by,int i) {
        webDriver.findElements(by).get(i).click();
    }

    void sendKeys (By by,int i,String content) {
        webDriver.findElements(by).get(i).sendKeys(content);;
    }

    /*@AfterAll
    public static void tearDown () {
        webDriver.quit();
    }*/

}
