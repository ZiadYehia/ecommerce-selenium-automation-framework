package com.nopcommerce.bots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsBot {
    private WebDriver driver;
    private WaitBot waitBot;

    public ActionsBot(WebDriver driver) {
        this.driver = driver;
        this.waitBot = new WaitBot(driver);
    }

    // Common actions can be added here in the future

    // Click action
    public void click(By by) {
        waitBot.defaultFluentWait()
                .until(d -> {
                    try {
                        WebElement element = d.findElement(by);
                        new Actions(d).scrollToElement(element);
                        element.click();
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                });
    }

    // Type action
    public void type(By by, String text) {
        waitBot.defaultFluentWait()
                .until(d -> {
                    try {
                        WebElement element = d.findElement(by);
                        new Actions(d).scrollToElement(element);
                        element.clear();
                        element.sendKeys(text);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                });
    }

    // Get text action
    public String getText(By by) {
        return waitBot.defaultFluentWait()
                .until(d -> {
                    try {
                        WebElement element = d.findElement(by);
                        new Actions(d).scrollToElement(element);
                        if (!element.getText().isEmpty()) {
                            return element.getText();
                        } else {
                            return null;
                        }
                    } catch (Exception e) {
                        return null;
                    }
                });
    }

    // Get Current URL
    public String getCurrentUrl() {
        return waitBot.defaultFluentWait()
                .until(d -> {
                    try {
                        return d.getCurrentUrl();
                    } catch (Exception e) {
                        return null;
                    }
                });
    }

    // Get Dom Property
    public String getDomProperty(By by, String property) {
        return waitBot.defaultFluentWait()
                .until(d -> {
                    try {
                        WebElement element = d.findElement(by);
                        new Actions(d).scrollToElement(element);
                        String propValue = element.getDomProperty(property);
                        if (!propValue.isEmpty()) {
                            return propValue;
                        } else {
                            return null;
                        }
                    } catch (Exception e) {
                        return null;
                    }
                });
    }
}
