package com.techproed.pages;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements {
    public LoginPageElements (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//h2[@class='mb-4']")
    public WebElement loginExpression;

    @FindBy(id="UserName")
    public WebElement userName;

    @FindBy(id="Password")
    public WebElement password;

    @FindBy(id="btnSubmit")
    public WebElement loginButton;

    public void login(){
        Day11_MainPage mainPage=new Day11_MainPage();
        Driver.getDriver().get(ConfigReader.getProperty("application_url"));
        mainPage.loginFindBy.click();
        userName.sendKeys(ConfigReader.getProperty("admin_username"));
        password.sendKeys(ConfigReader.getProperty("admin_password"));
        loginButton.click();

    }


}
