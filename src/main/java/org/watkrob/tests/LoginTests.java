package org.watkrob.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.watkrob.pages.MainPage;


/**
 * Created by robertwatkins on 1/7/17.
 *
 */
public class LoginTests extends Tests{

    @Test
    public void LoginTest(){
        Reporter.log("Starting LoginTest",true);
        mainPage = new MainPage(driver);
        signInPage = mainPage.clickSignIn();
        Assert.assertTrue(null != signInPage);
        Reporter.log("Arrived at sign in page");
    }

    @Test
    public void LoginLogoutTest(){
        Reporter.log("Starting LoginLogoutTest",true);
        mainPage = new MainPage(driver);
        signInPage = mainPage.clickSignIn();
        Assert.assertTrue(null != signInPage,"Expected to be on Signon Page, but got an unexpected page");
        Reporter.log("Arrive at Signon page",true);


        mainPage = signInPage.LoginWithValidCredentials("tuser","tuser");
        String helloUserTextFound = mainPage.GetHelloUserText();
        Assert.assertEquals("Hello Test User", helloUserTextFound,"Expected 'Hello Test User', got '" + helloUserTextFound + "'");
        Reporter.log("Signed in successfully",true);

        mainPage.clickSignOff();
        Assert.assertFalse(mainPage.isUserLoggedIn(),"Expected User to be Logged Out, but found that the user was still logged in");
        Reporter.log("Signed Out Successfully");
    }
}
