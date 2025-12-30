package com.avinashsinha.pages.amazon;

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
    private By addToCartText = By.xpath("//h1[normalize-space()='Added to cart']");
    private By clickProceedToBuy = By.xpath("//input[@name='proceedToRetailCheckout']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void buyProduct() {

        if (PropertiesReader.readKey("cartText").matches("Added to cart")) {
            WaitHelpers.presenceOfElement(driver, addToCartText);
            clickElement(clickProceedToBuy);
        } else {
            System.out.println("Amazon Cart Page is Failed");
        }

    }

}