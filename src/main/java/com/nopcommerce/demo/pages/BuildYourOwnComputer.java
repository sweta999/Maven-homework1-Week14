package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class BuildYourOwnComputer extends Utility {

    By verifyTextBuildOwnComputer = By.xpath("//h1[contains(text(),'Build your own computer')]");
    By processorAttribute = By.xpath("//select[@id='product_attribute_1']");
    By ramAttribute = By.xpath("//select[@id='product_attribute_2']");
    By hddAttribute320GB = By.xpath("//input[@id='product_attribute_3_6']");
    By hddAttribute400GB = By.xpath("//input[@id='product_attribute_3_7']");
    By osAttributeVistaHome = By.xpath("//input[@id='product_attribute_4_8']");
    By osAttributeVistaPremium = By.xpath("//input[@id='product_attribute_4_9']");
    By SoftwareMicrosoftOffice = By.xpath(("//input[@id='product_attribute_5_10']"));
    By SoftwareAcrobatReader = By.xpath(("//input[@id='product_attribute_5_11']"));
    By SoftwareTotalCommander = By.xpath("//input[@id='product_attribute_5_12']");
    By verifyPrice$1475 = By.xpath("//span[@id='price-value-1']");
    By AddToCartButton = By.xpath("//button[@id='add-to-cart-button-1']");
    By verifyProductAddedMsg = By.xpath("//div[@class='bar-notification success']/p");//div[@id='bar-notification']
    By closeTheBarCrossButton = By.xpath("//span[@class='close']");


    public String getTextBuildYourOwnComputer() {
        Reporter.log("Verify the Text, Build Your Own Computer" + verifyTextBuildOwnComputer.toString() + "<br>");
        return getTextFromElement(verifyTextBuildOwnComputer);
    }

    public void selectProcessorAttribute(String value) {
        Reporter.log("Selection of Processor Attribute" + processorAttribute.toString() + "<br>");
        selectByValueFromDropDown(processorAttribute,
                value);
    }

    public void selectRamAttribute(String value) {
        Reporter.log("Selection of Ram Attribute" + ramAttribute.toString() + "<br>");
        selectByValueFromDropDown(ramAttribute,
                value);
    }

    public void selectHDDAttribute(String value) {
        if (value == "6") {
            Reporter.log("Selection of HDD Attribute" + hddAttribute320GB.toString() + "<br>");
            clickOnElement(hddAttribute320GB);
        } else if (value == "7") {
            Reporter.log("Selection of HDD Attribute" + hddAttribute400GB.toString() + "<br>");
            clickOnElement(hddAttribute400GB);
        } else {
            System.out.println("Accepts value 6 or 7 only");
        }
    }

    public void selectOSAttribute(String value) {
        if (value == "8") {
            Reporter.log("Selection of OS Attribute" + osAttributeVistaHome.toString() + "<br>");
            clickOnElement(osAttributeVistaHome);
        } else if (value == "9") {
            Reporter.log("Selection of OS Attribute" + osAttributeVistaPremium.toString() + "<br>");
            clickOnElement(osAttributeVistaPremium);
        } else {
            System.out.println("Accepts value 8 or 9 only");
        }
    }

    public void selectSoftwareMicrosoftOffice() {
        Reporter.log("Selection of Software Attribute" + SoftwareMicrosoftOffice.toString() + "<br>");
        mouseHoverToElementAndClick(SoftwareMicrosoftOffice);
    }

    public void selectSoftwareAcrobatReader() {
        Reporter.log("Selection of Software Attribute" + SoftwareAcrobatReader.toString() + "<br>");
        mouseHoverToElementAndClick(SoftwareAcrobatReader); //mouse hover method works without parameter
    }

    public void selectSoftwareTotalCommander() {
        Reporter.log("Selection of Software Attribute" + SoftwareTotalCommander.toString() + "<br>");
        mouseHoverToElementAndClick(SoftwareTotalCommander);
    }

    public String getTextForPrice$1475() {
        Reporter.log("Verifying the Price" + verifyPrice$1475.toString() + "<br>");
        return getTextFromElement(verifyPrice$1475);
    }

    public void clickOnAddToCartButton() {
        Reporter.log("Click on Add to Cart Button" + AddToCartButton.toString() + "<br>");
        mouseHoverToElementAndClick(AddToCartButton);
    }

    public String getTextProductAddedToCart() {
        Reporter.log("Verifying the Text, Product is added to Cart" + verifyProductAddedMsg.toString() + "<br>");
        return getTextFromElement(verifyProductAddedMsg);
    }

    public void setCloseTheBarCrossButton() {
        Reporter.log("Close the Bar Cross Button" + closeTheBarCrossButton.toString() + "<br>");
        mouseHoverToElementAndClick(closeTheBarCrossButton);
    }

}
