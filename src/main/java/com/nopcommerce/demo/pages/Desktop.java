package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Desktop extends Utility {

    By sortByZtoA = By.id("products-orderby");
    By descendingOrder = By.id("products-orderby");//div[@class='details']products-orderby
    By sortByAtoZ = By.id("products-orderby");
    By addToCart = By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]");//button[@class='button-2 product-box-add-to-cart-button']

    public void selectSortByPositionNameZToA() {
        Reporter.log("Select sort by Z to A" + sortByZtoA.toString() + "<br>");
        selectByValueFromDropDown((sortByZtoA), "6");
    }

    public void verifyProductArrangeInDescendingOrder() {
        Reporter.log("Verifying Product is arranged in Descending Order" + descendingOrder.toString() + "<br>");
        selectByValueVisibleText((descendingOrder), "Name: Z to A");

        //Getting list of web elements of product name
        List<WebElement> deskTopList = driver.findElements(By.xpath("//div[@class='item-grid']"));

        List<String> productName = new ArrayList<>();
        for (WebElement desktop : deskTopList) {
            productName.add(desktop.getText());

            List<String> templist = new ArrayList<>();  // temporary array list
            templist.addAll(productName);

            Collections.sort(templist, Collections.reverseOrder());  // Collections.sort(templist); for Asc only
            System.out.println(productName);
            System.out.println(templist);

            Assert.assertEquals(productName, templist);
        }
    }

    public void selectSortByPositionNameAToZ() {
        Reporter.log("Select sort by A to Z" + sortByAtoZ.toString() + "<br>");
        selectByValueFromDropDown((sortByAtoZ), "5");
    }

    public void clickOnAddToCart() {
        Reporter.log("Click on Add To Cart Button" + addToCart.toString() + "<br>");
        mouseHoverToElementAndClick(addToCart);

    }

}
