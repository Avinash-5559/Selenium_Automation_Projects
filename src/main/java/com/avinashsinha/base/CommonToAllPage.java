package com.avinashsinha.base;

import com.avinashsinha.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static com.avinashsinha.driver.DriverManager.getDriver;

// If you want to call something before every Page Object Class call, Put your Code here
// Open File, Open Data, Base Connection you can write code here

public class CommonToAllPage {

    public CommonToAllPage() {
    }

    public void openAmazonUrl() {
        getDriver().get(PropertiesReader.readKey("actualAmazonUrl"));
    }

    public void openAppToolsUrl() {
        getDriver().get(PropertiesReader.readKey("appURL"));
    }

    public void openFlipkartUrl() {
        getDriver().get(PropertiesReader.readKey("actualFlipkartUrl"));
    }

    public void openPracticeTestAutomation() {
        getDriver().get(PropertiesReader.readKey("pta_url"));
    }

    public void clickElement(By by) {
        getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by) {
        by.click();
    }

    public void pressEnter(By by) {
        getDriver().findElement(by).sendKeys(Keys.ENTER);
    }

    public void pressEnter(WebElement by) {
        by.sendKeys(Keys.ENTER);
    }

    public void enterInput(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement by, String key) {
        by.sendKeys(key);
    }

    public String getText(By by) {
        return getDriver().findElement(by).getText();
    }

    public String getText(WebElement by) {
        return by.getText();
    }

}