import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterPage {

    //variables

    private WebDriver driver;

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
    }

    //actions

    public RegisterPage register(String firstName, String lastName, String email, String company, String password) {
        driver.findElement(maleGenderRadio).click();
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(companayInput).sendKeys(company);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(confirmPasswordInput).sendKeys(password);
        driver.findElement(registerButton).click();
        return new RegisterPage(driver);
    }

    //validations

    public RegSuccessPage isRegistrationCompleted(String expectedMsg) {
        Assert.assertTrue(driver.findElement(registrationCompletedText).getText().contains(expectedMsg));
        return new RegSuccessPage(driver);
    }

    public RegisterPage isRegistrationNotCompleted(String expectedMsg) {
        Assert.assertFalse(driver.findElement(registrationCompletedText).getText().contains(expectedMsg));
        return this;
    }

}
