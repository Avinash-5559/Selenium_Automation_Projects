package com.avinashsinha.pages.appliTools;

import com.avinashsinha.base.CommonToAllPage;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class LoginPage extends CommonToAllPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private By loginForm = By.xpath("//h4[normalize-space()='Login Form']");
    private By username = By.xpath("//input[@id='username']");
    private By password = By.xpath("//input[@id='password']");
    private By login = By.xpath("//a[@id='log-in']");
    private By overviewText=By.xpath("//h6[normalize-space()='Financial Overview']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void loginToAppliToolsCreds(String usr, String pwd) {

        openAppToolsUrl();

        WaitHelpers.waitJVM(1500);

        enterInput(username, usr);

        WaitHelpers.waitJVM(1500);

        enterInput(password, pwd);

        WaitHelpers.waitJVM(1500);

        clickElement(login);

        WaitHelpers.waitJVM(1500);
        WaitHelpers.presenceOfElement(overviewText);

    }

}