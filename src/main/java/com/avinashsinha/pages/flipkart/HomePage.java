package com.avinashsinha.pages.flipkart;

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
    private static final By CROSS_BUTTON = By.xpath("//span[@role='button']");
    private static final By SEARCH_BAR = By.xpath("//input[@type='text']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void flipkartHomePage() {

        openFlipkartUrl();

        //clickElement(crossButton);

        String expectedUrl = PropertiesReader.readKey("expectedFlipkartUrl");
        String actualUrl = PropertiesReader.readKey("actualFlipkartUrl");

        WaitHelpers.waitForElementToBeClickable(driver, SEARCH_BAR);

        if (expectedUrl.equals(actualUrl)) {
            enterInput(SEARCH_BAR, PropertiesReader.readKey("searchOnFlipkart"));
            pressEnter(SEARCH_BAR);
        } else {
            System.out.println("\nFlipkart Home Page is Not Found\n");
            WaitHelpers.visibilityOfElement(driver.findElement(By.xpath("//span[text()='Filters']")));
        }

    }

}