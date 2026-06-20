package com.avinashsinha.pages.saucedemo;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.WaitHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class BackToProductsPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(BackToProductsPage.class);

    WebDriver driver;

    public BackToProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private final static By MENU_BUTTON = By.id("react-burger-menu-btn");
    private static final By SAUCE_DEMO_FALLBACK = By.id("sauce-demo-id");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public BackToProductsPage clickOnMenuButton() {

        boolean isMenuButtonPresent = WaitHelpers.isElementPresent(driver, MENU_BUTTON);

        if (isMenuButtonPresent) {

            LOGGER.info("Menu button found. Clicking to navigate.");
            clickElement(MENU_BUTTON);

        } else {

            LOGGER.error("User was not redirected to the Products Page: Menu button not found.");
            WaitHelpers.presenceOfElement(driver, SAUCE_DEMO_FALLBACK);

        }

        return this;

    }

}