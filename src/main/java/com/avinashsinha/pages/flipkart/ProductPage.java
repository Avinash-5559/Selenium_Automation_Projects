package com.avinashsinha.pages.flipkart;

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
    private By addToCartButton = By.xpath("//button[text()='Add to cart']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void clickAddToCartButton() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement addToCartButtonElement = driver.findElement(addToCartButton);
        js.executeScript(
                "window.scrollBy(0, 1000);",
                addToCartButtonElement);

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

        clickElement(addToCartButtonElement);

        WaitHelpers.waitJVM(3000);

    }
}
