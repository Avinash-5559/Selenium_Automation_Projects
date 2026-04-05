package com.avinashsinha.pages.amazon;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class HomePage extends BasePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private static final By SEARCH_BAR = By.xpath("//input[@aria-label='Search Amazon.in']");
    private static final By SEARCH_BUTTON = By.xpath("//input[@type='submit']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void amazonHomePage() {

        openAmazonUrl();

        String expectedUrl = PropertiesReader.readKey("expectedAmazonUrl");
        String actualUrl = PropertiesReader.readKey("actualAmazonUrl");

        WaitHelpers.waitForElementToBeClickable(driver, SEARCH_BAR);

        if (expectedUrl.equals(actualUrl)) {
            enterInput(SEARCH_BAR, PropertiesReader.readKey("searchOnAmazon"));
            clickElement(SEARCH_BUTTON);
        } else {
            System.out.println("\nAmazon Home Page Not Found.\n");
            WaitHelpers.visibilityOfElement(driver.findElement(By.xpath("//label[@id='searchDropdownDescription']")));
        }

    }

}