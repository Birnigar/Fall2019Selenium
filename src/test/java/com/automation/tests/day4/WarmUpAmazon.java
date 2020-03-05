package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class WarmUpAmazon {

        public static void main(String[] args) throws InterruptedException {


            WebDriver driver= DriverFactory.createADriver("chrome");
            driver.get("http://amazon.com");
            Thread.sleep(3000);
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java book", Keys.ENTER);

          //  driver.findElement(By.id("nav-search-submit-text")).click();
            Thread.sleep(3000);
           String title=driver.getTitle();
            System.out.println("title = " + title);
           if(title.contains("Java book")){
               System.out.println("test passed");
           }else{
               System.out.println("test failed");
           }

            driver.quit();


        }
    }

