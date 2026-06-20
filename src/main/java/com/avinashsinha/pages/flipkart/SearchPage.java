package com.avinashsinha.pages.flipkart;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.WaitHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class SearchPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(SearchPage.class);

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private static final By FIND_PRODUCT = By.xpath("(//div[@data-id]//a[contains(@href,'/p/')])[120]");
    private static final By BUY_NOW = By.xpath("//button[normalize-space()='Buy Now']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public boolean searchProduct() {

        boolean isProductPresent = WaitHelpers.isElementPresent(FIND_PRODUCT);

        if (isProductPresent) {

            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript(
                    "arguments[0].scrollIntoView({behavior:'smooth',block:'center'});" +
                            "setTimeout(() => arguments[0].click(), 3000);",
                    driver.findElement(FIND_PRODUCT));

            WaitHelpers.waitJVM(5000);

            String parentWindow = driver.getWindowHandle();

            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(parentWindow)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }

            LOGGER.info("Product clicked, switched to new window.");

        } else {

            LOGGER.error("Search Page Failed: Product not found in search results.");
            WaitHelpers.visibilityOfElement(driver, BUY_NOW);

        }

        return isProductPresent;

    }

}