package com.avinashsinha.pages.saucedemo;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.WaitHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class BackToLoginPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(BackToLoginPage.class);

    WebDriver driver;

    public BackToLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private final static By LOGOUT_BUTTON = By.id("logout_sidebar_link");
    private static final By SAUCE_DEMO_FALLBACK = By.id("sauce-demo-id");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public BackToLoginPage clickLogoutButton() {

        boolean isLogoutButtonPresent = WaitHelpers.isElementPresent(driver, LOGOUT_BUTTON);

        if (isLogoutButtonPresent) {

            LOGGER.info("Logout button found. Clicking to log out.");
            clickElement(LOGOUT_BUTTON);

        } else {

            LOGGER.error("User was not redirected to the Login Page: Logout button not found.");
            WaitHelpers.presenceOfElement(driver, SAUCE_DEMO_FALLBACK);

        }

        return this;

    }

}