package com.blazedemo.drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxFactory extends AbstractDriver {
    private FirefoxOptions getOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("--start-maximized");
        return options;
    }

    @Override
    public WebDriver createDriver() {
        return new FirefoxDriver(getOptions());
    }
}
