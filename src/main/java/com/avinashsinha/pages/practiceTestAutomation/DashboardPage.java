package com.avinashsinha.pages.practiceTestAutomation;

import com.avinashsinha.base.CommonToAllPage;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class DashboardPage extends CommonToAllPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private static final By LOGGED_MESSAGE = By.xpath("//h1[contains(text(),'Logged In Successfully')]");
    private static final By CONGRATULATION_MESSAGE = By.xpath("//p//strong[contains(text(),'Congratulations student. You successfully logged in!')]");
    private static final By LOGOUT = By.xpath("//a[text()='Log out']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void openDashboardPage() {

        System.out.println("\nDashboard Page URL     : " + driver.getCurrentUrl());

        WaitHelpers.checkVisibilityOfAndTextToBePresentInElement(driver, driver.findElement(LOGGED_MESSAGE));

        String loggedMessageText = driver.findElement(LOGGED_MESSAGE).getText();
        System.out.println("\nLogged Message         : " + loggedMessageText);

        WaitHelpers.checkVisibilityOfAndTextToBePresentInElement(driver, driver.findElement(CONGRATULATION_MESSAGE));

        String congratulationMessageText = driver.findElement(CONGRATULATION_MESSAGE).getText();
        System.out.println("\nCongratulation Message : " + congratulationMessageText + "\n");

        WaitHelpers.presenceOfElement(LOGOUT);

        clickElement(LOGOUT);

    }

    public void clickLogoutButton(){

        WaitHelpers.presenceOfElement(LOGOUT);

        clickElement(LOGOUT);

    }

}