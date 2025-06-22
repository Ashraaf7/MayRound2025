import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Parameter {
    WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void setup()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Parameters({"username", "password"})
    @Test()
    public void validLoginTC(@Optional("tomsmith") String username, @Optional("SuperSecretPassword!") String password)
    {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("radius")).click();
        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed(), "Login message is not appeared!");
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        driver.quit();
    }
}
