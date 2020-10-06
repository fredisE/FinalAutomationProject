package Pages;

import Utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SignUpPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private final By email = By.id("email");
    private final By continueButton = By.id("signup-submit");
    private final By name = By.id("name");
    private final By password = By.id("password");

    public SignUpPage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void addEmail() {
        driver.findElement(email).sendKeys(ReadProperties.getInstance().getProperties().get("email").toString());
    }

    public void continueSignUp(){
        driver.findElement(continueButton).click();
    }

    public void addName(){
        driver.findElement(name).sendKeys(ReadProperties.getInstance().getProperties().get("fullName").toString());
    }

    public void addPass(){
        driver.findElement(password).sendKeys(ReadProperties.getInstance().getProperties().get("pass").toString());
    }



}
