import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DynamicLocator {
    WebDriver driver;

    @Test
    public void DL() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/");
        chooseCategory("Contribute");
        chooseSubCategory("Code");
    }

    //DON'T FORGET WAITS
    public void chooseSubCategory(String option) {
        driver.findElement(By.xpath("//a[.='" + option + "']")).click(); //86
    }

    public void chooseCategory(String option) {
        new Actions(driver).moveToElement(driver.findElement(By.xpath("//li[@class='dropdown'] //a[.='" + option + "']")))
                .perform();
    }
}
