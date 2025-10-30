package com.nopcommerce.validations;

import com.nopcommerce.utils.logs.LogsManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

// Hard Assertion
public class Verification extends BaseAssertion {
    public Verification(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void assertTrue(boolean condition, String message) {
        LogsManager.info("Asserting true:", message);
        Assert.assertTrue(condition, message);
    }

    @Override
    protected void assertFalse(boolean condition, String message) {
        LogsManager.info("Asserting false:", message);
        Assert.assertFalse(condition, message);
    }

    @Override
    protected void assertEquals(String actual, String expected, String message) {
        LogsManager.info("Asserting equals:", message, " | Expected:", expected, " | Actual:", actual);
        Assert.assertEquals(actual, expected, message);
    }

}
