package com.nopcommerce.tests;

import com.nopcommerce.drivers.GUIDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.nopcommerce.pages.LoginPage;

public class LoginTest {
    //variables
    WebDriver driver;
    String homePageUrl = "https://demo.nopcommerce.com/";

    //Test cases
    @Test
    public void validLoginTC() {
        new LoginPage(driver)
                .login("ziadTest22@gmail.com", "P@ssw0rd")
                .isSuccessfulLogin(homePageUrl);
    }

    //Configurations

    @BeforeMethod
    public void setup() {
        driver = GUIDriver.initDriver("edge");
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }

    @AfterMethod
    public void tearDown() {
        GUIDriver.quitDriver();
    }
}
