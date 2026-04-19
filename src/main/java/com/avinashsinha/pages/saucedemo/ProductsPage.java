package com.avinashsinha.pages.saucedemo;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//This is Page Class
public class ProductsPage extends BasePage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private final static By PRODUCT = By.xpath("//div[text()='Sauce Labs Fleece Jacket']");
    private final static By ADD_TO_CART_BUTTON = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final static By CART_BUTTON = By.id("shopping_cart_container");
    private final static By LOW_TO_HIGH_SORT = By.xpath("//select[@class='product_sort_container']");
    private final static By PRODUCT_DETAILS = By.id("item_4_title_link");
    private final static By BACK_TO_PRODUCTS_BUTTON = By.id("back-to-products");
    private final static By REMOVE_BUTTON = By.id("remove-sauce-labs-fleece-jacket");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public ProductsPage searchProduct() {

        String expectedProductPageTitle = PropertiesReader.readKey("expectedProductPageTitle");
        String actualProductPageTitle = PropertiesReader.readKey("actualProductPageTitle");

        if (expectedProductPageTitle.equals(actualProductPageTitle)) {

            WaitHelpers.presenceOfElement(driver, PRODUCT);

        } else {

            System.out.println("\nProduct is not Listed on the product Page.\n");
            WaitHelpers.visibilityOfElement(driver.findElement(By.id("sauce-demo-id")));

        }

        return this;

    }

    public ProductsPage clickAddToCart() {

        clickElement(ADD_TO_CART_BUTTON);

        return this;

    }

    public ProductsPage clickCart() {

        clickElement(CART_BUTTON);

        WaitHelpers.presenceOfElement(driver, By.xpath("//span[text()='Your Cart']"));

        return this;

    }

    public ProductsPage sortLowToHigh() {

        WebElement dropDown = WaitHelpers.getElement(LOW_TO_HIGH_SORT);
        Select select = new Select(dropDown);
        select.selectByValue("lohi");

        return this;

    }

    public ProductsPage clickProductDetails() {

        clickElement(PRODUCT_DETAILS);
        return this;

    }

    public ProductsPage navigateToProductPage() {

        clickElement(BACK_TO_PRODUCTS_BUTTON);
        return this;

    }

    public ProductsPage clickRemoveFromCart() {

        clickElement(REMOVE_BUTTON);

        return this;

    }

}