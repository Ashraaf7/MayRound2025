package tests;

import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {
    //variables
    WebDriver driver;


    //Tests
    @Test
    public void validLoginTest() {
        new LoginPage(driver).
                login("standard_user", "secret_sauce")
                .isLoggedIn("https://www.saucedemo.com/v1/inventory.html");
    }

    @Test
    public void inValidLoginTest() {
        new LoginPage(driver).
                login("admin", "secret_sauce")
                .isLoggedIn("https://www.saucedemo.com/v1/inventory.html");
    }


    //Configuration
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.initDriver("edge");
        driver.get("https://www.saucedemo.com/v1/index.html");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
}































