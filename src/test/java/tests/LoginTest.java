package tests;

import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    //variables
    WebDriver driver;
    String homePageUrl = "https://demo.nopcommerce.com/";
    //Test cases
    @Test
    public void validLoginTC(){
        new LoginPage(driver)
                .login("testtesttest@gmail.com","asdasd")
                .isSuccessfulLogin(homePageUrl);
    }

    //Configurations

    @BeforeMethod
    public void setup() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
