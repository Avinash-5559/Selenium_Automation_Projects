package com.avinashsinha.pages.saucedemo;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class BackToProductsPage extends BasePage {

    WebDriver driver;

    public BackToProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private final static By MENU_BUTTON = By.id("react-burger-menu-btn");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public BackToProductsPage clickOnMenuButton() {

        String expectedRedirectProductPageTitle = PropertiesReader.readKey("expectedRedirectProductPageTitle");
        String actualRedirectProductPageTitle = PropertiesReader.readKey("actualRedirectProductPageTitle");

        if (expectedRedirectProductPageTitle.equals(actualRedirectProductPageTitle)) {

            clickElement(MENU_BUTTON);

        } else {

            System.out.println("\nUser is not Redirect to the Products Page\n");
            WaitHelpers.presenceOfElement(driver, By.id("sauce-demo-id"));

        }

        return this;

    }

}