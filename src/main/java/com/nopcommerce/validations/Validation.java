package com.nopcommerce.validations;

import com.nopcommerce.utils.logs.LogsManager;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

// Soft Assertion
public class Validation extends BaseAssertion {
    private static SoftAssert softAssert = new SoftAssert();
    private static boolean flag = false; // Flag to track if there are any assertion done
    public Validation(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void assertTrue(boolean condition, String message) {
        LogsManager.info("Asserting True:", message);
        flag = true;
        softAssert.assertTrue(condition, message);
    }

    @Override
    protected void assertFalse(boolean condition, String message) {
        LogsManager.info("Asserting False:", message);
        flag = true;
        softAssert.assertFalse(condition, message);
    }

    @Override
    protected void assertEquals(String actual, String expected, String message) {
        LogsManager.info("Asserting Equals:", message, " | Expected:", expected, " | Actual:", actual);
        flag = true;
        softAssert.assertEquals(actual, expected, message);
    }

    public static void assertAll() {
        if (!flag) {
            LogsManager.warn("No assertions were made.");
            return;
        }
        flag = false; // Reset flag for next use
        try {
            softAssert.assertAll();
        } catch (AssertionError e) {
            LogsManager.error("Soft Assertion failed:", e.getMessage());
            throw e;
        } finally {
            softAssert = new SoftAssert();
        }
    }
}
