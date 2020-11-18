package com.selenium;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
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
 * @ClassName: MainMenu
 * @PackageName: com.selenium
 * @Description: MainMenu演练
 * @Date: 2020-11-16 10:21 AM
 */
public class MainMenu extends BaseDish{

    public MainMenu() throws IOException, InterruptedException {
        this.startLogin();
    }

    void testLogin () throws IOException, InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://work.weixin.qq.com/wework_admin/frame");
        Thread.sleep(20000);
        Set<Cookie> cookie = webDriver.manage().getCookies();
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.writeValue(new File("cookie.yaml"),cookie);
        System.exit(0);
    }

    void startLogin () throws InterruptedException, IOException {
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
            webDriver.navigate().refresh();
        } else {
            testLogin();
        }
    }

    public ContactMenu jumpAddressBk () {
        click(By.linkText("通讯录"), INIT_NUM0);
        return new ContactMenu(webDriver);
    }


}
