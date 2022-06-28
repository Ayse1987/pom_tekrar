package com.techproed.tests;

import com.techproed.pages.Day11_MainPage;
import com.techproed.pages.ListOfUsersPage;
import com.techproed.pages.LoginPageElements;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtentExample extends TestBase {
    Day11_MainPage mainPage;
    LoginPageElements loginPageElements;
    ListOfUsersPage listOfUsersPage;

    @Test
    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("application_url"));
        mainPage.loginFindBy.click();
       extentTest.info("User is on Login Page");
        loginPageElements.userName.sendKeys(ConfigReader.getProperty("manager_username"));
        extentTest.info("User entered username");
        loginPageElements.password.sendKeys(ConfigReader.getProperty("manager_password"));
        extentReports.createTest("password","User entered password");
        loginPageElements.loginButton.click();
        Assert.assertTrue(listOfUsersPage.expression.isDisplayed());
        extentReports.createTest("List of Users","Lsit of users page is displayed");



    }
}
