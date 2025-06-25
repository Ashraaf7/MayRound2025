import CustomListeners.TestNGListeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListeners.class)
@Test(groups = "LoginFeature")
public class Retry {
    WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void setup()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test(groups = {"valid","smoke"},retryAnalyzer = TestNGListeners.class)
    public void validLoginTC()
    {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        Assert.assertFalse(driver.findElement(By.id("flash")).isDisplayed(), "Login message is not appeared!");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        driver.quit();
    }
}
