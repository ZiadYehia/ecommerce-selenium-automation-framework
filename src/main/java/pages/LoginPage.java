package pages;

import bots.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    //variables
    private WebDriver driver;
    private ActionsBot actionsBot;
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
        this.actionsBot = new ActionsBot(driver);
    }

    //actions
    public LoginPage login(String email, String password) {
        actionsBot.type(emailInput, email);
        actionsBot.type(passwordInput, password);
        actionsBot.click(rememberMeCheck);
        actionsBot.click(loginButton);
        return new LoginPage(driver);
    }

    public PwRecoveryPage forgetPassword() {
        actionsBot.click(forgotPassword);
        return new PwRecoveryPage(driver);
    }

    //validations
    public HomePage isSuccessfulLogin(String expectedHomeUrl) {
        Assert.assertEquals(actionsBot.getCurrentUrl(), expectedHomeUrl, "This is not HomePage URL");
        return new HomePage(driver);
    }

    public LoginPage isNotSuccessfulLogin(String expectedLoginUrl) {
        Assert.assertEquals(actionsBot.getCurrentUrl(), expectedLoginUrl, "This is not LoginPage URL");
        return new LoginPage(driver);
    }

    public LoginPage isEyeIconWorking() {
        Assert.assertEquals(actionsBot.getDomProperty(passwordInput, "type"), "text", "Eye icon is not working");
        return new LoginPage(driver);
    }
}
