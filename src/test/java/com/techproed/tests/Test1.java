package com.techproed.tests;

import com.techproed.pages.AmazonHomePage;
import com.techproed.utilities.ConfigReader;
import static com.techproed.utilities.Driver.*;
import org.testng.annotations.Test;

public class Test1 {
    @Test
    public void test(){
        System.out.println(ConfigReader.getProperty("browser"));
        getDriver().get("https://www.amazon.com/");
        AmazonHomePage amazon=new AmazonHomePage();
        amazon.searchBox.sendKeys(ConfigReader.getProperty("browser"));

    }
}
