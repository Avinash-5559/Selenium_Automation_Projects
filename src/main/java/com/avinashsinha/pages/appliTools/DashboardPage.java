package com.avinashsinha.pages.appliTools;

import com.avinashsinha.base.BasePage;
import com.avinashsinha.utils.WaitHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

//This is Page Class
public class DashboardPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(DashboardPage.class);

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private static final By AMOUNT_ELEMENTS = By.xpath("//span[contains(text(),'USD')]");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public double calculateTotalDashboardAmount() {

        WaitHelpers.presenceOfElement(driver, AMOUNT_ELEMENTS);

        List<WebElement> amountElements = driver.findElements(
                By.xpath("//span[contains(text(),'USD')]")
        );

        double total = 0.0;

        for (WebElement element : amountElements) {

            String text = element.getText();

            try {

                text = text.replace("USD", "")
                        .replace(" ", "")
                        .replace(",", "");

                double value = Double.parseDouble(text);

                total += value;
            } catch (NumberFormatException e) {
                LOGGER.error("Skipping unparseable amount text: '{}'", text, e);
            }

        }

        LOGGER.info("Total Amount = {}", total);

        return total;
    }

}