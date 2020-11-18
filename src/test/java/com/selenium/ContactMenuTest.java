package com.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.selenium.ContactTest.webDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Version: 1.0
 * @Author: chriswang66
 * @ClassName: ContactMenuTest
 * @PackageName: com.selenium
 * @Description: ContactMenuTest演练
 * @Date: 2020-11-16 11:14 AM
 */
public class ContactMenuTest {
    public static MainMenu mainMenu;
    public String DEPNM1 =  "销售部";
    public String DEPNM2 =  "风纪部";

    @BeforeAll
    static void cleanData () throws InterruptedException, IOException {
        mainMenu = new MainMenu();
//        mainMenu.jumpAddressBk().clearAllDeparts();
    }

    //没写完
    @Test
    public void uploadMember () throws InterruptedException {
        mainMenu.jumpAddressBk().searchDep("销售部1").addBatch();
    }

    @Test
    public void deleteMember () throws InterruptedException {
        mainMenu.jumpAddressBk().searchDep("销售部1").deleteMember();
    }

    @Test
    public void addMember () throws InterruptedException {
        mainMenu.jumpAddressBk().searchDep("销售部1").addMemberSuc("王磊4", "1", "13212780850");
    }

    @Test
    public void searchDep () throws InterruptedException {
        assertTrue(mainMenu.jumpAddressBk().searchDep(DEPNM1).validateMsg().contains("无任何成员"));
    }

    @Test
    public void addDep () throws InterruptedException {
        assertTrue(mainMenu.jumpAddressBk().addDep(DEPNM1).searchDep(DEPNM1).validateMsg().contains(DEPNM1));
    }

    @Test
    public void deleteDep () throws InterruptedException {
        mainMenu.jumpAddressBk().searchDep("销售部1").deleteMember().deleteDep("销售部1");
    }

    @Test
    public void modifyDep () throws InterruptedException {
        mainMenu.jumpAddressBk().modifyDep("销售部", "销售部1");
    }

    /*@AfterAll
    public void fresh () {
        webDriver.navigate().refresh();
    }*/
}
