package com.avinashsinha.tests.appliTools;

import com.avinashsinha.base.BaseTest;
import com.avinashsinha.listeners.RetryAnalyzer;
import com.avinashsinha.listeners.ScreenshotListeners;
import com.avinashsinha.pages.appliTools.DashboardPage;
import com.avinashsinha.pages.appliTools.LoginPage;
import com.avinashsinha.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.avinashsinha.driver.DriverManager.getDriver;

@Listeners(ScreenshotListeners.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestAppliToolsPage extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(TestAppliToolsPage.class);

    @Test
    @Description("TC#1 : Verify that after Login Add the Total Amount shown on Dashboard Page")
    @Owner("Avinash Sinha")
    public void test_appliToolsPage() {

        LOGGER.info("Starting the TestCase of AppliTools Page");

        LoginPage loginPage = new LoginPage(getDriver());
        boolean loginResult = loginPage.loginToAppliToolsCreds(
                PropertiesReader.readKey("appUsername"),
                PropertiesReader.readKey("appPassword"));
        Assert.assertTrue(loginResult, "Login Page Failed: Financial Overview not found after login attempt.");

        LOGGER.info("Submission of all Amounts");

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        double totalAmount = dashboardPage.calculateTotalDashboardAmount();
        Assert.assertTrue(totalAmount > 0, "Dashboard Page Failed: Total amount calculated was zero or negative.");

        LOGGER.info("Finishing the TestCase of AppliTools Page");

    }

}