package com.avinashsinha.tests.saucedemo;

import com.avinashsinha.base.BaseTest;
import com.avinashsinha.listeners.RetryAnalyzer;
import com.avinashsinha.listeners.ScreenshotListeners;
import com.avinashsinha.pages.saucedemo.LoginPage;
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
public class TestSauceDemo_LoginPage extends BaseTest {

    private final static Logger LOGGER = LogManager.getLogger(TestSauceDemo_LoginPage.class);

    @Test(priority = 1)
    @Description("TC#1 : Verify that User able to Successfully Login with Valid Credentials")
    @Owner("Avinash Sinha")
    @Story("Positive - Valid Login")
    public void testWithValidLoginCredentials() {

        LOGGER.info("Start with the Valid Credentials for test the Login Page");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername(PropertiesReader.readKey("sauceValidUsername"))
                .enterPassword(PropertiesReader.readKey("sauceValidPassword"))
                .clickLoginButton();

        LOGGER.info("Valid Login Test Successful Completed");

    }

    @Test(priority = 2)
    @Description("TC#2 : Verify that User enter the Username and click on Login Button")
    @Owner("Avinash Sinha")
    @Story("Negative - Invalid Login")
    public void testWithUsernameOnly() {

        LOGGER.info("Enter the Username and click on Login Button");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername(PropertiesReader.readKey("sauceValidUsername"))
                .enterPassword("")
                .clickLoginButton();

        LOGGER.info("Invalid Login with Username only Test Completed");

    }

    @Test(priority = 3)
    @Description("TC#3 : Verify that User enter the Password and click on Login Button")
    @Owner("Avinash Sinha")
    @Story("Negative - Invalid Login")
    public void testWithPasswordOnly() {

        LOGGER.info("Enter the Password and click on Login Button");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername("")
                .enterPassword(PropertiesReader.readKey("sauceValidPassword"))
                .clickLoginButton();

        LOGGER.info("Invalid Login with Password only Test Completed");

    }

    @Test(priority = 4)
    @Description("TC#4 : Verify that User not able to Login with Invalid Credentials")
    @Owner("Avinash Sinha")
    @Story("Negative - Invalid Login")
    public void testWithInvalidLoginCredentials() {

        LOGGER.info("Start with the Invalid Credentials for test the Login Page");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername(PropertiesReader.readKey("sauceInvalidUsername"))
                .enterPassword(PropertiesReader.readKey("sauceInvalidPassword"))
                .clickLoginButton();

        LOGGER.info("Invalid Login Test Successful Completed");

    }

    @Test(priority = 5)
    @Description("TC#5 : Verify that User not enter any Credentials")
    @Owner("Avinash Sinha")
    @Story("Negative - Invalid Login")
    public void testWithBlankCredentials() {

        LOGGER.info("Start with the Blank Credentials for test the Login Page");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername("")
                .enterPassword("")
                .clickLoginButton();

        LOGGER.info("Test with Blank Credentials Completed");

    }

}
