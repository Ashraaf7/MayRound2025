package com.automationexercices.tests;

import com.automationexercices.drivers.GUIDriver;
import com.automationexercices.drivers.WebDriverProvider;
import com.automationexercices.utils.dataReader.JsonReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest implements WebDriverProvider {
    protected GUIDriver driver;
    protected JsonReader testData;

    @BeforeClass
    protected void preCondition() {
        testData = new JsonReader("register-data");
    }



    @Override
    public WebDriver getWebDriver() {
        return driver.get();
    }
}
