package org.watkrob.pages;

/**
 * Created by robertwatkins on 1/7/17.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.watkrob.utils.ErrorHandling;

public class SignInPage extends PageBase {

    private By usernameField = By.id("uid");
    private By passwordField = By.id("passw");
    private By submitButton = By.name("btnSubmit");

    SignInPage(WebDriver driver){
        this.driver = driver;
    }

    public MainPage LoginWithValidCredentials(String username, String password){
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
        ErrorHandling.logMessage("Logging in with user '"+username+"' (password not shown)");
        waitForPageLoaded();
        return new MainPage(driver);
    }

}
