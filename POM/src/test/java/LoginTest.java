import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.saucedemo.com/v1/index.html");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
