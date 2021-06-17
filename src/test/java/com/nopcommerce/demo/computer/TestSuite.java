package com.nopcommerce.demo.computer;

import com.nopcommerce.demo.pages.BuildYourOwnComputer;
import com.nopcommerce.demo.pages.Computers;
import com.nopcommerce.demo.pages.Desktop;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite extends TestBase {

    HomePage homepage = new HomePage();      // Object created for Homepage globally
    Computers computer = new Computers();    // Object created for Computers globally
    Desktop desktop = new Desktop();         // Object created for Desktop globally
    BuildYourOwnComputer buildyourowncomputer = new BuildYourOwnComputer();  // Object created for BuildYourOwnComputer globally


    @Test(groups = {"sanity", "regression"})
    public void verifyProductArrangeInReverseAlphabeticalOrder() throws InterruptedException {

        homepage.clickOnComputerMenu();
        computer.clickOnDesktop();
        Thread.sleep(2000);
        desktop.selectSortByPositionNameZToA();
        desktop.verifyProductArrangeInDescendingOrder();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        homepage.clickOnComputerMenu();
        Thread.sleep(1000);
        computer.clickOnDesktop();
        desktop.selectSortByPositionNameAToZ();
        Thread.sleep(2000);
        desktop.clickOnAddToCart();
        String expectedMsg = "Build your own computer";
        String actualMsg = buildyourowncomputer.getTextBuildYourOwnComputer();
        Assert.assertEquals(actualMsg, expectedMsg);
        buildyourowncomputer.selectProcessorAttribute("1");  // Select value 1 or 2 here
        buildyourowncomputer.selectRamAttribute("5");  // Select value 3,4 or 5 here
        buildyourowncomputer.selectHDDAttribute("7");  // Select value 6 or 7 here
        buildyourowncomputer.selectOSAttribute("9");   // Select value 8 or 9 here
        buildyourowncomputer.selectSoftwareTotalCommander();
        Thread.sleep(1000);
        String expectedPrice = "$1,475.00";
        String actualPrice = buildyourowncomputer.getTextForPrice$1475();
        Assert.assertEquals(actualPrice, expectedPrice);
        buildyourowncomputer.clickOnAddToCartButton();
        String expectedMsg1 = "The product has been added to your shopping cart";
        String actualMsg1 = buildyourowncomputer.getTextProductAddedToCart();
        Assert.assertEquals(actualMsg1, expectedMsg1);
        buildyourowncomputer.setCloseTheBarCrossButton();

    }

}
