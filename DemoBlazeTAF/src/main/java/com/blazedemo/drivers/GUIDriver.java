package com.blazedemo.drivers;

import com.blazedemo.utils.dataReader.PropertyReader;
import com.blazedemo.utils.logs.LogsManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class GUIDriver {
    private final String browser = PropertyReader.getProperty("browserType");

    private  ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    public GUIDriver()
    {
        Browser browserType = Browser.valueOf(browser.toUpperCase());
        LogsManager.info("Starting driver for browser: " + browserType);
        AbstractDriver abstractDriver = browserType.getDriverFactory(); //local
        WebDriver driver = ThreadGuard.protect(abstractDriver.createDriver());
        driverThreadLocal.set(driver);
    }

    public WebDriver get() {
        return driverThreadLocal.get();
    }

    public  void quitDriver() {
        driverThreadLocal.get().quit();
    }
}
