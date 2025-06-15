import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class BrowserOptions {

    WebDriver driver;

    @Test
    public void browserOptions() {
        EdgeOptions options = new EdgeOptions();
        //options.addArguments("--headless");
        ///options.setBrowserVersion("latest");
        options.addArguments("--guest");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setAcceptInsecureCerts(true);
        //options.addExtensions(new File("src/test/resources/adBlocker.crx"));
        Map<String, Object> prefs = new HashMap<>();
        String userHome = System.getProperty("user.dir");
        String downloadPath = userHome + File.separator + "src/test/resources";
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", prefs);
        driver = new EdgeDriver(options);
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[.='LambdaTest.txt']")).click();
    }
}

