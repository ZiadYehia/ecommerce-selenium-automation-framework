package com.nopcommerce.pages;

import com.nopcommerce.utils.actions.ElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class PwRecoveryPage {

    //variables
    private WebDriver driver;
    private ElementActions elementActions;
    //locators
    By pwRecoveryTitle = By.cssSelector("[class=\"page-title\"]");
    By pwRecoveryMsg = By.cssSelector("[class=\"tooltip\"]");
    By emailInput = By.cssSelector("[id=\"Email\"]");
    By recoverBtn = By.cssSelector("[name=\"send-email\"]");
    By pwRecoveryErrorMsg = By.cssSelector("[id=\"Email-error\"]");
    By pwRecoverySuccessMsg = By.cssSelector("[class=\"content\"]");
    //constructor
    public PwRecoveryPage(WebDriver driver) {
        this.driver = driver;
        this.elementActions = new ElementActions(driver);

    }

    //actions


    //validations
}
