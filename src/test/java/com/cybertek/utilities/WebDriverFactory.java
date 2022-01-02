package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    //Task: Write a static method that takes a string parameter name: browserType
    //based on the value of parameter
    //it will setup the browser and the method will return chromedriver or firefoxdriver object
    //name of the method: getDriver

    public static WebDriver getDriver(String browseType){

        WebDriver driver = null;

        //Chrome, CHROME,ChrOme
        switch (browseType.toLowerCase()){

            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver();
                driver=new FirefoxDriver();
                break;

        }
        return driver;

    }




}
