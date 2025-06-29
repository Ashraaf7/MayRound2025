import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    //variables
    private WebDriver driver;
    //locator
    private final By userName = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");

    //constructor
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }



    //actions
    public LoginPage login(String username, String pass)
    {
        driver.findElement(userName).sendKeys(username);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
        return this;
    }
    //validations
    public HomePage isLoggedIn(String expectedUrl)
    {
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        return new HomePage(driver);
    }


}
