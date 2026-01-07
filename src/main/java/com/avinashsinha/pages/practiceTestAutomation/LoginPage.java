package com.avinashsinha.pages.practiceTestAutomation;

import com.avinashsinha.base.CommonToAllPage;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

//This is Page Class
public class LoginPage extends CommonToAllPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private By username = By.xpath("//input[@id='username']");
    private By password = By.xpath("//input[@id='password']");
    private By submit = By.xpath("//button[@id='submit']");
    private By errorUsernameMessage = By.xpath("//div[contains(text(),'Your username is invalid!')]");
    private By errorPasswordMessage = By.xpath("//div[contains(text(),'Your password is invalid!')]");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void openPracticeTestAutomation(String usr, String pwd) {

        openPracticeTestAutomation();

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.PAGE_DOWN)
                .build().perform();

        WaitHelpers.presenceOfElement(driver, username);
        enterInput(username, usr);

        WaitHelpers.presenceOfElement(driver, password);
        enterInput(password, pwd);

        WaitHelpers.presenceOfElement(driver, submit);
        clickElement(submit);

    }

    public void showInvalidUsernameMessage(String usr, String pwd) {

        openPracticeTestAutomation();

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.PAGE_DOWN)
                .build().perform();

        WaitHelpers.presenceOfElement(driver, username);
        enterInput(username, usr);

        WaitHelpers.presenceOfElement(driver, password);
        enterInput(password, pwd);

        WaitHelpers.presenceOfElement(driver, submit);
        clickElement(submit);

        WaitHelpers.presenceOfElement(driver, errorUsernameMessage);

        String errorUsernameMessageText = driver.findElement(errorUsernameMessage).getText();
        System.out.println("\nError Message Shown when USER enter Invalid Username : " + errorUsernameMessageText + "\n");

    }

    public void showInvalidPasswordMessage(String usr, String pwd) {

        openPracticeTestAutomation();

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.PAGE_DOWN)
                .build().perform();

        WaitHelpers.presenceOfElement(driver, username);
        enterInput(username, usr);

        WaitHelpers.presenceOfElement(driver, password);
        enterInput(password, pwd);

        WaitHelpers.presenceOfElement(driver, submit);
        clickElement(submit);

        WaitHelpers.presenceOfElement(driver, errorPasswordMessage);

        String errorPasswordMessageText = driver.findElement(errorPasswordMessage).getText();
        System.out.println("\nError Message Shown when USER enter Invalid Password : " + errorPasswordMessageText + "\n");

    }

    public void goToTheLogoutButtonPage(String usr, String pwd) {

        openPracticeTestAutomation();

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.PAGE_DOWN)
                .build().perform();

        WaitHelpers.presenceOfElement(driver,username);
        enterInput(username, usr);

        WaitHelpers.presenceOfElement(driver, password);
        enterInput(password, pwd);

        WaitHelpers.presenceOfElement(driver, submit);
        clickElement(submit);

    }

}