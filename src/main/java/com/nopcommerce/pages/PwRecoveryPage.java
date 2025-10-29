package com.nopcommerce.pages;

import com.nopcommerce.bots.ActionsBot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class PwRecoveryPage {

    //variables
    private WebDriver driver;
    private ActionsBot actionsBot;
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
        this.actionsBot = new ActionsBot(driver);

    }

    //actions


    //validations
}
