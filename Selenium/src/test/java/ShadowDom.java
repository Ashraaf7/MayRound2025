import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ShadowDom {
    WebDriver driver;  //CTRL+ALT+L


    @Test
    public void shadowDom() {
        driver = new EdgeDriver();
        maximize();
        navigateTo("http://watir.com/examples/shadow_dom.html");
        By shadowHost = By.id("shadow_host");
        By input = By.cssSelector("[type=\"text\"]");
        driver.findElement(shadowHost).getShadowRoot().findElement(input).sendKeys("ahmed");
    }

    //wapping method
    public WebElement findElement(By by) {
        return driver.findElement(by); //relocation strategy
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void maximize() {
        driver.manage().window().maximize();
    }
}
