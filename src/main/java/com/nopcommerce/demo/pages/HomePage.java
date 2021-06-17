package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    By computerLink = By.xpath("//div[@class='header-menu']/ul[1]/li[1]/a");


    public void selectMenu(String menu) {
        Reporter.log("clicking on computer link" + computerLink.toString() + "<br>");
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='header-menu']/ul[1]/li/a"));
        for (WebElement element : elementList) {
            if (element.getText().equalsIgnoreCase(menu)) {
                element.click();
                break;
            }
        }
    }

    public void clickOnComputerMenu() {
        Reporter.log("clicking on computer link" + computerLink.toString() + "<br>");
        mouseHoverToElementAndClick(computerLink);
    }



}