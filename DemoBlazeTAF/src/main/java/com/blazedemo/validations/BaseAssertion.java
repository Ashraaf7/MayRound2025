package com.blazedemo.validations;

import com.blazedemo.utils.WaitManager;
import com.blazedemo.utils.actions.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BaseAssertion {
    protected final WebDriver driver;
    protected final WaitManager  waitManager;
    protected ElementActions elementActions;
    protected BaseAssertion(WebDriver driver) {
        this.driver = driver;
        this.waitManager = new WaitManager(driver);
        this.elementActions = new ElementActions(driver);
    }
    protected abstract void assertTrue(boolean condition, String message);
    protected abstract void assertFalse(boolean condition, String message);
    protected abstract void assertEquals(String actual, String expected, String message);

    protected void Equals(String actual, String expected, String message) {
        assertEquals(actual, expected, message);
    }
    protected void isElementVisible(By locator)
    {
      boolean flag =  waitManager.fluentWait().until(driver1 ->
        {
            try {
                driver1.findElement(locator).isDisplayed();
                return true;
            }
            catch (Exception e) {
                return false;
            }
        });
        assertTrue(flag, "Element is not visible: " + locator);
    }
    // verify page url
    protected void assertPageUrl(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        assertEquals(actualUrl, expectedUrl, "URL does not match. Expected: " + expectedUrl + ", Actual: " + actualUrl);
    }
    // verify page title
    protected void assertPageTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, expectedTitle, "Title does not match. Expected: " + expectedTitle + ", Actual: " + actualTitle);
    }
}
