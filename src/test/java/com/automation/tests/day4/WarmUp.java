package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WarmUp {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://ebay.com");
        Thread.sleep(3000);
        driver.findElement(By.id("gh-ac")).sendKeys("Selenium book");
        Thread.sleep(3000);
        driver.findElement(By.id("gh-btn")).click();
        Thread.sleep(3000);
        String result = driver.findElement(By.tagName("h1")).getText();
        System.out.println("result = " + result.split(" ")[0]);
        driver.quit();


    }
}
