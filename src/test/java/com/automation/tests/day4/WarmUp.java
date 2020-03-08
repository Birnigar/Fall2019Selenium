package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class WarmUp {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = DriverFactory.createADriver("chrome");
        //Go to ebay
        driver.get("http://ebay.com");

        Thread.sleep(2000);//to wait 2 seconds

        //enter search term
        driver.findElement(By.id("gh-ac")).sendKeys("java book");

        Thread.sleep(2000);//to wait 2 seconds

        //click on search button
        driver.findElement(By.id("gh-btn")).click();

        Thread.sleep(4000);//to wait 2 seconds

        WebElement searchResults = driver.findElement(By.tagName("h1"));


        //print number of results
        String[] searchSentence = searchResults.getText().split(" ");
        System.out.println(Arrays.toString(searchSentence));
    }
}
