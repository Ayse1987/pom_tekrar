package com.techproed.tests;

import com.techproed.pages.Day11_MainPage;
import com.techproed.pages.HotelRoomPage;
import com.techproed.pages.ListOfUsersPage;
import com.techproed.pages.LoginPageElements;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Day13_WebTables {
     /*
Create a method: BeforeMethod to log in the app and navigate to hotel rooms page
Log in  https://qa-environment.resortsline.com/Account/Logon
Click on Hotel Management
Click on Hotel Rooms
Create a test method: entireTable() and Find the size of the entire table body and print all of headers
Create a test method: printRows() and Print all of the rows and print the elements on the 4th row
Create a test method: printCells() and a the total number of cells in the table body and print all of the cells
Create a test method: printColumns() and print Find the total number of columns and Print the elements of the 5th column
Create a test method: printData(int row, int column); This method should print the given cell. Example: printData(2,3); should print 2nd row,3rd column
*/


    LoginPageElements loginPageElements=new LoginPageElements();
    ListOfUsersPage listOfUsersPage=new ListOfUsersPage();
    HotelRoomPage hotelRoomPage=new HotelRoomPage();
    @Test
    public void webTable(){
        loginPageElements.login();
        listOfUsersPage.hotelManagement.click();
        listOfUsersPage.hotelRoom.click();

        List<WebElement>alltabl=Driver.getDriver().findElements(By.xpath("//table"));
        System.out.println(alltabl.size());

        List<WebElement>allHeader=Driver.getDriver().findElements(By.xpath("//thead//th"));
        for(WebElement w:allHeader){
            System.out.println(w.getText());

        }
        List<WebElement>allrows=Driver.getDriver().findElements(By.xpath("//tbody//tr"));
        int count=1;
        for(WebElement w:allrows){
            if(count==4) {
                System.out.println(count + ". row" + w.getText());
            }
            count++;
        }
        List<WebElement>allCells=Driver.getDriver().findElements(By.xpath("//tbody//td"));
        System.out.println(allCells.size());

        for(WebElement w: allCells){
            System.out.print(w.getText());
        }

        List<WebElement>columns=Driver.getDriver().findElements(By.xpath("//tbody//tr//td[6]"));
        System.out.println("=======");
        for(WebElement w:columns){
            System.out.println(w.getText());
        }


    }
    public void dataProvider(int row,int column){
       WebElement data=Driver.getDriver().findElement(By.xpath("//tbody//tr["+row+"]//td["+column+"]"));
        System.out.println(data.getText());
    }
    @Test
    public void yeni(){
        loginPageElements.login();
        listOfUsersPage.hotelManagement.click();
        listOfUsersPage.hotelRoom.click();
        dataProvider(2,6);
    }




}
