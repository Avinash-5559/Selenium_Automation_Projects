package com.avinashsinha.pages.saucedemo;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//This is Page Class
public class ConfirmationPage extends BasePage {

    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private final static By BACK_HOME_BUTTON = By.id("back-to-products");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public ConfirmationPage placedOrderConfirmed() {

        String expectedCompletePageTitle = PropertiesReader.readKey("expectedCompletePageTitle");
        String actualCompletePageTitle = PropertiesReader.readKey("actualCompletePageTitle");

        if (expectedCompletePageTitle.equals(actualCompletePageTitle)) {

            File sourceFolder = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));

            File screenshotDir = new File("screenshots");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdir();
            }

            File destinationFolder = new File(screenshotDir, "ConfirmationPage_" + timeStamp + ".png");

            try {
                FileHandler.copy(sourceFolder, destinationFolder);
            } catch (IOException e) {
                throw new RuntimeException("Failed to save screenshot", e);
            }

            clickElement(BACK_HOME_BUTTON);

        } else {

            System.out.println("\nOrder is not Placed and Dispatched\n");
            WaitHelpers.presenceOfElement(driver, By.id("sauce-demo-id"));

        }

        return this;

    }

}