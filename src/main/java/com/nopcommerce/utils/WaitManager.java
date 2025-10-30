package com.nopcommerce.utils;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class WaitManager {
    private final WebDriver driver;

    public WaitManager(WebDriver driver) {
        this.driver = driver;
    }

    public FluentWait<WebDriver> defaultFluentWait() {
        return fluentWait(10L, 10L);
    }

    public FluentWait<WebDriver> fluentWait(Long sec, Long millis) {
        return new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(sec))
                .pollingEvery(Duration.ofMillis(millis))
                .withMessage("TimeOut as exceeded: " + sec + " seconds")
                .ignoreAll(getExceptions());
    }

    private ArrayList<Class<? extends Exception>> getExceptions() {
        ArrayList<Class<? extends Exception>> exceptions = new ArrayList<>();
        exceptions.add(NoSuchElementException.class);
        exceptions.add(StaleElementReferenceException.class);
        exceptions.add(ElementClickInterceptedException.class);
        exceptions.add(ElementNotInteractableException.class);
        return exceptions;
    }
}
