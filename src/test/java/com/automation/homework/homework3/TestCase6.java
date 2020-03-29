package com.automation.homework.homework3;



import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCase6 {



@Test
public static void Test6(){
   WebDriver driver= DriverFactory.createADriver("chrome");
    WebDriverWait wait=new WebDriverWait(driver,10);
    driver.get("https://www.tempmailaddress.com/");

    String email=driver.findElement(By.className("animace")).getText();
    driver.close();
   driver=DriverFactory.createADriver("chrome");
    driver.get("http://practice.cybertekschool.com/");
    driver.findElement(By.xpath("//a[text()='Sign Up For Mailing List']")).click();
    driver.findElement(By.name("full_name")).sendKeys("Ahmet");
    driver.findElement(By.name("email")).sendKeys(email);
    driver.findElement(By.name("wooden_spoon")).click();
    String emailUploadMessage=driver.findElement(By.name("signup_message")).getText();
    String expected="Thank you for signing up. Click the button below to return to the home page.";
    driver.findElement(By.id("wooden_spoon")).click();
    driver.close();
    driver=DriverFactory.createADriver("chrome");
    driver.get("https://www.tempmailaddress.com/");
    WebElement emailElement=driver.findElement(By.xpath("//tbody[@id='schranka']/tr[1]/td[1]"));
    String emailVerify=emailElement.getText();
    emailElement.click();



    Assert.assertEquals(emailUploadMessage,expected);



}




}
