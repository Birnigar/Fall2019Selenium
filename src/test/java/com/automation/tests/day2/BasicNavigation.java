package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {
        //Selenium script we need:
        //Setup webdriver(browser driver) and create webdriver object
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
       // in Seleniums everything starts from webdriver interface
           driver.get("http://google.com");





    }
}
