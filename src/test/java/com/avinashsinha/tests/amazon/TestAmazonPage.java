package com.avinashsinha.tests.amazon;

import com.avinashsinha.base.CommonToAllTest;
import com.avinashsinha.listeners.RetryAnalyzer;
import com.avinashsinha.listeners.ScreenshotListeners;
import com.avinashsinha.pages.amazon.*;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.avinashsinha.driver.DriverManager.getDriver;

@Listeners(ScreenshotListeners.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestAmazonPage extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestAmazonPage.class);

    @Test
    @Description("TC#1 : Verify that search the Product on Amazon.in and purchase it")
    @Owner("Avinash Sinha")
    public void test_amazonPage() {

        logger.info("Starting the TestCase of Amazon Page");

        HomePage homePage = new HomePage(getDriver());
        homePage.amazonHomePage();

        logger.info("Search the Product on Amazon Search Page");

        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.searchProduct();

        logger.info("Open the Product on New Amazon Product Page");

        ProductPage productPage = new ProductPage(getDriver());
        productPage.clickAddToCartButton();

        logger.info("Add the Product on Amazon Cart Page");

        CartPage cartPage = new CartPage(getDriver());
        cartPage.buyProduct();

        logger.info("Proceed to the Amazon CheckOut Page");

        CheckoutCumLoginPage checkoutCumLoginPage = new CheckoutCumLoginPage(getDriver());
        checkoutCumLoginPage.checkOutCumLogin();

        logger.info("Finished the TestCase of Amazon Page");

    }
}