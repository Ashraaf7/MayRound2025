import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumActions {
    WebDriver driver;
    By rightElement = By.id("riClickBtn");
    By doubleElement = By.id("dblClickBtn");
    By avatar = By.cssSelector("[alt='User Avatar']"); //3 > selenium always choose first element
    By drag = By.cssSelector("[alt=\"my Image\"]");
    By drop = By.id("dropZone");

    @Test
    public void contextClick() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:5500/Pages/mouse.html");
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(rightElement)).perform();
    }

    @Test
    public void hover() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(avatar)).perform();
    }

    @Test
    public void doubleClick() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:5500/Pages/mouse.html");
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(doubleElement)).perform();
    }


    @Test
    public void dragAndDrop() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:5500/Pages/dragDrop.html");
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(drag), driver.findElement(drop)).perform();
    }

    @Test
    public void clickAndHold() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:5500/Pages/dragDrop.html");
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(drag))
                .moveToElement(driver.findElement(drop))
                .release()
                .perform();
    }

    @Test
    public void keys() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/key_presses");
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).perform();
        reset();
        driver.findElement(By.id("target")).sendKeys("ahmed");
    }

    @Test
    public void scrolling() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:5500/Pages/scrolling.html");
        //driver.findElement(By.id("scroll_text")).sendKeys("test");
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.id("scroll_text"))).perform();
    }


    public void reset() {
        ((RemoteWebDriver) driver).resetInputState();
    }

}
