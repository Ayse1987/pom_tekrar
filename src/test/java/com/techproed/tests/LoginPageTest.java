package com.techproed.tests;

import com.techproed.pages.Day11_MainPage;
import com.techproed.pages.ListOfUsersPage;
import com.techproed.pages.LoginPageElements;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class LoginPageTest {
    LoginPageElements loginPageElements;
    ListOfUsersPage listOfUsersPage;
    Day11_MainPage mainPage=new Day11_MainPage();
    ExcelUtil excelUtil;
    List<Map<String,String>> testData;


    @Test
    public void login(){
        Driver.getDriver().get("https://qa-environment.resortsline.com/Account/Logon");
        Assert.assertTrue(loginPageElements.loginExpression.isDisplayed());
        loginPageElements.userName.sendKeys(ConfigReader.getProperty("admin_username"));
        loginPageElements.password.sendKeys(ConfigReader.getProperty("admin_password"));
        loginPageElements.loginButton.click();
        Assert.assertTrue(listOfUsersPage.expression.isDisplayed());

    }
    @Test
    public void loginExcel(){
        excelUtil=new ExcelUtil("C:\\Users\\Ayse\\IdeaProjects\\pom_tekrar\\src\\test\\java\\resources\\smoketestdata.xlsx","admin_login_info");
        Driver.getDriver().get(ConfigReader.getProperty("application_url"));
        mainPage.loginFindBy.click();
        loginPageElements.userName.sendKeys(excelUtil.getCellData(1,0));
        loginPageElements.password.sendKeys(excelUtil.getCellData(1,1));
        loginPageElements.loginButton.click();
    }
    public void setUp(){
        loginPageElements=new LoginPageElements();
        Driver.getDriver().get(ConfigReader.getProperty("application_url"));


    }

    @Test
    public void managerLogin() throws InterruptedException {
        Actions actions=new Actions(Driver.getDriver());

        excelUtil=new ExcelUtil("C:\\Users\\Ayse\\IdeaProjects\\pom_tekrar\\src\\test\\java\\resources\\smoketestdata.xlsx","manager_login_info");
        testData=excelUtil.getDataList();
        System.out.println(testData);
        //{password=Manager1!, username=manager}

        for(Map<String,String> w:testData){
            setUp();
            mainPage.loginFindBy.click();
            loginPageElements.userName.sendKeys(w.get("username"));
            loginPageElements.password.sendKeys(w.get("password"));
            loginPageElements.loginButton.click();
            listOfUsersPage=new ListOfUsersPage();
            Thread.sleep(1000);
            Assert.assertTrue(listOfUsersPage.expression.isDisplayed());
            Thread.sleep(1000);
            Driver.closeDriver();



        }
    }

}
