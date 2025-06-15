import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class JS {


    WebDriver driver;

    @Test
    public void test() {
        driver = new EdgeDriver();
        driver.get("http://127.0.0.1:5500/Pages/scrolling.html");
        ((JavascriptExecutor) driver).
                executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("scroll_text")));
    }
}
