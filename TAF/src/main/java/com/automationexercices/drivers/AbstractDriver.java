package com.automationexercices.drivers;

import com.automationexercices.utils.dataReader.PropertyReader;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.List;

public abstract class AbstractDriver {
    protected final String remoteHost = PropertyReader.getProperty("remoteHost");
    protected final String remotePort = PropertyReader.getProperty("remotePort");
    protected List<File> extensions = List.of(
        new File("src/main/resources/extensions/AdBlocker.crx"),
        new  File("src/main/resources/extensions/HaramBlur.crx")
    );
    public abstract WebDriver createDriver();
}
