package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Flights;
import pages.LogIn;

public class SignIn {
    WebDriver webDriver;

    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest test1,test2;

    @BeforeSuite
    public void reportSetup(){
        //create ExtentReports and attach reporter(s)
        extentSparkReporter = new ExtentSparkReporter("SignIn.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
    }

    @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/faithmandela/Desktop/QE/Learning/Selenium/chromedriver");
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        webDriver = new ChromeDriver();
        webDriver.get(baseUrl);
        Thread.sleep(1000);


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

    @Test(priority = 2)
    public void bookFlight(){
        test2 = extentReports.createTest("Book a flight");

        Flights flights = new Flights(webDriver);
        flights.clickOnFlight();
        test2.pass("Form openned successfully");
    }

    @AfterTest
    public void closeTest(){
        webDriver.close();
        extentReports.flush();
    }
}
