package com.nopcommerce.utils.bots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

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
                        scrollToElementJs(by);
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
                        scrollToElementJs(by);
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
                        scrollToElementJs(by);
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
                        scrollToElementJs(by);
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

    public void scrollToElement(By by) {
        waitBot.defaultFluentWait()
                .until(d -> {
                    try {
                        WebElement element = driver.findElement(by);
                        scrollToElementJs(by);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                });
    }

    // Scroll to Element using javaScript with behavior auto , block center , inline center
    public void scrollToElementJs(By by) {
        waitBot.defaultFluentWait()
                .until(d -> {
                    try {
                        WebElement element = driver.findElement(by);
                        ((org.openqa.selenium.JavascriptExecutor) driver)
                                .executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", element);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                });
    }

    public WebElement findElement(By by) {
        return waitBot.defaultFluentWait()
                .until(d -> {
                    try {
                        WebElement element = d.findElement(by);
                        scrollToElementJs(by);
                        return element;
                    } catch (Exception e) {
                        return null;
                    }
                });
    }

    // Upload File

    public void uploadFile(By by, String filePath) {
        String fileAbsolutePath = System.getProperty("user.dir") + File.separator + filePath;
        waitBot.defaultFluentWait()
                .until(d -> {
                    try {
                        WebElement element = d.findElement(by);
                        scrollToElementJs(by);
                        element.sendKeys(fileAbsolutePath);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                });
    }
}
