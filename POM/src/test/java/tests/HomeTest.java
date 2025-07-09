package tests;

import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.JsonReader;

public class HomeTest {
    WebDriver driver;
    JsonReader jsonReader;

    @Test
    public void addToCartTC() {
        new LoginPage(driver)
                .login(jsonReader.getJsonData("username"), jsonReader.getJsonData("password"))
                .isLoggedIn("https://www.saucedemo.com/v1/inventory.html")
                .addToCart()
                .validateCartIcon();
    }


    //Configuration
    @BeforeMethod
    public void setUp() {
        jsonReader = new JsonReader("login-data");
        driver = WebDriverFactory.initDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
}
