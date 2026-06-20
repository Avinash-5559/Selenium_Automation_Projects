package com.avinashsinha.pages.amazon;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.WaitHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//This is Page Class
public class SearchPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(SearchPage.class);

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private static final By FIND_PRODUCT = By.xpath("(//div[@data-cy='title-recipe'])[21]");
    private static final By GIFT_WRAP = By.xpath("//input[@id='gift-wrap']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public boolean searchProduct() {

        boolean isProductPresent = WaitHelpers.isElementPresent(FIND_PRODUCT);

        if (isProductPresent) {

            WebElement element = WaitHelpers.presenceOfElement(driver, FIND_PRODUCT);

            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript(
                    "arguments[0].scrollIntoView({behavior:'smooth',block:'center'});",
                    element);

            WaitHelpers.waitJVM(3000);

            clickElement(FIND_PRODUCT);

            WaitHelpers.waitJVM(3000);

            String pageUrl = js.executeScript("return document.URL").toString();
            LOGGER.info("Navigated to product page: {}", pageUrl);

            String parentWindow = driver.getWindowHandle();

            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(parentWindow)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }

        } else {

            LOGGER.error("Search Page Failed: Product not found in search results.");
            WaitHelpers.visibilityOfElement(driver, GIFT_WRAP);

        }

        return isProductPresent;
    }

}