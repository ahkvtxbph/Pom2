package tests;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import pageObject.basePage;
import pageObject.loginPage;
import pageObject.signUp;

import com.relevantcodes.extentreports.LogStatus;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static tests.baseTest.extent;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class tests extends baseTest {
    String status;

    @Before
    public void test()
    {
        driver.get("https://www.buyme.co.il");
    }


    @Test
    public void test01_emailError() throws Exception {

        myTests =   extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        myTests.log(LogStatus.PASS, "Test Start");

        Thread.sleep(5000);
        signUp.loginMainLoginButton();
        Thread.sleep(750);
        signUp.signUpButton();
        Thread.sleep(750);
        status=readFrom("buymeEmail",path,file);
      //  signUp.buymeEmail("a@gmail.com");
        signUp.buymeEmail("a@a");
        Thread.sleep(750);
        signUp.buttonReg();
        System.out.println(signUp.validate());
        if(!signUp.validate())
              myTests.log(LogStatus.FAIL,"details", "Email not valid");
        else {
           Thread.sleep(750);
            myTests.log(LogStatus.INFO,"details", String.valueOf(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(imagePath+"\\"+System.currentTimeMillis())).build()));
            myTests.log(LogStatus.PASS, "details", "Email is valid");
        }
    }

    @After
    public void after()
    {
        extent.endTest(myTests);
    }

    @AfterClass
    public static void end() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        driver.quit();
        extent.flush();
    }

}
