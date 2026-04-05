package com.avinashsinha.pages.flipkart;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//This is Page Class
public class CheckoutCumLoginPage extends BasePage {

    WebDriver driver;

    public CheckoutCumLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private static final By PLACE_ORDER_BUTTON = By.xpath("//div[contains(text(),'Place Order')]");
    private static final By CONTINUE_BUTTON = By.xpath("//button[contains(text(),'Continue')]");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void checkOutCumLogin() {

        String expectedButtonText = PropertiesReader.readKey("expectedFlipkartButtonText");
        String actualButtonText = PropertiesReader.readKey("actualFlipkartButtonText");

        WebElement placeOrderButton = WaitHelpers.checkVisibility(PLACE_ORDER_BUTTON);
        clickElement(placeOrderButton);

        WaitHelpers.checkVisibility(CONTINUE_BUTTON);

        if (expectedButtonText.equals(actualButtonText)) {
            System.out.println("\nWhole WebPages are Passed\n");
        } else {
            System.out.println("\nFlipkart Checkout Page is Failed\n");
            WaitHelpers.visibilityOfElement(CONTINUE_BUTTON);
        }

    }

}