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
    private By loggedMessage = By.xpath("//h1[contains(text(),'Logged In Successfully')]");
    private By congratulationMessage = By.xpath("//p//strong[contains(text(),'Congratulations student. You successfully logged in!')]");
    private By logout = By.xpath("//a[text()='Log out']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void openDashboardPage() {

        System.out.println("\nDashboard Page URL     : " + driver.getCurrentUrl());

        WaitHelpers.checkVisibilityOfAndTextToBePresentInElement(driver, driver.findElement(loggedMessage));

        String loggedMessageText = driver.findElement(loggedMessage).getText();
        System.out.println("\nLogged Message         : " + loggedMessageText);

        WaitHelpers.checkVisibilityOfAndTextToBePresentInElement(driver, driver.findElement(congratulationMessage));

        String congratulationMessageText = driver.findElement(congratulationMessage).getText();
        System.out.println("\nCongratulation Message : " + congratulationMessageText + "\n");

        WaitHelpers.presenceOfElement(logout);

        clickElement(logout);

    }

    public void clickLogoutButton(){

        WaitHelpers.presenceOfElement(logout);

        clickElement(logout);

    }



}