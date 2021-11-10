package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Flights {
    WebDriver webDriver;
    By lkFlights = By.linkText("Flights");

    public Flights(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public void clickOnFlight(){
        webDriver.findElement(lkFlights).click();
    }
}
