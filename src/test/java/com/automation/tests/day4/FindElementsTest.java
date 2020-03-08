package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElementsTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/");

        Thread.sleep(2000);
        //how to collect all links from the page?


        List<WebElement> links= driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
            System.out.println();
          //  link.click();//click on link
           // Thread.sleep(2000);
          //  driver.navigate().back();//and then go back
        }
        for (int i = 1; i <links.size() ; i++) {
            links.get(i).click();
           // driver.findElements(By.tagName("a")).get(i).click(); //it is most short way

            //Thread.sleep(2000);
            driver.navigate().back();
           // Thread.sleep(2000);
            //refresh list
            links=driver.findElements(By.tagName("a"));

        }






        driver.quit();







    }
}
