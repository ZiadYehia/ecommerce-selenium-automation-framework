package pages;

import bots.ActionsBot;
import org.openqa.selenium.WebDriver;

public class HomePage {
    //variables
    private WebDriver driver;
    private ActionsBot actionsBot;
    //locators

    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.actionsBot = new ActionsBot(driver);

    }

    //actions


    //validations


}
