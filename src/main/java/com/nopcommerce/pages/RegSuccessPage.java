package com.nopcommerce.pages;

import com.nopcommerce.utils.actions.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegSuccessPage {

    //variables
    private WebDriver driver;
    private ElementActions elementActions;
    //locators
    private final By continueButton = By.cssSelector("a[class=\"button-1 register-continue-button\"]");

    //constructor
    public RegSuccessPage(WebDriver driver) {
        this.driver = driver;
        this.elementActions = new ElementActions(driver);
    }

    //actions
    public RegSuccessPage continueReg() {
        elementActions.click(continueButton);
        return new RegSuccessPage(driver);
    }

    //validations
    public HomePage isHomePageAppear(String expectedHomeUrl) {
        Assert.assertEquals(elementActions.getCurrentUrl(), expectedHomeUrl, "This is not HomePage URL");
        return new HomePage(driver);
    }
}
