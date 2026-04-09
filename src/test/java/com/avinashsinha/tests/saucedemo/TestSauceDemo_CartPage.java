package com.avinashsinha.tests.saucedemo;

import com.avinashsinha.base.BaseTest;
import com.avinashsinha.listeners.RetryAnalyzer;
import com.avinashsinha.listeners.ScreenshotListeners;
import com.avinashsinha.pages.saucedemo.CartPage;
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
public class TestSauceDemo_CartPage extends BaseTest {

    private final static Logger LOGGER = LogManager.getLogger(TestSauceDemo_CartPage.class);

    @Test(priority = 1)
    @Description("TC#1 : Verify that Product is present in the Cart Page")
    @Owner("Avinash Sinha")
    @Story("Positive - Product Present in Cart")
    public void testProductPresentInCart() {

        LOGGER.info("User is able to Login the WebPage");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername(PropertiesReader.readKey("sauceValidUsername"))
                .enterPassword(PropertiesReader.readKey("sauceValidPassword"))
                .clickLoginButton();

        LOGGER.info("Login to the Product Page");

        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage
                .searchProduct()
                .clickAddToCart()
                .clickCart();

        LOGGER.info("Product is now move to the Cart Page");

        CartPage cartPage = new CartPage(getDriver());
        cartPage
                .isProductPresent();

        LOGGER.info("Product is present on the Cart Page");

    }

    @Test(priority = 2)
    @Description("TC#2 : Verify that Product is move to the Checkout Page")
    @Owner("Avinash Sinha")
    @Story("Positive - Move to the Checkout Page")
    public void testProductMoveToCheckout() {

        LOGGER.info("User is able to Login Valid Credentials");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername(PropertiesReader.readKey("sauceValidUsername"))
                .enterPassword(PropertiesReader.readKey("sauceValidPassword"))
                .clickLoginButton();

        LOGGER.info("All products are listed on the Product Page");

        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage
                .searchProduct()
                .clickAddToCart()
                .clickCart();

        LOGGER.info("Product now move to the Cart Page");

        CartPage cartPage = new CartPage(getDriver());
        cartPage
                .isProductPresent();

        cartPage
                .clickCheckoutButtton();

        LOGGER.info("Product is now move to the Checkout Page");

    }

    @Test(priority = 3)
    @Description("TC#3 : Verify that move to the Cart Page and again back to Product Page")
    @Owner("Avinash Sinha")
    @Story("Positive - Again back to Product Page")
    public void testBackToProductPage() {

        LOGGER.info("User Login with Valid Credentials");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername(PropertiesReader.readKey("sauceValidUsername"))
                .enterPassword(PropertiesReader.readKey("sauceValidPassword"))
                .clickLoginButton();

        LOGGER.info("All products are shown on the Product Page");

        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage
                .searchProduct()
                .clickAddToCart()
                .clickCart();

        LOGGER.info("Selected Product now move to the Cart");

        CartPage cartPage = new CartPage(getDriver());
        cartPage
                .isProductPresent();

        cartPage
                .clickContinueShoppingButton();

        LOGGER.info("User can move to the Product Page Again");

    }

    @Test(priority = 4)
    @Description("TC#4 : Verify that user Remove the Product from the Cart Page")
    @Owner("Avinash Sinha")
    @Story("Negative - Remove the Product")
    public void testRemoveProductCartPage() {

        LOGGER.info("User can Login with Valid Credentials");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername(PropertiesReader.readKey("sauceValidUsername"))
                .enterPassword(PropertiesReader.readKey("sauceValidPassword"))
                .clickLoginButton();

        LOGGER.info("All the products are shown on the Product Page");

        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage
                .searchProduct()
                .clickAddToCart()
                .clickCart();

        LOGGER.info("Selected Product, remove from the Cart Page");

        CartPage cartPage = new CartPage(getDriver());
        cartPage
                .isProductPresent();

        cartPage
                .clickRemoveFromCartButton();

        LOGGER.info("User successfully remove the Product from Cart Page");

    }

    @Test(priority = 5)
    @Description("TC#5 : Verify that Cart Page is in Empty State")
    @Owner("Avinash Sinha")
    @Story("Negative - Cart Page is Empty")
    public void testEmptyCartPage() {

        LOGGER.info("User can be able to Login with Valid Credentials");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername(PropertiesReader.readKey("sauceValidUsername"))
                .enterPassword(PropertiesReader.readKey("sauceValidPassword"))
                .clickLoginButton();

        LOGGER.info("All the products are listed on the Product Page");

        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage
                .searchProduct()
                .clickCart();

        LOGGER.info("Empty state of the Cart Page");

        CartPage cartPage = new CartPage(getDriver());
        cartPage
                .isCartEmpty();

        LOGGER.info("Cart Page is fully Empty");

    }

}