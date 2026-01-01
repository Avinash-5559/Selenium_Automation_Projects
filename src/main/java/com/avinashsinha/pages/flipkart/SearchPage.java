package com.avinashsinha.pages.flipkart;

import com.avinashsinha.base.CommonToAllPage;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class SearchPage extends CommonToAllPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private By findProduct = By.xpath(PropertiesReader.readKey("actualFlipkartXpath"));

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void searchProduct() {

        String expectedPath = PropertiesReader.readKey("expectedFlipkartXpath");
        String actualPath = PropertiesReader.readKey("actualFlipkartXpath");

        if (expectedPath.equals(actualPath)) {

            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript(
                    "arguments[0].scrollIntoView({behavior:'smooth',block:'center'});" +
                            "setTimeout(() => arguments[0].click(), 3000);",
                    driver.findElement(findProduct));

            WaitHelpers.waitJVM(5000);

            String parentWindow = driver.getWindowHandle();

            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(parentWindow)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }

        } else {

            System.out.println("\nProduct is not Listed on the Flipkart Page.\n");
            WaitHelpers.visibilityOfElement(driver.findElement(By.xpath("//button[normalize-space()='Buy Now']")));

        }

    }

}