import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Waits {

    WebDriver driver;  //CTRL+ALT+L

    //TestNG
    @Test
    public void implicitWait() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
        driver.get("https://www.google.com/");
        driver.quit();
    }

    // Empty Text
    @Test
    public void explicitWait() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.tagName("button")).click();
        boolean flag = driver.findElement(By.cssSelector("#finish >h4")).isDisplayed();
        System.out.println(flag);
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish >h4")));
        String msg = driver.findElement(By.cssSelector("#finish >h4")).getText();
        System.out.println(msg);
    }

    //NoSuchElementException
    @Test
    public void explicitWait2() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.tagName("button")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> d.findElement(By.cssSelector("#finish >h4")).isDisplayed());
        String msg = driver.findElement(By.cssSelector("#finish >h4")).getText();
        System.out.println(msg);
    }

    //NoSuchElementException
    @Test
    public void fluentWait() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.tagName("button")).click();
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(100L))
                .withMessage("element is not visible")
                .ignoring(NoSuchElementException.class)
                .until(d -> d.findElement(By.cssSelector("#finish >h4")).isDisplayed());
        String msg = driver.findElement(By.cssSelector("#finish >h4")).getText();
        System.out.println(msg);
    }


}
