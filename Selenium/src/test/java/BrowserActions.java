import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class BrowserActions {
    WebDriver driver;  //CTRL+ALT+L

    //Test Runner
    @Test
    public void testCase() {
        driver = new EdgeDriver();
        maximize();
        navigateTo("https://www.google.com");
        driver.switchTo().newWindow(WindowType.TAB);
        quit();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void minimize() {
        driver.manage().window().minimize();
    }

    public void setPosition(int x, int y) {
        // Point point = new Point(100, 100);
        driver.manage().window().setPosition(new Point(x, y));
    }

    public void setSize(int width, int height) {
        //Dimension dimension = new Dimension(width, height);
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public void fullScreen() {
        driver.manage().window().fullscreen();
    }

    public void getCurrentUrl() {
        String url = driver.getCurrentUrl();
        System.out.println("Current URL: " + url);
    }

    public void getTitle() {
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
    }

    public void getPageSource() {
        String src = driver.getPageSource();
        System.out.println("Page Source: " + src);
    }

    public void getWindowHandle() {
        String handle = driver.getWindowHandle();
        System.out.println("Window Handle: " + handle);
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }


}
