package org.watkrob.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
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
        System.out.println("Starting Before Suite");

        System.out.println("Read Configs");
        Properties defaultProps = new Properties();
        File configFile = new File("config.xml");
        try {
            InputStream inputStream = new FileInputStream(configFile);
            defaultProps.loadFromXML(inputStream);
        } catch (Exception e1) {
            System.out.println("Unable to find or parse 'config.xml' file.");
            e1.printStackTrace();
        }


        String driverType = defaultProps.getProperty("drivertype");
        System.out.println("Driver Type: "+driverType);
        if (null == driverType) {
            ErrorHandling.throwNPE("Driver type is 'null'");
        } else if (driverType.equals("Firefox")) {
            driver = new FirefoxDriver();
        } else if (driverType.equals("HTMLUnit")){
            driver = new HtmlUnitDriver(true);
        } else ErrorHandling.throwNPE("Unknown driver type '"+driverType+"'");



        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://demo.testfire.net/");
        System.out.println("Launched Site");

    }

    @AfterSuite
    public void teardown(){

        System.out.println("End of Test.");
        driver.quit();

    }

}
