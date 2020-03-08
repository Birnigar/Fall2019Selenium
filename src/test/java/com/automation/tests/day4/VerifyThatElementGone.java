package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyThatElementGone {
    /**
     * interview question
     * how to check if element doesn't exist anymore
     * @param args
     */


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);

        if( driver.findElements(By.id("disappearing_button")).size()==0){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        driver.quit();







    }
}
