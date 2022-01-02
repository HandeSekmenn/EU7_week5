package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ChercherTest {
/*
Task1:
    1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
    2. Click on "Click me, to Open an alert after 5 seconds"
    3. Explicitly wait until alert is present
    4. Then handle the Javascript alert
 */

    WebDriver driver;
    
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //implicitly wait, this is going to be applied to whole test cases and elements
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

    }

    @AfterMethod
    public void tearDown(){
       driver.close();

    }

    @Test
    public void alertPresentTest(){
        //click on "click me",to open an alert after 5 seconds
        WebElement initiateAlert = driver.findElement(By.id("alert"));
        initiateAlert.click();
        
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.alertIsPresent());

        //handle javascript alert
        //if you don't wait you will get NoAlertPresentException
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    @Test
    public void disabledButtonTest(){
        WebElement button = driver.findElement(By.id("disable"));
        System.out.println("button.isEnabled() = " + button.isEnabled()); //false
        WebElement buttonInitiator = driver.findElement(By.id("enable-button"));
        buttonInitiator.click();

        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(button));

        System.out.println("button.isEnabled() = " + button.isEnabled());
        Assert.assertTrue(button.isEnabled(),"verify the Button is enabled");

    }

}
