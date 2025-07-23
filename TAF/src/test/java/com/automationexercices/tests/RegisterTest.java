package com.automationexercices.tests;

import com.automationexercices.drivers.GUIDriver;
import com.automationexercices.pages.SignupLoginPage;
import com.automationexercices.pages.components.NavigationBarComponent;
import com.automationexercices.utils.TimeManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{



    //Tests
    @Test
    public void validSignUpTC() {
        new SignupLoginPage(driver).navigate()
                .enterSignupName(testData.getJsonData("name"))
                .enterSignupEmail(testData.getJsonData("email")+ TimeManager.getSimpleTimestamp()+"@gmail.com")
                .clickSignupButton()
                .fillRegisterationForm(
                        testData.getJsonData("titleMale"),
                        testData.getJsonData("password"),
                        testData.getJsonData("day"),
                        testData.getJsonData("month"),
                        testData.getJsonData("year"),
                        testData.getJsonData("firstName"),
                        testData.getJsonData("lastName"),
                        testData.getJsonData("companyName"),
                        testData.getJsonData("address1"),
                        testData.getJsonData("address2"),
                        testData.getJsonData("country"),
                        testData.getJsonData("state"),
                        testData.getJsonData("city"),
                        testData.getJsonData("zipcode"),
                        testData.getJsonData("mobileNumber")
                )
                .clickCreateAccountButton()
                .verifyAccountCreated();
    }

    @Test
    public void invalidSignUpTC() {

    }




    //Configurations
    @BeforeMethod
    public void setUp() {
        driver = new GUIDriver();
        driver.browser().closeExtensionsTabs(); // Close any extension tabs that might have opened
        new NavigationBarComponent(driver).navigate();
    }

    @AfterMethod
    public void tearDown() {
      //  driver.quitDriver();
    }
}
