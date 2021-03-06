package org.watkrob.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.watkrob.pages.MainPage;
import org.watkrob.pages.SignInPage;
import org.watkrob.utils.ErrorHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by robert watkins on 1/7/17.
 *
 */
public class Tests {

    WebDriver driver;
    MainPage mainPage;
    SignInPage signInPage;

    @BeforeSuite
    public void setup() {
        Reporter.log("Starting Before Suite");

        Reporter.log("Read Configs");
        Properties defaultProps = new Properties();
        File configFile = new File("config.xml");
        try {
            InputStream inputStream = new FileInputStream(configFile);
            defaultProps.loadFromXML(inputStream);
        } catch (Exception e1) {
            Reporter.log("Unable to find or parse 'config.xml' file.");
            e1.printStackTrace();
        }


        String driverType = defaultProps.getProperty("drivertype");
        Reporter.log("Driver Type: "+driverType);
        if (null == driverType) {
            ErrorHandling.throwNPE("Driver type is 'null'");
        } else if (driverType.equals("Firefox")) {
            driver = new FirefoxDriver();
        } else if (driverType.equals("HTMLUnit")){
            driver = new HtmlUnitDriver(true);
        } else ErrorHandling.throwNPE("Unknown driver type '"+driverType+"'");



        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://demo.testfire.net/");
        Reporter.log("Launched Site",true);

    }

    @AfterSuite
    public void teardown(){

        Reporter.log("End of Test.");
        driver.quit();

    }

}
