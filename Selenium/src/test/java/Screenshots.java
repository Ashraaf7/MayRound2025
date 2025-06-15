import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Screenshots {
    WebDriver driver;

    @Test
    public void takeScreenshot() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("src/test/resources/google.png");
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    @Test
    public void takeScreenshotForElement() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        File src = driver.findElement(By.cssSelector("svg.lnXdpd")).getScreenshotAs(OutputType.FILE);
        File dest = new File("src/test/resources/googleLogo.png");
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
