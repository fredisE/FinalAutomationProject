package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage{

    private WebDriver driver;
    private final String url = "https://trello.com/";
    private final By registerButton = By.xpath("//a[contains(text(),'Registrarse')]");

    public HomePage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void openHomePage(){
        driver.get(url);
    }

    public void clickRegisterUser(){
        driver.findElement(registerButton).click();
    }

}
