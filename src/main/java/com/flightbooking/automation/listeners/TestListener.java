package com.flightbooking.automation.listeners;

import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.flightbooking.automation.base.DriverManager;
import com.flightbooking.automation.listeners.TestListener;
import com.flightbooking.automation.reports.*;
import com.flightbooking.automation.utils.LoggerUtils;
import com.flightbooking.automation.utils.ScreenshotUtils;
import com.aventstack.extentreports.ExtentReports;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTestManager.setTest(
                extent.createTest(result.getMethod().getMethodName())
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        String screenshotPath =
                ScreenshotUtils.captureScreenshot(
                        DriverManager.getDriver(),
                        result.getMethod().getMethodName());

        ExtentTestManager.getTest().pass("Test Passed")
                .addScreenCaptureFromPath(screenshotPath);
    }


    @Override
    public void onTestFailure(ITestResult result) {

        String testName = result.getMethod().getMethodName();
        LoggerUtils.error(Thread.currentThread().getName()+" Test failed: "
                + result.getThrowable().getMessage());
        String screenshotPath =
                ScreenshotUtils.captureScreenshot(
                        DriverManager.getDriver(),
                        testName);

        ExtentTestManager.getTest()
                .fail("Test Failed: " + result.getThrowable().getMessage());

        try {

            ExtentTestManager.getTest()
                    .addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {

            ExtentTestManager.getTest()
                    .fail("Screenshot could not be attached");
        }
    }
//    Information of entire test run-ITestContext
    @Override
    public void onFinish(ITestContext context) {
//    	for saving the report
        extent.flush();
    }
}