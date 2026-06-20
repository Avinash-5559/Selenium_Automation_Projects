package com.avinashsinha.pages.flipkart;

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
    private static final By CROSS_BUTTON = By.xpath("//span[@role='button']");
    private static final By SEARCH_BAR = By.xpath("//input[@type='text']");
    private static final By FILTERS = By.xpath("//span[text()='Filters']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public boolean flipkartHomePage() {

        openFlipkartUrl();

        if (WaitHelpers.isElementPresent(driver, CROSS_BUTTON)) {
            clickElement(CROSS_BUTTON);
            LOGGER.info("Dismissed Flipkart login popup.");
        }

        boolean isSearchBarClickable = WaitHelpers.waitForElementToBeClickable(driver, SEARCH_BAR);

        if (isSearchBarClickable) {
            LOGGER.info("Search bar is clickable. Searching for product.");
            enterInput(SEARCH_BAR, PropertiesReader.readKey("searchOnFlipkart"));
            pressEnter(SEARCH_BAR);
        } else {
            LOGGER.error("Flipkart Home Page Failed: Search bar not clickable.");
            WaitHelpers.visibilityOfElement(driver, FILTERS);
        }
        return isSearchBarClickable;

    }

}