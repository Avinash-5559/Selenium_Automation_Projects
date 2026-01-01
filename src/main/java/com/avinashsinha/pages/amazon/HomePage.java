package com.avinashsinha.pages.amazon;

import com.avinashsinha.base.CommonToAllPage;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class HomePage extends CommonToAllPage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private By searchBar = By.xpath("//input[@aria-label='Search Amazon.in']");
    private By searchButton = By.xpath("//input[@type='submit']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void amazonHomePage() {

        openAmazonUrl();

        String expectedUrl = PropertiesReader.readKey("expectedAmazonUrl");
        String actualUrl = PropertiesReader.readKey("actualAmazonUrl");

        WaitHelpers.waitForElementToBeClickable(driver, searchBar);

        if (expectedUrl.equals(actualUrl)) {
            enterInput(searchBar, PropertiesReader.readKey("searchOnAmazon"));
            clickElement(searchButton);
        } else {
            System.out.println("\nAmazon Home Page Not Found.\n");
            WaitHelpers.visibilityOfElement(driver.findElement(By.xpath("//label[@id='searchDropdownDescription']")));
        }

    }

}