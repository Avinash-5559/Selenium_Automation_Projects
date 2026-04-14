package com.avinashsinha.tests.saucedemo;

import com.avinashsinha.base.BaseTest;
import com.avinashsinha.pages.saucedemo.*;
import com.avinashsinha.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static com.avinashsinha.driver.DriverManager.getDriver;

public class TestSauceDemo_CheckoutInfoPage extends BaseTest {

    private final static Logger LOGGER = LogManager.getLogger(TestSauceDemo_CheckoutInfoPage.class);

    @Test(priority = 1)
    @Description("TC#1 : Verify that User able to fill the form")
    @Owner("Avinash Sinha")
    @Story("Positive - Fill the form")
    public void testFillTheForm() {

        LOGGER.info("Start with the Valid Credentials to the Login Page");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername(PropertiesReader.readKey("sauceValidUsername"))
                .enterPassword(PropertiesReader.readKey("sauceValidPassword"))
                .clickLoginButton();

        LOGGER.info("Valid Login Successful Completed");

        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage
                .searchProduct()
                .clickAddToCart()
                .clickCart();

        LOGGER.info("User successfully able to Click Add To Cart Button on the Product Page");


        CartPage cartPage = new CartPage(getDriver());
        cartPage
                .isProductPresent();

        cartPage
                .clickCheckoutButtton();

        LOGGER.info("Product is now move to the Checkout Page");

        InformationPage informationPage = new InformationPage(getDriver());
        informationPage
                .enterFirstName(PropertiesReader.readKey("firstName"))
                .enterLastName(PropertiesReader.readKey("lastName"))
                .enterPostalCode(PropertiesReader.readKey("postalCode"));

        LOGGER.info("User successfully able to Fill the Form");

    }

    @Test(priority = 2)
    @Description("TC#2 : Verify that User see the Error message without fill the form")
    @Owner("Avinash Sinha")
    @Story("Negative - See the Error message")
    public void testSeeErrorMessage() {

        LOGGER.info("Start login with Valid Credentials to the Login Page");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername(PropertiesReader.readKey("sauceValidUsername"))
                .enterPassword(PropertiesReader.readKey("sauceValidPassword"))
                .clickLoginButton();

        LOGGER.info("User Login Successful Completed");

        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage
                .searchProduct()
                .clickAddToCart()
                .clickCart();

        LOGGER.info("User add the Product on the Cart");


        CartPage cartPage = new CartPage(getDriver());
        cartPage
                .isProductPresent();

        cartPage
                .clickCheckoutButtton();

        LOGGER.info("Product is ready for the Checkout");

        InformationPage informationPage = new InformationPage(getDriver());
        informationPage
                .clickContinue()
                .seeErrorMessage();

        LOGGER.info("User see the Error message without fill the form");

    }

    @Test(priority = 3)
    @Description("TC#3 : Verify that User able to see Confirmation Details of Purchase")
    @Owner("Avinash Sinha")
    @Story("Positive - See the Confirmation")
    public void testSeeConfirmationPage() {

        LOGGER.info("User login to Valid Credentials");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername(PropertiesReader.readKey("sauceValidUsername"))
                .enterPassword(PropertiesReader.readKey("sauceValidPassword"))
                .clickLoginButton();

        LOGGER.info("User logged in Successful");

        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage
                .searchProduct()
                .clickAddToCart()
                .clickCart();

        LOGGER.info("User Click to the Add To Cart Button on the Product Page");


        CartPage cartPage = new CartPage(getDriver());
        cartPage
                .isProductPresent();

        cartPage
                .clickCheckoutButtton();

        LOGGER.info("User move the product to the Checkout Page");

        InformationPage informationPage = new InformationPage(getDriver());
        informationPage
                .enterFirstName(PropertiesReader.readKey("firstName"))
                .enterLastName(PropertiesReader.readKey("lastName"))
                .enterPostalCode(PropertiesReader.readKey("postalCode"))
                .clickContinue();

        LOGGER.info("User see the Confirmation Details of Purchase");

    }

    @Test(priority = 4)
    @Description("TC#4 : Verify that User able to cancel the Order")
    @Owner("Avinash Sinha")
    @Story("Negative - Cancel the Order")
    public void testCancelOrder() {

        LOGGER.info("User login with Valid Credentials to the Login Page");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername(PropertiesReader.readKey("sauceValidUsername"))
                .enterPassword(PropertiesReader.readKey("sauceValidPassword"))
                .clickLoginButton();

        LOGGER.info("Successful logged in with Valid Credentials Completed");

        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage
                .searchProduct()
                .clickAddToCart()
                .clickCart();

        LOGGER.info("Add the Product on the Cart page");


        CartPage cartPage = new CartPage(getDriver());
        cartPage
                .isProductPresent();

        cartPage
                .clickCheckoutButtton();

        LOGGER.info("User try to cancel the order");

        InformationPage informationPage = new InformationPage(getDriver());
        informationPage
                .cancelOrder();

        LOGGER.info("Successfully cancel the Order");

    }

    @Test(priority = 5)
    @Description("TC#5 : Verify that User able to Purchase the product")
    @Owner("Avinash Sinha")
    @Story("Positive - Purchase the product")
    public void testPurchaseProduct() {

        LOGGER.info("Start with Valid Credentials to the Login Page");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername(PropertiesReader.readKey("sauceValidUsername"))
                .enterPassword(PropertiesReader.readKey("sauceValidPassword"))
                .clickLoginButton();

        LOGGER.info("Logged Successful Completed");

        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage
                .searchProduct()
                .clickAddToCart()
                .clickCart();

        LOGGER.info("User able to Click on Add To Cart Button on the Product Page");


        CartPage cartPage = new CartPage(getDriver());
        cartPage
                .isProductPresent();

        cartPage
                .clickCheckoutButtton();

        LOGGER.info("Product now move to the Checkout Page");

        InformationPage informationPage = new InformationPage(getDriver());
        informationPage
                .enterFirstName(PropertiesReader.readKey("firstName"))
                .enterLastName(PropertiesReader.readKey("lastName"))
                .enterPostalCode(PropertiesReader.readKey("postalCode"))
                .clickContinue();

        LOGGER.info("User confirm the order details");

        OverviewPage overviewPage = new OverviewPage(getDriver());
        overviewPage
                .checkOrderDetails();

        LOGGER.info("User successfully purchased the order");

    }

}