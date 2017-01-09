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
    private By HelloUserTextLocation = By.xpath("//h1");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public SignInPage clickSignIn() {
        driver.findElement(SignInLink).click();

        return new SignInPage(driver);
    }

    public String GetHelloUserText(){
        WebElement myTextLocation = driver.findElement(HelloUserTextLocation);
        if (null == myTextLocation){
           ErrorHandling.throwNPE("No 'Hello User' Message Found");
        }
        String myText = myTextLocation.getText();
        return myText;
    }


}
