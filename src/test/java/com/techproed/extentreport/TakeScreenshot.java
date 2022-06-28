package com.techproed.extentreport;

import com.techproed.pages.ListOfUsersPage;
import com.techproed.pages.LoginPageElements;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenshot {

    public void takeScreensshot() throws IOException {
        TakesScreenshot ts=(TakesScreenshot) Driver.getDriver();
        File image=ts.getScreenshotAs(OutputType.FILE);
        String currentDate=  new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());



        String path=System.getProperty("user.dir")+"/test-output/Screenshots/"+currentDate+".png";
        File finalpath=new File(path);
        FileUtils.copyFile(image,finalpath);

    }
    @BeforeMethod
    public void setUp() throws IOException {
        Driver.getDriver().get(ConfigReader.getProperty("application_login_url"));
        takeScreensshot();
    }
    LoginPageElements loginPageElements=new LoginPageElements();
    ListOfUsersPage listOfUsersPage=new ListOfUsersPage();
    @Test
    public void positiveLoginTest() throws IOException {
        loginPageElements.userName.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPageElements.password.sendKeys(ConfigReader.getProperty("manager_password"));
        takeScreensshot();
        loginPageElements.loginButton.click();
        Assert.assertTrue(listOfUsersPage.expression.isDisplayed());
        takeScreensshot();


    }
    @Test
    public void negativeLoginTest() throws IOException {
        loginPageElements.userName.sendKeys(ConfigReader.getProperty("admin_username"));
        loginPageElements.password.sendKeys(ConfigReader.getProperty("admin_password"));
        takeScreensshot();
        loginPageElements.loginButton.click();
        takeScreensshot();
        Assert.assertTrue(listOfUsersPage.expression.isDisplayed());

    }
}
