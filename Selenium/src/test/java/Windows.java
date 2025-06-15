import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Windows {
    WebDriver driver;
    By clickHere = By.cssSelector(".example > a");
    By newTab = By.cssSelector("body > .example > h3");

    @Test
    public void windows() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        String parent = driver.getWindowHandle(); // The Internet
        driver.findElement(clickHere).click();
        String child = driver.getWindowHandles().toArray()[1].toString(); // The Internet, New Window
        /*
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(parent)) {
                driver.switchTo().window(window);
            }
        }
        */
        driver.switchTo().window(child);
        System.out.println(driver.findElement(newTab).getText());
        driver.switchTo().window(parent);

        //   driver.switchTo().newWindow(WindowType.TAB).navigate().to("https://www.google.com/");

    }


}
