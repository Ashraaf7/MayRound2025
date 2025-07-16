package com.blazedemo.drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariFactory extends AbstractDriver {
    public SafariOptions getOptions() {
        SafariOptions options = new SafariOptions();
        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        return options;
    }

    @Override
    public WebDriver createDriver() {
        return new SafariDriver(getOptions());
    }
}
