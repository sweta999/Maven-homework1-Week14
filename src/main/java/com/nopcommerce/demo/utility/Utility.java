package com.nopcommerce.demo.utility;

import com.nopcommerce.demo.basepage.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Utility extends BasePage {

    // public WebDriver driver;
    // this is commented because this class is extends with BasePage and WebDriver is mentioned in BasePage

    /* Utility Class extends to BasePage for the driver to finding locators
    All common methods are fixed in the utility Class.*/

    /**
     * This method will generate random number
     */
    public static int generateRandomNumber() {
        return (int) (Math.random() * 5000 + 1);
    }

    /**
     * This method will click on element
     */
    // click on element method. By=class, by=variable
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void clickOnElement(By by, String value) {
        driver.findElement(by).click();
    }

    /**
     * This method will return list of elements
     */
    public List<WebElement> getListOfElements(By by) {
        return driver.findElements(by);
    }

    /**
     * This method will get text from element
     *
     * @return
     */
    public String getTextFromElement(By by) {
        /*String text = driver.findElement(by).click();
        text =*/
        //OR
        return driver.findElement(by).getText();
    }

    /**
     * This method will send Text to/on  Element or field
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    public void sendTextToElement(WebElement element, String text) {
        element.sendKeys(text);
        element.sendKeys(Keys.TAB);
    }

    /**
     * This method will select by value from dropdown by value
     */
    public void selectByValueFromDropDown(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }
    public void selectByValueFromDropDown(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    /**
     * This method will select by visibleText from dropdown by visibleText
     */
    public void selectByValueVisibleText(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(value);
    }
    public void selectByVisibleTextFromDropDown(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    /**
     * This method will select by Index from dropdown by Index
     */
    public void selectByIndex(By by, int value) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(value);
    }
    public void selectByIndexFromDropDown(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    /**
     * This method will used to hover mouse on element
     */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }
    public void mouseHoverToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    /**
     * This method will used to hover mouse on element and click
     */
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
    public void mouseHoverToElementAndClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    /**
     * This method will used to wait web driver until element become clickable
     */
    public void waitUntilElementToBeClickable(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
    }

    /**
     * This method will used to wait web driver until presence of element located by locator
     */
    public void waitUntilPresenceOfElementLocated(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * This method will used to wait until element located
     */
    public WebElement waitUntilVisibilityOfElement(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }    //OR
    // 1 Line for 2 & 3 line(shown as below)
    /*  public WebElement waitUntilVisibilityOfElement(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }*/

    /**
     * This method will verify that element is displayed
     */
    public boolean verifyThatElementIsDisplayed(By by) {
        WebElement element = driver.findElement(by);
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
    public boolean verifyThatElementIsDisplayed(WebElement element) {
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method will verify that element is displayed
     */
    public boolean verifyThatTextIsDisplayed(By by, String text) {
        WebElement element = driver.findElement(by);
        if (text.equals(element.getText())) {
            return true;
        } else {
            return false;
        }
    }
    public boolean verifyThatTextIsDisplayed(WebElement element, String text) {
        if (text.equals(element.getText())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method will returns list of web elements
     */
    public List<WebElement> webElementList(By by) {
        return driver.findElements(by);
    }
    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    /**
     * Screenshot methods
     */
    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    /**
     * This method will used to wait until element located and Verify Message
     */
    public void verifyMessage(By by, int timeout, String expected, String unexpected) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        String expectedMessage = expected;
        String actualMessage = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }

}