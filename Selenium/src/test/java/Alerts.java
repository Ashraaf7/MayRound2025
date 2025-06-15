import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Alerts {

    WebDriver driver;
    By jsAlert = By.cssSelector("[onclick=\"jsAlert()\"]");
    By jsConfirm = By.cssSelector("[onclick=\"jsConfirm()\"]");
    By jsPrompt = By.cssSelector("[onclick=\"jsPrompt()\"]");

    @Test
    public void jsConfirm() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(jsAlert).click(); //Alert appears
        driver.switchTo().alert().accept();
    }

    @Test
    public void jsDismiss() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(jsConfirm).click(); //Alert appears
        driver.switchTo().alert().dismiss();
    }

    @Test
    public void jsPrompt() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(jsPrompt).click(); //Alert appears
        driver.switchTo().alert().sendKeys("Hello Selenium");
        //new Actions(driver).keyDown(Keys.ENTER).perform();
    }


    //get Text
    @Test
    public void jsAlert() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(jsAlert).click(); //Alert appears
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);

    }
}

