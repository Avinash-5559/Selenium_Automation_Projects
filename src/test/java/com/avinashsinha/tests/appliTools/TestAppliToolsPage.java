package com.avinashsinha.tests.appliTools;

import com.avinashsinha.base.CommonToAllTest;
import com.avinashsinha.listeners.RetryAnalyzer;
import com.avinashsinha.listeners.ScreenshotListeners;
import com.avinashsinha.pages.appliTools.DashboardPage;
import com.avinashsinha.pages.appliTools.LoginPage;
import com.avinashsinha.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.avinashsinha.driver.DriverManager.getDriver;

@Listeners(ScreenshotListeners.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestAppliToolsPage extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestAppliToolsPage.class);

    @Test
    @Description("TC#1 : Verify that after Login Add the Total Amount shown on Dashboard Page")
    @Owner("Avinash Sinha")
    public void test_appliToolsPage() {

        logger.info("Starting the TestCase of AppliTools Page");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginToAppliToolsCreds(PropertiesReader.readKey("appUsername"), PropertiesReader.readKey("appPassword"));

        System.out.println("\n---------- Submission of all Amounts ----------\n");

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        dashboardPage.enterToDashboardPage();

        logger.info("Finishing the TestCase of AppliTools Page");

    }

}