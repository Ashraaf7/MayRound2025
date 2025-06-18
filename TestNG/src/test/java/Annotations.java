import org.testng.Assert;
import org.testng.annotations.*;
@Test
public class Annotations {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }


    public void test() {
        System.out.println("Test");

    }


    public void test2()
    {
        Assert.fail();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }



    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }
}



