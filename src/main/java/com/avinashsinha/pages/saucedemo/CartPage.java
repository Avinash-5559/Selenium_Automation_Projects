package com.avinashsinha.pages.saucedemo;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

//This is Page Class
public class CartPage extends BasePage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private final static By CHECKOUT_BUTTON = By.id("checkout");
    private final static By PRODUCT_PRESENT = By.cssSelector(".inventory_item_name");
    private final static By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    private final static By REMOVE_BUTTON = By.cssSelector(".cart_button");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public CartPage clickCheckoutButtton() {

        String expectedCartPageTitle = PropertiesReader.readKey("expectedCartPageTitle");
        String actualCartPageTitle = PropertiesReader.readKey("actualCartPageTitle");

        if (expectedCartPageTitle.equals(actualCartPageTitle)) {

            clickElement(CHECKOUT_BUTTON);

        } else {

            System.out.println("\nProduct is not Listed on the cart Page.\n");
            WaitHelpers.presenceOfElement(driver, By.id("sauce-demo-id"));

        }

        return this;

    }

    public boolean isProductPresent() {

        WebElement productPresented = driver.findElement(PRODUCT_PRESENT);

        try {
            if (productPresented.isDisplayed()) {
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return this.isProductPresent();

    }

    public CartPage clickContinueShoppingButton() {

        clickElement(CONTINUE_SHOPPING_BUTTON);

        return this;

    }

    public CartPage clickRemoveFromCartButton() {

        clickElement(REMOVE_BUTTON);
        return this;

    }

    public boolean isCartEmpty() {

        List<WebElement> productPresented = driver.findElements(PRODUCT_PRESENT);

        return productPresented.isEmpty();

    }

}