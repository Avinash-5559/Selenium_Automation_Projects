package com.avinashsinha.pages.saucedemo;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.WaitHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class InformationPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(InformationPage.class);

    WebDriver driver;

    public InformationPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private final static By FIRST_NAME_TEXT_FIELD = By.id("first-name");
    private final static By LAST_NAME_TEXT_FIELD = By.id("last-name");
    private final static By POSTAL_CODE_TEXT_FIELD = By.id("postal-code");
    private final static By CONTINUE_BUTTON = By.id("continue");
    private final static By CANCEL_BUTTON = By.id("cancel");
    private final static By ERROR_MESSAGE = By.cssSelector(".error-message-container");
    private static final By SAUCE_DEMO_FALLBACK = By.id("sauce-demo-id");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public InformationPage fillUserFormDetails() {

        boolean isFormVisible = WaitHelpers.isElementPresent(driver, FIRST_NAME_TEXT_FIELD);

        if (isFormVisible) {

            LOGGER.info("Information Page loaded. Ready to fill user details.");

        } else {

            LOGGER.error("Information Page Failed: Form is not available to fill.");
            WaitHelpers.presenceOfElement(driver, SAUCE_DEMO_FALLBACK);

        }

        return this;

    }

    public InformationPage enterFirstName(String firstName) {

        LOGGER.info("Entering first name: {}", firstName);
        enterInput(FIRST_NAME_TEXT_FIELD, firstName);
        return this;

    }

    public InformationPage enterLastName(String lastName) {

        LOGGER.info("Entering last name: {}", lastName);
        enterInput(LAST_NAME_TEXT_FIELD, lastName);
        return this;

    }

    public InformationPage enterPostalCode(String postalCode) {

        LOGGER.info("Entering postal code: {}", postalCode);
        enterInput(POSTAL_CODE_TEXT_FIELD, postalCode);
        return this;

    }

    public InformationPage clickContinue() {

        LOGGER.info("Clicking Continue button.");
        clickElement(CONTINUE_BUTTON);
        return this;

    }

    private boolean lastErrorMessageVisible;

    public InformationPage seeErrorMessage() {

        boolean isErrorVisible = WaitHelpers.isElementPresent(driver, ERROR_MESSAGE);
        this.lastErrorMessageVisible = isErrorVisible;

        if (isErrorVisible) {
            LOGGER.info("Error message displayed as expected.");
        } else {
            LOGGER.error("Information Page Failed: Expected error message not shown.");
        }
        return this;

    }

    public boolean isErrorMessageVisible() {
        return lastErrorMessageVisible;
    }

    public InformationPage cancelOrder() {

        LOGGER.info("Clicking Cancel button.");
        clickElement(CANCEL_BUTTON);
        return this;

    }

}