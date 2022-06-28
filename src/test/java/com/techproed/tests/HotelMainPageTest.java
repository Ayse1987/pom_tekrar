package com.techproed.tests;

import com.techproed.pages.Day11_MainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class HotelMainPageTest {

    Day11_MainPage mainPage=new Day11_MainPage();
    @Test
    public void main(){
        Driver.getDriver().get(ConfigReader.getProperty("application_url"));

        mainPage.loginFindBy.click();


    }
}
