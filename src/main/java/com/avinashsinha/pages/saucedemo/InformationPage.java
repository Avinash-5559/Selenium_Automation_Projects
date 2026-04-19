package com.avinashsinha.pages.saucedemo;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class InformationPage extends BasePage {

    WebDriver driver;

    public InformationPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private final static By FIRST_NAME_TEXT_FIELD = By.id("first-name");
    private final static By LAST_NAME_TEXT_FIELD = By.id("last-name");
    private final static By POSTAL_CODE_TEXT_FIELD = By.id("postal-code");
    private final static By CONTINUE_BUTTON = By.id("continue");
    private final static By CANCEL_BUTTON = By.id("cancel");
    private final static By ERROR_MESSAGE = By.cssSelector(".error-message-container");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public InformationPage fillUserFormDetails() {

        String expectedInformationPageTitle = PropertiesReader.readKey("expectedInformationPageTitle");
        String actualInformationPageTitle = PropertiesReader.readKey("actualInformationPageTitle");

        if (expectedInformationPageTitle.equals(actualInformationPageTitle)) {


        } else {

            System.out.println("\nForm is not filled by the User\n");
            WaitHelpers.presenceOfElement(driver, By.id("sauce-demo-id"));

        }

        return this;

    }

    public InformationPage enterFirstName(String firstName) {

        enterInput(FIRST_NAME_TEXT_FIELD, firstName);
        return this;

    }

    public InformationPage enterLastName(String lastName) {

        enterInput(LAST_NAME_TEXT_FIELD, lastName);
        return this;

    }

    public InformationPage enterPostalCode(String postalCode) {

        enterInput(POSTAL_CODE_TEXT_FIELD, postalCode);
        return this;

    }

    public InformationPage clickContinue() {

        clickElement(CONTINUE_BUTTON);
        return this;

    }

    public InformationPage seeErrorMessage() {

        WaitHelpers.checkVisibility(driver, ERROR_MESSAGE);
        return this;

    }

    public InformationPage cancelOrder(){

        clickElement(CANCEL_BUTTON);
        return  this;

    }

}