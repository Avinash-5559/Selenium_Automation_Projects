package com.avinashsinha.tests.flipkart;

import com.avinashsinha.base.CommonToAllTest;
import com.avinashsinha.listeners.RetryAnalyzer;
import com.avinashsinha.listeners.ScreenshotListeners;
import com.avinashsinha.pages.flipkart.*;
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
    public void test_flipkartPage() {

        logger.info("Starting the TestCase of Flipkart Page");

        HomePage homePage = new HomePage(getDriver());
        homePage.flipkartHomePage();

        logger.info("Search the Product on Flipkart Search Page");

        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.searchProduct();

        logger.info("Open the Product on New Flipkart Product Page");

        ProductPage productPage = new ProductPage(getDriver());
        productPage.clickAddToCartButton();

        logger.info("Add the Product on Flipkart Cart Page");

        CartPage cartPage = new CartPage(getDriver());
        cartPage.buyProduct();

        logger.info("Proceed to the Flipkart CheckOut Page");

        CheckoutCumLoginPage checkoutCumLoginPage = new CheckoutCumLoginPage(getDriver());
        checkoutCumLoginPage.checkOutCumLogin();

        logger.info("Finishing the TestCase of Flipkart Page");

    }
}