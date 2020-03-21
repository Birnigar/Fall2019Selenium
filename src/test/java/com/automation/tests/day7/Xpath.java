package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Xpath {
   public static String userNameLocator="//label[text()='Username']/following-sibling::/input";
   public static  String passwordLocator="//label[text()='Password']/followin-sibling::/input";
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(3);
         driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");

         BrowserUtils.wait(2);
         driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");

BrowserUtils.wait(2 );
         driver.findElement(By.xpath("//button[text()='Login']")).click();









        BrowserUtils.wait(3);
        driver.quit();






    }
}
