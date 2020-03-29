package com.officeHours;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class UnderstandingJavaScriptExecutor {
    @Test(description = "Send text to sezrch box on etsy")
    public void test1(){
        // Driver instance created
        WebDriver driver = DriverFactory.createADriver("chrome");
        // Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('global-enhancements-search-query').value='Send these characters'");
    }
    @Test(description = "get the page title")
    public void testcase3(){
        WebDriver driver =  DriverFactory.createADriver("chrome");
        // Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        // return keyword before the script is for Selenium to know that it needs to bring back information
        String pageTitle = js.executeScript("return document.title").toString();
        System.out.println(pageTitle);
    }
    @Test(description = "return page URL")
    public void test4(){
        WebDriver driver =  DriverFactory.createADriver("chrome");
        // Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        // return keyword before the script is for Selenium to know that it needs to bring back information
        String pageURL = js.executeScript("return document.URL").toString();
        System.out.println(pageURL);
    }
    @Test(description = "return element text")
    public void test5(){
        //catnav-primary-link-11049
        WebDriver driver=DriverFactory.createADriver("chrome");
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
      String elementText=js.executeScript("return document.getElementId('catnav-primary-link-11049').innerHTML").toString();
        BrowserUtils.wait(3);
        System.out.println(elementText);

    }
}
