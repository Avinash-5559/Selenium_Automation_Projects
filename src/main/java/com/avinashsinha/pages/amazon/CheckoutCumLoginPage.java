package com.avinashsinha.pages.amazon;

import com.avinashsinha.base.CommonToAllPage;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class CheckoutCumLoginPage extends CommonToAllPage {

    WebDriver driver;

    public CheckoutCumLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private By continueButton = By.xpath("//span[@id='continue-announce']");
    private By searchText = By.xpath("//label[@for='twotabsearchtextbox']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void checkOutCumLogin() {

        String expectedButtonText = PropertiesReader.readKey("expectedAmazonButtonText");
        String actualButtonText = PropertiesReader.readKey("actualAmazonButtonText");

        WaitHelpers.presenceOfElement(driver, continueButton);

        if (expectedButtonText.equals(actualButtonText)) {
            System.out.println("\nWhole WebPages are Passed\n");
        } else {
            System.out.println("\nAmazon Checkout Page is Failed\n");
            WaitHelpers.visibilityOfElement(searchText);
        }

    }

}