package com.avinashsinha.driver;

import com.avinashsinha.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driverRef) {
        driver.set(driverRef);
    }

    //When we want to Start the Browser
    public static void openBrowser() {

        String browser = PropertiesReader.readKey("browser");
        browser = browser.toLowerCase();
        WebDriver driverRef = null;

        switch (browser) {

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--inprivate");
                //edgeOptions.addArguments("--headless");
                driverRef = new EdgeDriver(edgeOptions);
                break;

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                //chromeOptions.addArguments("--headless");
                driverRef = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("-private-window");
                //firefoxOptions.addArguments("--headless");
                driverRef = new FirefoxDriver(firefoxOptions);
                break;

            default:
                System.out.println("Browser Not Supported!!!");

        }

        assert driverRef != null;
        driverRef.manage().deleteAllCookies();
        driverRef.manage().window().maximize();
        setDriver(driverRef);
    }

    //When we want to Close the Browser
    public static void closeBrowser() {

        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }

}