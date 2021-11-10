package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn {

    WebDriver webDriver;

    By username = By.name("userName");
    By password = By.name("password");
    By btnSubmit = By.name("submit");

    public LogIn(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void username(String name){
        webDriver.findElement(username).sendKeys(name);

    }

    public void password(String pass){
        webDriver.findElement(password).sendKeys(pass);

    }

    public void submit(){
        webDriver.findElement(btnSubmit).click();

    }
}
