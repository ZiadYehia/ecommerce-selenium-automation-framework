package pages;

import bots.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegSuccessPage {

    //variables
    private WebDriver driver;
    private ActionsBot actionsBot;
    //locators
    private final By continueButton = By.cssSelector("a[class=\"button-1 register-continue-button\"]");

    //constructor
    public RegSuccessPage(WebDriver driver) {
        this.driver = driver;
        this.actionsBot = new ActionsBot(driver);
    }

    //actions
    public RegSuccessPage continueReg() {
        actionsBot.click(continueButton);
        return new RegSuccessPage(driver);
    }

    //validations
    public HomePage isHomePageAppear(String expectedHomeUrl) {
        Assert.assertEquals(actionsBot.getCurrentUrl(), expectedHomeUrl, "This is not HomePage URL");
        return new HomePage(driver);
    }
}
