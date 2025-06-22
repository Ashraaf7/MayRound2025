package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {
    WebDriver driver;

    @Ignore
    @Test(enabled = false)
    public void fakeTest()
    {
        String token = null;
        Assert.assertNotNull(token, "flag should be false");
    }

    @BeforeMethod
    public void setup()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/index.html");
    }
    @Test
    public void inValidLogin()
    {
        /*
        1.enter username
        2. enter password
        3.click login button
        4.verify error message is displayed
         */
        driver.findElement(By.id("user-name")).sendKeys("ahmed");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String actualText = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(actualText,"Epic sadface: Username and password ","error message is not correct"); //fail
        Assert.assertTrue(driver.getCurrentUrl().contains("/index.html"), "url is not correct");
    }

    @Test
    public void inValidLoginSoft()
    {
        SoftAssert softAssert = new SoftAssert();
        /*
        1.enter username
        2. enter password
        3.click login button
        4.verify error message is displayed
         */
        driver.findElement(By.id("user-name")).sendKeys("ahmed");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String actualText = driver.findElement(By.tagName("h3")).getText();
        softAssert.assertEquals(actualText,"Epic sadface: Username and password do not match any user in this service","error message is not correct"); //fail
        softAssert.assertTrue(driver.getCurrentUrl().contains("/home.html"), "url is not correct");
        //throw new RuntimeException("invalid username");
        softAssert.assertAll();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();

    }
}
