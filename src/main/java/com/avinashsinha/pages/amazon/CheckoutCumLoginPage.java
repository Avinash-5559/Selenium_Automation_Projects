package com.avinashsinha.pages.amazon;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.WaitHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class CheckoutCumLoginPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(CheckoutCumLoginPage.class);

    WebDriver driver;

    public CheckoutCumLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private static final By CONTINUE_BUTTON = By.xpath("//span[@id='continue-announce']");
    private static final By SEARCH_TEXT = By.xpath("//label[@for='twotabsearchtextbox']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public boolean checkOutCumLogin() {

        boolean isContinueButtonPresent = WaitHelpers.isElementPresent(driver, CONTINUE_BUTTON);

        if (isContinueButtonPresent) {
            LOGGER.info("Checkout flow proceeded successfully. Whole webpage flow passed.");
        } else {
            LOGGER.info("Amazon Checkout Page Failed: Continue button not found.");
            WaitHelpers.visibilityOfElement(driver, SEARCH_TEXT);
        }

        return isContinueButtonPresent;
    }

}