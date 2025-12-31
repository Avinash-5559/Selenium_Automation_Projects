package com.avinashsinha.tests.flipkart;

import com.avinashsinha.base.CommonToAllTest;
import com.avinashsinha.listeners.RetryAnalyzer;
import com.avinashsinha.listeners.ScreenshotListeners;
import com.avinashsinha.pages.flipkart.HomePage;
import com.avinashsinha.pages.flipkart.SearchPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.avinashsinha.driver.DriverManager.getDriver;

@Listeners(ScreenshotListeners.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestFlipkartPage extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestFlipkartPage.class);

    @Test
    @Description("TC#1 Verify that search the Product on Flipkart.com and purchase it")
    @Owner("Avinash Sinha")
    public void test_FlipkartPage() {

        logger.info("Starting the TestCase of Flipkart Page");

        HomePage homePage = new HomePage(getDriver());
        homePage.flipkartHomePage();

        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.searchProduct();

        logger.info("Finishing the TestCase of Flipkart Page");

    }
}
