package org.watkrob.pages;

/**
 * Created by robertwatkins on 1/7/17.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends PageBase {

    private By usernameField = By.id("uid");
    private By passwordField = By.id("passw");
    private By submitButton = By.name("btnSubmit");

    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    public MainPage LoginWithValidCredentials(String username, String password){
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();

        waitForPageLoaded();
        return new MainPage(driver);
    }

}
