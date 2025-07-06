package pages;

import bots.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    //locator
    private final By userName = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    //variables
    private WebDriver driver;
    private ActionsBot actionsBot;


    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.actionsBot = new ActionsBot(driver);
    }


    //actions
    public LoginPage login(String username, String pass) {
        actionsBot.type(userName, username);
        actionsBot.type(password, pass);
        actionsBot.click(loginButton);
        return this;
    }

    //validations
    public HomePage isLoggedIn(String expectedUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        return new HomePage(driver);
    }


}
