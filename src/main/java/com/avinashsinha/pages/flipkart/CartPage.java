package com.avinashsinha.pages.flipkart;

import com.avinashsinha.base.CommonToAllPage;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class CartPage extends CommonToAllPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private By placeOrder = By.xpath("//button[normalize-space()='Place Order']");
    private By plusButton = By.xpath("//button[text()='+']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void buyProduct() {

        String expectedText = PropertiesReader.readKey("expectedFlipkartText");
        String actualText = PropertiesReader.readKey("actualFlipkartText");

        if (expectedText.equals(actualText)) {

            for (int i = 0; i < 2; i++) {
                clickElement(plusButton);
                WaitHelpers.waitJVM(1500);
            }

            clickElement(placeOrder);
            WaitHelpers.waitJVM(1500);

        } else {
            System.out.println("\nFlipkart Cart Page is Failed.\n");
            WaitHelpers.visibilityOfElement(driver.findElement(By.xpath("//h3[.//span[normalize-space()='Login or Signup']]")));
        }

    }
}