package tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.w3c.dom.Document;

import pageObject.basePage;
import pageObject.loginPage;
import pageObject.signUp;

public class baseTest {

    static loginPage loginPage;
    static signUp signUp;
    static basePage basePage;
    static ExtentReports extent;
    static ExtentTest myTests;
    static String reportFilePath="C:\\selenium\\files\\reports\\testReports2.html";
    static WebDriver driver=null;
    static String path="C:\\Selenium\\files\\";
    static String file="config.xml";
    static String assertionError = null;
    static String imagePath="C:\\selenium\\files\\image";


    @BeforeClass
    public static void testSetup()throws Exception {
        extent = new ExtentReports(reportFilePath);
        myTests = extent.startTest("ExtentDemo");
        String browse = readFrom("brwoser", path, file);
        resetBrowser(browse);
        driver.manage().window().maximize();
        resetPage();
    }


    public static void resetPage()
    {
        loginPage=new loginPage(driver);
        signUp=new signUp(driver);
        basePage=new basePage(driver);
    }

    public  static String takeScreenShot(String IMagePath) throws IOException
    {
        TakesScreenshot takesScreenshot =(TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(IMagePath+".png");
        try
        {
            FileUtils.copyFile(screenShotFile,destinationFile);
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return IMagePath+".png";
    }

    public static String readFrom(String keyData, String path, String file) throws Exception {
                File xmlFile = new File(path+file);
        System.out.println(xmlFile);
        DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
        Document doc = dbBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        myTests.log(LogStatus.INFO, doc.getElementsByTagName(keyData).item(0).getTextContent());
        return doc.getElementsByTagName(keyData).item(0).getTextContent();


    }


    public static void resetBrowser(String browseReset)
    {
        if (browseReset.contains("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else
        {
            System.setProperty("webdriver.gecko.driver", "C:/selenium/firefox/geckodriver.exe");
            driver = new FirefoxDriver();
            //
        }
       // basePage.basePage1(driver);

    }



}
