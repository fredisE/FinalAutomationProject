package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.*;

import java.util.concurrent.TimeUnit;

public class UITests {

    protected WebDriver webDriver;
    private WebDriverWait wait;
    private HomePage homePage;
    private SignUpPage signUpPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("start-maximized");
        webDriver = new ChromeDriver(options);
        webDriver.get("https://trello.com/");
        wait = new WebDriverWait(webDriver, 20);
        homePage = new HomePage(webDriver);
        signUpPage = new SignUpPage(webDriver);
    }

    @Test
    public void registerNewUser(){
        homePage.openHomePage();
        homePage.clickRegisterUser();
        signUpPage.addEmail();
        signUpPage.continueSignUp();
        signUpPage.addName();
        signUpPage.addPass();
        signUpPage.continueSignUp();
    }


   /* @After
    public void tearDown() {
        webDriver.quit();
    }*/


}
