package com.nopcommerce.pages;

import com.nopcommerce.utils.actions.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterPage {

    //variables
    private WebDriver driver;
    private ElementActions elementActions;
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
        this.elementActions = new ElementActions(driver);
    }

    //actions
    public RegisterPage register(String firstName, String lastName, String email, String company, String password) {
        elementActions.click(maleGenderRadio);
        elementActions.type(firstNameInput, firstName);
        elementActions.type(lastNameInput, lastName);
        elementActions.type(emailInput, email);
        elementActions.click(newsletterCheckbox);
        elementActions.type(companayInput, company);
        elementActions.type(passwordInput, password);
        elementActions.type(confirmPasswordInput, password);
        elementActions.click(registerButton);
        return new RegisterPage(driver);
    }

    //validations
    public RegSuccessPage isRegistrationCompleted(String expectedMsg) {
        Assert.assertTrue(elementActions.getText(registrationCompletedText).contains(expectedMsg));
        return new RegSuccessPage(driver);
    }

    public RegisterPage isRegistrationNotCompleted() {
        Assert.assertEquals(elementActions.getText(registerText), "Register");
        return this;
    }
}
