import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.testng.annotations.Test;

import java.io.File;

public class ElementActions {
    /*driver.findElements(loginFields).getFirst().sendKeys("ahmed"); // using ByAll
    driver.findElements(loginFields).getLast().sendKeys("ashraf"); // using ByAll*/
    // WebElement username = driver.findElement(By.id("")); //stale element reference exception

    WebDriver driver;  //CTRL+ALT+L
    By username = By.id("inputUsername"); //key // traditional locator strategy
    // By username = new ByChained(By.id("loginForm"), By.id("inputUsername")); // chained locator strategy
    By password = By.cssSelector("[type=\"password\"]");
    By loginButton = RelativeLocator.with(By.tagName("button")).below(password);
    By loginFields = new ByAll(By.id("inputUsername"), By.cssSelector("[type=\"password\"]"));

    By uploadFile = By.id("fileInput");

    @FindBy(id = "inputUsername")
    WebElement usernameField; // Page Factory - Page Object Model

    // Test Runner
    @Test
    public void loginTC() {
        driver = new EdgeDriver();
        maximize();
        navigateTo("http://127.0.0.1:5500/index.html");
        type(username, "admin");
        type(password, "admin");
        clicking(loginButton);
    }

    @Test
    public void uploadFileTC() {
        driver = new EdgeDriver();
        maximize();
        navigateTo("http://127.0.0.1:5500/Pages/uploadFile.html");
        uploadFile(uploadFile, "src/test/resources/test.txt");
    }

    @Test
    public void isEnabledTC() {
        driver = new EdgeDriver();
        maximize();
        navigateTo("http://127.0.0.1:5500/index.html");
        System.out.println(findElement(username).isEnabled());
    }


    public void clicking(By by) {
        driver.findElement(by).click(); // using By
    }

    public void type(By by, String text) {
        clear(by);
        driver.findElement(by).sendKeys(text);
    }

    public void clear(By by) {
        driver.findElement(by).clear(); // using By
    }

    public void uploadFile(By by, String filePath) {
        String userHome = System.getProperty("user.dir");
        System.out.println(userHome);
        findElement(by).sendKeys(userHome + File.separator + filePath);
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
