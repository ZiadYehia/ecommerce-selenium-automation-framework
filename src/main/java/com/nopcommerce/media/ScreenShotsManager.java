package com.nopcommerce.media;


import com.nopcommerce.utils.TimeManager;
import com.nopcommerce.utils.logs.LogsManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenShotsManager {

    private static final String SCREENSHOTS_PATH = "test-output/screenshots/";

    public static void capturePageScreenShot(WebDriver driver, String screenshotName) {
        try {
            // Capture Screenshot using TakesScreenshot
            File screenshotSrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Save Screenshot to a file if needed
            File screenshotDest = new File(SCREENSHOTS_PATH + screenshotName + "-" + TimeManager.getTimestamp() + ".png");

            // Copy file to destination
            FileUtils.copyFile(screenshotSrc, screenshotDest);

            // TODO: Attach screenshot to Allure Report
            //attachScreenshotToAllureReport(screenshotName, screenshotDest.getPath());

            LogsManager.info("Screenshot captured:", screenshotDest.getAbsolutePath());

        } catch (Exception e) {
            LogsManager.error("Error capturing screenshot:", e.getMessage());
        }

    }

    public static void captureElementScreenShot(WebDriver driver, By by) {
        try {
            // Get element name for screenshot naming
            String screenshotName = driver.findElement(by).getAccessibleName();

            // Capture Screenshot using TakesScreenshot
            File screenshotSrc = driver.findElement(by).getScreenshotAs(OutputType.FILE);
            // Save Screenshot to a file if needed
            File screenshotDest = new File(SCREENSHOTS_PATH + screenshotName + "-" + TimeManager.getTimestamp() + ".png");

            // Copy file to destination
            FileUtils.copyFile(screenshotSrc, screenshotDest);

            // TODO: Attach screenshot to Allure Report
            //attachScreenshotToAllureReport(screenshotName, screenshotDest.getPath());

            LogsManager.info("Element Screenshot captured:", screenshotDest.getAbsolutePath());

        } catch (Exception e) {
            LogsManager.error("Error capturing element screenshot:", e.getMessage());
        }
    }
}