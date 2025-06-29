package org.example.base;

import org.example.driver.DriverManager;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class CommonToAllTest {

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            // 👇 Take screenshot on failure
            ScreenshotUtils.takeScreenshot(DriverManager.getDriver());
        }

        DriverManager.down();
    }
}
