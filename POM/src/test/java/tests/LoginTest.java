package tests;

import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import static utils.PropertyReader.getProperty;

public class LoginTest {
    //variables
    WebDriver driver;


    //Tests
    @Test
    public void validLoginTest() {
        new LoginPage(driver).
                login(getProperty("validUsername"), getProperty("validPassword"))
                .isLoggedIn("https://www.saucedemo.com/v1/inventory.html");
    }

    @Test
    public void inValidLoginTest() {
        new LoginPage(driver).
                login(getProperty("invalidUsername"), getProperty("invalidPassword"))
                .isLoggedIn("https://www.saucedemo.com/v1/inventory.html");
    }


    //Configuration
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.initDriver();
        driver.get(getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
}































