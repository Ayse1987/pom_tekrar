package com.techproed.dataProvider;

import com.techproed.pages.Day11_MainPage;
import com.techproed.pages.ListOfUsersPage;
import com.techproed.pages.LoginPageElements;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class DataProviderIntro {
    LoginPageElements loginPageElements;
    Day11_MainPage mainPage;
    ListOfUsersPage listOfUsersPage;

    @DataProvider
    public Object[][] getData(){
        String[][] managerLoginData={{"manager","Manager1!"},
                {"manager2","Manager2!"},{"manager3","Manager3!"}};
        return managerLoginData;
    }
@Test(dataProvider = "getData")
    public void test(String userName, String password){
    System.out.println("user name: "+ userName+" | "+" Password : "+password);

}
@BeforeMethod
public  void setUp(){
    Driver.getDriver().get(ConfigReader.getProperty("application_url"));
    loginPageElements=new LoginPageElements();
    mainPage=new Day11_MainPage();
    listOfUsersPage=new ListOfUsersPage();

    mainPage.loginFindBy.click();
}
@Test(dataProvider = "getData")
    public void loginWithDataProvider(String userName,String password){
    setUp();
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
