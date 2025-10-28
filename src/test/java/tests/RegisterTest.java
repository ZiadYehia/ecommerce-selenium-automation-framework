package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegisterPage;


public class RegisterTest {
    //variables
    WebDriver driver;
    String successfulRegMsg = "Your registration completed";

    //Test cases
    @Test
    public void validUserRegistration() {
        new RegisterPage(driver)
                .register("ziad", "yehia", "ziadTest@gmail.com", "TestCompany", "P@ssw0rd")
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
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
