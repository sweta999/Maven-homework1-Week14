package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class Computers extends Utility {

    By desktoplink = By.xpath("//ul[@class='sublist']/li[1]/a"); //OR //div[@class='header-menu']/ul[1]/li[1]/ul/li[1]/a //OR //ul[@class='top-menu notmobile']/li[1]/ul/li[1]/a


    public void clickOnDesktop() {
        Reporter.log("clicking on desktop link" + desktoplink.toString() + "<br>");
        mouseHoverToElementAndClick(desktoplink);
    }



}
