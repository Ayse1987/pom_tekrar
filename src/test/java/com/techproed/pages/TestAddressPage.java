package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestAddressPage {

   public TestAddressPage(){
       PageFactory.initElements(Driver.getDriver(),this);
   }
   @FindBy(id="session_email")
    public WebElement mail;
   @FindBy(id="session_password")
    public WebElement password;
   @FindBy(xpath = "//input[@type='submit']")
    public WebElement signInButton;

}
