import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    //variables
    private WebDriver driver;
    //locators
    By emailInput = By.cssSelector("[id=\"Email\"]");
    By passwordInput = By.cssSelector("[id=\"Password\"]");
    By rememberMeCheck = By.cssSelector("[id=\"RememberMe\"]");
    By loginButton = By.cssSelector("[class*=\"login-button\"]");
    By forgotPassword = By.cssSelector("[href=\"/passwordrecovery\"]");
    By eyeIcon = By.cssSelector("[class=\"password-eye\"]"); //check type property is coverted from password to text
    //constructors

    //actions

    //validations
}
