import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Test
public class Priority {
    WebDriver driver;


    @BeforeClass
    public void setup()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test(priority = 1)
    public void loginTC()
    {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed(), "Login message is not appeared!");
    }

    @Test(priority = 2,groups = "logoutFun")
    public void logoutTC()
    {
        driver.findElement(By.cssSelector(".example > a")).click();
        String actualMsg = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(actualMsg.contains("You logged out of the secure area!"),"Logout message is not correct!");
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();

    }
}
