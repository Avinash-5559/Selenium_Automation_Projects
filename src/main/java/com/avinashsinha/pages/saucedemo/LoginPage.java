package com.avinashsinha.pages.saucedemo;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.WaitHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class LoginPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private static final By USERNAME_TEXT_FIELD = By.id("user-name");
    private static final By PASSWORD_TEXT_FIELD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By PRODUCTS_TEXT = By.xpath("//span[text()='Products']");
    private static final By ERROR_MESSAGE = By.cssSelector(".error-message-container");
    private static final By SAUCE_DEMO_FALLBACK = By.id("sauce-demo-id");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public LoginPage openSauceDemo() {

        openSauceDemoUrl();

        boolean isUsernameFieldPresent = WaitHelpers.isElementPresent(driver, USERNAME_TEXT_FIELD);

        if (isUsernameFieldPresent) {
            LOGGER.info("SauceDemo login page loaded successfully.");
        } else {
            LOGGER.error("Redirected to the wrong URL: Login page not loaded.");
            WaitHelpers.presenceOfElement(driver, SAUCE_DEMO_FALLBACK);
        }

        return this;

    }

    public LoginPage enterUsername(String usr) {
        LOGGER.info("Entering username: {}", usr);
        enterInput(USERNAME_TEXT_FIELD, usr);
        return this;
    }

    public LoginPage enterPassword(String pwd) {
        LOGGER.info("Entering password.");
        enterInput(PASSWORD_TEXT_FIELD, pwd);
        return this;
    }

    public LoginPage clickLoginButton() {

        clickElement(LOGIN_BUTTON);

        WaitHelpers.waitForEitherElement(PRODUCTS_TEXT, ERROR_MESSAGE);

        if (WaitHelpers.isElementPresent(driver, PRODUCTS_TEXT)) {
            LOGGER.info("Login PASSED. Products page loaded.");
        } else if (WaitHelpers.isElementPresent(driver, ERROR_MESSAGE)) {
            LOGGER.error("Login FAILED. Error message displayed.");
        } else {
            LOGGER.warn("Login result UNKNOWN STATE: neither Products page nor error message found.");
        }

        return this;

    }

    public boolean isLoginSuccessful() {
        return WaitHelpers.isElementPresent(driver, PRODUCTS_TEXT);
    }

}