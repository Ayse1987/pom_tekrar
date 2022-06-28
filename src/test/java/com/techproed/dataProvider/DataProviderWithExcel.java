package com.techproed.dataProvider;

import com.techproed.pages.Day11_MainPage;
import com.techproed.pages.ListOfUsersPage;
import com.techproed.pages.LoginPageElements;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithExcel {
    LoginPageElements loginPageElements;
    Day11_MainPage mainPage;
    ListOfUsersPage listOfUsersPage;
    public void setUp(){
        loginPageElements=new LoginPageElements();
        mainPage=new Day11_MainPage();
        listOfUsersPage=new ListOfUsersPage();
        Driver.getDriver().get(ConfigReader.getProperty("application_url"));

    }
    @DataProvider
    public Object[][] dataFromExcel(){
        ExcelUtil excelUtil=new ExcelUtil("C:\\Users\\Ayse\\IdeaProjects\\pom_tekrar\\src\\test\\java\\resources\\smoketestdata.xlsx","manager_login_info");
        String excelarr[][]=excelUtil.getDataArrayWithoutFirstRow();
    return excelarr;
    }
    @Test(dataProvider = "dataFromExcel")
    public void excelData(String userName,String password){
        setUp();
        mainPage.loginFindBy.click();
        loginPageElements.userName.sendKeys(userName);
        loginPageElements.password.sendKeys(password);
        loginPageElements.loginButton.click();
        Assert.assertTrue(listOfUsersPage.expression.isDisplayed());


    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
