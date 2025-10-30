package com.nopcommerce.validations;

import com.nopcommerce.utils.WaitManager;
import com.nopcommerce.utils.actions.ElementActions;
import com.nopcommerce.utils.logs.LogsManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

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

    public BaseAssertion Equals(String actual, String expected, String message) {
        assertEquals(actual, expected, message);
        return this;
    }

    public void isElementVisible(By by) {
        boolean flag = waitManager.defaultFluentWait().until(driver1 ->
        {
            try {
                driver1.findElement(by).isDisplayed();
                LogsManager.info("Element is visible:", by.toString());
                return true;
            } catch (Exception e) {
                LogsManager.info("Element is not visible yet:", by.toString());
                return false;
            }
        });
        LogsManager.info("Asserting visibility of element:", by.toString());
        assertTrue(flag, "Element is not visible: " + by);
    }

    // verify page url
    public void assertPageUrl(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        LogsManager.info("Asserting page URL. Expected:", expectedUrl , ", Actual:" , actualUrl);
        assertEquals(actualUrl, expectedUrl, "URL does not match. Expected: " + expectedUrl + ", Actual: " + actualUrl);
    }

    // verify page title
    public void assertPageTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        LogsManager.info("Asserting page Title. Expected:", expectedTitle , ", Actual:" , actualTitle);
        assertEquals(actualTitle, expectedTitle, "Title does not match. Expected: " + expectedTitle + ", Actual: " + actualTitle);
    }


}
