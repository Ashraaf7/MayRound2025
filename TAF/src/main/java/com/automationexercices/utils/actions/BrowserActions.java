package com.automationexercices.utils.actions;

import com.automationexercices.utils.WaitManager;
import com.automationexercices.utils.dataReader.PropertyReader;
import com.automationexercices.utils.logs.LogsManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Set;

public class BrowserActions {
    private final WebDriver driver;
    private WaitManager waitManager;
    public BrowserActions(WebDriver driver) {
        this.driver = driver;
        this.waitManager = new WaitManager(driver);
    }
    /**
     * Maximize window
     */
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }
    // get current web page's URL
    public String getCurrentUrl() {
        String url = driver.getCurrentUrl();
        LogsManager.info("Current URL: " + url);
        return url;
    }

    // Navigate to a specific URL
    public void navigateTo(String url) {
        driver.get(url);
        LogsManager.info("Navigated to URL: " + url);
    }

    // Refresh the current page
    public void refreshPage() {
        driver.navigate().refresh();
    }

    // close the current window
    public void closeCurrentWindow() {
        driver.close();
    }

    // open a new window
    public void openNewWindow() {
        driver.switchTo().newWindow(WindowType.WINDOW);
    }



}
