package com.avinashsinha.pages.amazon;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.WaitHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class HomePage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private static final By SEARCH_BAR = By.xpath("//input[@aria-label='Search Amazon.in']");
    private static final By SEARCH_BUTTON = By.xpath("//input[@type='submit']");
    private static final By SEARCH_DROPDOWN = By.xpath("//label[@id='searchDropdownDescription']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public boolean amazonHomePage() {

        openAmazonUrl();

        boolean isSearchBarClickable = WaitHelpers.waitForElementToBeClickable(driver, SEARCH_BAR);

        if (isSearchBarClickable) {
            LOGGER.info("Search bar is clickable. Searching for product.");
            enterInput(SEARCH_BAR, PropertiesReader.readKey("searchOnAmazon"));
            clickElement(SEARCH_BUTTON);
        } else {
            LOGGER.info("Amazon Home Page Failed: Search bar not clickable.");
            WaitHelpers.visibilityOfElement(driver, SEARCH_DROPDOWN);
        }

        return isSearchBarClickable;

    }

}