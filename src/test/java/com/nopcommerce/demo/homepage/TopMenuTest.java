package com.nopcommerce.demo.homepage;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TopMenuTest extends TestBase {

    HomePage homepage = new HomePage();   // Object create for HomePage globally

    @Test(groups = {"smoke", "regression"})
    public void verifyPageNavigation(){
        //waitUntilVisibilityOfElement(By.xpath("//ul[@class='top-menu notmobile']"),20);
        homepage.selectMenu("Apparel");
        verifyMessage(By.xpath("//div[@class='page-title']/h1"),50,"Apparel","Not Valid Message");
    }

}
