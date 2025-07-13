package tests.webportal.login;

import drivers.WebDriverFactory;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import static utils.PropertyReader.getProperty;

public class LoginTest {
    //variables
    WebDriver driver;


    //Tests

    @Test
    @Description("verify that the user is redirected to home page after providing correct credentials")
    @Tag("validLogin")
    @Owner("Ashraf")
    @Severity(SeverityLevel.CRITICAL)
    @Link("www.confluence.jira.com/login")
    @TmsLink("https://ashrafnezam.atlassian.net/projects/TA?selectedItem=com.atlassian.plugins.atlassian-connect-plugin:com.kanoah.test-manager__main-project-page#!/v2/testCase/TA-T1")
    @Issue("https://ashrafnezam.atlassian.net/browse/TA-64")
    public void validLoginTest() {
        Allure.getLifecycle().updateTestCase(testResult ->
        {
            testResult.setName("Valid Login");
        });
        new LoginPage(driver).
                login(getProperty("validUsername"), getProperty("validPassword"))
                .isLoggedIn("https://www.saucedemo.com/v1/inventory.html");
    }

    //behavioral-based hire
    @Epic("Web Portal")
    @Feature("Login Feature")
    @Story("In Valid Test Cases")
    @Test
    public void inValidLoginTest() {
        new LoginPage(driver).
                login(getProperty("invalidUsername"), getProperty("invalidPassword"))
                .isLoggedIn("https://www.saucedemo.com/v1/inventory.html");
    }


    //Configuration
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.initDriver();
        driver.get(getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
}































