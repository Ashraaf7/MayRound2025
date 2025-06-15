import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class CheckAndRadio {
    WebDriver driver;
    By noFanCheckbox = By.id("noClub");
    By ahlyCheckbox = By.id("Ahly");
    By highRadio = By.id("radio-button-1");

    @Test
    public void checkbox() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:5500/Pages/checkbox_Radio.html");
        System.out.println("Checked: " + driver.findElement(ahlyCheckbox).isSelected()); //T or F
        driver.findElement(noFanCheckbox).click();
    }


    @Test
    public void radio() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:5500/Pages/checkbox_Radio.html");
        System.out.println("Checked: " + driver.findElement(highRadio).isSelected()); //T or F
        driver.findElement(highRadio).click();
    }
}
