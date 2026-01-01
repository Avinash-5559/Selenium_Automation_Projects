package com.avinashsinha.pages.flipkart;

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
    private By crossButton = By.xpath("//span[@role='button']");
    private By searchBar = By.xpath("//input[@type='text']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void flipkartHomePage() {

        openFlipkartUrl();

        //clickElement(crossButton);

        String expectedUrl = PropertiesReader.readKey("expectedFlipkartUrl");
        String actualUrl = PropertiesReader.readKey("actualFlipkartUrl");

        WaitHelpers.waitForElementToBeClickable(driver, searchBar);

        if (expectedUrl.equals(actualUrl)) {
            enterInput(searchBar, PropertiesReader.readKey("searchOnFlipkart"));
            pressEnter(searchBar);
        } else {
            System.out.println("\nFlipkart Home Page is Not Found\n");
            WaitHelpers.visibilityOfElement(driver.findElement(By.xpath("//span[text()='Filters']")));
        }

    }

}