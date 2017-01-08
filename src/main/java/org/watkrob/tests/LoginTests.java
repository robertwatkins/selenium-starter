package org.watkrob.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.watkrob.pages.MainPage;
import org.watkrob.pages.SignInPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by robertwatkins on 1/7/17.
 */
public class LoginTests {

    private WebDriver driver;
    private MainPage mainPage;
    private SignInPage signInPage;

    @BeforeSuite
    public void setup() {
        System.out.println("Starting Before Class");
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://demo.testfire.net/");
        System.out.println("Launched Site");

    }

    @AfterSuite
    public void teardown(){

        System.out.println("End of Test.");
        driver.quit();

    }

    @Test
    public void LoginTest(){
        System.out.println("Starting LoginTest");
        mainPage = new MainPage(driver);
        signInPage = mainPage.clickSignIn();
        Assert.assertTrue(null != signInPage);

    }
}
