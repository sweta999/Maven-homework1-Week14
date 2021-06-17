package com.nopcommerce.demo.testbase;

import com.nopcommerce.demo.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends Utility {
    String browser = "chrome";

    @BeforeMethod (groups = {"smoke", "sanity", "regression"})
    public void setUp(){
        selectBrowser(browser);
    }

    @AfterMethod (groups = {"smoke", "sanity", "regression"})
    public void tearDown(){
        closeBrowser();
    }

}
