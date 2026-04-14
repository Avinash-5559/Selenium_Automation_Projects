package com.avinashsinha.tests.saucedemo;

import com.avinashsinha.base.BaseTest;
import com.avinashsinha.listeners.RetryAnalyzer;
import com.avinashsinha.listeners.ScreenshotListeners;
import com.avinashsinha.pages.saucedemo.LoginPage;
import com.avinashsinha.pages.saucedemo.ProductsPage;
import com.avinashsinha.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.avinashsinha.driver.DriverManager.getDriver;

@Listeners(ScreenshotListeners.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestSauceDemo_ProductPage extends BaseTest {

    private final static Logger LOGGER = LogManager.getLogger(TestSauceDemo_ProductPage.class);

    @Test(priority = 1)
    @Description("TC#1 : Verify that User is able to click Add To Cart")
    @Owner("Avinash Sinha")
    @Story("Positive - Click Add To Cart")
    public void testClickAddToCartButton() {

        LOGGER.info("User is able to Login the Page");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername(PropertiesReader.readKey("sauceValidUsername"))
                .enterPassword(PropertiesReader.readKey("sauceValidPassword"))
                .clickLoginButton();

        LOGGER.info("Open the Product Page and Search for the Product");

        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage
                .searchProduct()
                .clickAddToCart();

        LOGGER.info("User successfully able to Click Add To Cart Button on the Product Page");

    }

    @Test(priority = 2)
    @Description("TC#2 : Verify that User is able to sort the filter Low to High")
    @Owner("Avinash Sinha")
    @Story("Positive - Sort the filter Low to High")
    public void testSortFilterLowToHigh() {

        LOGGER.info("User is now Login the Page");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername(PropertiesReader.readKey("sauceValidUsername"))
                .enterPassword(PropertiesReader.readKey("sauceValidPassword"))
                .clickLoginButton();

        LOGGER.info("User click the filter Low to High");

        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage
                .sortLowToHigh();

        LOGGER.info("Products are successfully able to sort the filter Low to High");

    }

    @Test(priority = 3)
    @Description("TC#3 : Verify that User is able see the Product Details")
    @Owner("Avinash Sinha")
    @Story("Positive - See the Product Details")
    public void testSeeProductDetails() {

        LOGGER.info("User now Login to the Page");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername(PropertiesReader.readKey("sauceValidUsername"))
                .enterPassword(PropertiesReader.readKey("sauceValidPassword"))
                .clickLoginButton();

        LOGGER.info("User click on the Product to see the Details");

        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage
                .clickProductDetails();

        LOGGER.info("User now able successfully able to see the details of the Product");

    }

    @Test(priority = 4)
    @Description("TC#4 : Verify that User is able to Navigate to the Products Page")
    @Owner("Avinash Sinha")
    @Story("Positive - Navigate to the Product Details")
    public void testNavigateProductsPage() {

        LOGGER.info("User use the Valid Credentials for Login to the Page");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername(PropertiesReader.readKey("sauceValidUsername"))
                .enterPassword(PropertiesReader.readKey("sauceValidPassword"))
                .clickLoginButton();

        LOGGER.info("User navigate to the Product to see the Details");

        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage
                .clickProductDetails()
                .navigateToProductPage();

        LOGGER.info("User successfully navigates to the Product Page");

    }

    @Test(priority = 5)
    @Description("TC#5 : Verify that User is able to click Remove Button on Product")
    @Owner("Avinash Sinha")
    @Story("Positive - Click Remove Button on Product")
    public void testClickRemoveButton() {

        LOGGER.info("User use Valid Credentials for Login to the Page");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername(PropertiesReader.readKey("sauceValidUsername"))
                .enterPassword(PropertiesReader.readKey("sauceValidPassword"))
                .clickLoginButton();

        LOGGER.info("Open the Product Page and Search the Product");

        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage
                .searchProduct()
                .clickAddToCart()
                .clickRemoveFromCart();

        LOGGER.info("User successfully click on the Remove Button");

    }

}