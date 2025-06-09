import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Waits {

    WebDriver driver;
    By startButton = By.tagName("button");
    By msg = By.cssSelector("#finish > h4");
    WebDriverWait wait;

    @Test
    public void implicitWait() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1"); //Empty Text
        driver.findElement(startButton).click();
        String message = driver.findElement(msg).getText();
        System.out.println(message);
    }

    @Test
    public void explicitWaitUsingExpectedConditions() {
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfElementLocated(startButton), ExpectedConditions.elementToBeClickable(startButton))); //loop
        driver.findElement(startButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(msg)); //loop
        String message = driver.findElement(msg).getText();
        System.out.println(message);
    }

    @Test
    public void explicitWaitUsingLambda() {
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        wait.until(d ->
                {
                    WebElement element = driver.findElement(startButton);
                    return element.isDisplayed() && element.isEnabled();
                }
        );
        driver.findElement(startButton).click();
        wait.until(d -> driver.findElement(msg).isDisplayed()); //loop
        String message = driver.findElement(msg).getText();
        System.out.println(message);
    }

    @Test
    public void fluentWait() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NONE); // don't wait for page load
        driver = new EdgeDriver(edgeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        wait.until(ExpectedConditions.elementToBeClickable(startButton)); //clickable = present + visible
        driver.findElement(startButton).click();
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(300L))
                .withMessage("element is not visible, locator " + msg.toString())
                .ignoring(NoSuchElementException.class)
                .until(d -> driver.findElement(msg).isDisplayed());
        String message = driver.findElement(msg).getText();
        System.out.println(message);
    }
}
