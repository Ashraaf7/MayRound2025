import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = "LoginFeature")
public class LoginTestParallel {
    ThreadLocal<WebDriver>  driverThreadLocal = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    public void setup()
    {
        WebDriver driver = new EdgeDriver();
        driverThreadLocal.set(driver); //introduce thread local variable to store the driver instance
        driverThreadLocal.get().manage().window().maximize();
        driverThreadLocal.get().get("https://the-internet.herokuapp.com/login");
    }

    @Test(groups = {"valid","smoke"})
    public void validLoginTC()
    {
        driverThreadLocal.get().findElement(By.id("username")).sendKeys("tomsmith");
        driverThreadLocal.get().findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driverThreadLocal.get().findElement(By.className("radius")).click();
        Assert.assertTrue( driverThreadLocal.get().findElement(By.id("flash")).isDisplayed(), "Login message is not appeared!");
        //throw  new RuntimeException(); to make the test fails
    }
    @Test(groups = {"invalid","smoke"})
    public void inValidUsernameLoginTC()
    {
        driverThreadLocal.get().findElement(By.id("username")).sendKeys("ahmed");
        driverThreadLocal.get().findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driverThreadLocal.get().findElement(By.className("radius")).click();
        String actualMsg =  driverThreadLocal.get().findElement(By.id("flash")).getText();
        Assert.assertTrue(actualMsg.contains("Your username is invalid!"), "Login message is not appeared!");
    }

    @Test(groups = {"invalid","smoke"})
    public void inValidPasswordLoginTC()
    {
        driverThreadLocal.get().findElement(By.id("username")).sendKeys("tomsmith");
        driverThreadLocal.get().findElement(By.id("password")).sendKeys("@#!");
        driverThreadLocal.get().findElement(By.className("radius")).click();
        String actualMsg =  driverThreadLocal.get().findElement(By.id("flash")).getText();
        Assert.assertTrue(actualMsg.contains("Your password is invalid!"), "Login message is not appeared!");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        if (driverThreadLocal.get() != null)
            driverThreadLocal.get().quit();
    }
}
