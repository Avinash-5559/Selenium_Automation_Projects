package com.avinashsinha.tests.saucedemo;

import com.avinashsinha.base.BaseTest;
import com.avinashsinha.listeners.RetryAnalyzer;
import com.avinashsinha.listeners.ScreenshotListeners;
import com.avinashsinha.pages.saucedemo.*;
import com.avinashsinha.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.avinashsinha.driver.DriverManager.getDriver;

@Listeners(ScreenshotListeners.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestSauceDemoPage_E2E extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(TestSauceDemoPage_E2E.class);

    @Test
    @Description("TC#1 : Verify that enter the Product on cart and purchase it")
    @Owner("Avinash Sinha")
    public void test_sauceDemoPageE2E() {

        LOGGER.info("Starting the TestCase of Sauce Demo Page");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername(PropertiesReader.readKey("sauceValidUsername"))
                .enterPassword(PropertiesReader.readKey("sauceValidPassword"))
                .clickLoginButton();

        LOGGER.info("Open the homepage and Search the Product");

        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage
                .searchProduct()
                .clickAddToCart()
                .clickCart();

        LOGGER.info("Click to add the product and go the Cart Page");

        CartPage cartPage = new CartPage(getDriver());
        cartPage
                .clickCheckoutButtton();

        LOGGER.info("Go for Checkout from the Cart Page");

        InformationPage informationPage = new InformationPage(getDriver());
        informationPage
                .fillUserFormDetails()
                .enterFirstName(PropertiesReader.readKey("firstName"))
                .enterLastName(PropertiesReader.readKey("lastName"))
                .enterPostalCode(PropertiesReader.readKey("postalCode"))
                .clickContinue();

        LOGGER.info("Fill the Form and Confirm the Order");

        OverviewPage overviewPage = new OverviewPage(getDriver());
        overviewPage
                .checkOrderDetails();

        LOGGER.info("Check the Whole Order Details");

        ConfirmationPage confirmationPage = new ConfirmationPage(getDriver());
        confirmationPage
                .placedOrderConfirmed();

        LOGGER.info("Order Placed and Dispatched successfully");

        BackToProductsPage backToProductsPage = new BackToProductsPage(getDriver());
        backToProductsPage
                .clickOnMenuButton();

        LOGGER.info("Back to Products Page");

        BackToLoginPage backToLoginPage = new BackToLoginPage(getDriver());
        backToLoginPage
                .clickLogoutButton();

        LOGGER.info("Back to Login Page");

    }

}