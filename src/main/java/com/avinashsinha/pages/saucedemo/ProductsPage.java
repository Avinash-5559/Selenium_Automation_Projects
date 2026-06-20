package com.avinashsinha.pages.saucedemo;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.WaitHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//This is Page Class
public class ProductsPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(ProductsPage.class);

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private static final By PRODUCT = By.xpath("//div[text()='Sauce Labs Fleece Jacket']");
    private static final By ADD_TO_CART_BUTTON = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private static final By CART_BUTTON = By.id("shopping_cart_container");
    private static final By CART_HEADER = By.xpath("//span[text()='Your Cart']");
    private static final By LOW_TO_HIGH_SORT = By.xpath("//select[@class='product_sort_container']");
    private static final By PRODUCT_DETAILS = By.id("item_4_title_link");
    private static final By BACK_TO_PRODUCTS_BUTTON = By.id("back-to-products");
    private static final By REMOVE_BUTTON = By.id("remove-sauce-labs-fleece-jacket");
    private static final By SAUCE_DEMO_FALLBACK = By.id("sauce-demo-id");

    private boolean lastSearchResult;

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public ProductsPage searchProduct() {

        boolean isProductPresent = WaitHelpers.isElementPresent(driver, PRODUCT);
        this.lastSearchResult = isProductPresent;

        if (isProductPresent) {
            LOGGER.info("Product found on Products Page.");
        } else {
            LOGGER.error("Product is not Listed on the Products Page.");
            WaitHelpers.visibilityOfElement(driver, SAUCE_DEMO_FALLBACK);
        }

        return this;

    }

    public boolean isProductSearchResult() {
        return lastSearchResult;
    }

    public ProductsPage clickAddToCart() {

        WaitHelpers.presenceOfElement(driver, ADD_TO_CART_BUTTON);
        LOGGER.info("Adding product to cart.");
        clickElement(ADD_TO_CART_BUTTON);
        return this;

    }

    public ProductsPage clickCart() {

        clickElement(CART_BUTTON);
        boolean isCartPagePresent = WaitHelpers.isElementPresent(driver, CART_HEADER);

        if (isCartPagePresent) {
            LOGGER.info("Navigated to Cart Page.");
        } else {
            LOGGER.error("Failed to navigate to Cart Page.");
        }

        return this;

    }

    public ProductsPage sortLowToHigh() {

        WaitHelpers.presenceOfElement(driver, LOW_TO_HIGH_SORT);
        WebElement dropDown = driver.findElement(LOW_TO_HIGH_SORT);
        Select select = new Select(dropDown);
        select.selectByValue("lohi");
        LOGGER.info("Sorted products Low to High.");

        return this;

    }

    public ProductsPage clickProductDetails() {

        WaitHelpers.presenceOfElement(driver, PRODUCT_DETAILS);
        LOGGER.info("Opening product details.");
        return this;

    }

    public ProductsPage navigateToProductPage() {

        LOGGER.info("Navigating back to Products Page.");
        clickElement(BACK_TO_PRODUCTS_BUTTON);
        return this;

    }

    public ProductsPage clickRemoveFromCart() {

        WaitHelpers.presenceOfElement(driver, REMOVE_BUTTON);
        LOGGER.info("Removing product from cart.");
        return this;

    }

}