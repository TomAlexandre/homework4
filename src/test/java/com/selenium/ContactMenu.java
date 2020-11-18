package com.selenium;

import org.junit.platform.commons.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * @Version: 1.0
 * @Author: chriswang66
 * @ClassName: ContactMenu
 * @PackageName: com.selenium
 * @Description: ContactMenu演练
 * @Date: 2020-11-16 10:35 AM
 */
public class ContactMenu extends BaseDish{

    public ContactMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public void addBatch () throws InterruptedException {
        click(By.linkText("批量导入"), INIT_NUM0);
        click(By.linkText("文件导入"), INIT_NUM0);
        click(By.linkText("上传文件"), INIT_NUM0);
        Thread.sleep(10000);
//        click(By.linkText("取消"), INIT_NUM0);
    }

    public ContactMenu searchDep (String depName) throws InterruptedException {
        click(By.linkText("通讯录"), INIT_NUM0);
        sendKeys(By.id("memberSearchInput"), INIT_NUM0,depName);
        Thread.sleep(1000);
        click(By.cssSelector(".ww_searchResult_item_Curr"),INIT_NUM0);
        return this;
    }

    public String validateMsg () {
        return getText(By.cssSelector(".js_party_info"));
    }

    public ContactMenu addDep (String depName) {
        click(By.linkText("通讯录"), INIT_NUM0);
        click(By.linkText("添加"), INIT_NUM0);
        click(By.linkText("添加部门"), INIT_NUM0);
        sendKeys(By.xpath("//input[@class='qui_inputText ww_inputText']"),INIT_NUM0,depName);
        click(By.linkText("选择所属部门"), INIT_NUM0);
        click(By.xpath("//a[@class='jstree-anchor']"),INIT_NUM1);
        click(By.linkText("确定"), INIT_NUM0);
        return this;
    }

    /*public void clearAllDeparts () throws InterruptedException {
        searchDep("销售部");
    }*/

    public ContactMenu addMemberSuc(String username,String acctid,String mobile) {
        addMember(username,acctid,mobile);
//        cleanBtn();
        return this;
    }


    public ContactMenu addMemberFai(String username,String acctid,String mobile) {
        addMember(username,acctid,mobile);
//        cleanBtn();
        return this;
    }

    public ContactMenu deleteDep (String depName) throws InterruptedException {
        chooseDep(DELETE_STEP.split("@")[0],DELETE_STEP.split("@")[1],depName,null);
//        cleanBtn();
        return this;
    }

    public ContactMenu modifyDep (String depName,String modifyName) throws InterruptedException {
        chooseDep(MODIFY_STEP.split("@")[0],MODIFY_STEP.split("@")[1],depName,modifyName);
//        cleanBtn();
        return this;
    }

    public void chooseDep (String operationStp,String operationSave,String depName,String modifyName) throws InterruptedException {
        click(By.linkText("通讯录"), INIT_NUM0);
        Thread.sleep(5000);
        click(By.linkText(depName), INIT_NUM0);
        Thread.sleep(5000);//$x('//span[@class="icon jstree-contextmenu-hover"]')
        click(By.xpath("//span[@class='icon jstree-contextmenu-hover']"), INIT_NUM1);
        click(By.linkText(operationStp), INIT_NUM0);
        Thread.sleep(5000);
        if (StringUtils.isNotBlank(modifyName)) {
            sendKeys(By.xpath("//input[@class='qui_inputText ww_inputText js_rename_input']"),INIT_NUM0,modifyName);
        }
        click(By.linkText(operationSave), INIT_NUM0);
    }

    public ContactMenu deleteMember () throws InterruptedException {
        click(By.xpath("//input[@class='ww_checkbox']"),INIT_NUM0);
        click(By.linkText("删除"), INIT_NUM0);
        Thread.sleep(3000);
        click(By.linkText("确认"), INIT_NUM0);
//        cleanBtn();
        return this;
    }

    public ContactMenu addMember (String username,String acctid,String mobile) {
        click(By.linkText("添加成员"), INIT_NUM0);
        sendKeys(By.xpath("//input[@class='ww_compatibleTxt_ipt']"),INIT_NUM0,username);
        sendKeys(By.xpath("//input[@class='qui_inputText ww_inputText']"),INIT_NUM0,acctid);
        sendKeys(By.xpath("//input[@class='qui_inputText ww_inputText ww_telInput_mainNumber']"),INIT_NUM0,mobile);
        click(By.xpath("//a[@class='qui_btn ww_btn ww_btn_Blue js_btn_continue']"),INIT_NUM0);
//        cleanBtn();
        return this;
    }

    void cleanBtn () {
        click(By.id("clearMemberSearchInput"),INIT_NUM0);
    }

}
