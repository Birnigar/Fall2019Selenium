package com.automation.tests.day10;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice {
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeMethod
    public void setup() {

        driver = DriverFactory.createADriver("chrome");
        wait = new WebDriverWait(driver, 10);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
        driver.findElement(By.xpath("//*[@name='ctl00$MainContent$username']")).sendKeys("Tester");
        driver.findElement(By.cssSelector("#ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.cssSelector(".button")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void verifyAllDeleted(){
       driver.findElement(By.xpath("//a[text()='Check All']")).click();
       driver.findElement(By.cssSelector(".btnDeleteSelected")).click();

       String expected="List of orders is empty. In order to add new order use this link.";
       String actual=driver.findElement(By.id("ctl00_MainContent_orderMessage")).getText();

        Assert.assertEquals(actual,expected);


    }
}