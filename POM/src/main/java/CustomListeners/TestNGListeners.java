package CustomListeners;

import drivers.WebDriverFactory;
import org.testng.*;
import utils.AllureUtils;
import utils.PropertyReader;
import utils.ScreenShotUtils;

public class TestNGListeners implements IInvokedMethodListener, ITestListener, IExecutionListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod())
            System.out.println(method.getTestMethod().getMethodName() + " started");

    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            ScreenShotUtils.takeScreenshot(WebDriverFactory.get(), testResult.getName());
            System.out.println(method.getTestMethod().getMethodName() + " finished");
        }
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " passed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " failed");

    }

    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " skipped");
    }

    public void onExecutionStart() {
        System.out.println("Execution started");
        PropertyReader.loadProperties();
        AllureUtils.cleanAllureResults();
    }

    public void onExecutionFinish() {
        System.out.println("Execution finished");
        AllureUtils.setAllureEnvironment();
    }

}

