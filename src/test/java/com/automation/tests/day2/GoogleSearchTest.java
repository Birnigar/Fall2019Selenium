package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(2000);
        //By.name("q") --> name="q"
        //name -it's one of the selenium locator
        //there are 8 locator
        //we use locators to find element
        // we choose locator ,just use By.locator
        WebElement search=driver.findElement(By.name("q"));
        //once we found element ,hoe to enter text?
        //how to press Enter after entering text ?
        //Use Key.ENTER
        //Use Key.ENTER - perform keyboard click
        search.sendKeys("Java", Keys.ENTER);

        Thread.sleep(2000);

        driver.quit();







    }
}
