package com.techproed.reusableTest;

import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ReusableTest {

    @Test
    public void windowHandle(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        WebElement click=Driver.getDriver().findElement(By.xpath("//*[.='Click Here']"));
        click.click();
        System.out.println(Driver.getDriver().getTitle());
        ReusableMethods.switchToWindow("New Window");
        System.out.println(Driver.getDriver().getTitle());
    }
    @Test
    public void hover(){
        Driver.getDriver().get("https://www.amazon.com/");
        WebElement account=Driver.getDriver().findElement(By.xpath("//a[@id='nav-link-accountList']"));
        ReusableMethods.hover(account);
        List<String> list=ReusableMethods.getElementsText(By.id("nav-al-your-account"));
        ReusableMethods.waitFor(10);
        account.click();
        System.out.println(list);
    }



}
