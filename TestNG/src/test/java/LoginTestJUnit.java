import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


public class LoginTestJUnit {
    WebDriver driver;


    @BeforeEach
    public void setup()
    {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--headless");
        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }


    @RepeatedTest(10)
    public void validLoginTC()
    {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        Assertions.assertTrue(driver.findElement(By.id("flash")).isDisplayed(), "Login message is not appeared!");
        //throw  new RuntimeException(); to make the test fails
    }

    @AfterEach
    public void tearDown()
    {
        driver.quit();
    }
}
