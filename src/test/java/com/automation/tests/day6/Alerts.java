package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);

        List<WebElement> buttons=driver.findElements(By.tagName("button"));

        buttons.get(0).click();
        BrowserUtils.wait(3);

        String popUpText=driver.switchTo().alert().getText();
        System.out.println(popUpText);
        driver.switchTo().alert().accept();//to click ok

        String expected="You successfully clicked an alert";
        String actual=driver.findElement(By.id("result")).getText();
        BrowserUtils.wait(3);

        //if will fail ,because there is a typo ##BUG##
        if(expected.equals(actual)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
        }

        BrowserUtils.wait(3);
        buttons.get(1).click();//to click on 2nd button
        BrowserUtils.wait(2);
        //to click cancel
        driver.switchTo().alert().dismiss();
BrowserUtils.wait(2);
        String expectedDismiss="You clicked: Cancel";
        BrowserUtils.wait(3);
        String actualDismiss=driver.findElement(By.id("result")).getText();

        if(expectedDismiss.equals(actualDismiss)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
            System.out.println("actualDismiss = " + actualDismiss);
            System.out.println("expectedDismiss = " + expectedDismiss);
        }

        BrowserUtils.wait(3);
        buttons.get(2).click();//to click on 3nd button
        BrowserUtils.wait(2);
        //to send message
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Hello, World");
        alert.accept();

        BrowserUtils.wait(2);
        String expected3="You entered: Hello, World";
        BrowserUtils.wait(3);
        String actual3=driver.findElement(By.id("result")).getText();
        BrowserUtils.wait(2);
        if(expected3.equals(actual3)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
            System.out.println("actual3 = " + actual3);
            System.out.println("expected3 = " + expected3);

        }







        BrowserUtils.wait(3);
        driver.quit();

















    }
}
