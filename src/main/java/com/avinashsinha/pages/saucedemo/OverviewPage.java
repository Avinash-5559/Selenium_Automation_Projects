package com.avinashsinha.pages.saucedemo;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.WaitHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
public class OverviewPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(OverviewPage.class);

    WebDriver driver;

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private final static By FINISH_BUTTON = By.id("finish");
    private static final By OVERVIEW_HEADER = By.cssSelector(".title");
    private static final By SAUCE_DEMO_FALLBACK = By.id("sauce-demo-id");

    private boolean lastOrderConfirmedResult;

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public OverviewPage checkOrderDetails() {

        boolean isOverviewPagePresent = WaitHelpers.isElementPresent(driver, OVERVIEW_HEADER);
        this.lastOrderConfirmedResult = isOverviewPagePresent;

        if (isOverviewPagePresent) {

            LOGGER.info("Overview Page loaded. Capturing screenshot.");

            File sourceFolder = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));

            File screenshotDir = new File("screenshots");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdir();
            }

            File destinationFolder = new File(screenshotDir, "OverviewPage_" + timeStamp + ".png");

            try {
                FileHandler.copy(sourceFolder, destinationFolder);
            } catch (IOException e) {
                throw new RuntimeException("Failed to save screenshot", e);
            }

            clickElement(FINISH_BUTTON);

        } else {

            LOGGER.error("Order is not Confirmed: Overview Page not loaded.");
            WaitHelpers.presenceOfElement(driver, SAUCE_DEMO_FALLBACK);

        }

        return this;

    }

    public boolean isOrderConfirmedResult() {
        return lastOrderConfirmedResult;
    }

}