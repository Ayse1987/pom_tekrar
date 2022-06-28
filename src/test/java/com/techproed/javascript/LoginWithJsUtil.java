package com.techproed.javascript;

import com.techproed.utilities.Driver;
import com.techproed.utilities.JSUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithJsUtil {
    @Test
    public void test(){
        Driver.getDriver().get("https://www.amazon.com/");
       // Actions actions=new Actions(Driver.getDriver());
        //actions.sendKeys(Keys.END).sendKeys(Keys.PAGE_UP).perform();
        WebElement lastItem=Driver.getDriver().findElement(By.xpath("//*[.='Make Money with Us']"));
        JSUtils.scrollIntoVIewJS(lastItem);
        WebElement sellProduct=Driver.getDriver().findElement(By.xpath("//*[.='Sell products on Amazon']"));
        JSUtils.clickElementByJS(sellProduct);

        Assert.assertTrue(lastItem.isDisplayed());

    }
}
