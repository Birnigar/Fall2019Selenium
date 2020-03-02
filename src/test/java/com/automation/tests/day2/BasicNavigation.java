package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {
        //Selenium script we need:
        //Setup webdriver(browser driver) and create webdriver object
       WebDriverManager.chromedriver().setup();
      WebDriver driver=new ChromeDriver();
       // in Seleniums everything starts from webdriver interface
        //Chrome Driver extends RemoteWebDriver -->implements WebDriver
           driver.get("http://google.com");
           Thread.sleep(3000);// for demo ,wait 3 seconds
        //method that return page title
        //you can also see is as tab name , in the browser
        String title=driver.getTitle();//returns <title> some title </title> text
        String expectedTitle="Google";
        System.out.println("Title is = "+title);
         if(expectedTitle.equals(title)){
             System.out.println("TEST PASSED!");
         }else{
             System.out.println("TEST FAILED!");
         }
    driver.close();//to close browser



    }
}
