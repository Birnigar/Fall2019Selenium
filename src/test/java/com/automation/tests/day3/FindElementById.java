package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementById {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= DriverFactory.createADriver("chrome");
       driver.get("http://practice.cybertekschool.com/login");
       driver.findElement(By.name("username")).sendKeys("tomsmith");
       Thread.sleep(2000);

       driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

       WebElement login=driver.findElement(By.id("wooden_spoon"));


       login.submit();
String expected="Welcome to the Secure Area. When you are done click logout below.";

String actual=driver.findElement(By.className("subheader")).getText();
        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }


        WebElement logout = driver.findElement(By.partialLinkText("Logout"));


        String href=logout.getAttribute("href");//href.getAttribute() give  web page url
       String className=logout.getAttribute("class");

        System.out.println(href);
        System.out.println(className);
        logout.click();
        Thread.sleep(2000);

        driver.findElement(By.name("username")).sendKeys("Batman");
        Thread.sleep(2000);

        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        login.submit();

        String errorMessage=driver.findElement(By.id("flash-messages")).getText();

        System.out.println("errorMessage = " + errorMessage);

        driver.quit();









    }
}
