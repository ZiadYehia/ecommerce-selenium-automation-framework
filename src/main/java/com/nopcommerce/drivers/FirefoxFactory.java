package com.nopcommerce.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class FirefoxFactory implements AbstractDriver {

    private FirefoxOptions getOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        return options;
    }

    public WebDriver createDriver() {
        return new FirefoxDriver(getOptions());
    }
}
