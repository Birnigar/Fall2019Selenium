package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {
        //Selenium script we need:
        //Setup webdriver(browser driver) and create webdriver object
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // in Seleniums everything starts from webdriver interface
        //Chrome Driver extends RemoteWebDriver -->implements WebDriver
        driver.get("http://google.com");

        Thread.sleep(3000);// for demo ,wait 3 seconds
        //method that return page title
        //you can also see is as tab name , in the browser
        String title = driver.getTitle();//returns <title> some title </title> text
        String expectedTitle = "Google";
        System.out.println("Title is = " + title);
        if (expectedTitle.equals(title)) {
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }

        driver.manage().window().maximize();//to maximize browser
        driver.navigate().to("http://amazon.com");
        Thread.sleep(3000);
        // driver.navigate().forward();
       // if (driver.getTitle().toLowerCase().contains("amazon")) {
        //    System.out.println("TEST PASSED!");
       // } else {
        //    System.out.println("TEST FAILED!");

       // }
            driver.navigate().back();//comeback google
        Thread.sleep(3000);
          verifyEquals(driver.getTitle(),"Google");
          //move forward in the browser
        driver.navigate().forward();
        Thread.sleep(3000);
        System.out.println("Title = "+driver.getTitle());

        driver.close();//to close browser
    }
    public static void verifyEquals(String arg1,String arg2){
        if(arg1.equals(arg2)){
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }



    }
}
