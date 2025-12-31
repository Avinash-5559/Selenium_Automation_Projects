package com.avinashsinha.base;

import com.avinashsinha.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {

    @BeforeMethod
    public void openBrowser() {
        DriverManager.openBrowser();
    }

    @AfterMethod
    public void closeBrowser() {
        DriverManager.closeBrowser();
    }

}