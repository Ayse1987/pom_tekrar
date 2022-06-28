package com.techproed.tests;

import com.techproed.pages.TestAddressPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class TestAddressLoginTest {

    TestAddressPage testAddressPage=new TestAddressPage();
    @Test
            public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("test_address_url"));
        testAddressPage.mail.sendKeys(ConfigReader.getProperty("mail"));
        testAddressPage.password.sendKeys(ConfigReader.getProperty("password"));
        testAddressPage.signInButton.click();

    }

}
