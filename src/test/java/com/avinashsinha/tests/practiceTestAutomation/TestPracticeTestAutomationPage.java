package com.avinashsinha.tests.practiceTestAutomation;

import com.avinashsinha.base.CommonToAllTest;
import com.avinashsinha.listeners.RetryAnalyzer;
import com.avinashsinha.listeners.ScreenshotListeners;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListeners.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestPracticeTestAutomationPage extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestPracticeTestAutomationPage.class);

    @Test(priority = 1)
    @Description("TC#1 : Verify that successful login with Valid Credentials")
    @Owner("Avinash Sinha")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Valid Login")
    public void testValidLogin() {

        logger.info("Start the Valid Login Test");

        logger.info("Valid Login Test Successful Completed");

    }

    @Test(priority = 2)
    @Description("TC#2 : Verify that error message with Invalid Username")
    @Owner("Avinash Sinha")
    @Severity(SeverityLevel.NORMAL)
    @Story("Invalid Login")
    public void testInvalidUsername() {

        logger.info("Start the Invalid Username Test");

        logger.info("Invalid Username Test Successful Completed");

    }

    @Test(priority = 3)
    @Description("TC#3 : Verify that error message with Invalid Password")
    @Owner("Avinash Sinha")
    @Severity(SeverityLevel.NORMAL)
    @Story("Invalid Login")
    public void testInvalidPassword() {

        logger.info("Start the Invalid Password Test");

        logger.info("Invalid Password Test Successful Completed");

    }

    @Test(priority = 4)
    @Description("TC#4 : Verify that Logout Functionality")
    @Owner("Avinash Sinha")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Invalid Login")
    public void testLogout() {

        logger.info("Start the Logout Test");

        logger.info("Logout Test Successful Completed");

    }

    @Test(priority = 5)
    @Description("TC#5 : Verify that capture the screenshot during Intentional Failure")
    @Owner("Avinash Sinha")
    @Severity(SeverityLevel.MINOR)
    @Story("Invalid Login")
    public void testIntentionalFailureForScreenshot() {

        logger.info("Start the Intentional Failure Test for Screenshot Verification");

        logger.info("Intentional Failure for Screenshot Verification Test Successful Completed");

    }

}