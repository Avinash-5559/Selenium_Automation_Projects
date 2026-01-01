package com.avinashsinha.pages.amazon;

import com.avinashsinha.base.CommonToAllPage;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//This is Page Class
public class ProductPage extends CommonToAllPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private By elementToBePresent = By.xpath("//input[@id='buy-now-button']");
    private By addToCartButton = By.xpath("//input[@id='add-to-cart-button']");
    private By clickQuantity = By.xpath("//span[@id='a-autoid-0-announce']");
    private By selectQuantity = By.xpath("//a[@id='quantity_10']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void clickAddToCartButton() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element = driver.findElement(elementToBePresent);
        js.executeScript(
                "arguments[0].scrollIntoView({behavior:'smooth',block:'center'});",
                element);

        WaitHelpers.waitJVM(2000);

        File sourceFolder = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));

        File screenshotDir = new File("screenshots");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdir();
        }

        File destinationFolder = new File(screenshotDir, "ProductPage_" + timeStamp + ".png");

        try {
            FileHandler.copy(sourceFolder, destinationFolder);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot", e);
        }

        clickElement(clickQuantity);
        clickElement(selectQuantity);
        clickElement(addToCartButton);

    }
}
