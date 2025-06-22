import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = "LoginFeature")
public class LoginTest {
    WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void setup()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test(groups = {"valid","smoke"})
    public void validLoginTC()
    {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed(), "Login message is not appeared!");
        //throw  new RuntimeException(); to make the test fails
    }
    @Test(groups = {"invalid","smoke"})
    public void inValidUsernameLoginTC()
    {
        driver.findElement(By.id("username")).sendKeys("ahmed");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        String actualMsg = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(actualMsg.contains("Your username is invalid!"), "Login message is not appeared!");
    }

    @Test(groups = {"invalid","smoke"})
    public void inValidPasswordLoginTC()
    {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("@#!");
        driver.findElement(By.className("radius")).click();
        String actualMsg = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(actualMsg.contains("Your password is invalid!"), "Login message is not appeared!");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        driver.quit();
    }
}
