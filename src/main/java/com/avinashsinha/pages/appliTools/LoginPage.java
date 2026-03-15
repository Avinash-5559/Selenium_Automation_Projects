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
    private static final By LOGIN_FORM = By.xpath("//h4[normalize-space()='Login Form']");
    private static final By USERNAME = By.xpath("//input[@id='username']");
    private static final By PASSWORD = By.xpath("//input[@id='password']");
    private static final By LOGIN = By.xpath("//a[@id='log-in']");
    private static final By OVERVIEW_TEXT =By.xpath("//h6[normalize-space()='Financial Overview']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void loginToAppliToolsCreds(String usr, String pwd) {

        openAppToolsUrl();

        WaitHelpers.waitJVM(1500);

        enterInput(USERNAME, usr);

        WaitHelpers.waitJVM(1500);

        enterInput(PASSWORD, pwd);

        WaitHelpers.waitJVM(1500);

        clickElement(LOGIN);

        WaitHelpers.waitJVM(1500);
        WaitHelpers.presenceOfElement(OVERVIEW_TEXT);

    }

}