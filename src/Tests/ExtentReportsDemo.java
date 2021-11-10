package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExtentReportsDemo {

    public static void main(String[] args) {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("logInSample.html");
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        ExtentTest test1 = extentReports.createTest("Starting the tests");

        System.setProperty("webdriver.chrome.driver","/Users/faithmandela/Desktop/QE/Learning/Selenium/chromedriver");
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        WebDriver webDriver = new ChromeDriver();
        webDriver.get(baseUrl);
        test1.pass("Navigated to the url");

        webDriver.findElement(By.name("userName")).sendKeys("tutorial");
        test1.pass("Entered username");

        webDriver.findElement(By.name("password")).sendKeys("tutorial");
        test1.pass("Entered password");

        webDriver.findElement(By.name("submit")).click();
        test1.pass("Clicked submit button");

        webDriver.close();
        test1.pass("Closed the browser");

        extentReports.flush();
    }
}
