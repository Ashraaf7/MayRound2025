import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDown {

    WebDriver driver;  //CTRL+ALT+L

    @Test
    public void testDropDown() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        By dropdown = By.id("dropdown");
        new Select(driver.findElement(By.id("dropdown"))).selectByIndex(0);
    }

    //dynamic locator will be the best efficient way
    @Test
    public void DropDown() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("demo");
        By dropdown = By.id("dropdown");
        driver.findElement(dropdown).click();  //opening dropdown
        By option = By.id("");
        driver.findElement(option).click();  //choosing option
    }
}
