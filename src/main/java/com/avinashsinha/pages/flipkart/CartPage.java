package com.avinashsinha.pages.flipkart;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class CartPage extends BasePage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private static final By HEADER_CART_BUTTON = By.xpath("//a[@title='Cart']");
    private static final By QUANTITY_BUTTON = By.xpath("//div[@class='css-g5y9jx r-13awgt0 r-18u37iz r-15ysp7h r-1awozwy r-1777fci']");
    private static final By SELECT_QUANTITY = By.xpath("(//div[@class='css-146c3p1 r-op4f77 r-1et8rh5 r-1b43r93'])[1]");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void buyProduct() {

        String expectedText = PropertiesReader.readKey("expectedFlipkartText");
        String actualText = PropertiesReader.readKey("actualFlipkartText");

        if (expectedText.equals(actualText)) {

            clickElement(HEADER_CART_BUTTON);
            WaitHelpers.waitJVM(1500);

            clickElement(QUANTITY_BUTTON);
            WaitHelpers.waitJVM(1500);

            clickElement(SELECT_QUANTITY);
            WaitHelpers.waitJVM(1500);

        } else {
            System.out.println("\nFlipkart Cart Page is Failed.\n");
            WaitHelpers.visibilityOfElement(driver.findElement(By.xpath("//h3[.//span[normalize-space()='Login or Signup']]")));
        }

    }
}