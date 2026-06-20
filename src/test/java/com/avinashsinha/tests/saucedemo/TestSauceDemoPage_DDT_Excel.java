package com.avinashsinha.tests.saucedemo;

import com.avinashsinha.base.BaseTest;
import com.avinashsinha.listeners.RetryAnalyzer;
import com.avinashsinha.listeners.ScreenshotListeners;
import com.avinashsinha.pages.saucedemo.LoginPage;
import com.avinashsinha.utils.UtilExcel;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.avinashsinha.driver.DriverManager.getDriver;

@Listeners(ScreenshotListeners.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestSauceDemoPage_DDT_Excel extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(TestSauceDemoPage_DDT_Excel.class);

    @Test(dataProvider = "getData")
    @Description("TC#1 : Verify to login the Web Page by Multiple Creds through Excel File")
    @Owner("Avinash Sinha")
    public void testSauceDemoPage_DDT_Excel(String username, String password) {

        LOGGER.info("Testing login with username: {} | password: {}", username, password);

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername(username)
                .enterPassword(password)
                .clickLoginButton();

        Assert.assertTrue(loginPage.isLoginSuccessful(),
                "Login failed for username: " + username);

        LOGGER.info("Login successful for username: {}", username);
    }

    @DataProvider
    public Object[][] getData() {

        return UtilExcel.getTestDataFromExcel("Sheet1");

    }

}