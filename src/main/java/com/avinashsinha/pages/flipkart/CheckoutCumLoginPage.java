package com.avinashsinha.pages.flipkart;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.WaitHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//This is Page Class
public class CheckoutCumLoginPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(CheckoutCumLoginPage.class);

    WebDriver driver;

    public CheckoutCumLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private static final By PLACE_ORDER_BUTTON = By.xpath("//div[contains(text(),'Place Order')]");
    private static final By CONTINUE_BUTTON = By.xpath("//button[contains(text(),'Continue')]");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public boolean checkOutCumLogin() {

        boolean isPlaceOrderButtonPresent = WaitHelpers.isElementPresent(driver, PLACE_ORDER_BUTTON);

        if (isPlaceOrderButtonPresent) {

            clickElement(PLACE_ORDER_BUTTON);
            WaitHelpers.checkVisibility(CONTINUE_BUTTON);
            LOGGER.info("Checkout flow proceeded successfully. Whole webpage flow passed.");

        } else {

            LOGGER.info("Flipkart Checkout Page Failed: Continue button not found.");
            WaitHelpers.visibilityOfElement(driver, CONTINUE_BUTTON);

        }

        return isPlaceOrderButtonPresent;

    }

}