package com.avinashsinha.pages.amazon;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.WaitHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class CartPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(CartPage.class);

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private static final By ADD_TO_CART_TEXT = By.xpath("//h1[normalize-space()='Added to cart']");
    private static final By CLICK_PROCEED_TO_BUY = By.xpath("//input[@name='proceedToRetailCheckout']");
    private static final By SIGN_IN_TEXT = By.xpath("//h1[normalize-space()='Sign in or create account']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public boolean buyProduct() {

        boolean isAddedToCart = WaitHelpers.isElementPresent(driver, ADD_TO_CART_TEXT);

        if (isAddedToCart) {
            LOGGER.info("Product added to cart successfully. Proceeding to checkout.");
            clickElement(CLICK_PROCEED_TO_BUY);
        } else {
            LOGGER.error("Amazon Cart Page Failed: Product was not added to cart.");
            WaitHelpers.presenceOfElement(driver, SIGN_IN_TEXT);
        }

        return isAddedToCart;
    }

}