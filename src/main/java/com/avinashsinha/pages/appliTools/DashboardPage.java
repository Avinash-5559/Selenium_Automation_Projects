package com.avinashsinha.pages.appliTools;

import com.avinashsinha.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

//This is Page Class
public class DashboardPage extends CommonToAllPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void enterToDashboardPage() {

        List<WebElement> amountElements = driver.findElements(
                By.xpath("//span[contains(text(),'USD')]")
        );

        double total = 0.0;

        for (WebElement element : amountElements) {

            String text = element.getText();

            text = text.replace("USD", "")
                    .replace(" ", "")
                    .replace(",", "");

            double value = Double.parseDouble(text);

            total += value;

        }

        System.out.println("Total Amount = " + total + "\n");

    }

}