package org.watkrob.pages;

/**
 * Created by robertwatkins on 1/7/17.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;
    private By SignInLink = By.linkText("Sign In");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public SignInPage clickSignIn() {
        driver.findElement(SignInLink).click();

        return new SignInPage(driver);
    }

}
