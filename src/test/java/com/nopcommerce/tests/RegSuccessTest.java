package com.nopcommerce.tests;

import com.nopcommerce.drivers.GUIDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.nopcommerce.pages.RegisterPage;


public class RegSuccessTest {
    //variables
    WebDriver driver;
    String successfulRegMsg = "Your registration completed";
    String homePageUrl = "https://demo.nopcommerce.com/";

    //Test cases
    @Test
    public void continueTC() {
        new RegisterPage(driver)
                .register("ziad", "yehia", "ziadTest22@gmail.com", "TestCompany", "P@ssw0rd")
                .isRegistrationCompleted(successfulRegMsg)
                .continueReg()
                .isHomePageAppear(homePageUrl);
    }

    //Configurations
    @BeforeMethod
    public void setup() {
        driver = GUIDriver.initDriver("edge");
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }

    @AfterMethod
    public void tearDown() {
        GUIDriver.quitDriver();
    }

}
