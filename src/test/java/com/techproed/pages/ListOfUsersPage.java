package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfUsersPage {
    public ListOfUsersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[.='ListOfUsers']")
    public WebElement expression;

    @FindBy(xpath = "//tbody//tr[3]//td[5]")
    public WebElement phone;

    @FindBy(xpath = "//*[.='Hotel Management']")
    public WebElement hotelManagement;

    @FindBy(xpath = "//a[@href='/admin/HotelRoomAdmin']")
    public WebElement hotelRoom;
}
