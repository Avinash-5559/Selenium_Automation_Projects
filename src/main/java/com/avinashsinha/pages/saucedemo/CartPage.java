package com.avinashsinha.pages.saucedemo;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.WaitHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

//This is Page Class
public class CartPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(CartPage.class);

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private final static By CHECKOUT_BUTTON = By.id("checkout");
    private final static By PRODUCT_PRESENT = By.cssSelector(".inventory_item_name");
    private final static By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    private final static By REMOVE_BUTTON = By.cssSelector(".cart_button");
    private static final By SAUCE_DEMO_FALLBACK = By.id("sauce-demo-id");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public CartPage clickCheckoutButton() {

        boolean isCheckoutButtonPresent = WaitHelpers.isElementPresent(driver, CHECKOUT_BUTTON);

        if (isCheckoutButtonPresent) {

            LOGGER.info("Checkout button found. Proceeding to checkout.");
            clickElement(CHECKOUT_BUTTON);

        } else {

            LOGGER.error("Cart Page Failed: Product not listed, checkout button not found.");
            WaitHelpers.presenceOfElement(driver, SAUCE_DEMO_FALLBACK);

        }

        return this;

    }

    private boolean lastProductPresentResult;

    public CartPage isProductPresent() {

        boolean isPresent = WaitHelpers.isElementPresent(driver, PRODUCT_PRESENT);
        this.lastProductPresentResult = isPresent;

        if (isPresent) {
            LOGGER.info("Product confirmed present in cart.");
        } else {
            LOGGER.error("Cart Page Failed: Product not present in cart.");
        }

        return this;

    }

    public boolean isProductPresentResult() {
        return lastProductPresentResult;
    }

    public CartPage clickContinueShoppingButton() {

        boolean isPresent = WaitHelpers.isElementPresent(driver, CONTINUE_SHOPPING_BUTTON);

        if (isPresent) {
            LOGGER.info("Continue Shopping button found. Navigating back to Products Page.");
            clickElement(CONTINUE_SHOPPING_BUTTON);
        } else {
            LOGGER.error("Cart Page Failed: Continue Shopping button not found.");
        }

        return this;

    }

    public CartPage clickRemoveFromCartButton() {

        boolean isPresent = WaitHelpers.isElementPresent(driver, REMOVE_BUTTON);

        if (isPresent) {
            LOGGER.info("Remove button found. Removing product from cart.");
            clickElement(REMOVE_BUTTON);
        } else {
            LOGGER.error("Cart Page Failed: Remove button not found.");
        }

        return this;

    }

    private boolean lastCartEmptyResult;

    public boolean isCartEmptyResult() {
        return lastCartEmptyResult;
    }

    public CartPage isCartEmpty() {

        List<WebElement> productPresented = driver.findElements(PRODUCT_PRESENT);

        boolean isEmpty = productPresented.isEmpty();
        this.lastCartEmptyResult = isEmpty;

        if (productPresented.isEmpty()) {
            LOGGER.info("Cart Page confirmed empty.");
        } else {
            LOGGER.error("Cart Page Failed: Expected empty cart, but {} product(s) found.", productPresented.size());
        }

        return this;

    }

}