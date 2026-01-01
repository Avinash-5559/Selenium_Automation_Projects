package com.avinashsinha.pages.amazon;

import com.avinashsinha.base.CommonToAllPage;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//This is Page Class
public class SearchPage extends CommonToAllPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private By findProduct = By.xpath(PropertiesReader.readKey("actualAmazonXpath"));

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void searchProduct() {

        String expectedPath = PropertiesReader.readKey("expectedAmazonXpath");
        String actualPath = PropertiesReader.readKey("actualAmazonXpath");

        if (expectedPath.equals(actualPath)) {

            JavascriptExecutor js = (JavascriptExecutor) driver;

            WebElement element = driver.findElement(findProduct);
            js.executeScript(
                    "arguments[0].scrollIntoView({behavior:'smooth',block:'center'});",
                    element);

            WaitHelpers.waitJVM(3000);

            clickElement(findProduct);

            WaitHelpers.waitJVM(3000);

            String pageUrl = js.executeScript("return document.URL").toString();
            System.out.println("\nProduct Name : " + pageUrl + "\n");

            String parentWindow = driver.getWindowHandle();

            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(parentWindow)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }

        } else {

            System.out.println("\nProduct is not Listed on the Amazon Page.\n");
            WaitHelpers.visibilityOfElement(driver.findElement(By.xpath("//input[@id='gift-wrap']")));

        }

    }

}