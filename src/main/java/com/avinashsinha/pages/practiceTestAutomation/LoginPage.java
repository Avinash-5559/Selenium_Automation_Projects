package com.avinashsinha.pages.practiceTestAutomation;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.WaitHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

//This is Page Class
public class LoginPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private static final By USERNAME = By.xpath("//input[@id='username']");
    private static final By PASSWORD = By.xpath("//input[@id='password']");
    private static final By SUBMIT = By.xpath("//button[@id='submit']");
    private static final By ERROR_USERNAME_MESSAGE = By.xpath("//div[contains(text(),'Your username is invalid!')]");
    private static final By ERROR_PASSWORD_MESSAGE = By.xpath("//div[contains(text(),'Your password is invalid!')]");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void openPracticeTestAutomation(String usr, String pwd) {

        LOGGER.info("Opening Practice Test Automation login page.");

        openPracticeTestAutomationUrl();

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.PAGE_DOWN)
                .build().perform();

        WaitHelpers.presenceOfElement(driver, USERNAME);
        enterInput(USERNAME, usr);

        WaitHelpers.presenceOfElement(driver, PASSWORD);
        enterInput(PASSWORD, pwd);

        WaitHelpers.presenceOfElement(driver, SUBMIT);
        clickElement(SUBMIT);

        LOGGER.info("Login submitted with username: {}", usr);

    }

    public void showInvalidUsernameMessage(String usr, String pwd) {

        LOGGER.info("Attempting login with invalid username: {}", usr);

        openPracticeTestAutomationUrl();

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.PAGE_DOWN)
                .build().perform();

        WaitHelpers.presenceOfElement(driver, USERNAME);
        enterInput(USERNAME, usr);

        WaitHelpers.presenceOfElement(driver, PASSWORD);
        enterInput(PASSWORD, pwd);

        WaitHelpers.presenceOfElement(driver, SUBMIT);
        clickElement(SUBMIT);

        WaitHelpers.presenceOfElement(driver, ERROR_USERNAME_MESSAGE);

        String errorUsernameMessageText = driver.findElement(ERROR_USERNAME_MESSAGE).getText();
        LOGGER.info("Error Message Shown when USER enter Invalid Username : {}", errorUsernameMessageText);

    }

    public void showInvalidPasswordMessage(String usr, String pwd) {

        LOGGER.info("Attempting login with invalid password.");

        openPracticeTestAutomationUrl();

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.PAGE_DOWN)
                .build().perform();

        WaitHelpers.presenceOfElement(driver, USERNAME);
        enterInput(USERNAME, usr);

        WaitHelpers.presenceOfElement(driver, PASSWORD);
        enterInput(PASSWORD, pwd);

        WaitHelpers.presenceOfElement(driver, SUBMIT);
        clickElement(SUBMIT);

        WaitHelpers.presenceOfElement(driver, ERROR_PASSWORD_MESSAGE);

        String errorPasswordMessageText = driver.findElement(ERROR_PASSWORD_MESSAGE).getText();
        LOGGER.info("Error Message Shown when USER enter Invalid Password : {}", errorPasswordMessageText);

    }

    public void goToTheLogoutButtonPage(String usr, String pwd) {

        LOGGER.info("Navigating to logout button page.");

        openPracticeTestAutomationUrl();

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.PAGE_DOWN)
                .build().perform();

        WaitHelpers.presenceOfElement(driver, USERNAME);
        enterInput(USERNAME, usr);

        WaitHelpers.presenceOfElement(driver, PASSWORD);
        enterInput(PASSWORD, pwd);

        WaitHelpers.presenceOfElement(driver, SUBMIT);
        clickElement(SUBMIT);

        LOGGER.info("Login submitted, ready for logout button page with username: {}", usr);

    }

}