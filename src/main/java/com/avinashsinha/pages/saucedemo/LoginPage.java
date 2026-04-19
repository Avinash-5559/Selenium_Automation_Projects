package com.avinashsinha.pages.saucedemo;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.driver.DriverManager;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class LoginPage extends BasePage {

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

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public LoginPage openSauceDemo() {

        String expectedUrl = PropertiesReader.readKey("expectedSauceDemoUrl");
        String actualUrl = PropertiesReader.readKey("actualSauceDemoUrl");

        if (expectedUrl.equals(actualUrl)) {

            openSauceDemoUrl();

        } else {

            System.out.println("\nRedirect to the Wrong URL\n");
            WaitHelpers.visibilityOfElement(driver.findElement(By.id("sauce-demo-id")));

        }

        return this;

    }

    public LoginPage enterUsername(String usr) {

        enterInput(USERNAME_TEXT_FIELD, usr);

        return this;

    }

    public LoginPage enterPassword(String pwd) {

        enterInput(PASSWORD_TEXT_FIELD, pwd);

        return this;

    }

    public LoginPage clickLoginButton() {

        clickElement(LOGIN_BUTTON);

        WaitHelpers.waitForEitherElement(PRODUCTS_TEXT, ERROR_MESSAGE);

        if (isElementPresent(PRODUCTS_TEXT)) {
            System.out.println("Login PASSED");
        } else if (isElementPresent(ERROR_MESSAGE)) {
            System.out.println("Login FAILED");
        } else {
            System.out.println("UNKNOWN STATE");
        }

        return this;

    }

    private boolean isElementPresent(By locator) {

        try {
            return DriverManager.getDriver().findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

}