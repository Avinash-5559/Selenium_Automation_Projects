package com.avinashsinha.tests.saucedemo;

import com.avinashsinha.base.BaseTest;
import com.avinashsinha.listeners.RetryAnalyzer;
import com.avinashsinha.listeners.ScreenshotListeners;
import com.avinashsinha.pages.saucedemo.LoginPage;
import com.avinashsinha.utils.DataReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static com.avinashsinha.driver.DriverManager.getDriver;

@Listeners(ScreenshotListeners.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestSauceDemoPage_DDT_JSON extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(TestSauceDemoPage_DDT_JSON.class);

    @Test(dataProvider = "getData")
    @Description("TC#1 : Verify to login the Web Page by Multiple Creds through JSON File")
    @Owner("Avinash Sinha")
    public void testSauceDemoPage_DDT_JSON(HashMap<String, String> testData) {

        LOGGER.info("Start the Test Case of LoginPage of Sauce Demo from JSON Data");

        String username = testData.get("username");
        String password = testData.get("password");

        System.out.println(" | " + username + " | " + password + " | ");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSauceDemo()
                .enterUsername(username)
                .enterPassword(password)
                .clickLoginButton();

        LOGGER.info("End the Test Case of Sauce LoginPage of Demo from JSON Data");

    }

    @DataProvider
    public Object[][] getData() throws IOException {

        DataReader dataReader = new DataReader();
        List<HashMap<String, String>> testDataList = dataReader.getTestDataFromJson();

        Object[][] data = new Object[testDataList.size()][1];
        for (int i = 0; i < testDataList.size(); i++) {
            data[i][0] = testDataList.get(i);
        }
        return data;
    }

}