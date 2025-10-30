package com.nopcommerce.validations;

import com.nopcommerce.utils.WaitManager;
import com.nopcommerce.utils.actions.ElementActions;
import org.openqa.selenium.WebDriver;

public abstract class BaseAssertion {
    protected final WebDriver driver;
    protected final WaitManager waitManager;
    protected ElementActions elementActions;
    protected BaseAssertion(WebDriver driver) {
        this.driver = driver;
        this.waitManager = new WaitManager(driver);
        this.elementActions = new ElementActions(driver);
    }
    protected abstract void assertTrue(boolean condition, String message);
    protected abstract void assertFalse(boolean condition, String message);
    protected abstract void assertEquals(String actual, String expected, String message);

}
