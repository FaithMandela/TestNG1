package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LogIn;

public class SignIn {
    WebDriver webDriver;

    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest test1,test2;

    @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/faithmandela/Desktop/QE/Learning/Selenium/chromedriver");
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        webDriver = new ChromeDriver();
        webDriver.get(baseUrl);
        Thread.sleep(1000);

        //create ExtentReports and attach reporter(s)
        extentSparkReporter = new ExtentSparkReporter("SignIn.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
    }

    @Test(priority = 1)
    public void SignIn(){
        test1 = extentReports.createTest("Sign in to portal");
        test1.log(Status.INFO,"Starting the tests");

        LogIn logIn = new LogIn(webDriver);
        logIn.username("tutorial");
        test1.pass("Entered username");
        logIn.password("tutorial");
        test1.pass("Entered password");
        logIn.submit();
        test1.pass("logged in successfully");
    }

    @AfterTest
    public void closeTest(){
        webDriver.close();
    }
}
