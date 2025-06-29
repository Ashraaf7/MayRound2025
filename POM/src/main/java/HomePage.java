import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    //variables

    private WebDriver driver;
    //locators
    private final By addToCartButton = By.xpath("//div[.='Sauce Labs Backpack'] //following::button[1]");
    private final By cartIcon = By.xpath("//*[@data-icon=\"shopping-cart\"] //following::span");


    //constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //actions
    public HomePage addToCart(){
        driver.findElement(addToCartButton).click();
        return this;
    }

    //validations
    public HomePage validateCartIcon() {
        String cartIconText = driver.findElement(cartIcon).getText();
        Assert.assertEquals(cartIconText, "1");
        return this;
    }
}
