package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class WarmUpAmazon {

        public static void main(String[] args) throws InterruptedException {

            WebDriver driver = DriverFactory.createADriver("chrome");
            //go to amazon
            driver.get("http://amazon.com");
            //enter text and click ENTER
            //enter search term + click on search button
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);

            Thread.sleep(4000);//to wait 2 seconds

            String title = driver.getTitle();

            //verify title contains search term
           if(title.contains("Java book")){
               System.out.println("test passed");
           }else{
               System.out.println("test failed");
           }

            driver.quit();


        }
    }

