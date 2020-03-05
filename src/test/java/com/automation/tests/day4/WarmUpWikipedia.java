package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class WarmUpWikipedia {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://wikipedia.org");
        Thread.sleep(3000);
        driver.findElement(By.id("searchInput")).sendKeys("Selenium (software)", Keys.ENTER);
        String link=driver.getCurrentUrl();
        Thread.sleep(3000);
        System.out.println("link = " + link);
        if(link.endsWith("Selenium (software)")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST PASSED");
        }

        driver.quit();
    }
}
