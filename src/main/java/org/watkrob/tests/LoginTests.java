package org.watkrob.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.watkrob.pages.MainPage;

/**
 * Created by robertwatkins on 1/7/17.
 */
public class LoginTests extends Tests{

    @Test
    public void LoginTest(){
        System.out.println("Starting LoginTest");
        mainPage = new MainPage(driver);
        signInPage = mainPage.clickSignIn();
        Assert.assertTrue(null != signInPage);

    }

    @Test
    public void LoginLogoutTest(){
        System.out.println("Starting LoginLogoutTest");
        mainPage = new MainPage(driver);
        signInPage = mainPage.clickSignIn();
        Assert.assertTrue(null != signInPage);

        mainPage = signInPage.LoginWithValidCredentials("tuser","tuser");
        String helloUserTextFound = mainPage.GetHelloUserText();
        Assert.assertEquals("Hello Test User", helloUserTextFound,"Expected 'Hello Test User', got '" + helloUserTextFound + "'");

        mainPage.clickSignOff();
        Assert.assertFalse(mainPage.isUserLoggedIn(),"Expected User to be Logged Out, but found that the user was still logged in");
    }
}
