package CustomListeners;

import org.testng.*;

public class TestNGListeners implements IInvokedMethodListener, ITestListener, IExecutionListener,IRetryAnalyzer {

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod())
            System.out.println(method.getTestMethod().getMethodName() + " started");

    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod())
            System.out.println(method.getTestMethod().getMethodName() + " finished");
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
    }

    public void onExecutionFinish() {
        System.out.println("Execution finished");
    }

    private  int attemps = 0;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (iTestResult.getStatus() == ITestResult.FAILURE && attemps==0) //1 attempt
        {
            attemps++;
            return true;
        }
        return false;
    }
}

