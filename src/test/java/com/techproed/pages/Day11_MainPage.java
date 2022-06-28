package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day11_MainPage {
    public Day11_MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(partialLinkText = "Log in")
    public WebElement loginFindBy;

    @FindBy(xpath="//*[.='Log out']")
    public WebElement logOut;
}
