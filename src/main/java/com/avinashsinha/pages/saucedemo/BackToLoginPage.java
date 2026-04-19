package com.avinashsinha.pages.saucedemo;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class BackToLoginPage extends BasePage {

    WebDriver driver;

    public BackToLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private final static By LOGOUT_BUTTON = By.id("logout_sidebar_link");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public BackToLoginPage clickLogoutButton() {

        String expectedLoginButtonText = PropertiesReader.readKey("expectedLoginButtonText");
        String actualLoginButtonText = PropertiesReader.readKey("actualLoginButtonText");

        if (expectedLoginButtonText.equals(actualLoginButtonText)) {

            WaitHelpers.checkVisibility(driver, LOGOUT_BUTTON);
            clickElement(LOGOUT_BUTTON);

        } else {

            System.out.println("\nUser is not Redirect to the Login Page\n");
            WaitHelpers.presenceOfElement(driver, By.id("sauce-demo-id"));

        }

        return this;

    }

}