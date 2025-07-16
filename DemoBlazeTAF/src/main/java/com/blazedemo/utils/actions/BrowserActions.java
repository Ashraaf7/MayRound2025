package com.blazedemo.utils.actions;

import com.blazedemo.utils.logs.LogsManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class BrowserActions {
    private final WebDriver driver;
    public BrowserActions(WebDriver driver) {
        this.driver = driver;
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
