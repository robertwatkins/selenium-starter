package org.watkrob.selenium.demo;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

//This example requires JUnit, while others use TestNG.
//The POM would need to be updated to satisfy this dependency
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Selenium2ExampleWithJUnitTest {

    @BeforeClass
    public static void setUp() {

    }

    @AfterClass
    public static void tearDown() {

    }

    @Test
    public void thirdest() {
        String expected = "Hello, JUnit!";
        String hello = "Hello JUnit!";
        assertEquals(hello, expected);
    }

    @Test
    public void secondTest() {
        String expected = "Hello, JUnit!";
        String hello = "Hello, JUnit!";
        assertEquals(hello, expected);
    }

    @Test
    public  void firstTest() {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.

        //download geckodriver from https://github.com/mozilla/geckodriver/releases/tag/v0.12.0
        //add to system path

        WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        //Close the browser
        driver.quit();
        assertTrue(true);
    }
}