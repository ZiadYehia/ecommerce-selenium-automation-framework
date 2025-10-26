import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegSuccessPage {

    //variables
    private WebDriver driver;
    //locators
    private final By continueButton = By.cssSelector("a[class=\"button-1 register-continue-button\"]");
    //constructor
    public RegSuccessPage (WebDriver driver){
        this.driver = driver;
    }
    //actions
    public RegSuccessPage continueReg(){
        driver.findElement(continueButton).click();
        return new RegSuccessPage(driver);
    }
    //validations
    public HomePage isHomePageAppear(String expectedUrl){
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl,"This is not HomePage URL");
        return new HomePage(driver);
    }


}
