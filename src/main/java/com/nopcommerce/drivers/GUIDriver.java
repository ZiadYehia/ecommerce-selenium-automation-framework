package com.nopcommerce.drivers;

import com.nopcommerce.utils.datareader.PropertyReader;
import com.nopcommerce.utils.logs.LogsManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class GUIDriver {

    private final static String browser = PropertyReader.getProperty("browser");
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public GUIDriver() {
        Browser browserType = Browser.valueOf(browser.toUpperCase());
        LogsManager.info("Initializing WebDriver for browser:", browserType.toString());
        AbstractDriver abstractDriver = browserType.getDriverFactory();
        WebDriver driver = ThreadGuard.protect(abstractDriver.createDriver());
        driverThreadLocal.set(driver);
    }

    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}
