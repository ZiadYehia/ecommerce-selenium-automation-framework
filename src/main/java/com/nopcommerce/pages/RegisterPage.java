package com.nopcommerce.pages;

import com.nopcommerce.bots.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterPage {

    //variables
    private WebDriver driver;
    private ActionsBot actionsBot;
    // locators
    private final By registerText = By.cssSelector("h1");
    private final By maleGenderRadio = By.cssSelector("[id=\"gender-male\"]");
    private final By femaleGenderRadio = By.cssSelector("[id=\"gender-male\"]");
    private final By firstNameInput = By.cssSelector("[id=\"FirstName\"]");
    private final By lastNameInput = By.cssSelector("[id=\"LastName\"]");
    private final By emailInput = By.cssSelector("[id=\"Email\"]");
    private final By companayInput = By.cssSelector("[id=\"Company\"]");
    private final By newsletterCheckbox = By.cssSelector("[id=\"Newsletter\"]");
    private final By passwordInput = By.cssSelector("[id=\"Password\"]");
    private final By confirmPasswordInput = By.cssSelector("[id=\"ConfirmPassword\"]");
    private final By registerButton = By.cssSelector("[id=\"register-button\"]");
    private final By registrationCompletedText = By.cssSelector("div[class=\"result\"]");

    //constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.actionsBot = new ActionsBot(driver);
    }

    //actions
    public RegisterPage register(String firstName, String lastName, String email, String company, String password) {
        actionsBot.click(maleGenderRadio);
        actionsBot.type(firstNameInput, firstName);
        actionsBot.type(lastNameInput, lastName);
        actionsBot.type(emailInput, email);
        actionsBot.click(newsletterCheckbox);
        actionsBot.type(companayInput, company);
        actionsBot.type(passwordInput, password);
        actionsBot.type(confirmPasswordInput, password);
        actionsBot.click(registerButton);
        return new RegisterPage(driver);
    }

    //validations
    public RegSuccessPage isRegistrationCompleted(String expectedMsg) {
        Assert.assertTrue(actionsBot.getText(registrationCompletedText).contains(expectedMsg));
        return new RegSuccessPage(driver);
    }

    public RegisterPage isRegistrationNotCompleted() {
        Assert.assertEquals(actionsBot.getText(registerText), "Register");
        return this;
    }
}
