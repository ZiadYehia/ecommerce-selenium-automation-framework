package com.nopcommerce.pages;

import com.nopcommerce.utils.actions.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    //variables
    private WebDriver driver;
    private ElementActions elementActions;
    //locators
    private final By emailInput = By.cssSelector("[id=\"Email\"]");
    private final By passwordInput = By.cssSelector("[id=\"Password\"]");
    private final By rememberMeCheck = By.cssSelector("[id=\"RememberMe\"]");
    private final By loginButton = By.cssSelector("[class*=\"login-button\"]");
    private final By forgotPassword = By.cssSelector("[href=\"/passwordrecovery\"]");
    private final By eyeIcon = By.cssSelector("[class=\"password-eye\"]"); //check type property is coverted from password to text

    //constructors
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.elementActions = new ElementActions(driver);
    }

    //actions
    public LoginPage login(String email, String password) {
        elementActions.type(emailInput, email);
        elementActions.type(passwordInput, password);
        elementActions.click(rememberMeCheck);
        elementActions.click(loginButton);
        return new LoginPage(driver);
    }

    public PwRecoveryPage forgetPassword() {
        elementActions.click(forgotPassword);
        return new PwRecoveryPage(driver);
    }

    public LoginPage clickEyeIcon() {
        elementActions.click(eyeIcon);
        return this;
    }

    //validations
    public HomePage isSuccessfulLogin(String expectedHomeUrl) {
        Assert.assertEquals(elementActions.getCurrentUrl(), expectedHomeUrl, "This is not HomePage URL");
        return new HomePage(driver);
    }

    public LoginPage isNotSuccessfulLogin(String expectedLoginUrl) {
        Assert.assertEquals(elementActions.getCurrentUrl(), expectedLoginUrl, "This is not LoginPage URL");
        return new LoginPage(driver);
    }

    public LoginPage isEnableEyeIconWorking() {
        Assert.assertEquals(elementActions.getDomProperty(passwordInput, "type"), "text", "Eye icon is not working");
        return new LoginPage(driver);
    }

    public LoginPage isDisableEyeIconWorking() {
        Assert.assertEquals(elementActions.getDomProperty(passwordInput, "type"), "password", "Eye icon is not working");
        return new LoginPage(driver);
    }
}
