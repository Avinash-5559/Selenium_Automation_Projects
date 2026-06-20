package com.avinashsinha.pages.practiceTestAutomation;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.WaitHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//This is Page Class
public class DashboardPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(DashboardPage.class);

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private static final By LOGGED_MESSAGE = By.xpath("//h1[contains(text(),'Logged In Successfully')]");
    private static final By CONGRATULATION_MESSAGE = By.xpath("//p//strong[contains(text(),'Congratulations student. You successfully logged in!')]");
    private static final By LOGOUT = By.xpath("//a[text()='Log out']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public boolean verifyDashboardPage() {

        LOGGER.info("Dashboard Page URL: {}", driver.getCurrentUrl());

        boolean isLoggedMessagePresent = WaitHelpers.isElementPresent(driver, LOGGED_MESSAGE);
        boolean isCongratsMessagePresent = WaitHelpers.isElementPresent(driver, CONGRATULATION_MESSAGE);

        if (isLoggedMessagePresent) {
            WebElement loggedMessageElement = driver.findElement(LOGGED_MESSAGE);
            WaitHelpers.checkVisibilityOfAndTextToBePresentInElement(driver, loggedMessageElement);
            LOGGER.info("Logged Message: {}", loggedMessageElement.getText());
        }

        if (isCongratsMessagePresent) {
            WebElement congratsMessageElement = driver.findElement(CONGRATULATION_MESSAGE);
            WaitHelpers.checkVisibilityOfAndTextToBePresentInElement(driver, congratsMessageElement);
            LOGGER.info("Congratulation Message: {}", congratsMessageElement.getText());
        }

        boolean isDashboardVerified = isLoggedMessagePresent && isCongratsMessagePresent;

        if (!isDashboardVerified) {
            LOGGER.error("Dashboard Page Failed: Expected success messages not found.");
        }

        return isDashboardVerified;
    }

    public void clickLogoutButton() {
        WaitHelpers.presenceOfElement(driver, LOGOUT);
        clickElement(LOGOUT);
        LOGGER.info("Logged out successfully.");
    }

}