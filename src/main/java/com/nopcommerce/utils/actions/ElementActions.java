package com.nopcommerce.utils.actions;

import com.nopcommerce.utils.WaitManager;
import com.nopcommerce.utils.logs.LogsManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class ElementActions {
    private final WebDriver driver;
    private WaitManager waitManager;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.waitManager = new WaitManager(driver);
    }

    // Common actions can be added here in the future

    // Click action
    public void click(By by) {
        waitManager.defaultFluentWait()
                .until(d -> {
                    try {
                        WebElement element = d.findElement(by);
                        LogsManager.info("Scrolling to click on element:", by.toString());
                        scrollToElementJs(by);
                        element.click();
                        LogsManager.info("Clicked on element:", by.toString());
                        return true;
                    } catch (Exception e) {
                        LogsManager.error("Failed to click on element:", by.toString(), e.getMessage());
                        return false;
                    }
                });
    }

    // Type action
    public void type(By by, String text) {
        waitManager.defaultFluentWait()
                .until(d -> {
                    try {
                        WebElement element = d.findElement(by);
                        LogsManager.info("Scrolling to type in element:", by.toString());
                        scrollToElementJs(by);
                        LogsManager.info("Typing text in element:", by.toString());
                        element.clear();
                        element.sendKeys(text);
                        LogsManager.info("Typed text in element:", by.toString());
                        return true;
                    } catch (Exception e) {
                        LogsManager.error("Failed to type in element:", by.toString(), e.getMessage());
                        return false;
                    }
                });
    }

    // Get text action
    public String getText(By by) {
        return waitManager.defaultFluentWait()
                .until(d -> {
                    try {
                        WebElement element = d.findElement(by);
                        LogsManager.info("Scrolling to get text from element:", by.toString());
                        scrollToElementJs(by);
                        if (!element.getText().isEmpty()) {
                            LogsManager.info("Got text from element:", by.toString());
                            return element.getText();
                        } else {
                            LogsManager.warn("No text found in element:", by.toString());
                            return null;
                        }
                    } catch (Exception e) {
                        LogsManager.error("Failed to get text from element:", by.toString(), e.getMessage());
                        return null;
                    }
                });
    }

    // Get Current URL
    public String getCurrentUrl() {
        return waitManager.defaultFluentWait()
                .until(d -> {
                    try {
                        LogsManager.info("Getting current URL");
                        return d.getCurrentUrl();
                    } catch (Exception e) {
                        LogsManager.error("Failed to get current URL:", e.getMessage());
                        return null;
                    }
                });
    }

    // Get Dom Property
    public String getDomProperty(By by, String property) {
        return waitManager.defaultFluentWait()
                .until(d -> {
                    try {
                        WebElement element = d.findElement(by);
                        LogsManager.info("Scrolling to get DOM property from element:", by.toString());
                        scrollToElementJs(by);
                        String propValue = element.getDomProperty(property);
                        if (!propValue.isEmpty()) {
                            LogsManager.info("Got DOM property from element:", by.toString());
                            return propValue;
                        } else {
                            LogsManager.warn("No DOM property found in element:", by.toString());
                            return null;
                        }
                    } catch (Exception e) {
                        LogsManager.error("Failed to get DOM property from element:", by.toString(), e.getMessage());
                        return null;
                    }
                });
    }

    public void scrollToElement(By by) {
        waitManager.defaultFluentWait()
                .until(d -> {
                    try {
                        WebElement element = driver.findElement(by);
                        LogsManager.info("Scrolling to element:", by.toString());
                        scrollToElementJs(by);
                        LogsManager.info("Scrolled to element:", by.toString());
                        return true;
                    } catch (Exception e) {
                        LogsManager.error("Failed to scroll to element:", by.toString(), e.getMessage());
                        return false;
                    }
                });
    }

    // Scroll to Element using javaScript with behavior auto , block center , inline center
    public void scrollToElementJs(By by) {
        waitManager.defaultFluentWait()
                .until(d -> {
                    try {
                        WebElement element = driver.findElement(by);
                        LogsManager.info("Scrolling to element using JavaScript:", by.toString());
                        ((org.openqa.selenium.JavascriptExecutor) driver)
                                .executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", element);
                        LogsManager.info("Scrolled to element using JavaScript:", by.toString());
                        return true;
                    } catch (Exception e) {
                        LogsManager.error("Failed to scroll to element using JavaScript:", by.toString(), e.getMessage());
                        return false;
                    }
                });
    }

    public WebElement findElement(By by) {
        return waitManager.defaultFluentWait()
                .until(d -> {
                    try {
                        WebElement element = d.findElement(by);
                        LogsManager.info("Scrolling to find element:", by.toString());
                        scrollToElementJs(by);
                        LogsManager.info("Found element:", by.toString());
                        return element;
                    } catch (Exception e) {
                        LogsManager.error("Failed to find element:", by.toString(), e.getMessage());
                        return null;
                    }
                });
    }

    // Upload File

    public void uploadFile(By by, String filePath) {
        String fileAbsolutePath = System.getProperty("user.dir") + File.separator + filePath;
        waitManager.defaultFluentWait()
                .until(d -> {
                    try {
                        WebElement element = d.findElement(by);
                        LogsManager.info("Scrolling to upload file to element:", by.toString());
                        scrollToElementJs(by);
                        LogsManager.info("Uploading file to element:", by.toString());
                        element.sendKeys(fileAbsolutePath);
                        LogsManager.info("Uploaded file to element:", by.toString());
                        return true;
                    } catch (Exception e) {
                        LogsManager.error("Failed to upload file to element:", by.toString(), e.getMessage());
                        return false;
                    }
                });
    }
}
