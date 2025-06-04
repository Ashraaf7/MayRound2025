import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class GetInfo {

    WebDriver driver;  //CTRL+ALT+L
    By username = By.id("inputUsername"); //key // traditional locator strategy

    @Test
    public void getTextTC() {
        driver = new EdgeDriver();
        maximize();
        navigateTo("http://127.0.0.1:5500/Pages/about.html");
        By p = By.cssSelector("section > p");
        getText(p);
    }

    @Test
    public void getPropertyTC() {
        driver = new EdgeDriver();
        maximize();
        navigateTo("http://127.0.0.1:5500/index.html");
        type(username, "admin");
        getProperty(username, "value"); //admin
        getAttribute(username, "value"); //intial
    }


    public String getProperty(By by, String prperty) {
        String property = findElement(by).getDomProperty(prperty);
        System.out.println(property);
        return property; // using By
    }


    //get attribute
    public String getAttribute(By by, String attribute) {
        String attr = driver.findElement(by).getDomAttribute(attribute);
        System.out.println(attr);
        return attr; // using By
    }


    public String getText(By by) {
        String text = driver.findElement(by).getText();
        System.out.println(text);
        return text; // using By
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

    public void type(By by, String text) {
        clear(by);
        driver.findElement(by).sendKeys(text);
    }

    public void clear(By by) {
        driver.findElement(by).clear(); // using By
    }

}

