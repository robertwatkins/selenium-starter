package org.watkrob.pages;

/**
 * Created by robertwatkins on 1/7/17.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.watkrob.utils.ErrorHandling;

public class MainPage extends PageBase{

    private By SignInLink = By.linkText("Sign In");
    private By SignOffLink = By.linkText("Sign Off");
    private By HelloUserTextLocation = By.xpath("//h1");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public SignInPage clickSignIn() {
        driver.findElement(SignInLink).click();
        waitForPageLoaded();
        ErrorHandling.logMessage("Clicking Sign In Link");
        return new SignInPage(driver);
    }

    public void clickSignOff() {
        driver.findElement(SignOffLink).click();
        waitForPageLoaded();
        ErrorHandling.logMessage("Clicking Sign Out Link");
        return;
    }

    public String GetHelloUserText(){
        WebElement myTextLocation = driver.findElement(HelloUserTextLocation);
        if (null == myTextLocation){
           ErrorHandling.throwNPE("No 'Hello User' Message Found");
        }
        String myText = myTextLocation.getText();
        ErrorHandling.logMessage("'Hello User' message reads '"+myText+"'.");
        return myText;
    }

    public Boolean isUserLoggedIn(){

        WebElement SignInLinkReference=null;
        WebElement SignOffLinkReference=null;

        ErrorHandling.logMessage("Determine if user is logged in by looking for Sign In/Out links.");
        try {
            SignInLinkReference = driver.findElement(SignInLink);
        } catch (Exception e){
            ErrorHandling.logMessage("No sign in link found.");
        }
        try {
            SignOffLinkReference = driver.findElement(SignOffLink);
        } catch (Exception e){
            ErrorHandling.logMessage(("No sign out message found."));
        }

        if ((null == SignInLinkReference) && (null== SignOffLinkReference)){
            ErrorHandling.throwNPE("Unable to determine if the user is logged in or not");
        } else if (null != SignInLinkReference) {
            ErrorHandling.logMessage("User is not logged in.");
            return false;
        }
        ErrorHandling.logMessage("User is still logged in.");
        return true;

    }

}
