package tests;

import com.nopcommerce.drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.nopcommerce.pages.RegisterPage;


public class RegisterTest {
    //variables
    WebDriver driver;
    String successfulRegMsg = "Your registration completed";

    //Test cases
    @Test
    public void validUserRegistration() {
        new RegisterPage(driver)
                .register("ziad", "yehia", "ziadTest233@gmail.com", "TestCompany", "P@ssw0rd")
                .isRegistrationCompleted(successfulRegMsg);
    }

    @Test
    public void inValidUserRegistration() {
        new RegisterPage(driver)
                .register("", "", "invalidEmail", "", "123")
                .isRegistrationNotCompleted();
    }

    //Configurations
    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.initDriver("edge");
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }

}
